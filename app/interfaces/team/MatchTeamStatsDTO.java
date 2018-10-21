package interfaces.team;

import interfaces.MatchDTO;
import interfaces.MatchPlayerDTO;
import interfaces.MatchTeamDTO;
import interfaces.PlayerTossupValuesDTO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * TeamStatsDTO contains all of the information necessary for the stats array list
 *
 * @author jshyo
 *
 */
public class MatchTeamStatsDTO extends MatchTeamDTO {
    // formatter
    private static final DecimalFormat DF = new DecimalFormat( "#.##" );

    // Display stats
    private String opponent;
    private String result;
    private Integer pointsTotal;
    private Integer pointsAgainst;
    private Integer numPow;
    private Integer numBase;
    private Integer numNeg;
    private List<TeamTossupValuesDTO> tossupValues;
    private Integer tuh;
    private Double ppth;
    private Double pnRatio;
    private Double gnRatio;
    private Integer bonusHeard;
    private Integer pointsBonus;
    private Integer pointsBounceback;
    private Double ppb;

    public MatchTeamStatsDTO(MatchTeamDTO matchTeamDTO, MatchDTO matchDTO){
        // super constructor
        super.setTeamId(matchTeamDTO.getTeamId());
        super.setScore(matchTeamDTO.getScore());
        pointsTotal = getScore();
        super.setBouncebackPoints(matchTeamDTO.getBouncebackPoints());
        pointsBounceback = getBouncebackPoints();
        super.setOvertimeTossups(matchTeamDTO.getOvertimeTossups());
        super.setPlayers(matchTeamDTO.getPlayers());
        super.setMatchId(matchTeamDTO.getMatchId());
        tuh = matchDTO.getTossupsHeard();
        // initialize tossupValues
        tossupValues = new ArrayList<>();

        // initialize opponent info
        List<MatchTeamDTO> teams = matchDTO.getTeams();
        for(MatchTeamDTO curTeam: teams){
            if(!curTeam.getTeamId().equals(getTeamId())){
                // set points scored against
                pointsAgainst = curTeam.getScore();
                // set result
                if(pointsTotal > pointsAgainst){
                    result = "W";
                } else{
                    result = "L";
                }
                // set opponent
                opponent = curTeam.getTeamId();
            }
        }
    }
    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public Integer getNumPow() {
        return numPow;
    }

    public void setNumPow(Integer numPow) {
        this.numPow = numPow;
    }

    public Integer getNumBase() {
        return numBase;
    }

    public void setNumBase(Integer numBase) {
        this.numBase = numBase;
    }

    public Integer getNumNeg() {
        return numNeg;
    }

    public void setNumNeg(Integer numNeg) {
        this.numNeg = numNeg;
    }

    public List<TeamTossupValuesDTO> getTossupValues() {
        return tossupValues;
    }

    public void setTossupValues(List<TeamTossupValuesDTO> tossupValues) {
        this.tossupValues = tossupValues;
    }

    public void setPnRatio(Double pnRatio) {
        this.pnRatio = pnRatio;
    }

    public void setGnRatio(Double gnRatio) {
        this.gnRatio = gnRatio;
    }

    public Integer getBonusHeard() {
        return bonusHeard;
    }

    public void setBonusHeard(Integer bonusHeard) {
        this.bonusHeard = bonusHeard;
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

    public Double getGnRatio() {
        return gnRatio;
    }

    public Double getPpb() {
        return ppb;
    }

    public void setPpb(Double ppb) {
        this.ppb = ppb;
    }

}
