package calculators;

import interfaces.*;
import interfaces.stats.TeamStandingsStatsCalculationResultDTO;

import java.util.*;

/**
 * Calculator for team standings
 */
public class TeamStandingsStatsCalculator implements StatsCalculator<TeamStandingsStatsCalculationResultDTO> {

    @Override
    public TeamStandingsStatsCalculationResultDTO calculate(StatsGenerationRequestDTO statsGenerationRequest) {
		TeamStandingsStatsCalculationResultDTO results = new TeamStandingsStatsCalculationResultDTO();
		// initialize
		List<TeamDTO> teams = statsGenerationRequest.getTeams();
		List<MatchDTO> matches = statsGenerationRequest.getMatches();
		// go through all matches
        Map<String, TeamStandingStatsDTO> teamStatsMap = populateMap(teams, matches);

        // calculate the rest of stats
        // stats go in order of Win, Loss, Tie, Win pct, PPG, PAPG, Margin, TUH, PPTH, P/N, G/N, PPB
        calculateTeamStats(teamStatsMap);

        // convert map back to sorted list
        List<TeamStandingStatsDTO> stats = new ArrayList<>();
        for(Map.Entry<String, TeamStandingStatsDTO> teamEntry : teamStatsMap.entrySet()){
            stats.add(teamEntry.getValue());
        }
        Collections.sort(stats);
        results.setStats(stats);
		return results;
	}

	private Map<String, TeamStandingStatsDTO> populateMap(List<TeamDTO> teams, List<MatchDTO> matches){
        Map<String, TeamStandingStatsDTO> teamStatsMap = new HashMap<>();
        // add teams
        for(TeamDTO curTeam : teams){
            teamStatsMap.put(curTeam.getId(), new TeamStandingStatsDTO());
        }

        // fill stats out for reach match
        for(MatchDTO curMatch : matches){
            populateMatch(teamStatsMap, curMatch);
        }

        return teamStatsMap;
    }

    /**
     *
     * @param teamStatsMap
     * @param curMatch
     */
    private void populateMatch(Map<String, TeamStandingStatsDTO> teamStatsMap, MatchDTO curMatch){
        List<MatchTeamDTO> curTeams = curMatch.getTeams();

        // for each match, fill out stats for each team assuming there are only two teams
        for(int teamNumber = 0; teamNumber < 2; teamNumber++){
            // grab teams
            MatchTeamDTO curMatchTeamOne = curTeams.get(teamNumber);
            MatchTeamDTO curMatchTeamTwo = curTeams.get((teamNumber + 1) % 2);
            TeamStandingStatsDTO teamStandingOne = teamStatsMap.get(curMatchTeamOne.getTeamId());
            TeamStandingStatsDTO teamStandingTwo = teamStatsMap.get(curMatchTeamTwo.getTeamId());

            // populate team one total stats
            teamStandingOne.setTuh(curMatch.getTossupsHeard()
                    + teamStandingOne.getTuh());
            teamStandingOne.setPointsTotal(curMatchTeamOne.getScore()
                    + teamStandingOne.getPointsTotal());
            teamStandingOne.setPointsAgainst(curMatchTeamTwo.getScore()
                    + teamStandingOne.getPointsAgainst());
            teamStandingOne.setPointsBounceback(curMatchTeamOne.getBouncebackPoints()
                    + teamStandingOne.getPointsBounceback());
            // calculate pointsTossup to calculate pointsBonus
            List<TeamTossupValuesDTO> curTeamTossupList = teamStandingOne.getTossupValues();
            if(curTeamTossupList == null){
                curTeamTossupList = new ArrayList<>();
            }
            // fetch a compiled tossup list from the current match and current team
            List<TeamTossupValuesDTO> curMatchTossupList = populatePlayers(curMatchTeamOne.getPlayers());
            // find the current tossup total from the current match and current team
            Integer curTossupTotal = 0;
            Integer curBonusHeard = 0;
            for(int tossupType = 0; tossupType < curMatchTossupList.size(); tossupType++){
                TeamTossupValuesDTO curTossup = curMatchTossupList.get(tossupType);
                // update power, base, neg
                if(curTossup.getValue() > 10){
                    teamStandingOne.setNumPowers(curTossup.getNumber()
                                        + teamStandingOne.getNumPowers());
                } else if(curTossup.getValue() < 0){
                    teamStandingOne.setNumPowers(curTossup.getNumber()
                                        + teamStandingOne.getNumNegs());
                } else {
                    teamStandingOne.setNumBase(curTossup.getNumber()
                                        + teamStandingOne.getNumNegs());
                }
                curTossupTotal += curTossup.getNumber() * curTossup.getValue();
                curBonusHeard += curTossup.getNumber();
                // if this match is the first to be entered, set team stats to current match stats
                if(curTeamTossupList.size() < curMatchTossupList.size()){
                    TeamTossupValuesDTO newTeamTossup = new TeamTossupValuesDTO();
                    newTeamTossup.setNumber(curTossup.getNumber());
                    newTeamTossup.setValue(curTossup.getValue());
                    curTeamTossupList.add(newTeamTossup);
                }
                // if this match is not the first entered, add match stats to current team stats
                else {
                    TeamTossupValuesDTO curTeamTossup = curTeamTossupList.get(tossupType);
                    curTeamTossup.setNumber(curTossup.getNumber() + curTeamTossup.getNumber());
                    curTeamTossup.setValue(curTossup.getValue() + curTeamTossup.getValue());
                }
            }
            // add the total points from tossups
            teamStandingOne.setPointsTossup(curTossupTotal
                    + teamStandingOne.getPointsTossup());
            // add number of bonuses heard
            teamStandingOne.setBonusesHeard(curBonusHeard
                    + teamStandingOne.getBonusesHeard());
            // calculate pointsBonus
            Integer curPointsBonus = curMatchTeamOne.getScore()
                    - curMatchTeamOne.getBouncebackPoints()
                    - teamStandingOne.getPointsTossup();
            teamStandingOne.setPointsBonus(curPointsBonus + teamStandingOne.getPointsBonus());

            // finally find wins/losses/ties
            if (curMatchTeamOne.getScore().compareTo(curMatchTeamTwo.getScore()) > 0){
                teamStandingOne.setWins(1 + teamStandingOne.getWins());
            } else if(curMatchTeamOne.getScore().equals(curMatchTeamTwo.getScore())){
                teamStandingOne.setTies(1 + teamStandingOne.getTies());
            } else {
                teamStandingOne.setLosses(1 + teamStandingOne.getLosses());
            }
        }
    }

