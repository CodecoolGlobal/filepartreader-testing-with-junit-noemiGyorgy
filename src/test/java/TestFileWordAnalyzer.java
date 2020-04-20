import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestFileWordAnalyzer {

    FilePartReader filePartReader = new FilePartReader();
    FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    private String filePath = "src/main/resources/test.txt";

    @Before
    public void init(){
        filePartReader.setup(filePath, 1,3);
    }

    @Test
    public void testGetWordsOrderedAlphabetically(){
        List<String> expected = Arrays.asList("barfoothefoobarman", "Foo", "foofoobarbar", "Level", "NoOn", "radar");
        assertEquals("ALPHABETICAL TEST: ", expected , fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testGetWordsContainingSubstring(){
        List<String> expected = Arrays.asList("barfoothefoobarman","foofoobarbar");
        assertEquals("SUBSTRING TEST: ", expected , fileWordAnalyzer.getWordsContainingSubstring("foo"));
    }

    @Test
    public void testGetStringsWhichPalindromes(){
        filePartReader.setup(filePath, 1,3);
        List<String> expected = Arrays.asList("Level", "NoOn", "radar");
        assertEquals("PALINDROME TEST: ", expected, fileWordAnalyzer.getStringsWhichPalindromes());
    }

}