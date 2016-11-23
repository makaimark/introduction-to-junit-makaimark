import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

/**
 * Created by makaimark on 2016.11.21..
 */
public class TestFileWordAnalyzer {

    FileReaderMock fileReader;
    FileWordAnalyzer analyzer;

    @Before
    public void setUp() {
        fileReader = new FileReaderMock();
        analyzer = new FileWordAnalyzer(fileReader);
    }

    @Test
    public void fileWorldAnalizer_wordsByABCTest() throws IOException {
        ArrayList returnList = analyzer.wordsByABC();
        assertEquals(returnList.get(2), "is");
    }

    @Test
    public void fileWorldAnalizer_wordsByABCOtherTest() throws IOException {
        ArrayList returnList = analyzer.wordsByABC();
        List<String> expected = Arrays.asList("a", "a", "is", "line", "test", "test", "this", "too");
        assertEquals(returnList, expected);
    }

    @Test
    public void fileWordAnalyzer_wordsContainingSubCharTest() throws IOException {
        ArrayList strings = analyzer.wordsContainingSubString("e");
        List<String> expected = Arrays.asList("test", "test", "line");
        assertEquals(strings, expected);
    }

    @Test
    public void fileWordAnalyzer_wordsContainingSubStringTest() throws IOException {
        ArrayList strings = analyzer.wordsContainingSubString("tes");
        List<String> expected = Arrays.asList("test", "test");
        assertEquals(strings, expected);
    }
}
