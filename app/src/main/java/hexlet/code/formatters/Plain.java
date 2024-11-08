package hexlet.code.formatters;

import org.apache.commons.lang3.ClassUtils;
import java.util.List;
import java.util.HashMap;

public class Plain implements Format {
    static final String TEXTADD = "\nProperty '%s' was added with value: %s";
    static final String TEXTRMV = "\nProperty '%s' was removed";
    static final String TEXTUPD = "\nProperty '%s' was updated. From %s to %s";

    public final String format(List<HashMap<String, Object>> diffMap) {
        String result = "";
        for (int i = 0; i < diffMap.size(); i++) {
            var map = diffMap.get(i);
            var key = map.get("key");
            var state = map.get("state");
            var value1 = defType(map.get("value"));
            var value2 = defType(map.get("valueNew"));
            if (state.equals("update")) {
                result = result.concat(String.format(TEXTUPD, key, value1, value2));
            } else if (state.equals("add")) {
                result = result.concat(String.format(TEXTADD, key, value2));
            } else if (state.equals("delete")) {
                result = result.concat(String.format(TEXTRMV, key));
            }
        }
        return result.trim();
    }

    public static String defType(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (!ClassUtils.isPrimitiveOrWrapper(value.getClass())) {
            return "[complex value]";
        }
        return value.toString();
    }
}
