package interfaces.individual;

import interfaces.PlayerDTO;

import java.util.List;

public class FullIndividualPlayerDTO extends PlayerDTO implements Comparable{
    private String teamName;
    private List<IndividualMatchPlayerDTO> matches;

    // default constructor
    public FullIndividualPlayerDTO(){}

    // create fullIndivPlayer from curplayer
    public FullIndividualPlayerDTO(PlayerDTO curPlayer){
        super.setId(curPlayer.getId());
        super.setName(curPlayer.getName());
        super.setTeamId(curPlayer.getTeamId());
    }

    public List<IndividualMatchPlayerDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<IndividualMatchPlayerDTO> matches) {
        this.matches = matches;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public int compareTo(Object other) {
        FullIndividualPlayerDTO otherPlayer = (FullIndividualPlayerDTO) other;
        if(getTeamName().equals(otherPlayer.getTeamName())){
            return getName().compareTo(otherPlayer.getName());
        } else{
            return getTeamName().compareTo(otherPlayer.getTeamName());
        }
    }
}
