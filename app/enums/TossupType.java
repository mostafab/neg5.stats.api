package enums;

/**
 * Represents the types a tossup can be
 */
public enum TossupType implements FriendlyNameIdentifable, IntegerIdentifiable {

    Neg(1, "Neg"),
    Base(2, "Base"),
    Power(3, "Power");

    private int id;
    private String displayName;

    TossupType(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return displayName;
    }
}
