package hexlet.code.parsers;

public class ParseFactory {
    public static Parser pick(String extension) {
        return switch (extension) {
            case "json" -> new JSON();
            case "yml" -> new YML();
            case "yaml" -> new YML();
            default -> new JSON();
        };
    }
}
