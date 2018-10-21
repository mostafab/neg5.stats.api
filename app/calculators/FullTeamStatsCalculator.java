package calculators;

import interfaces.*;
import interfaces.individual.FullIndividualPlayerDTO;
import interfaces.individual.IndividualStandingsDTO;
import interfaces.stats.FullIndividualStatsCalculationResultDTO;
import interfaces.stats.FullTeamStatsCalculationResultDTO;
import interfaces.stats.StatsCalculationResultDTO;
import interfaces.team.FullTeamStatsDTO;
import interfaces.team.MatchTeamStatsDTO;

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
        // use the IndividualStandingsCalculator
        StatsCalculationResultDTO fullIndividualResults = new FullIndividualStatsCalculationResultDTO();
        StatsCalculator individualStatsCalculator = new IndividualStandingsStatsCalculator();
        StatsCalculationResultDTO individualResults = individualStatsCalculator.calculate(statsGenerationRequest);
        List<IndividualStandingsDTO> individualResultsList = individualResults.getStats();

        // stats go in order of Win, Loss, Tie, Win pct, PPG, PAPG, Margin, TUH, PPTH, P/N, G/N, PPB
        Map<String, FullTeamStatsDTO> teamStatsMap = new HashMap<>();

        // go through teams
        for(TeamDTO curTeam: teams){
            FullTeamStatsDTO newFullTeamStats = new FullTeamStatsDTO(curTeam);
            String curTeamId = curTeam.getId();
            teamStatsMap.put(curTeamId, newFullTeamStats);
        }

        // go through players to pair teams with player stats
        for(IndividualStandingsDTO curPlayerStats : individualResultsList){
            String curTeamId = curPlayerStats.getTeamId();
            FullTeamStatsDTO curFullTeamStats = teamStatsMap.get(curTeamId);
            // add new player
            List<IndividualStandingsDTO> totalPlayers = curFullTeamStats.getPlayerStats();
            totalPlayers.add(curPlayerStats);
            curFullTeamStats.setPlayerStats(totalPlayers);
        }

        // fill stats with each team
        for(MatchDTO curMatch: matches){
            // add and calculate results for each team of the match
            for(MatchTeamDTO curMatchTeam : curMatch.getTeams()){
                String curTeamId = curMatchTeam.getTeamId();
                MatchTeamStatsDTO curMatchTeamStats = new MatchTeamStatsDTO(curMatchTeam, curMatch);

                // calculate the statistics
                calculateStats(curMatchTeamStats);
                // put the newly calculated statistics into the matches list
                FullTeamStatsDTO curFullTeamStats = teamStatsMap.get(curTeamId);
                curFullTeamStats.getMatches().add(curMatchTeamStats);
                teamStatsMap.put(curTeamId, curFullTeamStats);
            }
        }

        // convert map back to sorted list
        // calculate stats from matches
        results.setStats(new ArrayList<>(teamStatsMap.values()));
        return results;
    }

    private void calculateStats(MatchTeamStatsDTO curMatchTeamStats){
        if(curMatchTeamStats.getTuh() > 0){
            curMatchTeamStats.setPpth((double) curMatchTeamStats.getPointsTotal() / curMatchTeamStats.getTuh());
            if(curMatchTeamStats.getBonusHeard() > 0){
                curMatchTeamStats.setPpb((double) (curMatchTeamStats.getPointsBonus() + curMatchTeamStats.getPointsBounceback()) /
                curMatchTeamStats.getBonusHeard());
                if(curMatchTeamStats.getNumNeg() > 0){
                    curMatchTeamStats.setGnRatio((double) (curMatchTeamStats.getNumBase() + curMatchTeamStats.getNumPow())
                    / curMatchTeamStats.getNumNeg());
                    curMatchTeamStats.setPnRatio((double) curMatchTeamStats.getNumPow() / curMatchTeamStats.getNumNeg());
                } else{
                    curMatchTeamStats.setGnRatio(Double.POSITIVE_INFINITY);
                    curMatchTeamStats.setPnRatio(Double.POSITIVE_INFINITY);
                }
            } else{
                curMatchTeamStats.setPpb(0d);
            }
        } else {
            curMatchTeamStats.setPpth(0d);
        }
    }
}
