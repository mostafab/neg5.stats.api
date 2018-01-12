package calculators;

import interfaces.MatchDTO;
import interfaces.StatsGenerationRequestDTO;
import interfaces.TeamDTO;
import interfaces.stats.TeamStandingsStatsCalculationResultDTO;
import interfaces.TeamStatsDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Calculator for team standings
 */
public class TeamStandingsStatsCalculator implements StatsCalculator<TeamStandingsStatsCalculationResultDTO> {

    @Override
    /**
     * Calculate the entire team standings and returns a Data Transfer Object containing team standing info.
     */
    public TeamStandingsStatsCalculationResultDTO calculate(StatsGenerationRequestDTO statsGenerationRequest) {
		TeamStandingsStatsCalculationResultDTO results = new TeamStandingsStatsCalculationResultDTO();
		// initialize
		List<TeamDTO> teams = statsGenerationRequest.getTeams();
		List<MatchDTO> matches = statsGenerationRequest.getMatches();
		// go through teams
		// stats go in order of Win, Loss, Tie, Win pct, PPG, PAPG, Margin, TUH, PPTH, P/N, G/N, PPB
		List<TeamStatsDTO> stats = new ArrayList<TeamStatsDTO>();
		// fill stats with each team


		// calculate stats from matches


		results.setStats(stats);
		return results;
	}
}
