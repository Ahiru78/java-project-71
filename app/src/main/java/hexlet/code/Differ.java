package hexlet.code;
import java.util.Map;
import java.util.TreeMap;
// import java.util.HashMap;
// import java.io.File;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        final var map1 = Parse.parse(Parse.getData(filepath1));
        final var map2 = Parse.parse(Parse.getData(filepath2));
        String result = "";
        var keys = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        keys.putAll(map1);
        keys.putAll(map2);
        for (Map.Entry<String, Object> entry: keys.entrySet()) {
            String key = entry.getKey();
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);
            if (value1 == null && !map1.containsKey(key)) {
                result = result.concat("\n+ " + (key + ": " + value2));
                // Added value
            } else if (value2 == null && !map2.containsKey(key)) {
                result = result.concat("\n- " + (key + ": " + value1));
                // Deleted value
            } else if (value1 != value2) {
                result = result.concat("\n- " + (key + ": " + value1));
                result = result.concat("\n+ " + (key + ": " + value2));
                // Changed value
            } else {
                result = result.concat("\n" + (key + ": " + value1));
                // Unchanged value
            }
        }
        return "{\n" + result.trim() + "\n}";
    }
}
