package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class Json implements Format {
    public final String format(TreeMap<String, HashMap<String, Object>> diffMap) throws JsonProcessingException {
        String result = "";
        for (Map.Entry<String, HashMap<String, Object>> entry: diffMap.entrySet()) {
            ObjectMapper objectMapper = new ObjectMapper();
            String asString = objectMapper.writeValueAsString(entry);
            result = result.concat("\n" + asString + ",");
        }
        return "[" + result.substring(0, result.length() - 1) + "\n]";
    }
}
