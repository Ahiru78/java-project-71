package hexlet.code.formatters;

import hexlet.code.Utils;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class Plain implements Format {
    static final String TEXTADD = "\nProperty '%s' was added with value: %s";
    static final String TEXTRMV = "\nProperty '%s' was removed";
    static final String TEXTUPD = "\nProperty '%s' was updated. From %s to %s";

    public final String format(TreeMap<String, HashMap<String, Object>> diffMap) {
        String result = "";
        for (Map.Entry<String, HashMap<String, Object>> entry: diffMap.entrySet()) {
            String key = entry.getKey();
            var map = diffMap.get(key);
            if (map.containsKey("add") && map.containsKey("delete")) {
                var value1 = Utils.defType(map.get("delete"));
                var value2 = Utils.defType(map.get("add"));
                result = result.concat(String.format(TEXTUPD, key, value1, value2));
            } else if (map.containsKey("add")) {
                var value = Utils.defType(map.get("add"));
                result = result.concat(String.format(TEXTADD, key, value));
            } else if (map.containsKey("delete")) {
                var value = Utils.defType(map.get("delete"));
                result = result.concat(String.format(TEXTRMV, key));
            }
        }
        return result.trim();
    }
}
