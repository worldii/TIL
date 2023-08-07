package study;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

@DisplayName("final 이 안붙어 있는 경우")


public class ProductTest {
    @Test
    void 역직렬화_실패() throws JsonProcessingException {
        String json = "{\"id\":\"1\"}";

        assertThatCode(()->new ObjectMapper().readValue(json, Product.class))
            .isInstanceOf(MismatchedInputException.class);
    }

    @Test
    void 역직렬화_성공() throws JsonProcessingException {
        String json = "{\"id\":\"1\"}";

        Product2 product = new ObjectMapper().readValue(json, Product2.class);
        assertThat(product.getId()).isEqualTo(1);
    }


}
