package hexlet.code.formatters;

import java.util.List;
import java.util.HashMap;

public class Stylish implements Format {
    static final String TEXT = "\n  %s %s: %s";

    public final String format(List<HashMap<String, Object>> diffMap) {
        String result = "";
        for (int i = 0; i < diffMap.size(); i++) {
            var map = diffMap.get(i);
            var key = map.get("key");
            var state = map.get("state");
            var value1 = map.get("value");
            var value2 = map.get("valueNew");
            if (state.equals("update")) {
                result = result.concat(String.format(TEXT, "-", key, value1));
                result = result.concat(String.format(TEXT, "+", key, value2));
            } else if (state.equals("add")) {
                var value = map.get("add");
                result = result.concat(String.format(TEXT, "+", key, value2));
            } else if (state.equals("delete")) {
                var value = map.get("delete");
                result = result.concat(String.format(TEXT, "-", key, value1));
            } else {
                var value = map.get("equal");
                result = result.concat(String.format(TEXT, " ", key, value1));
            }
        }
        return "{" + result + "\n}";
    }
}
