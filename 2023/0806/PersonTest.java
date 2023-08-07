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

@DisplayName("생성자가 단 하나인 경우")
public class PersonTest {

    ObjectMapper om;
    @BeforeEach
    void setUp() {
        om = new ObjectMapper();
        om.registerModule(new ParameterNamesModule(JsonCreator.Mode.PROPERTIES));
    }

    @Test
    void 역직렬화() throws JsonProcessingException {
        String json = "{\"name\":\"beanName\"}";

        PersonSuccess personSuccess = new ObjectMapper().readValue(json, PersonSuccess.class);
        assertThat(personSuccess.getName()).isEqualTo("beanName");
    }

    @Test
    @DisplayName("역직렬화 실패")
    void 역직렬화_실패() {
        String json = "{\"name\":\"beanName\"}";

        assertThatCode(()->new ObjectMapper().readValue(json, PersonFail.class))
            .isInstanceOf(MismatchedInputException.class);
    }
/*
*  `Parameter names` 모듈이다.
* 설명을 읽어보면 @JsonProperty 로 위임정보를 명시하지 않더라도,
* 생성자를 자동으로 탐지하는 것을 도와주는 모듈이다.
* 이 모듈이 자동으로 생성자를 위임시켜줘서, 기본생성자가 없어도 잘 작동했던 것이다.
* ObjectMapper 에 모듈을 추가적으로 등록할 수 있다.
*  */
    @Test
    @DisplayName("역직렬화 실패 with JsonCreater")
    void 역직렬화_실패_with_Json_Creator() {
        String json = "{\"name\":\"beanName\"}";

        assertThatCode(()->new ObjectMapper().readValue(json, PersonFailWithJsonCreater.class))
            .isInstanceOf(MismatchedInputException.class);
    }


    @Test
    @DisplayName("역직렬화 성공 with JsonCreator")
    void 역직렬화_성공_with_Json_Creator() {
        String json = "{\"name\":\"beanName\"}";

        assertThatCode(()->om.readValue(json, PersonFailWithJsonCreater.class))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("역직렬화 실패 with JsonCreator, JsonProperty")
    void 역직렬화_싪패_JSON_CRETOR_Property() {
        String json = "{\"name\":\"beanName\"}";
        assertThatCode(()->new ObjectMapper().readValue(json, PersonFailWithJsonCreaterAndProperty.class))
            .isInstanceOf(MismatchedInputException.class);
    }


    @Test
    @DisplayName("역직렬화 실패 with JsonCreator, JsonProperty")
    void 역직렬화_성공_JSON_CRETOR_Property() {
        String json = "{\"name\":\"beanName\"}";
        assertThatCode(()->om.readValue(json, PersonFailWithJsonCreaterAndProperty.class))
            .doesNotThrowAnyException();
    }
}
