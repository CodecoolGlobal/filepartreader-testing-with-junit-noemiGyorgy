import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;
    private List<String> words;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
        getWords();
    }
    public List<String> getWordsOrderedAlphabetically() {
        List<String> orderedWords = new ArrayList<>(words);
        Collections.sort(orderedWords);

        return orderedWords;
    }

    public List<String> getWordsContainingSubstring(String subString) {
        List<String> wordsContainingSubstring = new ArrayList<>();
        Stream<String> stream = words.stream();

        stream.forEach(word -> {
            if(word.contains(subString)) wordsContainingSubstring.add(word);
        });

        return wordsContainingSubstring;
    }

    public List<String> getStringsWhichPalindromes() {
        List<String> palindromes = new ArrayList<>();
        Stream<String> stream = words.stream();

        stream.forEach(word -> {
            String backward = new StringBuilder(word).reverse().toString().toLowerCase();
            if (word.toLowerCase().equals(backward)) palindromes.add(word);
        });

        return palindromes;
    }

    @SneakyThrows
    private void getWords () {
        String readLines = filePartReader
                .readLines()
                .replace("\n", " ")
                .replaceAll("[.,;]", " ")
                .replaceAll("", " ")
                .replaceAll("\t", " ");

        this.words = Arrays
                .stream(readLines.split(" "))
                .collect(Collectors.toList());
    }
}