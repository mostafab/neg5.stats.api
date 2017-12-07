package dtos.stats;

import enums.StatReportType;

import java.time.Instant;
import java.util.List;

/**
 * Base class for stats calculations. Implementing classes should
 * specify the stat report type.
 * @param <T> The type for array of stats
 */
public abstract class StatsCalculationResultDTO<T> {

    private String tournamentId;
    private String phaseId;
    private Instant calculatedAt;
    private List<T> stats;
    private StatReportType statReportType;

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(String phaseId) {
        this.phaseId = phaseId;
    }

    public Instant getCalculatedAt() {
        return calculatedAt;
    }

    public void setCalculatedAt(Instant calculatedAt) {
        this.calculatedAt = calculatedAt;
    }

    public List<T> getStats() {
        return stats;
    }

    public void setStats(List<T> stats) {
        this.stats = stats;
    }

    public abstract StatReportType getStatReportType();

    public void setStatReportType(StatReportType statReportType) {
        this.statReportType = statReportType;
    }
}
