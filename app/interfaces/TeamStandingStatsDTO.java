package interfaces;

import java.util.List;

/**
 * TeamStatsDTO contains all of the information necessary for the stats array list
 *
 * @author jshyo
 *
 */
public class TeamStandingStatsDTO extends TeamDTO implements Comparable{

    // Display stats
    private Integer wins;
    private Integer losses;
    private Integer ties;
    private Double winPct;
    private Double ppg;
    private Double papg;
    private Integer numPowers;
    private Integer numBase;
    private Integer numNegs;
    private List<TeamTossupValuesDTO> tossupValues;
    private Double margin;
    private Integer tuh;
    private Double ppth;
    private Double pnRatio;
    private Double gnRatio;
    private Double ppb;

    // total stats
    private Integer pointsTotal;
    private Integer pointsAgainst;
    private Integer pointsBonus;
    private Integer pointsBounceback;
    private Integer pointsTossup;
    private Integer bonusesHeard;

    public int compareTo(Object other) {
        TeamStandingStatsDTO teamOther = (TeamStandingStatsDTO) other;
        // First compare wins.
        if(this.wins.equals(teamOther.wins)) {
            // Next compare losses.
            if(this.losses.equals(teamOther.losses)) {
                // Third compare ppb
                if(this.ppb == teamOther.ppb) {
                    return 0;
                } else if(this.ppb > teamOther.ppb) {
                    return 1;
                } else if(this.ppb < teamOther.ppb) {
                    return -1;
                }
            } else if(this.losses < teamOther.losses) {
                return 1;
            } else if(this.losses > teamOther.losses) {
                return -1;
            }
        } else if(this.wins > teamOther.wins) {
            return 1;
        } else if(this.wins < teamOther.wins) {
            return -1;
        }
        return 0;
    }

    public void calculateStats(){

    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getTies() {
        return ties;
    }

    public void setTies(Integer ties) {
        this.ties = ties;
    }

    public Double getWinPct() {
        return winPct;
    }

    public void setWinPct(Double winPct) {
        this.winPct = winPct;
    }

    public Double getPpg() {
        return ppg;
    }

    public void setPpg(Double ppg) {
        this.ppg = ppg;
    }

    public Double getPapg() {
        return papg;
    }

    public void setPapg(Double papg) {
        this.papg = papg;
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
    public void setNumBase(Integer numBase){
        this.numBase = numBase;
    }

    public Integer getNumNegs() {
        return numNegs;
    }

    public void setNumNegs(Integer numNegs) {
        this.numNegs = numNegs;
    }

    public List<TeamTossupValuesDTO> getTossupValues() {
        return tossupValues;
    }

    public void setTossupValues(List<TeamTossupValuesDTO> tossupValues) {
        this.tossupValues = tossupValues;
    }

    public Double getMargin() {
        return margin;
    }

    public void setMargin(Double margin) {
        this.margin = margin;
    }

    public Integer getTuh() {
        return tuh;
    }

    public void setTuh(Integer tuh) {
        this.tuh = tuh;
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

    public Double getPpb() {
        return ppb;
    }

    public void setPpb(Double ppb) {
        this.ppb = ppb;
    }

    public Integer getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(Integer pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    public Integer getPointsAgainst() {
        return pointsAgainst;
    }

    public void setPointsAgainst(Integer pointsAgainst) {
        this.pointsAgainst = pointsAgainst;
    }

    public Integer getPointsBonus() {
        return pointsBonus;
    }

    public void setPointsBonus(Integer pointsBonus) {
        this.pointsBonus = pointsBonus;
    }

    public Integer getPointsBounceback() {
        return pointsBounceback;
    }

    public void setPointsBounceback(Integer pointsBounceback) {
        this.pointsBounceback = pointsBounceback;
    }

    public Integer getPointsTossup() {
        return pointsTossup;
    }

    public void setPointsTossup(Integer pointsTossup) {
        this.pointsTossup = pointsTossup;
    }

    public Integer getBonusesHeard() {
        return bonusesHeard;
    }

    public void setBonusesHeard(Integer bonusesHeard) {
        this.bonusesHeard = bonusesHeard;
    }
}