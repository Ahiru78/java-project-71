package hexlet.code;

import hexlet.code.parsers.ParseFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Objects;
import java.util.Map;

public class Tree {
    public static List<HashMap<String, Object>> diff(String filepath1, String filepath2) throws Exception {
        final var map1 = getData(filepath1);
        final var map2 = getData(filepath2);
        final var state = new String[]{"add", "delete", "update", "equal"};
        var keys = findKeys(map1, map2);
        var result = new ArrayList<HashMap<String, Object>>();
        for (String key : keys) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);
            var diffMap = new HashMap<String, Object>();
            if (!map1.containsKey(key) && value1 == null) {
                // Added value
                diffMap.put("key", key);
                diffMap.put("state", state[0]);
                diffMap.put("valueNew", value2);
            } else if (!map2.containsKey(key) && value2 == null) {
                // Deleted value
                diffMap.put("key", key);
                diffMap.put("state", state[1]);
                diffMap.put("value", value1);
            } else if (!Objects.equals(value1, value2)) {
                // Changed value
                diffMap.put("key", key);
                diffMap.put("state", state[2]);
                diffMap.put("value", value1);
                diffMap.put("valueNew", value2);
            } else if (Objects.equals(value1, value2)) {
                // Unchanged value
                diffMap.put("key", key);
                diffMap.put("state", state[3]);
                diffMap.put("value", value1);
            }
            result.add(diffMap);
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

    public static Map<String, Object> getData(String path) throws Exception {
        Path pathNorm = Paths.get(path).toAbsolutePath().normalize();
        var data = Files.readString(pathNorm);
        var pick = ParseFactory.pick(getExtension(path));
        return pick.parse(data);
    }

    public static String getExtension(String path) throws Exception {
        if (path.lastIndexOf(".") > path.lastIndexOf("/")) {
            return path.substring(path.lastIndexOf(".") + 1);
        } else {
            throw new Exception("File extension not found");
        }
    }
}
