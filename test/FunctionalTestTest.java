import interfaces.*;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.L;
import static org.junit.jupiter.api.Assertions.*;

class FunctionalTestTest {
    public static void main(String[] args){
        StatsGenerationRequestDTO generationRequest = new StatsGenerationRequestDTO();
        TeamDTO team1 = new TeamDTO();
        team1.setId("0");
        team1.setName("Team One");
        List<PlayerDTO> team1Players = new ArrayList<>();
        PlayerDTO team1p1 = new PlayerDTO();
        team1p1.setId("0");
        team1p1.setName("Eric");
        team1p1.setTeamId("0");
        team1Players.add(team1p1);
        team1.setPlayers(team1Players);
        List<TeamDTO> teams = new ArrayList<>();
        teams.add(team1);

        
        generationRequest.setTeams(teams);
        generationRequest.setMatches(new ArrayList<MatchDTO>());
        generationRequest.setTossupValues(new ArrayList<TossupValueDTO>());
        generationRequest.setPhaseId("0");
    }
}