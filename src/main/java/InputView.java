import java.util.Scanner;

public class InputView {
    private static final Scanner scan = new Scanner(System.in);

    static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scan.nextLine();
    }

    static int getGameRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scan.nextLine();
        return Integer.parseInt(input);
    }
}
