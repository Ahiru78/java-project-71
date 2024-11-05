package hexlet.code.formatters;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public interface Format {
    String format(TreeMap<String, HashMap<String, Object>> diffMap) throws IOException;
}
