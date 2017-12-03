package dtos;

import java.util.List;

/**
 * Match interface
 */
public class MatchDTO {

    private String id;
    private String tournamentId;
    private Integer round;
    private Integer tossupsHeard;
    private List<MatchTeamDTO> teams;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getTossupsHeard() {
        return tossupsHeard;
    }

    public void setTossupsHeard(Integer tossupsHeard) {
        this.tossupsHeard = tossupsHeard;
    }

    public List<MatchTeamDTO> getTeams() {
        return teams;
    }

    public void setTeams(List<MatchTeamDTO> teams) {
        this.teams = teams;
    }
}
