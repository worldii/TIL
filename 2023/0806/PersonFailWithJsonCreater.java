package study;

import com.fasterxml.jackson.annotation.JsonCreator;

public class PersonFailWithJsonCreater {
    private final String name;

    @JsonCreator
    public PersonFailWithJsonCreater(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
