package hexlet.code;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Objects;
import hexlet.code.formatters.Formatter;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        var diffValues = diff(filepath1, filepath2);
        return Formatter.pick(format).format(diffValues);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static TreeMap<String, HashMap<String, Object>> diff(String filepath1, String filepath2) throws Exception {
        final var map1 = Utils.getData(filepath1);
        final var map2 = Utils.getData(filepath2);
        final var state = new String[]{"add", "delete", "equal"};
        var keys = findKeys(map1, map2);
        var result = new TreeMap<String, HashMap<String, Object>>(String.CASE_INSENSITIVE_ORDER);
        for (String key : keys) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);
            var diffMap = new HashMap<String, Object>();
            if (!map1.containsKey(key) && value1 == null) {
                // Added value
                diffMap.put(state[0], value2);
                result.put(key, diffMap);
            } else if (!map2.containsKey(key) && value2 == null) {
                // Deleted value
                diffMap.put(state[1], value1);
                result.put(key, diffMap);
            } else if (!Objects.equals(value1, value2)) {
                // Changed value
                diffMap.put(state[1], value1);
                diffMap.put(state[0], value2);
                result.put(key, diffMap);
            } else if (Objects.equals(value1, value2)) {
                // Unchanged value
                diffMap.put(state[2], value1);
                result.put(key, diffMap);
            }
        }
        return result;
    }

    public static ArrayList<String> findKeys(Map<String, Object> map1, Map<String, Object> map2) {
        var result = new ArrayList<String>();
        var keys = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        keys.putAll(map1);
        keys.putAll(map2);
        for (Map.Entry<String, Object> entry: keys.entrySet()) {
            String key = entry.getKey();
            result.add(key);
        }
        return result;
    }
}
