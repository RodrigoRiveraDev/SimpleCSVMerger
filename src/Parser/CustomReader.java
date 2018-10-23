package Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomReader {

    private BufferedReader bufferedReader;

    public CustomReader(String fullPathFile) throws IOException {
        FileReader fileReader = new FileReader(fullPathFile);
        bufferedReader = new BufferedReader(fileReader);
    }

    public String nextLine() throws IOException {
        return bufferedReader.readLine();
    }

    public void close() throws IOException {
        bufferedReader.close();
    }
}
