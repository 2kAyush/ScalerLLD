package numberprinterexecutor;

public class PrintString implements Runnable{
    char toPrint;

    public PrintString(char toPrint) {
        this.toPrint = toPrint;
    }

    @Override
    public void run() {
        System.out.println(this.toPrint);
    }
}
