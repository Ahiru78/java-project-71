package hexlet.code.parsers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.io.IOException;

public class JSON implements Parser {
    public final Map<String, Object> parse(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(data, new TypeReference<>() { });
    }
}
