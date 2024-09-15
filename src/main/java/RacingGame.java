import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    RacingCars racingCars;

    public RacingCars generateUniqueCars(String input) throws IllegalArgumentException {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        this.racingCars = new RacingCars(cars);
        return this.racingCars;
    }
}
