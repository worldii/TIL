package study;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonSuccess {
    /*
    * JsonCreator, JsonProperty를 통해 실행 가능하다.
    * */
    @JsonProperty("name")
    private final String name;

    @JsonCreator
    public PersonSuccess(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
