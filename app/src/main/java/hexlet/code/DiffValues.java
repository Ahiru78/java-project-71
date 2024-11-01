package hexlet.code;

public class DiffValues {
    private String key;
    private String state;
    private Object value1;
    private Object value2;

    public DiffValues(String state, Object value1, Object value2) {
        this.state = state;
        this.value1 = value1;
        this.value2 = value2;
    }

    public Object getKey() {
        return key;
    }

    public String getState() {
        return state;
    }

    public Object getValue1() {
        return value1;
    }

    public Object getValue2() {
        return value2;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
