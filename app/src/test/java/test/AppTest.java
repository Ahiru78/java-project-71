package test;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    private final String path = "src/test/resources/";
    private final String pathJSON1 = (path + "file1.json");
    private final String pathJSON2 = (path + "file2.json");
//  private final String pathYAML1 = (path + "file1.yaml");
//  private final String pathYAML2 = (path + "file2.yaml");
    private final String pathYML1 = (path + "file1.yml");
    private final String pathYML2 = (path + "file2.yml");
    private final String expStylish =  (path + "StylishExpected.txt");
    private final String expPlain = (path + "PlainExpected.txt");
    private final String expJson = (path + "JsonExpected.txt");

    @Test
    void testGenerateJson() throws Exception {
        String expected = readFile(expStylish);
        String actual = Differ.generate(pathJSON1, pathJSON2);
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateYml() throws Exception {
        String expected = readFile(expStylish);
        String actual = Differ.generate(pathYML1, pathYML2);
        assertEquals(expected, actual);
    }

    @Test
    void testStylishJson() throws Exception {
        String expected = readFile(expStylish);
        String actual = Differ.generate(pathJSON1, pathJSON2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    void testStylishYml() throws Exception {
        String expected = readFile(expStylish);
        String actual = Differ.generate(pathYML1, pathYML2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    void testPlainJson() throws Exception {
        String expected = readFile(expPlain);
        String actual = Differ.generate(pathJSON1, pathJSON2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    void testPlainYml() throws Exception {
        String expected = readFile(expPlain);
        String actual = Differ.generate(pathYML1, pathYML2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    void testJsonJson() throws Exception {
        String expected = readFile(expJson);
        String actual = Differ.generate(pathJSON1, pathJSON2, "json");
        assertEquals(expected, actual);
    }

    @Test
    void testJsonYml() throws Exception {
        String expected = readFile(expJson);
        String actual = Differ.generate(pathYML1, pathYML2, "json");
        assertEquals(expected, actual);
    }

    public static String readFile(String path) throws IOException {
        var normPath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(normPath);
    }
}
