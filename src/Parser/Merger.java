package Parser;

import Exec.ArrayConvertor;

import java.util.ArrayList;
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

            if(valuesOne == null) {
                valuesOne = new ArrayList<>();
            }

            if(valuesTwo == null) {
                valuesTwo = new ArrayList<>();
            }

            int maxValue = Math.max(valuesOne.size(), valuesTwo.size());

            for(int i = 0; i < maxValue; i++) {
                mergedFile.append(keyOne).append(",");
                if(i < valuesOne.size()) {
                    mergedFile.append(ArrayConvertor.fromArray(valuesOne.get(i)));
                } else {
                    mergedFile.append(ArrayConvertor.fromArray(fileOne.getEmpty()));
                }
                mergedFile.append(",");
                if(i < valuesTwo.size()) {
                    mergedFile.append(ArrayConvertor.fromArray(valuesTwo.get(i)));
                } else {
                    mergedFile.append(ArrayConvertor.fromArray(fileTwo.getEmpty()));
                }
                mergedFile.append("\n");
            }
            keysFileTwo.remove(keyOne);
        }

        for(String keyTwo : keysFileTwo) {
            List<String[]> valuesOne = fileOne.getValues(keyTwo);
            List<String[]> valuesTwo = fileTwo.getValues(keyTwo);

            if(valuesOne == null) {
                valuesOne = new ArrayList<>();
            }

            if(valuesTwo == null) {
                valuesTwo = new ArrayList<>();
            }

            int maxValue = Math.max(valuesOne.size(), valuesTwo.size());

            for(int i = 0; i < maxValue; i++) {
                mergedFile.append(keyTwo).append(",");
                if(i < valuesOne.size()) {
                    mergedFile.append(ArrayConvertor.fromArray(valuesOne.get(i)));
                } else {
                    mergedFile.append(ArrayConvertor.fromArray(fileOne.getEmpty()));
                }
                mergedFile.append(",");
                if(i < valuesTwo.size()) {
                    mergedFile.append(ArrayConvertor.fromArray(valuesTwo.get(i)));
                } else {
                    mergedFile.append(ArrayConvertor.fromArray(fileTwo.getEmpty()));
                }
                mergedFile.append("\n");
            }
        }
    }

    public String getContet() {
        return mergedFile.toString();
    }

}
