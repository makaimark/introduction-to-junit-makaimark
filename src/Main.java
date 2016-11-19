import java.io.IOException;

/**
 * Created by makaimark on 2016.11.19..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader fileReader = new FilePartReader("/home/makaimark/Desktop/Codecool/JAVA/introduction-to-junit-makaimark/src/test.txt",0, 2);
        String result = fileReader.readLines();
        System.out.println(result);
    }
}
