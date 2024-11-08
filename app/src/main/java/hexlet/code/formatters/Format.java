package hexlet.code.formatters;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface Format {
    String format(List<HashMap<String, Object>> diffMap) throws IOException;
}
