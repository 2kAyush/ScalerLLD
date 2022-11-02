package addersubtractoratomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Value {
    private int value = 0;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public void add(int i) {
        atomicInteger.addAndGet(i);
        value += i;
    }
    public void subtract(int i) {
        atomicInteger.addAndGet(-1*i);
        value -= i;
    }
    public int get() {
        return atomicInteger.get();
//        return value;
    }
    public void set(int i) {
        atomicInteger.set(i);
        this.value = i;
    }
}
