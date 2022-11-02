package multithreadedmergesort;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> list = List.of(
                134,45,46,3,22,8,7,51,6,12
        );
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Integer>> sortedListFuture = executorService.submit(new Sorter(list));
        List<Integer> sortedList = sortedListFuture.get();
        System.out.println(sortedList);
    }
}
