package Parser;

import javafx.util.Pair;

public class CustomParser {

    public static Pair<String, String[]> parseLine(String line, int maxNumberColumns) {
        String[] columns = new String[maxNumberColumns];
        String[] actualColumns = line.split(",");
        String key = actualColumns[0];

        int i;
        for(i = 1; i < actualColumns.length; i++) {
            columns[i-1] = actualColumns[i];
        }

        while(i < columns.length) {
            columns[i-1] = " ";
            i++;
        }

        return new Pair<>(key, columns);
    }

}
