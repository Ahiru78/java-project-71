package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class Stylish implements Format {
    static final String TEXT = "\n  %s %s: %s";

    public final String format(TreeMap<String, HashMap<String, Object>> diffMap) {
        String result = "";
        for (Map.Entry<String, HashMap<String, Object>> entry: diffMap.entrySet()) {
            String key = entry.getKey();
            var map = diffMap.get(key);
            if (map.containsKey("add") && map.containsKey("delete")) {
                var value1 = map.get("delete");
                var value2 = map.get("add");
                result = result.concat(String.format(TEXT, "-", key, value1));
                result = result.concat(String.format(TEXT, "+", key, value2));
            } else if (map.containsKey("add")) {
                var value = map.get("add");
                result = result.concat(String.format(TEXT, "+", key, value));
            } else if (map.containsKey("delete")) {
                var value = map.get("delete");
                result = result.concat(String.format(TEXT, "-", key, value));
            } else {
                var value = map.get("equal");
                result = result.concat(String.format(TEXT, " ", key, value));
            }
        }
        return "{" + result + "\n}";
    }
}
