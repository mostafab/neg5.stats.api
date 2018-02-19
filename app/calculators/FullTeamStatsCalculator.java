package calculators;

import interfaces.*;
import interfaces.stats.FullTeamStatsCalculationResultDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullTeamStatsCalculator implements StatsCalculator {
    @Override
    public FullTeamStatsCalculationResultDTO calculate(StatsGenerationRequestDTO statsGenerationRequest) {
        FullTeamStatsCalculationResultDTO results = new FullTeamStatsCalculationResultDTO();
        // initialize
        List<TeamDTO> teams = statsGenerationRequest.getTeams();
        List<MatchDTO> matches = statsGenerationRequest.getMatches();

        // stats go in order of Win, Loss, Tie, Win pct, PPG, PAPG, Margin, TUH, PPTH, P/N, G/N, PPB
        Map<String, List<MatchTeamStatsDTO>> teamStatsMap = new HashMap<>();

        // go through teams
        for(TeamDTO curTeam: teams){
            List<MatchTeamStatsDTO> newMatchList = new ArrayList<>();
            teamStatsMap.put(curTeam.getId(), newMatchList);
        }

        // list of team standings to be displayed
        List<MatchTeamStatsDTO> fullStandingStats = new ArrayList<>();

        // fill stats with each team
        for(MatchDTO curMatch: matches){
            // add and calculate results for each team of the match
            for(MatchTeamDTO curMatchTeam : curMatch.getTeams()){
                String curTeamId = curMatchTeam.getTeamId();
                MatchTeamStatsDTO curMatchTeamStats = new MatchTeamStatsDTO(curMatchTeam, curMatch);
                // calculate the statistics
                // curMatchTeamStats.calculate();

                List<MatchTeamStatsDTO> matchTeamStatsDTOList = teamStatsMap.get(curTeamId);
                matchTeamStatsDTOList.add(curMatchTeamStats);
                teamStatsMap.put(curTeamId, matchTeamStatsDTOList);
            }
        }

        // convert map back to sorted list
        // calculate stats from matches
        // maybe make team stats dto
        results.setStats(fullStandingStats);
        return results;
    }

    private Map<String, MatchTeamStatsDTO> populateMap(List<MatchDTO> matches){
        // go through each match and add the stats to the map
        for(MatchDTO curMatch: matches){
            int tossupsHeard = curMatch.getTossupsHeard();
            List<MatchTeamDTO> curTeams = curMatch.getTeams();
            for(MatchTeamDTO curMatchTeam : curTeams){
                String curId = curMatchTeam.getTeamId();
                int scoreTotal = curMatchTeam.getScore();
                List<MatchPlayerDTO> curPlayers = curMatchTeam.getPlayers();
                for(MatchPlayerDTO curMatchPlayer : curPlayers){

                }
            }

        }
        return new HashMap<>();
    }
}
