package controllers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import interfaces.StatsGenerationRequestDTO;
import interfaces.stats.FullIndividualStatsCalculationResultDTO;
import mvc.ApiResult;
import mvc.HttpRequestHelper;
import play.mvc.Controller;
import play.mvc.Result;
import services.StatsCalculationService;

@Singleton
public class StatsController extends Controller {

    @Inject private StatsCalculationService statsCalculationService;
    @Inject private HttpRequestHelper httpRequestHelper;

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
