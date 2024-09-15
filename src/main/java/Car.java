import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;
    public static final int THRESHOLD = 4;

    public static String LENGTH_ERROR = "이름은 5자 이내로 설정해주십시오.";

    public Car(String name) throws Exception {
        if (!isValidName(name)) throw new Exception(LENGTH_ERROR);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int go() {
        int value = new Random().nextInt(10);
        return go(value);
    }

    protected int go(int value) {
        if (value >= THRESHOLD) {
            this.position += 1;
        }

        return getPosition();
    }

    private boolean isValidName(String name) {
        int MAX_NAME_LENGTH = 5;
        return name.length() <= MAX_NAME_LENGTH;
    }


    public int getPosition() {
        return position;
    }
}
