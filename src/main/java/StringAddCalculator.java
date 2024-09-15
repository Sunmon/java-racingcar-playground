import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public int splitAndSum(String text) throws RuntimeException {
        if (text == null || text.isEmpty()) return 0;

        String[] delAndText = splitDelAndText(text);
        if (delAndText == null || delAndText[1] == null || delAndText[1].isEmpty()) return 0;

        String delimiter = delAndText[0];
        String target = delAndText[1];

        if (hasInvalidInput(target)) throw new RuntimeException();

        int result = 0;
        String regex = delimiter == null ? "[,:]" : "[,:" + delimiter + "]";

        String[] split = target.split(regex);
        for (String s : split) {
            int n = Integer.parseInt(s);
            result += n;
        }

        return result;
    }

    private String[] splitDelAndText(String text) {
        String regex = "(?://(.)\n)?(.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (!matcher.find()) return null;
        return new String[]{matcher.group(1), matcher.group(2)};
    }

    private boolean hasInvalidInput(String text) {
        String regex = "[-a-zA-z]";
        return Pattern.compile(regex).matcher(text).find();
    }
}
