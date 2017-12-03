package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import dtos.StatsGenerationRequestDTO;
import mvc.ApiResult;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.StatsCalculationService;

@Singleton
public class StatsController extends Controller {

    private StatsCalculationService statsCalculationService;

    @Inject
    public StatsController(StatsCalculationService statsCalculationService) {
        this.statsCalculationService = statsCalculationService;
    }

    /**
     * Calculate full individual stats
     * @param tournamentId the tournament id
     * @return A {@link Result} json payload of calculation
     */
    public Result fullIndividual(String tournamentId) {
        StatsGenerationRequestDTO statsRequest = deserializeRequest();
        statsCalculationService.calculateFullIndividualStats(statsRequest);
        return new ApiResult<StatsGenerationRequestDTO>().success(statsRequest);
    }

    private StatsGenerationRequestDTO deserializeRequest() {
        JsonNode requestJson = request().body().asJson();
        return Json.fromJson(requestJson, StatsGenerationRequestDTO.class);
    }

}
