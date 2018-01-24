package calculators;

import interfaces.*;
import interfaces.stats.TeamStandingsStatsCalculationResultDTO;

import java.util.*;

/**
 * Calculator for team standings
 */
public class TeamStandingsStatsCalculator implements StatsCalculator<TeamStandingsStatsCalculationResultDTO> {

    @Override
    /**
     * Calculate the entire team standings and returns a Data Transfer Object containing team standing info.
     */
    public TeamStandingsStatsCalculationResultDTO calculate(StatsGenerationRequestDTO statsGenerationRequest) {
		TeamStandingsStatsCalculationResultDTO results = new TeamStandingsStatsCalculationResultDTO();
		// initialize
		List<TeamDTO> teams = statsGenerationRequest.getTeams();
		List<MatchDTO> matches = statsGenerationRequest.getMatches();
		// go through teams
		// stats go in order of Win, Loss, Tie, Win pct, PPG, PAPG, Margin, TUH, PPTH, P/N, G/N, PPB
        Map<String, List<MatchTeamStatsDTO>> teamStatsMap = new HashMap<>();
		List<MatchTeamStatsDTO> stats = new ArrayList<MatchTeamStatsDTO>();
		// fill stats with each team
        for(int i = 0; i < matches.size(); i++){
            // calculate team 1
            MatchDTO curMatch = matches.get(i);
            int numTeams = curMatch.getTeams().size();
            // add and calculate results for each team of the match
            for(int j = 0; j < numTeams; j++){
                MatchTeamDTO curTeam = curMatch.getTeams().get(j);
                String curTeamId = curTeam.getTeamId();
                MatchTeamStatsDTO curMatchTeamOne = new MatchTeamStatsDTO(curTeam, curMatch);
                if(teamStatsMap.containsKey(curTeamId)){
                    List<MatchTeamStatsDTO> matchTeamStatsDTOList = teamStatsMap.get(curTeamId);
                    matchTeamStatsDTOList.add(curMatchTeamOne);
                    teamStatsMap.put(curTeamId, matchTeamStatsDTOList);
                }
                // add the new team stats DTO into map
                else{
                    List<MatchTeamStatsDTO> matchTeamStatsDTOList = new ArrayList<MatchTeamStatsDTO>();
                    matchTeamStatsDTOList.add(curMatchTeamOne);
                    teamStatsMap.put(curTeamId, matchTeamStatsDTOList);
                }
            }
        }

        // convert map back to sorted list
		// calculate stats from matches
        // maybe make team stats dto
		results.setStats(stats);
		return results;
	}

	private Map<String, MatchTeamStatsDTO> populateMap(List<MatchDTO> matches){
        // go through each match and add the stats to the map
        for(int i = 0; i < matches.size(); i++){
            MatchDTO curMatch = matches.get(i);
            int tossupsHeard = curMatch.getTossupsHeard();
            List<MatchTeamDTO> curTeams = curMatch.getTeams();
            for(int j = 0; j < curTeams.size(); j++){
                MatchTeamDTO curMatchTeam = curTeams.get(j);
                String curId = curMatchTeam.getTeamId();
                int scoreTotal = curMatchTeam.getScore();
                List<MatchPlayerDTO> curPlayers = curMatchTeam.getPlayers();
                for(int k = 0; k < curPlayers.size(); k++){
                    
                }
            }

        }
        return new HashMap<String, MatchTeamStatsDTO>();
    }
}
