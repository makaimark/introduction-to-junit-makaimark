package test.java.model;

import main.java.Project.FilePartReader;
import main.java.Project.FileWordAnalyzer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by makaimark on 2016.11.21..
 */
public class MockitoTestClass {
    FilePartReader wordReader;

    @Before
    public void init() throws IOException {
        wordReader = mock(FilePartReader.class);

        when(wordReader.readLines()).thenReturn("test string mocking cuccos xox");
    }

    @Test
    public void fileWorldAnalizer_wordsByABCTest() throws IOException {
        FileWordAnalyzer analyzer = new FileWordAnalyzer(wordReader);
        ArrayList returnList = analyzer.wordsByABC();
        assertEquals(returnList.get(1), "mocking");
    }

    @Test
    public void fileWordAnalyzer_wordsContainingSubStringTest() throws IOException {
        FileWordAnalyzer analyzer = new FileWordAnalyzer(wordReader);
        ArrayList strings = analyzer.wordsContainingSubString("e");
        assertEquals(strings.size(), 1);
    }

    @Test
    public void fileWordAnalyzer_palindromeTest() throws IOException {
        FileWordAnalyzer analyzer = new FileWordAnalyzer(wordReader);
        ArrayList strings = analyzer.wordsArePalindrome();
        assertEquals(strings.size(), 1);
    }

}
