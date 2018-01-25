package calculators;

import interfaces.*;
import interfaces.stats.FullTeamStatsCalculationResultDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullTeamStatsCalculator implements StatsCalculator {
    @Override
    /** Calculate the entire team standings and returns a Data Transfer Object containing team standing info.
     */
    public FullTeamStatsCalculationResultDTO calculate(StatsGenerationRequestDTO statsGenerationRequest) {
        FullTeamStatsCalculationResultDTO results = new FullTeamStatsCalculationResultDTO();
        // initialize
        List<TeamDTO> teams = statsGenerationRequest.getTeams();
        List<MatchDTO> matches = statsGenerationRequest.getMatches();
        // go through teams
        // stats go in order of Win, Loss, Tie, Win pct, PPG, PAPG, Margin, TUH, PPTH, P/N, G/N, PPB
        Map<String, List<MatchTeamStatsDTO>> teamStatsMap = new HashMap<>();
        List<MatchTeamStatsDTO> stats = new ArrayList<>();
        // fill stats with each team
        for(MatchDTO curMatch: matches){
            // calculate team 1
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
                    List<MatchTeamStatsDTO> matchTeamStatsDTOList = new ArrayList<>();
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
        for(MatchDTO curMatch: matches){
            int tossupsHeard = curMatch.getTossupsHeard();
            List<MatchTeamDTO> curTeams = curMatch.getTeams();
            for(MatchTeamDTO curMatchTeam: curTeams){
                String curId = curMatchTeam.getTeamId();
                int scoreTotal = curMatchTeam.getScore();
                List<MatchPlayerDTO> curPlayers = curMatchTeam.getPlayers();
                for(int k = 0; k < curPlayers.size(); k++){

                }
            }

        }
        return new HashMap<>();
    }
}
