import org.junit.jupiter.api.DisplayName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Car car;

    @DisplayName("자동차의 이름을 5자 이내로 설정할 수 있다. 5자 초과는 오류를 반환한다")
    @ParameterizedTest
    @MethodSource("carNameInputs")
    public void carNameSetTest(String name, String expectedName) throws Exception {
        if (expectedName == null) {
            // when
            assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(Exception.class)
                    .hasMessage(Car.LENGTH_ERROR);
//            assertThatExceptionOfType(expectedException)
//                    .isThrownBy(() -> new Car(name))
//                    .withMessage("이름은 5자 이내로 설정해주십시오.");
        } else {
            //when
            Car car = new Car(name);
            //then
            assertThat(car.getName()).isEqualTo(name);

        }
    }

    static Stream<Arguments> carNameInputs() {
        return Stream.of(
                Arguments.of("car1", "car1"),
                Arguments.of("booroong", null)
        );
    }
}
