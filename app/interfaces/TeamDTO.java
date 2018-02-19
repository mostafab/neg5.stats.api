package interfaces;

import java.util.List;

/**
 * Team interface
 */
public class TeamDTO {

    private String id;
    private String name;
    private List<PlayerDTO> players;

    public TeamDTO(String id, String name)
    {
      this.id = id;
      this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }
}
