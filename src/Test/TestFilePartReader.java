import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by makaimark on 2016.11.22..
 */
public class TestFilePartReader {

    private String filePath;
    private String invalidFilePath;

    @Before
    public void setUp() {
        filePath = "/home/makaimark/Desktop/Codecool/JAVA/introduction-to-junit-makaimark/src/Project/test.txt";
        invalidFilePath = "/testnotexist.txt";
    }

    @Test
    public void testValidLines() throws IOException {
        FilePartReader reader = new FilePartReader(filePath, 0, 1);
        assertEquals(reader.readLines(), "test line \n" + "this is the second \n");
    }

    @Test
    public void testSameFromTo() throws IOException {
        FilePartReader reader = new FilePartReader(filePath, 1, 1);
        assertEquals(reader.readLines(), "this is the second \n");
    }

    @Test
    public void testInvalidLines() throws IOException {
        FilePartReader reader = new FilePartReader(filePath, 6, 8);
        assertEquals(reader.readLines(), "");
    }
}
