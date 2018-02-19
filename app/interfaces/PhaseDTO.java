package interfaces;

/**
 * Interface for tournament phase
 */
public class PhaseDTO {

    private String id;
    private String name;

    public PhaseDTO(String id, String name)
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
}
