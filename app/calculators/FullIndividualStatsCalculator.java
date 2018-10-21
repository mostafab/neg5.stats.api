package calculators;

import interfaces.*;
import interfaces.individual.FullIndividualPlayerDTO;
import interfaces.individual.IndividualMatchPlayerDTO;
import interfaces.stats.FullIndividualStatsCalculationResultDTO;

import java.util.*;

/**
 * Calculator for full individual stats
 */
public class FullIndividualStatsCalculator implements StatsCalculator<FullIndividualStatsCalculationResultDTO> {

    @Override
    public FullIndividualStatsCalculationResultDTO calculate(StatsGenerationRequestDTO statsGenerationRequest) {
        FullIndividualStatsCalculationResultDTO results = new FullIndividualStatsCalculationResultDTO();
        List<TeamDTO> teams = statsGenerationRequest.getTeams();
        List<MatchDTO> matches = statsGenerationRequest.getMatches();

        // Map of players
        Map<String, FullIndividualPlayerDTO> playerStatsMap = new HashMap<>();

        // initialize map
        for(TeamDTO curTeam : teams){
            for(PlayerDTO curPlayer : curTeam.getPlayers()){
                FullIndividualPlayerDTO curFullIndividualPlayer = new FullIndividualPlayerDTO(curPlayer);
                List<IndividualMatchPlayerDTO> individualMatchList = new ArrayList<>();
                curFullIndividualPlayer.setMatches(individualMatchList);
                playerStatsMap.put(curFullIndividualPlayer.getId(), curFullIndividualPlayer);
            }
        }
        List<FullIndividualPlayerDTO> resultsList = new ArrayList<>(playerStatsMap.values());
        Collections.sort(resultsList);
        results.setStats(resultsList);
        return results;
    }

    /**
     * populates the given player stats map with a list of IndividualMatchPlayerDTOs for each match
     * @param playerStatsMap
     * @param matches
     */
    private void populateMatches(Map<String, FullIndividualPlayerDTO> playerStatsMap, List<MatchDTO> matches){
        for(MatchDTO curMatch : matches){
            for(MatchTeamDTO curMatchTeam : curMatch.getTeams()){
                for(MatchPlayerDTO curMatchPlayer : curMatchTeam.getPlayers()){
                    IndividualMatchPlayerDTO curIndMatchPlayer = new IndividualMatchPlayerDTO(curMatchPlayer);
                    populatePlayer(curIndMatchPlayer, curMatch, curMatchTeam);
                    calculatePlayer(curIndMatchPlayer);
                    // after calculating everything, place this curIndMatchPlayer in the list of
                    playerStatsMap.get(curIndMatchPlayer.getPlayerId()).getMatches().add(curIndMatchPlayer);
                }
            }
        }
    }

    private void populatePlayer(IndividualMatchPlayerDTO curIndMatchPlayer, MatchDTO curMatch, MatchTeamDTO curTeam){
        curIndMatchPlayer.setRoundNumber(curMatch.getRound());
        // find opponentId
        for(MatchTeamDTO curMatchTeam : curMatch.getTeams()){
            if(!curMatchTeam.getTeamId().equals(curTeam.getTeamId())) {
                curIndMatchPlayer.setOpponentId(curMatchTeam.getTeamId());
            }
        }

        // populate with PlayerTossupValuesDTO
        for(PlayerTossupValuesDTO curTossup : curIndMatchPlayer.getTossupValues()){
            Integer num = curTossup.getNumber();
            Integer val = curTossup.getValue();
            curIndMatchPlayer.setPointsEarned(curIndMatchPlayer.getPointsEarned() + num * val);
            if(val > 10){
                curIndMatchPlayer.setNumPowers(curIndMatchPlayer.getNumPowers() + num);
            } else if (val == 10){
                curIndMatchPlayer.setNumBase(curIndMatchPlayer.getNumBase() + num);
            } else if (val < 0){
                curIndMatchPlayer.setNumNegs(curIndMatchPlayer.getNumNegs() + num);
            }
        }
    }

    private void calculatePlayer(IndividualMatchPlayerDTO curIndMatchPlayer){
        // retrieve basic stats
        Integer numPowers = curIndMatchPlayer.getNumPowers();
        Integer numNegs = curIndMatchPlayer.getNumNegs();
        Integer numBase = curIndMatchPlayer.getNumBase();
        Integer tossupsHeard = curIndMatchPlayer.getTossupsHeard();
        Integer pointsEarned = curIndMatchPlayer.getTossupsHeard();

        // calculate advanced stats
        // if there have been 0 tossups heard, then ptu ratio is infinity
        if(curIndMatchPlayer.getTossupsHeard() == 0){
            curIndMatchPlayer.setPtuRatio(Double.POSITIVE_INFINITY);
            // if there have been 0 negs, then pn and gn ratio is infinity
            if(curIndMatchPlayer.getNumNegs() == 0){
                curIndMatchPlayer.setPnRatio(Double.POSITIVE_INFINITY);
                curIndMatchPlayer.setGnRatio(Double.POSITIVE_INFINITY);
            }
            else {
                curIndMatchPlayer.setPnRatio((double) numPowers / numNegs);
                curIndMatchPlayer.setGnRatio((double) (numBase + numPowers) / numNegs);
            }
        }
        else {
           curIndMatchPlayer.setPtuRatio((double) pointsEarned / tossupsHeard);
        }
    }
}
