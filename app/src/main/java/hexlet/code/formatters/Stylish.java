package hexlet.code.formatters;

import hexlet.code.DiffValues;
import java.util.Map;
import java.util.TreeMap;

public class Stylish implements Format {
    static final String TEXT = "\n  %s %s: %s";

    public final String format(TreeMap<String, DiffValues> diffMap) {
        String result = "";
        for (Map.Entry<String, DiffValues> entry: diffMap.entrySet()) {
            String key = entry.getKey();
            var value = diffMap.get(key);
            var value1 = value.getValue1();
            var value2 = value.getValue2();
            switch (value.getState()) {
                case "add":
                    result = result.concat(String.format(TEXT, "+", key, value2));
                    break;
                case "delete":
                    result = result.concat(String.format(TEXT, "-", key, value1));
                    break;
                case "change":
                    result = result.concat(String.format(TEXT, "-", key, value1));
                    result = result.concat(String.format(TEXT, "+", key, value2));
                    break;
                default:
                    result = result.concat(String.format(TEXT, " ", key, value1));
            }
        }
        return "{" + result + "\n}";
    }
}
