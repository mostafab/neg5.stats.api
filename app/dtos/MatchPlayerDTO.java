package dtos;

import java.util.List;

/**
 * Interface for a match player
 */
public class MatchPlayerDTO {

    private String playerId;
    private Integer tossupsHeard;
    private List<PlayerTossupValuesDTO> tossupValues;

    private String teamId;
    private String matchId;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Integer getTossupsHeard() {
        return tossupsHeard;
    }

    public void setTossupsHeard(Integer tossupsHeard) {
        this.tossupsHeard = tossupsHeard;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public List<PlayerTossupValuesDTO> getTossupValues() {
        return tossupValues;
    }

    public void setTossupValues(List<PlayerTossupValuesDTO> tossupValues) {
        this.tossupValues = tossupValues;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getMatchId() {
        return matchId;
    }
}
