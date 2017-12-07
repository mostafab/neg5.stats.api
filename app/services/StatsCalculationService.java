package services;

import dtos.StatsGenerationRequestDTO;
import dtos.stats.FullIndividualStatsCalculationResultDTO;
import dtos.stats.TeamStandingsStatsCalculationResultDTO;

public interface StatsCalculationService {

    TeamStandingsStatsCalculationResultDTO calculcateTeamStandings(StatsGenerationRequestDTO generationRequestDTO);

    void calculateIndividualStandings(StatsGenerationRequestDTO generationRequestDTO);

    void calculateFullTeamStats(StatsGenerationRequestDTO generationRequestDTO);

    FullIndividualStatsCalculationResultDTO calculateFullIndividualStats(StatsGenerationRequestDTO generationRequestDTO);

    void calculateRoundReport(StatsGenerationRequestDTO generationRequestDTO);
}
