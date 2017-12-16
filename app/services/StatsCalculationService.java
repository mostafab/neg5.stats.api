package services;

import interfaces.StatsGenerationRequestDTO;
import interfaces.stats.FullIndividualStatsCalculationResultDTO;
import interfaces.stats.TeamStandingsStatsCalculationResultDTO;

/**
 * Service to calculate stats
 */
public interface StatsCalculationService {

    /**
     * Calculate team standings
     * @param generationRequestDTO the generation request
     * @return result of calculation
     */
    TeamStandingsStatsCalculationResultDTO calculateTeamStandings(StatsGenerationRequestDTO generationRequestDTO);

    /**
     * Calculate individual standings
     * @param generationRequestDTO  generation request
     */
    void calculateIndividualStandings(StatsGenerationRequestDTO generationRequestDTO);

    /**
     * Calculate full team stats
     * @param generationRequestDTO generation request
     */
    void calculateFullTeamStats(StatsGenerationRequestDTO generationRequestDTO);

    /**
     * Calculate full individual stats
     * @param generationRequestDTO generation request
     * @return result of calculation
     */
    FullIndividualStatsCalculationResultDTO calculateFullIndividualStats(StatsGenerationRequestDTO generationRequestDTO);

    /**
     * Calculate round report stats
     * @param generationRequestDTO generation request
     */
    void calculateRoundReport(StatsGenerationRequestDTO generationRequestDTO);
}
