package interfaces;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * TeamStatsDTO contains all of the information necessary for the stats array list
 *
 * @author jshyo
 *
 */
public class MatchTeamStatsDTO extends MatchTeamDTO{
    // formatter
    private static final DecimalFormat DF = new DecimalFormat( "#.##" );

    // Display stats
    private String opponent;
    private String result;
    private Integer pointsTotal;
    private Integer pointsAgainst;
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
        super.setBouncebackPoints(matchTeamDTO.getBouncebackPoints());
        super.setOvertimeTossups(matchTeamDTO.getOvertimeTossups());
        super.setPlayers(matchTeamDTO.getPlayers());
        super.setMatchId(matchTeamDTO.getMatchId());

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
        // calculate stats
        calculateStats();
    }

    private void calculateStats(){
        calculatePlayerStats();
        // calculate stats if games have been played


        // format to decimal places

    }

    private void calculatePlayerStats(){
        List<MatchPlayerDTO> players = getPlayers();
        for(MatchPlayerDTO curPlayer : players){
            List<PlayerTossupValuesDTO> playerTossupValues = curPlayer.getTossupValues();
            // collect tossupValues info
            for(int j = 0; j < playerTossupValues.size(); j++){
                playerTossupValues.get(j);

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

    public List<TeamTossupValuesDTO> getTossupValues() {
        return tossupValues;
    }

    public void setTossupValues(List<TeamTossupValuesDTO> tossupValues) {
        this.tossupValues = tossupValues;
    }

    public void setTUH(Integer tuh) {
        this.tuh = tuh;
    }

    public void setPPTH(Double ppth) {
        this.ppth = ppth;
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

    public void setPPB(Double ppb) {
        this.ppb = ppb;
    }
}
