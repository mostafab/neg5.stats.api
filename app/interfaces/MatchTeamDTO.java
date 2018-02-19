package interfaces;

import java.util.List;

/**
 * Represents a team in a match
 */
public class MatchTeamDTO {

    private String teamId;
    private Integer score;
    private Integer bouncebackPoints;
    private Integer overtimeTossups;
    private List<MatchPlayerDTO> players;

    private String matchId;

    public MatchTeamDTO(String teamId, Integer score, Integer bouncebackPoints, Integer overtimeTossups, String matchId)
    {
      this.teamId = teamId;
      this.score = score;
      this.bouncebackPoints = bouncebackPoints;
      this.overtimeTossups = overtimeTossups;
      this.matchId = matchId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getBouncebackPoints() {
        return bouncebackPoints;
    }

    public void setBouncebackPoints(Integer bouncebackPoints) {
        this.bouncebackPoints = bouncebackPoints;
    }

    public Integer getOvertimeTossups() {
        return overtimeTossups;
    }

    public void setOvertimeTossups(Integer overtimeTossups) {
        this.overtimeTossups = overtimeTossups;
    }

    public List<MatchPlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<MatchPlayerDTO> players) {
        this.players = players;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
}
