package calculators;

import interfaces.StatsGenerationRequestDTO;
import interfaces.stats.StatsCalculationResultDTO;

/**
 * Interface for calculating stats
 * @param <T> The return type for stats
 */
public interface StatsCalculator<T extends StatsCalculationResultDTO> {

    /**
     * Calculate stats returning given stats type
     * @param statsGenerationRequest The generation request
     * @return The calculation result
     */
    T calculate(StatsGenerationRequestDTO statsGenerationRequest);

}
