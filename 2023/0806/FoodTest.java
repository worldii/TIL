package study;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

@DisplayName("직렬화 ")
public class FoodTest {


    ObjectMapper om;
    @BeforeEach
    void setUp() {
        om = new ObjectMapper();
        om.registerModule(new ParameterNamesModule(JsonCreator.Mode.PROPERTIES));
    }

    @Test
    void 역직렬화_성공() throws JsonProcessingException {
        String json = "{\"name\":\"beanName\", \"imageUrl\":\"jongha\" }";

        Food food = om.readValue(json, Food.class);
        assertThat(food.getName()).isEqualTo("beanName");
        assertThat(food.getImageUrl()).isEqualTo("jongha");

    }

    @Test
    @DisplayName("역직렬화 실패")
    void 역직렬화_실패() {
        String json = "{\"name\":\"beanName\"}";

        assertThatCode(()->om.readValue(json, PersonFail.class))
            .isInstanceOf(MismatchedInputException.class);
    }

    @Test
    @DisplayName("역직렬화 실패 with JsonCreater")
    void 역직렬화_실패_with_Json_Creator() {
        String json = "{\"name\":\"beanName\"}";

        assertThatCode(()->new ObjectMapper().readValue(json, PersonFailWithJsonCreater.class))
            .isInstanceOf(MismatchedInputException.class);
    }

    @Test
    @DisplayName("역직렬화 실패 with JsonCreator, JsonProperty")
    void 역직렬화_싪패_JSON_CRETOR_Property() {
        String json = "{\"name\":\"beanName\"}";
        assertThatCode(()->new ObjectMapper().readValue(json, PersonFailWithJsonCreaterAndProperty.class))
            .isInstanceOf(MismatchedInputException.class);
    }

}
