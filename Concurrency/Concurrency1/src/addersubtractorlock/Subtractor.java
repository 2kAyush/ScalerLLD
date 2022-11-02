package addersubtractorlock;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{
    Value value;
    Lock lockForValue;

    public Subtractor(Value value, Lock lockForValue) {
        this.value = value;
        this.lockForValue = lockForValue;
    }

    @Override
    public void run() {
        for (int i = 1;i <= 1000;++i) {
            try{
                Thread.sleep(10L);
            }
            catch (Exception e) {
                System.out.println(e);
            }
//            value.subtract(i);
            lockForValue.lock();
            int temp = value.get();
            temp -= i;
            value.set(temp);
            lockForValue.unlock();
        }

    }
}
