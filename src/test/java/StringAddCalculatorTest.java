import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    @ParameterizedTest
    @MethodSource("validInputs")
    void splitAndSum_validInputs(String input, int expected) {
        // when
        int result = StringAddCalculator.splitAndSum(input);
        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> validInputs() {
        return Stream.of(
                Arguments.of("1:2,3", 6),
                Arguments.of("1,2:3", 6),
                Arguments.of("1", 1),
                Arguments.of("", 0),
                Arguments.of(null, 0)
        );
    }
    

}