import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.startGame();
    }

    RacingCars racingCars;

    public void startGame() {
        while (true) {
            try {
                String input = InputView.getCarNames();
                this.racingCars = generateUniqueCars(input);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }

        int gameRounds = InputView.getGameRounds();
        OutputView.printRaceMessage();
        race(gameRounds);
        OutputView.printWinners(racingCars);
    }

    public RacingCars generateUniqueCars(String input) throws IllegalArgumentException {
        String[] names = input.split(",", -1);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        this.racingCars = new RacingCars(cars);
        return this.racingCars;
    }

    public void race(int count) {
        for (int i = 0; i < count; i++) {
            this.racingCars.race();
            OutputView.printRace(racingCars);
            System.out.println();
        }
    }


}
