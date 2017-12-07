package dtos;

import java.util.List;

/**
 * Payload sent to server to calculate stats
 */
public class StatsGenerationRequestDTO {

    private String tournamentId;
    private List<MatchDTO> matches;
    private List<TeamDTO> teams;
    private String phaseId;

    private List<TossupValueDTO> tossupValues;

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public List<MatchDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDTO> matches) {
        this.matches = matches;
    }

    public List<TeamDTO> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDTO> teams) {
        this.teams = teams;
    }

    public String getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(String phaseId) {
        this.phaseId = phaseId;
    }

    public List<TossupValueDTO> getTossupValues() {
        return tossupValues;
    }

    public void setTossupValues(List<TossupValueDTO> tossupValues) {
        this.tossupValues = tossupValues;
    }
}
