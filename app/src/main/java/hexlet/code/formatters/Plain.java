package hexlet.code.formatters;

import hexlet.code.DiffValues;
import hexlet.code.Utils;
import java.util.Map;
import java.util.TreeMap;

public class Plain implements Format {
    static final String TEXTADD = "\nProperty '%s' was added with value: %s";
    static final String TEXTRMV = "\nProperty '%s' was removed";
    static final String TEXTUPD = "\nProperty '%s' was updated. From %s to %s";

    public final String format(TreeMap<String, DiffValues> diffMap) {
        String result = "";
        for (Map.Entry<String, DiffValues> entry: diffMap.entrySet()) {
            String key = entry.getKey();
            var value = diffMap.get(key);
            var value1 = Utils.defType(value.getValue1());
            var value2 = Utils.defType(value.getValue2());
            switch (value.getState()) {
                case "add":
                    result = result.concat(String.format(TEXTADD, key, value2));
                    break;
                case "delete":
                    result = result.concat(String.format(TEXTRMV, key));
                    break;
                case "change":
                    result = result.concat(String.format(TEXTUPD, key, value1, value2));
                    break;
                case "equal":
                    break;
                default: throw new RuntimeException("Something went wrong");
            }
        }
        return result.trim();
    }
}
