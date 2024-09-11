public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) return 0;

        int result = 0;
        String[] split = text.split("[,:]");
        for (String s : split) {
            result += Integer.parseInt(s);
        }

        return result;
    }
}
