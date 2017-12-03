package services;

import dtos.StatsGenerationRequestDTO;

public interface StatsCalculationService {

    void calculcateTeamStandings(StatsGenerationRequestDTO generationRequestDTO);

    void calculateIndividualStandings(StatsGenerationRequestDTO generationRequestDTO);

    void calculateFullTeamStats(StatsGenerationRequestDTO generationRequestDTO);

    void calculateFullIndividualStats(StatsGenerationRequestDTO generationRequestDTO);

    void calculateRoundReport(StatsGenerationRequestDTO generationRequestDTO);
}