    /**
     * Given a list of MatchPlayerDTO, creates a list of TeamTossupValuesDTO the tossup value and number of each player.
     * @param players
     * @return populated teamStatsDTO
     */
    private List<TeamTossupValuesDTO> populatePlayers(List<MatchPlayerDTO> players){
        List<TeamTossupValuesDTO> teamTossupVals = new ArrayList<>();

        for(MatchPlayerDTO curPlayer : players){
            List<PlayerTossupValuesDTO> playerTossupVal = curPlayer.getTossupValues();
            for(int tossupType = 0; tossupType < playerTossupVal.size(); tossupType++){
                PlayerTossupValuesDTO curPlayerTossupVal = playerTossupVal.get(tossupType);
                // If this is first entry, then enter player stats as the first team stat entry
                if(teamTossupVals.size() == 0){
                    TeamTossupValuesDTO newTossupValue = new TeamTossupValuesDTO();
                    newTossupValue.setNumber(curPlayerTossupVal.getNumber());
                    newTossupValue.setValue(curPlayerTossupVal.getValue());
                }
                // if not first entry, then add player stats to the previous team stat entry
                else{
                    TeamTossupValuesDTO curTossupValue = teamTossupVals.get(tossupType);
                    curTossupValue.setNumber(curPlayerTossupVal.getNumber() +
                                             curTossupValue.getNumber());
                    curTossupValue.setValue(curPlayerTossupVal.getValue() +
                                            curTossupValue.getValue());
                }
            }
        }
        // after population, set them back
        return teamTossupVals;
    }

    /**
     * Calculate the remaining stats to be displayed in place.
     * @param teamStatsMap
     */
    private void calculateTeamStats(Map<String, TeamStandingStatsDTO> teamStatsMap){
        for(Map.Entry<String, TeamStandingStatsDTO> teamStatsEntry : teamStatsMap.entrySet()){
            String curTeamId = teamStatsEntry.getKey();
            TeamStandingStatsDTO curTeamStats = teamStatsEntry.getValue();
            Integer totalGames = curTeamStats.getWins() + curTeamStats.getLosses() + curTeamStats.getTies();
            if(totalGames > 0){
                curTeamStats.setWinPct((double) curTeamStats.getWins() / totalGames);
                curTeamStats.setPpg((double) curTeamStats.getPointsTotal() / totalGames);
                curTeamStats.setPapg((double) curTeamStats.getPointsAgainst() / totalGames);
                curTeamStats.setMargin(curTeamStats.getPpg() - curTeamStats.getPapg());
                curTeamStats.setPpth((double) curTeamStats.getPointsTotal() / curTeamStats.getTuh());
                curTeamStats.setPnRatio((double) curTeamStats.getNumPowers() / curTeamStats.getNumNegs());
                curTeamStats.setGnRatio((double) (curTeamStats.getNumPowers() + curTeamStats.getNumBase())
                                                /(curTeamStats.getNumNegs()));
                curTeamStats.setPpb((double) curTeamStats.getPointsBonus() / totalGames);
            }
        }
    }
}
