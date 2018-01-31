package interfaces;

import java.util.List;

public class IndividualPlayerDTO extends PlayerDTO implements Comparable{
    private Integer rank;
    private Integer gamesPlayed;
    private Integer numPowers;
    private Integer numBase;
    private Integer numNegs;
    private List<PlayerTossupValuesDTO> tossupValues;
    private Integer tossupsHeard;
    private Integer pointsEarned;
    private Double ppth;
    private Double pnRatio;
    private Double gnRatio;
    private Double ppg;

    public IndividualPlayerDTO(){}

    public IndividualPlayerDTO(PlayerDTO playerDTO){
        super.setId(playerDTO.getId());
        super.setName(playerDTO.getName());
        super.setTeamId(playerDTO.getTeamId());
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
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

    public List<PlayerTossupValuesDTO> getTossupValues() {
        return tossupValues;
    }

    public void setTossupValues(List<PlayerTossupValuesDTO> tossupValues) {
        this.tossupValues = tossupValues;
    }

    public Integer getTossupsHeard() {
        return tossupsHeard;
    }

    public void setTossupsHeard(Integer tossupsHeard) {
        this.tossupsHeard = tossupsHeard;
    }

    public Integer getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(Integer pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public Double getPpth() {
        return ppth;
    }

    public void setPpth(Double ppth) {
        this.ppth = ppth;
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

    public Double getPpg() {
        return ppg;
    }

    public void setPpg(Double ppg) {
        this.ppg = ppg;
    }

    @Override
    public int compareTo(Object other) {
        IndividualPlayerDTO otherPlayer = (IndividualPlayerDTO) other;
        if(this.getPpg() > otherPlayer.getPpg()){
            return 1;
        }
        else if(this.getPpg() < otherPlayer.getPpg()){
            return -1;
        }
        else {
            return 0;
        }
    }
}
