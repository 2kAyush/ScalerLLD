package addersubtractor;

public class Subtractor implements Runnable{
    Value value;

    public Subtractor(Value value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 1;i <= 100;++i) {
            try{
                Thread.sleep(5L);
            }
            catch (Exception e) {
                System.out.println(e);
            }
//            value.value -= i;
            value.subtract(i);
        }

    }
}
