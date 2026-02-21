import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.slotmachine.SlotMachine;
import components.slotmachine.SlotMachine2;

/**
 * Program that conducts a simple slot machine game.
 *
 * @author Irene Suh
 *
 */
public final class SlotMachineDemo {
    /**
     * No argument constructor--private to prevent instantiation.
     */
    private SlotMachineDemo() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        SlotMachine sm = new SlotMachine2();
        sm.gameLoop(in, out);
        in.close();
        out.close();
    }
}
