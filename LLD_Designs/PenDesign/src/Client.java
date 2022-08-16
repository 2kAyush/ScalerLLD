public class Client {
    public static void main(String[] args) {
        GelPen gelPen = PenFactory.createGelPen()
                .setRefil(new Refil())
                .setCanChangeRefil(true)
                .build();
    }
}