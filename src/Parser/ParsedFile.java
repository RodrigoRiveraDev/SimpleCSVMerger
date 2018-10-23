package Parser;

import java.util.*;

public class ParsedFile {
    private Map<String, List<String[]>> content;
    private String[] empty;

    public ParsedFile() {
        content = new HashMap<>();
    }

    public void addContent(String key, String[] value) {
        if(content.containsKey(key)) {
            List<String[]> values = content.get(key);
            values.add(value);
            content.put(key, values);
        } else {
            List<String[]> values = Collections.singletonList(value);
            content.put(key, values);
        }
        empty = new String[value].length;
    }

    public Set<String> getKeys() {
        return content.keySet();
    }

    public List<String[]> getValues(String key) {
        return content.get(key);
    }

    public String[] getEmpty() {
        return empty;
    }
}
