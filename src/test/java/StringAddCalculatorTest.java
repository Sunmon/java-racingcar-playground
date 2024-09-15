import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    @ParameterizedTest
    @MethodSource("validInputs")
    void splitAndSum_validInputs(String input, int expected) {
        // when
        int result = stringAddCalculator.splitAndSum(input);
        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자를 지정할 수 있다")
    @ParameterizedTest
    @MethodSource("validInputsWithCustomDel")
    void splitAndSum_validInputsWithCustomDel(String input, int expected) {
        // when
        int result = stringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.")
    @ParameterizedTest
    @MethodSource("invalidInputs")
    void splitAndSum_invalidInputs(String input, Class<? extends Throwable> expectedException) {
        // when
        assertThatThrownBy(() -> {
            int result = stringAddCalculator.splitAndSum(input);
            // then
        }).isInstanceOf(expectedException);
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

    static Stream<Arguments> validInputsWithCustomDel() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("///\n1/2", 3),
                Arguments.of("//.\n", 0)
        );
    }

    static Stream<Arguments> invalidInputs() {
        return Stream.of(
                Arguments.of("//;\n1;2-3", RuntimeException.class),
                Arguments.of("//;\n1;-2;3", RuntimeException.class),
                Arguments.of("///\n-2", RuntimeException.class),
                Arguments.of("//.\nabc", RuntimeException.class)
        );
    }

}