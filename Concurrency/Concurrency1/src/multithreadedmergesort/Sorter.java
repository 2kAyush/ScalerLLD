package multithreadedmergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> list;

    public Sorter(List<Integer> list) {
        this.list = list;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(list.size() <= 1) return list;
        int mid = list.size() / 2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i = 0;i < mid;i++){
            left.add(list.get(i));
        }

        for(int i = mid;i < list.size();i++){
            right.add(list.get(i));
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<List<Integer>> sortedLeftFuture = executor.submit(new Sorter(left));
        Future<List<Integer>> sortedRightFuture = executor.submit(new Sorter(right));

        List<Integer> sortedLeft = sortedLeftFuture.get();
        List<Integer> sortedRight = sortedRightFuture.get();

        List<Integer> finalList = new ArrayList<>();
        int i = 0, j = 0;
        while(i < sortedLeft.size() && j < sortedRight.size()) {
            if(sortedLeft.get(i) <= sortedRight.get(j)) {
                finalList.add(sortedLeft.get(i));
                ++i;
            }
            else{
                finalList.add(sortedRight.get(j));
                ++j;
            }
        }

        while(i < sortedLeft.size()) {
            finalList.add(sortedLeft.get(i));
            ++i;
        }
        while(j < sortedRight.size()) {
            finalList.add(sortedRight.get(j));
            ++j;
        }
        return finalList;
    }
}
