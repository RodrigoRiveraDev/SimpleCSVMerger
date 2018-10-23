package Exec;

import Parser.CustomParser;
import Parser.CustomReader;
import Parser.Merger;
import Parser.ParsedFile;
import javafx.util.Pair;

public class Main {
    public static void main(String[] args) {
        String path1 = System.getProperty("user.dir") + "/src/resources/File1.csv";
        int columnNumbers1 = 2;
        String path2 = System.getProperty("user.dir") + "/src/resources/File2.csv";
        int columnNumbers2 = 3;

        try {
            CustomReader reader1 = new CustomReader(path1);
            ParsedFile parsedFile1 = new ParsedFile();

            String line = reader1.nextLine();
            while(line != null) {
                Pair<String, String[]> parsedLine = CustomParser.parseLine(line, columnNumbers1);
                parsedFile1.addContent(parsedLine.getKey(), parsedLine.getValue());
                line = reader1.nextLine();
            }

            CustomReader reader2 = new CustomReader(path2);
            ParsedFile parsedFile2 = new ParsedFile();

            line = reader2.nextLine();
            while(line != null) {
                Pair<String, String[]> parsedLine = CustomParser.parseLine(line, columnNumbers2);
                parsedFile2.addContent(parsedLine.getKey(), parsedLine.getValue());
                line = reader2.nextLine();
            }

            Merger merger = new Merger();

            merger.mergeFiles(parsedFile1, parsedFile2);

            System.out.println(merger.getContet());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
