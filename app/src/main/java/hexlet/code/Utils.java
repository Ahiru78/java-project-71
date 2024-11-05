package hexlet.code;
import hexlet.code.parsers.ParseFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;


public class Utils {
    public static Map<String, Object> getData(String path) throws Exception {
        Path pathNorm = Paths.get(path).toAbsolutePath().normalize();
        var data = Files.readString(pathNorm);
        var pick = ParseFactory.pick(getExtension(path));
        return pick.parse(data);
    }

    public static String getExtension(String path) throws Exception {
        if (path.lastIndexOf(".") > path.lastIndexOf("/")) {
            return path.substring(path.lastIndexOf(".") + 1);
        } else {
            throw new Exception("File extension not found");
        }
    }

    public static String readFile(String path) throws IOException {
        var normPath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(normPath);
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
