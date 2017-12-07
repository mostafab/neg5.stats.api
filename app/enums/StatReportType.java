package enums;

/**
 * Enum representing the type of report to be generated
 */
public enum StatReportType implements FriendlyNameIdentifable, IntegerIdentifiable {

    TEAM_STANDINGS(1, "Team Standings"),
    INDIVIDUAL_STANDINGS(2, "Individual Standings"),
    TEAM_FULL(3, "Team Full"),
    INDIVIDUAL_FULL(4, "Individual Full"),
    ROUND_REPORT(5, "Round Report");

    private int id;
    private String displayName;

    StatReportType(int id, String displayName) {
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
