import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {
    RacingGame racingGame;
//    InputView inputView;

    @DisplayName("유효한 이름이면 자동차 리스트를 생성하고, 아니면 오류를 반환한다.")
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

    @DisplayName("정해진 횟수동안 가장 멀리 간 자동차를 리턴한다")
    @ParameterizedTest
    @MethodSource("provideCarWinnerTestCases")
    public void testGetWinner(RacingCars racingCars, String winnerNames) {
        // given
        //when
        List<Car> winners = racingCars.getWinners();
        winners.forEach(car -> {
            assertThat(winnerNames).contains(car.getName());
        });
//        assertThat(1).isEqualTo(1);


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

    static Stream<Arguments> provideCarWinnerTestCases() {
        List<Car> cars1 = new ArrayList<>(List.of(
                new Car("car0", 0),
                new Car("car1", 10),
                new Car("car2", 6),
                new Car("car3", 5)
        ));

        List<Car> cars2 = new ArrayList<>(List.of(
                new Car("car0", 0),
                new Car("car1", 2),
                new Car("car2", 10),
                new Car("car3", 10)
        ));

        return Stream.of(
                Arguments.of(new RacingCars(cars1), "car1"),
                Arguments.of(new RacingCars(cars2), "car2, car3")
        );
    }


}
