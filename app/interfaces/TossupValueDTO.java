package interfaces;

import enums.TossupType;

/**
 * DTO for a tournament's tossup values
 */
public class TossupValueDTO {

    private Integer value;
    private TossupType type;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TossupType getType() {
        return type;
    }

    public void setType(TossupType type) {
        this.type = type;
    }
}
