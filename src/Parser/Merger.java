package Parser;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Merger {

    private StringBuilder mergedFile;

    public Merger() {
        mergedFile = new StringBuilder();
    }

    public void mergeFiles(ParsedFile fileOne, ParsedFile fileTwo) {
        Set<String> keysFileOne = fileOne.getKeys();
        Set<String> keysFileTwo = fileTwo.getKeys();

        for(String keyOne : keysFileOne) {
            List<String[]> valuesOne = fileOne.getValues(keyOne);
            List<String[]> valuesTwo = fileTwo.getValues(keyOne);

            int maxValue = Math.max(valuesOne.size(), valuesTwo.size());

            for(int i = 0; i < maxValue; i++) {
                mergedFile.append(keyOne).append(",");
                if(i < valuesOne.size()) {
                    mergedFile.append(Arrays.toString(valuesOne.get(i)));
                } else {
                    mergedFile.append(Arrays.toString(fileOne.getEmpty()));
                }
                if(i < valuesTwo.size()) {
                    mergedFile.append(Arrays.toString(valuesTwo.get(i)));
                } else {
                    mergedFile.append(Arrays.toString(fileTwo.getEmpty()));
                }
                mergedFile.append("\n");
            }
            keysFileTwo.remove(keyOne);
        }

        for(String keyTwo : keysFileTwo) {
            List<String[]> valuesOne = fileOne.getValues(keyTwo);
            List<String[]> valuesTwo = fileTwo.getValues(keyTwo);

            int maxValue = Math.max(valuesOne.size(), valuesTwo.size());

            for(int i = 0; i < maxValue; i++) {
                mergedFile.append(keyTwo).append(",");
                if(i < valuesOne.size()) {
                    mergedFile.append(Arrays.toString(valuesOne.get(i)));
                } else {
                    mergedFile.append(Arrays.toString(fileOne.getEmpty()));
                }
                if(i < valuesTwo.size()) {
                    mergedFile.append(Arrays.toString(valuesTwo.get(i)));
                } else {
                    mergedFile.append(Arrays.toString(fileTwo.getEmpty()));
                }
                mergedFile.append("\n");
            }
        }
    }

    public String getContet() {
        return mergedFile.toString();
    }

}
