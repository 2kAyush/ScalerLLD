package addersubtractorlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws Exception {
        Value value = new Value();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Lock lockForValue = new ReentrantLock();

        executorService.execute(new Adder(value, lockForValue));
        executorService.execute(new Subtractor(value, lockForValue));

        executorService.shutdown();
        executorService.awaitTermination(5L, TimeUnit.SECONDS);
        System.out.println(value.get());

    }
}
