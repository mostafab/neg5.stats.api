package interfaces;

import enums.TossupType;

public class TeamTossupValuesDTO {
    private Integer value;
    private Integer number;
    private String teamId;
    private TossupType type;

    private String matchId;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) { this.teamId = teamId; }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public TossupType getType() {
        return type;
    }

    public void setType(TossupType type) {
        this.type = type;
    }
}