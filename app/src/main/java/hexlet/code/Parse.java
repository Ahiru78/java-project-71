package hexlet.code;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class Parse {
    public static String getData(String path) throws Exception {
        Path toPath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(toPath);
    }

    public static Map<String, Object> parse(String data) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(data, new TypeReference<>() { });
    }
}
