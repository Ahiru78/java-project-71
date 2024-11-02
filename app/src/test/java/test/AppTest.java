package test;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    final String pathJSON1 = "src/test/resources/file1.json";
    final String pathJSON2 = "src/test/resources/file2.json";
    final String pathYAML1 = "src/test/resources/file1.yaml";
    final String pathYAML2 = "src/test/resources/file2.yaml";
    final String pathYML1 = "src/test/resources/file1.yml";
    final String pathYML2 = "src/test/resources/file2.yml";
    final String expStylish = "src/test/resources/StylishExpected.txt";
    final String expPlain = "src/test/resources/PlainExpected.txt";
    final String expJson = "src/test/resources/JsonExpected.txt";

    @Test
    void testCompareJSON() throws Exception {
        var expectedPath = Paths.get(expStylish).toAbsolutePath().normalize();
        String expected = Files.readString(expectedPath);
        String actual = Differ.generate(pathJSON1, pathJSON2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    void testCompareYML() throws Exception {
        var expectedPath = Paths.get(expStylish).toAbsolutePath().normalize();
        String expected = Files.readString(expectedPath);
        String actual = Differ.generate(pathYML1, pathYML2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    void testCompareYAML() throws Exception {
        var expectedPath = Paths.get(expStylish).toAbsolutePath().normalize();
        String expected = Files.readString(expectedPath);
        String actual = Differ.generate(pathYAML1, pathYAML2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    void testPlain() throws Exception {
        var expectedPath = Paths.get(expPlain).toAbsolutePath().normalize();
        String expected = Files.readString(expectedPath);
        String actual = Differ.generate(pathJSON1, pathJSON2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    void testJson() throws Exception {
        var expectedPath = Paths.get(expJson).toAbsolutePath().normalize();
        String expected = Files.readString(expectedPath);
        String actual = Differ.generate(pathJSON1, pathJSON2, "json");
        assertEquals(expected, actual);
    }
}
