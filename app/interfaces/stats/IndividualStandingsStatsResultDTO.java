package interfaces.stats;

import enums.StatReportType;

public class IndividualStandingsStatsResultDTO extends StatsCalculationResultDTO {

    @Override
    public StatReportType getStatReportType() { return StatReportType.INDIVIDUAL_STANDINGS; }
}
