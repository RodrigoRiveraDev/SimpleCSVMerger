package Parser;

public class Parser {

    public static String[] parseLine(String line, int maxNumberColumns) {
        String[] columns = new String[maxNumberColumns];
        String[] actualColumns = line.split(",");

        if(actualColumns.length < columns.length) {
            int i;
            for(i = 0; i < columns.length; i++) {
                columns[i] = actualColumns[i];
            }

            while(i < columns.length) {
                columns[i] = " ";
                i++;
            }
        }
        return columns;
    }

}
