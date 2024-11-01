package hexlet.code.formatters;

import hexlet.code.DiffValues;
import java.io.IOException;
import java.util.TreeMap;

public interface Format {
    String format(TreeMap<String, DiffValues> diffMap) throws IOException;
}
