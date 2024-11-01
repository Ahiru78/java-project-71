package hexlet.code.formatters;

public class Formatter {
    public static Format pick(String name) {
        return switch (name) {
            case "stylish" -> new Stylish();
            case "plain" -> new Plain();
            case "json" -> new Json();
            default -> new Stylish();
        };
    }
}
