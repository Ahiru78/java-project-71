package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
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

    public static TreeMap<String, DiffValues> diff(String filepath1, String filepath2) throws Exception {
        final var map1 = Utils.getData(filepath1);
        final var map2 = Utils.getData(filepath2);
        final var states = new String[]{"add", "delete", "change", "equal"};
        var keys = new TreeMap<String, Object>(String.CASE_INSENSITIVE_ORDER);
        keys.putAll(map1);
        keys.putAll(map2);
        var result = new TreeMap<String, DiffValues>(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, Object> entry: keys.entrySet()) {
            String key = entry.getKey();
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);
            if (value1 == null && !map1.containsKey(key)) {
                var diffValue = new DiffValues(states[0], null, value2);
                result.put(key, diffValue);
                // Added value
            } else if (value2 == null && !map2.containsKey(key)) {
                var diffValue = new DiffValues(states[1], value1, null);
                result.put(key, diffValue);
                // Deleted value
            } else if (!Objects.equals(value1, value2)) {
                var diffValue = new DiffValues(states[2], value1, value2);
                result.put(key, diffValue);
                // Changed value
            } else {
                var diffValue = new DiffValues(states[3], value1, value2);
                result.put(key, diffValue);
                // Unchanged value
            }
        }
        return result;
    }
}
