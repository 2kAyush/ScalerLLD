import strategies.writestrategies.WriteBehaviour;
import strategies.writestrategies.SmoothWriteBehaviour;
public class Marker extends Pen implements RefilPen{
    Marker(WriteBehaviour writeBehaviour) {
        super(PenType.MARKER, writeBehaviour);
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
