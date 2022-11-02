package addersubtractoratomic;

public class Adder implements Runnable {
    Value value;

    public Adder(Value value) {
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
            value.add(i);
//            int current = value.get();
//            current += i;
//            value.set(current);
        }
    }
}
