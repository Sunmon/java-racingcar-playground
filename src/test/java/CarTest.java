import com.sun.org.apache.xpath.internal.Arg;
import org.junit.jupiter.api.DisplayName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("전진을 판별하는 값이 4 이상이면 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    public void carRunTest(int value) throws Exception {
        // given
        Car car = new Car("name");
        int prevPosition = car.getPosition();

        //when
        car.go(value);

        //then
        if (value >= Car.THRESHOLD) {
            assertThat(car.getPosition()).isEqualTo(prevPosition + 1);
        } else {
            assertThat(car.getPosition()).isEqualTo(prevPosition);
        }
    }


}
