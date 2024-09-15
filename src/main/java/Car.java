public class Car {
    private final String name;
    public static String LENGTH_ERROR = "이름은 5자 이내로 설정해주십시오.";

    public Car(String name) throws Exception {
        if (!isValidName(name)) throw new Exception(LENGTH_ERROR);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isValidName(String name) {
        int MAX_NAME_LENGTH = 5;
        return name.length() <= MAX_NAME_LENGTH;
    }
}
