package interfaces.team;

import interfaces.TeamDTO;
import interfaces.individual.IndividualStandingsDTO;

import java.util.ArrayList;
import java.util.List;

public class FullTeamStatsDTO extends TeamDTO implements Comparable{
    private List<MatchTeamStatsDTO> matches;
    private List<IndividualStandingsDTO> playerStats;

    public FullTeamStatsDTO(TeamDTO teamDTO){
        super.setId(teamDTO.getId());
        super.setName(teamDTO.getName());
        super.setPlayers(teamDTO.getPlayers());
        matches = new ArrayList<>();
        playerStats = new ArrayList<>();
    }

    public List<MatchTeamStatsDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchTeamStatsDTO> matches) {
        this.matches = matches;
    }

    public List<IndividualStandingsDTO> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(List<IndividualStandingsDTO> playerStats) {
        this.playerStats = playerStats;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}