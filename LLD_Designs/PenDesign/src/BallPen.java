import strategies.writestrategies.WriteBehaviour;
import strategies.writestrategies.SmoothWriteBehaviour;

public class BallPen extends Pen implements RefilPen{
    public BallPen(WriteBehaviour writeBehaviour) {
        super(PenType.BALL, writeBehaviour);
    }
    @Override
    public void write() {

    }

    @Override
    public Colour getColour() {
        return null;
    }

    @Override
    public Refil getRefil(){
        return null;
    }

    @Override
    public boolean canChangeRefil() {
        return false;
    }

    @Override
    public void changeRefil(Refil newRefil) {
    }
}
