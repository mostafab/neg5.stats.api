package services;

import dtos.StatsGenerationRequestDTO;
import dtos.stats.FullIndividualStatsCalculationResultDTO;
import dtos.stats.StatsCalculationResultDTO;
import dtos.stats.TeamStandingsStatsCalculationResultDTO;

import java.time.Instant;

/**
 * Implementation of {@link StatsCalculationService}
 */
public class StatsCalculationServiceImpl implements StatsCalculationService {

    @Override
    public TeamStandingsStatsCalculationResultDTO calculcateTeamStandings(StatsGenerationRequestDTO
                                                                                      generationRequestDTO) {
        TeamStandingsStatsCalculationResultDTO teamStandings = new TeamStandingsStatsCalculationResultDTO();
        populateWithGenerationRequestInfo(teamStandings, generationRequestDTO);
        return teamStandings;
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
        FullIndividualStatsCalculationResultDTO fullIndividualStandings = new FullIndividualStatsCalculationResultDTO();
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
