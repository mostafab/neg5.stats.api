package calculators;


import enums.TossupType;
import interfaces.*;
import interfaces.individual.FullIndividualPlayerDTO;
import interfaces.individual.IndividualMatchPlayerDTO;
import interfaces.individual.IndividualStandingsDTO;
import interfaces.stats.FullIndividualStatsCalculationResultDTO;
import interfaces.stats.StatsCalculationResultDTO;

import java.util.*;


public class IndividualStandingsStatsCalculator implements StatsCalculator{
    @Override
    public StatsCalculationResultDTO calculate(StatsGenerationRequestDTO statsGenerationRequest) {
        StatsCalculationResultDTO results = new FullIndividualStatsCalculationResultDTO();
        List<TeamDTO> teams = statsGenerationRequest.getTeams();

        // use the FullIndividualStatsCalculator and then turn each round stats into cumulative stats
        StatsCalculator fullIndividualStatsCalculator = new FullIndividualStatsCalculator();
        StatsCalculationResultDTO individualResults = fullIndividualStatsCalculator.calculate(statsGenerationRequest);
        List<FullIndividualPlayerDTO> individualResultsList = individualResults.getStats();
        // take a full individual playerStatsMap first
        Map<String, IndividualStandingsDTO> playerStatsMap = new HashMap<>();

        // initialize each player entry within the playerStatsMap
        for(TeamDTO curTeam: teams){
            List<PlayerDTO> players = curTeam.getPlayers();
            for(PlayerDTO curPlayer: players){
                IndividualStandingsDTO newStandingsPlayer = new IndividualStandingsDTO(curPlayer);
                String curPlayerId = curPlayer.getId();
                playerStatsMap.put(curPlayerId, newStandingsPlayer);
            }
        }

        // populate each player entry within the playerStatsMap
        for(FullIndividualPlayerDTO curFullIndividualPlayer : individualResultsList){
            String curPlayerId = curFullIndividualPlayer.getId();
            populatePlayer(playerStatsMap, curFullIndividualPlayer);
            calculateStats(playerStatsMap, playerStatsMap.get(curPlayerId));
        }

        // convert map back to sorted list
        List<IndividualStandingsDTO> stats = new ArrayList<>();
        for(Map.Entry<String, IndividualStandingsDTO> playerEntry : playerStatsMap.entrySet()){
            stats.add(playerEntry.getValue());
        }

        // sort players and add ranks
        Collections.sort(stats);
        for(int rank = 0; rank < stats.size(); rank++){
            stats.get(rank).setRank(rank + 1);
        }
        results.setStats(stats);

        return results;
    }


    private void populatePlayer(Map<String, IndividualStandingsDTO> playerStatsMap, FullIndividualPlayerDTO fullIndividualResult) {
        String curPlayerId = fullIndividualResult.getId();
        IndividualStandingsDTO curPlayerStandings = playerStatsMap.get(curPlayerId);

        // add the stats from each round
        List<IndividualMatchPlayerDTO> matches = fullIndividualResult.getMatches();
        for(IndividualMatchPlayerDTO curMatchPlayer : matches){
            curPlayerStandings.setGamesPlayed(curPlayerStandings.getGamesPlayed() + 1);
            curPlayerStandings.setNumPowers(curPlayerStandings.getNumPowers() + curMatchPlayer.getNumPowers());
            curPlayerStandings.setNumBase(curPlayerStandings.getNumBase() + curMatchPlayer.getNumBase());
            curPlayerStandings.setNumNegs(curPlayerStandings.getNumNegs() + curMatchPlayer.getNumNegs());

            // add tossup values
            List<PlayerTossupValuesDTO> totalTossupVals = curPlayerStandings.getTossupValues();
            List<PlayerTossupValuesDTO> curTossupVals = curMatchPlayer.getTossupValues();
            for(int tossupType = 0; tossupType < curTossupVals.size(); tossupType++) {
                if (tossupType >= totalTossupVals.size()) {
                    totalTossupVals.add(curTossupVals.get(tossupType));
                } else {
                    PlayerTossupValuesDTO totalTossupType = totalTossupVals.get(tossupType);
                    PlayerTossupValuesDTO curTossupType = curTossupVals.get(tossupType);
                    totalTossupType.setNumber(totalTossupType.getNumber() + curTossupType.getNumber());
                }
            }
            curPlayerStandings.setTossupsHeard(curPlayerStandings.getTossupsHeard() + curMatchPlayer.getTossupsHeard());
            curPlayerStandings.setPointsEarned(curPlayerStandings.getPointsEarned() + curMatchPlayer.getPointsEarned());
        }
    }
    /**
     * Calculates the remaining statistics once map has been populated.
     * @param curPlayer
     */
    private void calculateStats(Map<String, IndividualStandingsDTO> playerStatsMap, IndividualStandingsDTO curPlayer){
        String curPlayerId = curPlayer.getId();
        if(curPlayer.getTossupsHeard() > 0){
            curPlayer.setPpth((double) curPlayer.getPointsEarned() / curPlayer.getTossupsHeard());
            curPlayer.setPpg((double) curPlayer.getPointsEarned() / curPlayer.getGamesPlayed());
            if(curPlayer.getNumNegs() > 0){
                curPlayer.setPnRatio((double) curPlayer.getNumPowers() / curPlayer.getNumNegs());
                curPlayer.setGnRatio((double) (curPlayer.getNumPowers() + curPlayer.getNumBase()) / curPlayer.getNumNegs());
            }
            // set neg ratios to infinity
            else{
                curPlayer.setPnRatio(Double.POSITIVE_INFINITY);
                curPlayer.setGnRatio(Double.POSITIVE_INFINITY);
            }
        } else {
            curPlayer.setPpth(0d);
            curPlayer.setPpg(0d);
        }
        // put player back
        playerStatsMap.put(curPlayerId, curPlayer);
    }

    private List<IndividualStandingsDTO> calculateRank(Map<String, IndividualStandingsDTO> playerStatsMap){
        List<IndividualStandingsDTO> rankedPlayerList = new ArrayList<>();
        for(IndividualStandingsDTO curPlayer : playerStatsMap.values()){
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