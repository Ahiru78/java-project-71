package hexlet.code.parsers;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YML implements Parser {
    public final Map<String, Object> parse(String data) throws IOException {
        YAMLMapper mapper = new YAMLMapper();
        return mapper.readValue(data, new TypeReference<>() { });
    }
}
