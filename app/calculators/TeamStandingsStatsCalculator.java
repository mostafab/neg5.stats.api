package calculators;

import interfaces.StatsGenerationRequestDTO;
import interfaces.stats.TeamStandingsStatsCalculationResultDTO;

/**
 * Calculator for team standings
 */
public class TeamStandingsStatsCalculator implements StatsCalculator<TeamStandingsStatsCalculationResultDTO> {

    @Override
    public TeamStandingsStatsCalculationResultDTO calculate(StatsGenerationRequestDTO statsGenerationRequest) {
        return new TeamStandingsStatsCalculationResultDTO();
    }
}
