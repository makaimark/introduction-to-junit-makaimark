package Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by makaimark on 2016.11.19..
 */
public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine) new IllegalArgumentException();
        if (fromLine < 1) new IllegalArgumentException();
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws IOException {
        String result = "";
        File file = new File(filePath);
        BufferedReader reader = null;
        String text = "";

        reader = new BufferedReader(new FileReader(file));

        while ((text = reader.readLine()) != null) {
            result += text + '\n';
        }
        return result;
    }

    public String readLines() throws IOException {
        String result = read();
        String[] tempArray  = result.split("\n");
        int counter = 0;
        String returnString = "";
        for ( String str : tempArray) {
            if ( counter >= fromLine && counter <= toLine ) {
                returnString += str + " ";
            }
            counter++;
        }
        return returnString;
    }
}