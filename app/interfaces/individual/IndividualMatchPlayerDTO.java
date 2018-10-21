package interfaces.individual;

import interfaces.MatchDTO;
import interfaces.MatchPlayerDTO;
import interfaces.MatchTeamDTO;
import interfaces.PlayerTossupValuesDTO;

public class IndividualMatchPlayerDTO extends MatchPlayerDTO {
    // meta stats
    private String playerName;
    private String playerTeam;
    private String opponentId;

    // numerical stats
    private Integer roundNumber;
    private String opponent;
    private Integer gamePoints;
    private Integer numPowers;
    private Integer numBase;
    private Integer numNegs;
    private Double ptuRatio;
    private Double pnRatio;
    private Double gnRatio;
    private Integer pointsEarned;

    public IndividualMatchPlayerDTO(){}

    public IndividualMatchPlayerDTO(MatchPlayerDTO curPlayer){
        super.setPlayerId(curPlayer.getPlayerId());
        super.setTeamId(curPlayer.getTeamId());
        super.setMatchId(curPlayer.getMatchId());
        super.setTossupsHeard(curPlayer.getTossupsHeard());
        super.setTossupValues(curPlayer.getTossupValues());
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public String getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(String opponentId) {
        this.opponentId = opponentId;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public Integer getGamePoints() {
        return gamePoints;
    }

    public void setGamePoints(Integer gamePoints) {
        this.gamePoints = gamePoints;
    }

    public Integer getNumPowers() {
        return numPowers;
    }

    public void setNumPowers(Integer numPowers) {
        this.numPowers = numPowers;
    }

    public Integer getNumBase() {
        return numBase;
    }

    public void setNumBase(Integer numBase) {
        this.numBase = numBase;
    }

    public Integer getNumNegs() {
        return numNegs;
    }

    public void setNumNegs(Integer numNegs) {
        this.numNegs = numNegs;
    }

    public Double getPtuRatio() {
        return ptuRatio;
    }

    public void setPtuRatio(Double ptuRatio) {
        this.ptuRatio = ptuRatio;
    }

    public Double getPnRatio() {
        return pnRatio;
    }

    public void setPnRatio(Double pnRatio) {
        this.pnRatio = pnRatio;
    }

    public Double getGnRatio() {
        return gnRatio;
    }

    public void setGnRatio(Double gnRatio) {
        this.gnRatio = gnRatio;
    }

    public Integer getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(Integer pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

}
