import java.util.stream.Collectors;

public class OutputView {
    static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    static void printRaceMessage() {
        System.out.println("실행 결과");
    }

    public static void printRace(RacingCars racingCars) {
        for (int i = 0; i < racingCars.getCarsLength(); i++) {
            String name = racingCars.getCar(i).getName();
            int position = racingCars.getCar(i).getPosition();
            String race = String.format("%s : %s", name, "-".repeat(position));
            System.out.println(race);
        }
    }

    public static void printWinners(RacingCars racingCars) {
        String winnerNames = racingCars.getWinners().stream().map(Car::getName).collect(Collectors.joining(", "));
        String result = String.format("%s가 최종 우승하였습니다.", winnerNames);
        System.out.println(result);
    }
}
