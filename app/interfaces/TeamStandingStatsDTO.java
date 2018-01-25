package interfaces;

/**
 * TeamStatsDTO contains all of the information necessary for the stats array list
 *
 * @author jshyo
 *
 */
public class TeamStandingStatsDTO extends TeamDTO implements Comparable{
    // Display stats
    private int wins;
    private int losses;
    private int ties;
    private float winPct;
    private float PPG;
    private float PAPG;
    private int pow;
    private int base;
    private int neg;
    private float margin;
    private int TUH;
    private float PPTH;
    private float pnRatio;
    private float gnRatio;
    private float PPB;

    // total stats
    private int pointsTotal;
    private int pointsBonus;
    private int pointsTossup;

    public int getBase() {
        return base;
    }
    public void setBase(int base){
        this.base = base;
    }

    public int compareTo(Object other) {
        TeamStandingStatsDTO teamOther = (TeamStandingStatsDTO) other;
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

    public void calculateStats(){

    }
}