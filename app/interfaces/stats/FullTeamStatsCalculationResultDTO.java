package interfaces.stats;

import enums.StatReportType;

public class FullTeamStatsCalculationResultDTO  extends StatsCalculationResultDTO {


    @Override
    public StatReportType getStatReportType() { return StatReportType.TEAM_FULL; }

}
