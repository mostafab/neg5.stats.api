package controllers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dtos.StatsGenerationRequestDTO;
import dtos.stats.FullIndividualStatsCalculationResultDTO;
import mvc.ApiResult;
import mvc.HttpRequestHelper;
import play.mvc.Controller;
import play.mvc.Result;
import services.StatsCalculationService;

@Singleton
public class StatsController extends Controller {

    private StatsCalculationService statsCalculationService;
    private HttpRequestHelper httpRequestHelper;

    @Inject
    public StatsController(StatsCalculationService statsCalculationService,
                           HttpRequestHelper httpRequestHelper) {
        this.statsCalculationService = statsCalculationService;
        this.httpRequestHelper = httpRequestHelper;
    }

    /**
     * Calculate full individual stats
     * @param tournamentId the tournament id
     * @return A {@link Result} json payload of calculation
     */
    public Result fullIndividual(String tournamentId) {
        StatsGenerationRequestDTO statsRequest = httpRequestHelper.deserializeRequest(request(),
                StatsGenerationRequestDTO.class);
        statsRequest.setTournamentId(tournamentId);
        return new ApiResult<FullIndividualStatsCalculationResultDTO>()
                .success(statsCalculationService.calculateFullIndividualStats(statsRequest));
    }

}
