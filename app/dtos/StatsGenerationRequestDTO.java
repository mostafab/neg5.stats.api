package dtos;

import java.util.List;

/**
 * Payload sent to server to calculate stats
 */
public class StatsGenerationRequestDTO {

    private List<MatchDTO> matches;
    private List<TeamDTO> teams;
    private String phaseId;

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
}
