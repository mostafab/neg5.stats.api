package calculators;


import interfaces.*;
import interfaces.stats.FullIndividualStatsCalculationResultDTO;
import interfaces.stats.StatsCalculationResultDTO;

import java.util.*;

public class IndividualStandingsStatsCalculator implements StatsCalculator{
    @Override
    public StatsCalculationResultDTO calculate(StatsGenerationRequestDTO statsGenerationRequest) {
        FullIndividualStatsCalculationResultDTO results = new FullIndividualStatsCalculationResultDTO();
        List<TeamDTO> teams = statsGenerationRequest.getTeams();
        List<MatchDTO> matches = statsGenerationRequest.getMatches();
        return results;

    }


    private Map<String, IndividualPlayerDTO> populatePlayers(List<TeamDTO> teams, List<MatchDTO> matches){
        Map<String, IndividualPlayerDTO> playerStatsMap = new HashMap<>();
        for(TeamDTO curTeam : teams){
            for(PlayerDTO curPlayer : curTeam.getPlayers()){
                IndividualPlayerDTO curPlayerStats = new IndividualPlayerDTO(curPlayer);
                playerStatsMap.put(curPlayerStats.getId(), curPlayerStats);
            }
        }
        // add each player match data to the stats map
        for(MatchDTO curMatch : matches){
            populateMatch(playerStatsMap, curMatch);
        }
        // return populated and calculated playerStatsMap
        return playerStatsMap;
    }

    private void populateMatch(Map<String, IndividualPlayerDTO> playerStatsMap, MatchDTO curMatch){
        List<MatchTeamDTO> curTeams = curMatch.getTeams();

        // for each match, fill out stats for each player
        for(int teamNumber = 0; teamNumber < curTeams.size(); teamNumber++){
            // grab current team
            MatchTeamDTO curMatchTeam = curTeams.get(teamNumber);
            List<MatchPlayerDTO> players = curMatchTeam.getPlayers();
            for(MatchPlayerDTO curPlayer : players){
                populatePlayer(playerStatsMap, curPlayer);
            }
        }
    }

    /**
     * Given a list of MatchPlayerDTO, creates a list of TeamTossupValuesDTO the tossup value and number of each player.
     * @param playerStatsMap
     * @param curPlayer
     * @return populated teamStatsDTO
     */
    private void populatePlayer(Map<String, IndividualPlayerDTO> playerStatsMap, MatchPlayerDTO curPlayer){
        IndividualPlayerDTO curPlayerStats = playerStatsMap.get(curPlayer.getPlayerId());
        curPlayerStats.setGamesPlayed(1 + curPlayerStats.getGamesPlayed());
        // add tossups heard
        curPlayerStats.setTossupsHeard(curPlayer.getTossupsHeard() + curPlayerStats.getTossupsHeard());

        // add individual tossups
        List<PlayerTossupValuesDTO> curPlayerTossupList = curPlayer.getTossupValues();
        for(int tossupType = 0; tossupType < curPlayerTossupList.size(); tossupType++){
            PlayerTossupValuesDTO curTossup = curPlayerTossupList.get(tossupType);
            // add current number of points to total
            curPlayerStats.setPointsEarned(curTossup.getNumber() * curTossup.getValue()
                                        + curPlayerStats.getPointsEarned());
            // update power, base, neg
            if(curTossup.getValue() > 10){
                curPlayerStats.setNumPowers(curTossup.getNumber()
                        + curPlayerStats.getNumPowers());
            } else if(curTossup.getValue() < 0){
                curPlayerStats.setNumPowers(curTossup.getNumber()
                        + curPlayerStats.getNumNegs());
            } else {
                curPlayerStats.setNumBase(curTossup.getNumber()
                        + curPlayerStats.getNumNegs());
            }

            List<PlayerTossupValuesDTO> totalPlayerTossupList = curPlayerStats.getTossupValues();
            // If this is first entry, then enter player stats as the first team stat entry
            if(totalPlayerTossupList.size() < curPlayerTossupList.size()){
                PlayerTossupValuesDTO newTossupValue = new PlayerTossupValuesDTO();
                newTossupValue.setNumber(curTossup.getNumber());
                newTossupValue.setValue(curTossup.getValue());
                newTossupValue.setPlayerId(curPlayer.getPlayerId());
                newTossupValue.setMatchId("-1"); // set invalid match id because it does not matter
            }
            // if not first entry, then add player stats to the previous team stat entry
            else{
                PlayerTossupValuesDTO totalTossupValue = totalPlayerTossupList.get(tossupType);
                totalTossupValue.setNumber(curTossup.getNumber() +
                        totalTossupValue.getNumber());
            }
        }
    }

    /**
     * Calculates the remaining statistics once map has been populated
     * @param playerStatsMap
     */
    private void calculateStats(Map<String, IndividualPlayerDTO> playerStatsMap){
        for(Map.Entry<String, IndividualPlayerDTO> curPlayer : playerStatsMap.entrySet()){
            IndividualPlayerDTO curPlayerStats = curPlayer.getValue();
            curPlayerStats.setPpth((double) curPlayerStats.getPointsEarned() / curPlayerStats.getTossupsHeard());
            curPlayerStats.setPnRatio((double) curPlayerStats.getNumPowers() / curPlayerStats.getNumNegs());
            curPlayerStats.setPpg((double) curPlayerStats.getPointsEarned() / curPlayerStats.getGamesPlayed());
        }
    }

    private List<IndividualPlayerDTO> calculateRank(Map<String, IndividualPlayerDTO> playerStatsMap){
        List<IndividualPlayerDTO> rankedPlayerList = new ArrayList<>();
        for(IndividualPlayerDTO curPlayer : playerStatsMap.values()){
            rankedPlayerList.add(curPlayer);
        }
        Collections.sort(rankedPlayerList);
        // assign rank from lowest to highest
        for(int rank = rankedPlayerList.size(); rank > 0; rank--){
            rankedPlayerList.get(rankedPlayerList.size() - rank).setRank(rank);
        }

        return rankedPlayerList;
    }
}