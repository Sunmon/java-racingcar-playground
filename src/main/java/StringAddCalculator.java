import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public int splitAndSum(String text) {
        if (text == null || text.isEmpty()) return 0;

        int result = 0;
        String customRegex = "//(.)\n";
        String customDel = extractCustomDelimeter(text, customRegex);
        String regex = customDel == null ? "[,:]" : "[,:" + customDel + "]";

        if (text.split(customRegex).length == 0) {
            return 0;
        }

        String[] split = customDel == null ? text.split(regex) : text.split(customRegex)[1].split(customDel);
        for (String s : split) {
            result += Integer.parseInt(s);
        }

        return result;
    }

    private String extractCustomDelimeter(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }
}
