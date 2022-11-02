package runnableexample;

public class PrintString implements Runnable{
    private char a;

    public PrintString(char a) {
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println(a);
    }
}
