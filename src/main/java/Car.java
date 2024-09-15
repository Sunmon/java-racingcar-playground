import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;
    public static final int THRESHOLD = 4;

    public static String NAME_LENGTH_ERROR_MESSAGE = "이름은 5자 이내로 설정해주십시오.";
    public static String EMPTY_NAME_ERROR_MESSAGE = "이름을 입력하지 않았습니다.";

    public Car(String name) throws IllegalArgumentException {
        if (isEmptyName(name)) throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        if (isLengthExceeded(name)) throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        this.name = name;
    }

    protected Car(String name, int position) {
        this(name);
        this.position = position;
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

    private boolean isLengthExceeded(String name) {
        int MAX_NAME_LENGTH = 5;
        return name.length() > MAX_NAME_LENGTH;
    }

    private boolean isEmptyName(String name) {
        return name.isEmpty();
    }


    public int getPosition() {
        return position;
    }

}
