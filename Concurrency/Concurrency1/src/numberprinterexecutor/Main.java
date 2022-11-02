package numberprinterexecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
//        for (int i = 0;i < 100;i++) {
//            executor.execute(new RunnableExample.NumberPrinter(i));
//        }
        String s = "I am Ayush Kumar and I am a software Developer";
        for(int i = 0;i < s.length();i++){
            executor.execute(new PrintString(s.charAt(i)));
        }
        executor.shutdown();
    }
}