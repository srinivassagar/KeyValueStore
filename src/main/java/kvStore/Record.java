package kvStore;

/*
Author Srinivas A
Data Object
 */

import java.sql.Timestamp;

public class Record {
    String key;
    Object value;
    String Label = "";
    Timestamp timestamp;

    private Record(String key, Object value, String label) {
        this.key = key;
        this.value = value;
        Label = label;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    private Record(String key, Object value) {
        this.key = key;
        this.value = value;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public static Record getRecord(String key, Object value) {
        return new Record(key, value);
    }

    public static Record getRecord(String key, Object value, String label) {
        return new Record(key, value, label);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Record{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", Label='" + Label + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
