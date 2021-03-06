import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FilePartReader {
    String filePath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader() {
        setup("src/main/resources/test.txt", 1, 1);
    }
    
    public void setup(String filePath,Integer fromLine, Integer toLine) {
        if (toLine < fromLine) {
            throw new IllegalArgumentException("toLine cannot be smaller than fromLine");
        } else if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine must be greater than 0");
        } else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    @SneakyThrows
    public String read() throws IOException {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            int i;
            StringBuilder content = new StringBuilder();
            while((i = fis.read()) != -1){
                content.append((char) i);
            }
            fis.close();
            return content.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "File not found";
    }

    @SneakyThrows
    public String readLines() {
        String read = read();
        String[] rows = read.split("\n");
        if (rows.length < toLine) toLine = rows.length;
        String[] usefulContentRows = new String[toLine - fromLine + 1];

        for (int i = fromLine - 1, j = 0; i < toLine; i++, j++) {
            usefulContentRows[j] = rows[i] + "\n";
        }
        StringBuilder usefulContent = new StringBuilder();
        Arrays.stream(usefulContentRows).forEach(usefulContent::append);
        return usefulContent.toString();
    }

}
