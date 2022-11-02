package runnableexample;

public class Main {
    public static void main(String[] args) {
        for (int i = 0;i < 100;i++) {
//            Thread t = new Thread(new RunnableExample.HelloPrinter());
//            t.start();
//            Thread t = new Thread(new RunnableExample.NumberPrinter(i + 1));
//            t.start();
        }
        String s = "I am Ayush Kumar and I am a software Developer";
        for(int i = 0;i < s.length();i++){
            Thread t = new Thread(new PrintString(s.charAt(i)));
            t.start();
        }
    }
}