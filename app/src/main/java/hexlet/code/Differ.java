package hexlet.code;

import hexlet.code.formatters.Formatter;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        var diffValues = Tree.diff(filepath1, filepath2);
        return Formatter.pick(format).format(diffValues);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
