package interfaces.stats;

import enums.StatReportType;

/**
 * Stats DTO for full individual stats
 */
public class FullIndividualStatsCalculationResultDTO extends StatsCalculationResultDTO {

    @Override
    public StatReportType getStatReportType() {
        return StatReportType.INDIVIDUAL_FULL;
    }
}
