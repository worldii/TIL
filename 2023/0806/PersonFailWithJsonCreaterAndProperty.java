package study;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonFailWithJsonCreaterAndProperty {
    @JsonProperty
    private final String name;
    /*
    * 파라미터에도 JsonProperty 를 붙여줘야 한다.
    * */

    @JsonCreator
    public PersonFailWithJsonCreaterAndProperty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
