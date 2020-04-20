import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public List<String> getWordsOrderedAlphabetically() {
        List<String> orderedWords = new ArrayList<>();
        return orderedWords;
    }

    public List<String> getWordsContainingSubstring(String subString) {
        List<String> wordsContainingSubstring = new ArrayList<>();
        return wordsContainingSubstring;
    }

    public List<String> getStringsWhichPalindromes() {
        List<String> stringsWhichPalindromes = new ArrayList<>();
        return stringsWhichPalindromes;
    }
}