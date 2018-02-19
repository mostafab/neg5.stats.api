package interfaces.stats;

import enums.StatReportType;

public class RoundReportStatsCalculationResultDTO extends StatsCalculationResultDTO {

    @Override
    public StatReportType getStatReportType() { return StatReportType.ROUND_REPORT; }
}
