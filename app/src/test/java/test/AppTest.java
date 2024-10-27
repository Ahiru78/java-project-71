package test;
import static hexlet.code.Differ.generate;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    final String path1 = "src/test/resources/file1.json";
    final String path2 = "src/test/resources/file2.json";
    final String pathExp = "src/test/resources/expected.txt";
    
    @Test
    void testCompareFlat() throws Exception {
        var expectedPath = Paths.get(pathExp).toAbsolutePath().normalize();
        String expected = Files.readString(expectedPath);
        String actual = generate(path1, path2);
        assertEquals(expected, actual);
    }
}
