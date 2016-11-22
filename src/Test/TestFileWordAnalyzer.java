import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by makaimark on 2016.11.21..
 */
public class TestFileWordAnalyzer {

    @Test
    public void fileWorldAnalizer_wordsByABCTest() throws IOException {
        FileReaderMock fileReader = new FileReaderMock();
        FileWordAnalyzer analyzer = new FileWordAnalyzer(fileReader);
        ArrayList returnList = analyzer.wordsByABC();
        System.out.println(returnList);
        assertEquals(returnList.get(2), "is");
    }

    @Test
    public void fileWordAnalyzer_wordsContainingSubStringTest() throws IOException {
        FileReaderMock fileReader = new FileReaderMock();
        FileWordAnalyzer analyzer = new FileWordAnalyzer(fileReader);
        ArrayList strings = analyzer.wordsContainingSubString("e");
        assertEquals(strings.size(), 3);
    }
}
