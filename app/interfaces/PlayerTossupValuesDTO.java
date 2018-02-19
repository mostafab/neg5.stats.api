package interfaces;

public class PlayerTossupValuesDTO {

    private Integer value;
    private Integer number;
    private String playerId;

    private String matchId;

    public PlayerTossupValuesDTO(Integer value, Integer number, String playerId, String matchId)
    {
      this.value = value;
      this.number = number;
      this.playerId = playerId;
      this.matchId = matchId;
    }

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

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
}
