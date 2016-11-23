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

    public ArrayList wordsArePalindrome() throws IOException {

        String lines = reader.readLines();

        ArrayList<String> list = new ArrayList<>(Arrays.asList(lines.split(" ")));

        ArrayList<String> returnList = new ArrayList<>();

        for ( String str : list ) {
            if (istPalindrom(str)) {
                returnList.add(str);
            }
        }
        return  returnList;
    }

    public static boolean istPalindrom(String word){
        int i1 = 0;
        int i2 = word.length() - 1;
        while (i2 > i1) {
            if (word.charAt(i1) != word.charAt(i2)) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
}
