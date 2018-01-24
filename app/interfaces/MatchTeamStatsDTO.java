package interfaces;

import java.text.DecimalFormat;
import java.util.List;

/**
 * TeamStatsDTO contains all of the information necessary for the stats array list
 *
 * @author jshyo
 *
 */
public class MatchTeamStatsDTO extends MatchTeamDTO{
    // formatter
    public static final DecimalFormat DF = new DecimalFormat( "#.##" );

    // Display stats
    private String opponent;
    private String result;
    private Integer pointsTotal;
    private Integer pointsAgainst;
    private List<Integer> tossupValues;
    private Integer TUH;
    private Float PPTH;
    private Float pnRatio;
    private Float gnRatio;
    private Integer bonusHeard;
    private Integer pointsBonus;
    private Integer pointsBounceback;
    private Float PPB;

    public MatchTeamStatsDTO(MatchTeamDTO matchTeamDTO, MatchDTO matchDTO){
        // super constructor
        super.setTeamId(matchTeamDTO.getTeamId());
        super.setScore(matchTeamDTO.getScore());
        super.setBouncebackPoints(matchTeamDTO.getBouncebackPoints());
        super.setOvertimeTossups(matchTeamDTO.getOvertimeTossups());
        super.setPlayers(matchTeamDTO.getPlayers());
        super.setMatchId(matchTeamDTO.getMatchId());
        // initialize opponent info
        List<MatchTeamDTO> teams = matchDTO.getTeams();
        for(int i = 0; i < teams.size(); i++){
            if(teams.get(i).getTeamId() != getTeamId()){
                MatchTeamDTO otherTeam = teams.get(i);
                // set points scored against
                pointsAgainst = otherTeam.getScore();
                // set result
                if(pointsTotal > pointsAgainst){
                    result = "W";
                } else{
                    result = "L";
                }
                // set opponent
                opponent = otherTeam.getTeamId();
            }
        }
        // calculate stats
        calculateStats();
    }
/*
    public int compareTo(Object other) {
        MatchTeamStatsDTO teamOther = (MatchTeamStatsDTO) other;
        // First compare wins.
        if(this.wins == teamOther.wins) {
            // Next compare losses.
            if(this.losses == teamOther.losses) {
                // Third compare PPB
                if(this.PPB == teamOther.PPB) {
                    return 0;
                } else if(this.PPB > teamOther.PPB) {
                    return 1;
                } else if(this.PPB < teamOther.PPB) {
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
*/
    private void calculateStats(){
        calculatePlayerStats();
        // calculate stats if games have been played


        // format to decimal places

    }

    private void calculatePlayerStats(){
        List<MatchPlayerDTO> players = getPlayers();
        for(int i = 0; i < players.size(); i++){
            List<PlayerTossupValuesDTO> tossupValues = players.get(i).getTossupValues();
            // collect tossupValues info
            for(int j = 0; j < tossupValues.size(); j++){
                tossupValues.get(j);
            }
        }
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public float getWinPct() {
        return winPct;
    }

    public void setWinPct(float winPct) {
        this.winPct = winPct;
    }

    public float getPPG() {
        return PPG;
    }

    public void setPPG(float PPG) {
        this.PPG = PPG;
    }

    public float getPAPG() {
        return PAPG;
    }

    public void setPAPG(float PAPG) {
        this.PAPG = PAPG;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getNeg() {
        return neg;
    }

    public void setNeg(int neg) {
        this.neg = neg;
    }

    public float getMargin() {
        return margin;
    }

    public void setMargin(float margin) {
        this.margin = margin;
    }

    public int getTUH() {
        return TUH;
    }

    public void setTUH(int TUH) {
        this.TUH = TUH;
    }

    public float getPPTH() {
        return PPTH;
    }

    public void setPPTH(float PPTH) {
        this.PPTH = PPTH;
    }

    public float getPnRatio() {
        return pnRatio;
    }

    public void setPnRatio(float pnRatio) {
        this.pnRatio = pnRatio;
    }

    public float getGnRatio() {
        return gnRatio;
    }

    public void setGnRatio(float gnRatio) {
        this.gnRatio = gnRatio;
    }

    public float getPPB() {
        return PPB;
    }

    public void setPPB(float PPB) {
        this.PPB = PPB;
    }
}
