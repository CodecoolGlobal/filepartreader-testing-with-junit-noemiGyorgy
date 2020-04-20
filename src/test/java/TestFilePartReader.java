import lombok.SneakyThrows;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFilePartReader {

    private FilePartReader filePartReader = new FilePartReader();
    private String filePath = "../../main/resources/test.txt";

    @Test(expected = IllegalArgumentException.class)
    public void testFromLineSmallerThanToLine(){
        filePartReader.setup(filePath, 3, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromLinePositiveness(){
        filePartReader.setup(filePath, -1, 1);
    }

    @Test @SneakyThrows
    public void testPath(){
        FilePartReader pathTester = new FilePartReader();
        pathTester.setup("nonexistent_file.txt", 1, 1);
        assertEquals("PATH ERROR: ", "File not found", pathTester.read());
    }

    @Test @SneakyThrows
    public void testRead(){
        assertEquals("READ TEST: ", "Level NoOn\n" +
                "barfoothefoobarman Foo\n" +
                "radar foofoobarbar", filePartReader.read());
    }

    @Test
    public void testReadlines(){
        filePartReader.setup(filePath,2,4);
        assertEquals("READLINES TEST: ", "barfoothefoobarman Foo\n" + "radar foofoobarbar", filePartReader.readLines());
    }
}