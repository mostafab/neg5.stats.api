package services;

import calculators.FullIndividualStatsCalculator;
import calculators.TeamStandingsStatsCalculator;
import com.google.inject.Inject;
import interfaces.StatsGenerationRequestDTO;
import interfaces.stats.FullIndividualStatsCalculationResultDTO;
import interfaces.stats.StatsCalculationResultDTO;
import interfaces.stats.TeamStandingsStatsCalculationResultDTO;

import java.time.Instant;

/**
 * Implementation of {@link StatsCalculationService}
 */
public class StatsCalculationServiceImpl implements StatsCalculationService {

    @Inject private TeamStandingsStatsCalculator teamStandingsStatsCalculator;
    @Inject private FullIndividualStatsCalculator fullIndividualStatsCalculator;

    @Override
    public TeamStandingsStatsCalculationResultDTO calculateTeamStandings(StatsGenerationRequestDTO
                                                                                      generationRequestDTO) {
        TeamStandingsStatsCalculationResultDTO results = teamStandingsStatsCalculator.calculate(generationRequestDTO);
        populateWithGenerationRequestInfo(results, generationRequestDTO);

        return results;
    }

    @Override
    public void calculateIndividualStandings(StatsGenerationRequestDTO generationRequestDTO) {

    }

    @Override
    public void calculateFullTeamStats(StatsGenerationRequestDTO generationRequestDTO) {

    }

    @Override
    public FullIndividualStatsCalculationResultDTO calculateFullIndividualStats(StatsGenerationRequestDTO
                                                                                            generationRequestDTO) {
        FullIndividualStatsCalculationResultDTO fullIndividualStandings = fullIndividualStatsCalculator.calculate(generationRequestDTO);
        populateWithGenerationRequestInfo(fullIndividualStandings, generationRequestDTO);
        return fullIndividualStandings;
    }

    @Override
    public void calculateRoundReport(StatsGenerationRequestDTO generationRequestDTO) {

    }

    private void populateWithGenerationRequestInfo(StatsCalculationResultDTO statsCalculationResult,
                                                                        StatsGenerationRequestDTO requestDTO) {
        statsCalculationResult.setTournamentId(requestDTO.getTournamentId());
        statsCalculationResult.setCalculatedAt(Instant.now());
        statsCalculationResult.setPhaseId(requestDTO.getPhaseId());
    }

}
