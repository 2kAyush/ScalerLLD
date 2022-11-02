package addersubtractorlock;

public class Value {
    private int value = 0;

    public void add(int i) {
        value += i;
    }
    public void subtract(int i) {
        value -= i;
    }
    public int get() {
        return value;
    }
    public void set(int i) {
        this.value = i;
    }
}
