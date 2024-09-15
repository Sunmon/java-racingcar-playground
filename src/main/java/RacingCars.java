import java.util.Collections;
import java.util.List;

public class RacingCars {
    public static String DUPLICATE_EXCEPTION_MESSAGE = "이름은 중복되지 않게 입력하십시오";
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        if (hasDuplicateCars(cars)) throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        this.cars = cars;
    }

    private boolean hasDuplicateCars(List<Car> cars) {
        return cars.size() != cars.stream().map(Car::getName).distinct().count();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Car getCar(int num) {
        return this.cars.get(num);
    }
}
