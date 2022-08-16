public class PenFactory {
    public static GelPen.Builder createGelPen() {
        return new GelPen.Builder();
    }
    public static BallPen createBallPen() {return null;}
    public static FountainPen createFountainPen() {return null;}
    public static Marker createMarker() {return null;}
}
