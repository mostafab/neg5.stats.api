package calculators;

import interfaces.StatsGenerationRequestDTO;
import interfaces.stats.FullIndividualStatsCalculationResultDTO;

/**
 * Calculator for full individual stats
 */
public class FullIndividualStatsCalculator implements StatsCalculator<FullIndividualStatsCalculationResultDTO> {

    @Override
    public FullIndividualStatsCalculationResultDTO calculate(StatsGenerationRequestDTO statsGenerationRequest) {
        return new FullIndividualStatsCalculationResultDTO();
    }
}
