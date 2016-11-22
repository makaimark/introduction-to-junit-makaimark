import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by makaimark on 2016.11.19..
 */
public class FileWordAnalyzer {

    private FileReaderInterface reader;

    public FileWordAnalyzer(FileReaderInterface object) {
        this.reader = object;
    }

    public ArrayList wordsByABC() throws IOException {
        //String lines = reader.readLines(); without mocking
        String lines = reader.readLines();
        ArrayList<String> returnList = new ArrayList<>(Arrays.asList(lines.split(" ")));
        Collections.sort(returnList);
        return returnList;
    }

    public ArrayList wordsContainingSubString(String subString) throws IOException {
        //String lines = reader.readLines(); without mocking
        String lines = reader.readLines();

        ArrayList<String> list = new ArrayList<>(Arrays.asList(lines.split(" ")));

        ArrayList<String> returnList = new ArrayList<>();

        for ( String str : list ) {
            if (str.toLowerCase().contains(subString.toLowerCase())) {
                returnList.add(str);
            }
        }
        return  returnList;
    }
}
