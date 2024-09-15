import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {
    RacingGame racingGame;

    @DisplayName("")
    @ParameterizedTest
    @MethodSource("provideCarNameTestCases")
    public void testGenerateUniqueCars(String input, String[] expectedCarNames, String expectedExceptionMessage) throws IllegalArgumentException {
        // given
        RacingGame racingGame = new RacingGame();
        //when

        if (expectedCarNames != null) {
            RacingCars racingCars = racingGame.generateUniqueCars(input);
            assertAll("carNames",
                    () -> assertEquals(expectedCarNames[0], racingCars.getCar(0).getName(), "Car name at index 0 should match the expected name."),
                    () -> assertEquals(expectedCarNames[1], racingCars.getCar(1).getName(), "Car name at index 1 should match the expected name."),
                    () -> assertEquals(expectedCarNames[2], racingCars.getCar(2).getName(), "Car name at index 2 should match the expected name.")
            );
        } else {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> racingGame.generateUniqueCars(input))
                    .withMessage(expectedExceptionMessage);
        }
    }

    static Stream<Arguments> provideCarNameTestCases() {
        return Stream.of(
                Arguments.of("car1,car2,car3", new String[]{"car1", "car2", "car3"}, null),
                Arguments.of("car1,,car3", null, Car.EMPTY_NAME_ERROR_MESSAGE),
                Arguments.of("car1,carabcde,car3", null, Car.NAME_LENGTH_ERROR_MESSAGE),
                Arguments.of("car1,car1,car3", null, RacingCars.DUPLICATE_EXCEPTION_MESSAGE),
                Arguments.of("", null, Car.EMPTY_NAME_ERROR_MESSAGE)
        );
    }


}
