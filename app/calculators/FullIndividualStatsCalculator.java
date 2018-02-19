package calculators;

import interfaces.*;
import interfaces.stats.FullIndividualStatsCalculationResultDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
