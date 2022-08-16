import strategies.writestrategies.WriteBehaviour;
import strategies.writestrategies.SmoothWriteBehaviour;

public class FountainPen extends Pen{
    public FountainPen(WriteBehaviour writeBehaviour) {
        super(PenType.FOUNTAIN, writeBehaviour);
    }
    @Override
    public void write() {

    }

    @Override
    public Colour getColour() {
        return null;
    }
}
