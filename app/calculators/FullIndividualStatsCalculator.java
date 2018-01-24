package calculators;

import interfaces.MatchDTO;
import interfaces.StatsGenerationRequestDTO;
import interfaces.TeamDTO;
import interfaces.stats.FullIndividualStatsCalculationResultDTO;

import java.util.List;

/**
 * Calculator for full individual stats
 */
public class FullIndividualStatsCalculator implements StatsCalculator<FullIndividualStatsCalculationResultDTO> {

    @Override
    public FullIndividualStatsCalculationResultDTO calculate(StatsGenerationRequestDTO statsGenerationRequest) {
        FullIndividualStatsCalculationResultDTO results = new FullIndividualStatsCalculationResultDTO();
        List<TeamDTO> teams = statsGenerationRequest.getTeams();
        List<MatchDTO> matches = statsGenerationRequest.getMatches();
        return results;
    }
}
