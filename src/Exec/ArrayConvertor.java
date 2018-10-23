package Exec;

public class ArrayConvertor {
    public static String fromArray(String[] values) {
        StringBuilder toString = new StringBuilder();
        if(values[0] != null) {
            toString.append(values[0]);
        } else {
            toString.append(", ");
        }
        for(int i = 1; i < values.length; i++) {
            if(values[i] != null) {
                toString.append(",").append(values[i]);
            } else {
                toString.append(", ");
            }
        }
        return toString.toString();
    }
}
