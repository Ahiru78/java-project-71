package hexlet.code;

public class DiffValues {
    private String key;
    private final String state;
    private final Object value1;
    private final Object value2;

    public DiffValues(String state, Object value1, Object value2) {
        this.state = state;
        this.value1 = value1;
        this.value2 = value2;
    }

    public final Object getKey() {
        return key;
    }

    public final String getState() {
        return state;
    }

    public final Object getValue1() {
        return value1;
    }

    public final Object getValue2() {
        return value2;
    }

    public final void setKey(String key) {
        this.key = key;
    }
}
