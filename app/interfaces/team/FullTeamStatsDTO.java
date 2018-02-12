package interfaces.team;

import interfaces.individual.IndividualPlayerDTO;

import java.util.List;

public class FullTeamStatsDTO {
    private List<MatchTeamStatsDTO> matches;
    private List<IndividualPlayerDTO> players;
}