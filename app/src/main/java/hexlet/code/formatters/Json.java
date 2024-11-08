package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.HashMap;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Json implements Format {
    public final String format(List<HashMap<String, Object>> diffMap) throws JsonProcessingException {
        String result = "";
        for (int i = 0; i < diffMap.size(); i++) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
            String asString = objectMapper.writeValueAsString(diffMap.get(i));
            result = result.concat("\n" + asString + ",");
        }
        return "[" + result.substring(0, result.length() - 1) + "\n]";
    }
}
