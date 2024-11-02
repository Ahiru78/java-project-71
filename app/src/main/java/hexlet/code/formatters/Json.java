package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DiffValues;
import java.util.Map;
import java.util.TreeMap;

public class Json implements Format {
    public final String format(TreeMap<String, DiffValues> diffMap) throws JsonProcessingException {
        String result = "";
        for (Map.Entry<String, DiffValues> entry: diffMap.entrySet()) {
            String key = entry.getKey();
            var value = diffMap.get(key);
            value.setKey(key);
            ObjectMapper objectMapper = new ObjectMapper();
            String asString = objectMapper.writeValueAsString(value);
            result = result.concat("\n" + asString + ",");
        }
        return "[" + result.substring(0, result.length() - 1) + "\n]";
    }
}
