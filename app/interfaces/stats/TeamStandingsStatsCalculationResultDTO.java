package interfaces.stats;

import enums.StatReportType;

/**
 * Interface for team standing results
 */
public class TeamStandingsStatsCalculationResultDTO extends StatsCalculationResultDTO {

    @Override
    public StatReportType getStatReportType() {
        return StatReportType.TEAM_STANDINGS;
    }
}
