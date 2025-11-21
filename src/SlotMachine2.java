import components.simplewriter.SimpleWriter;

/**
 * {@code SlotMachine} implementations of primary methods.
 *
 * @convention $this.rep != null && this.rep.length == 3 && 1 <= $this.rep[i] <=
 *             9 for all of i
 * @correspondence this = $this.rep
 */
public class SlotMachine2 extends SlotMachineSecondary {

    /**
     * Useful constant, not a magic number: 3.
     */
    private static final int THREE = 3;
    /**
     * Useful constant, not a magic number: 9.
     */
    private static final int NINE = 9;

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * The current spin results.
     */
    private int[] rep;

    /**
     * Initializes the representation to a fresh spin of zeros.
     */
    private void createNewRep() {
        this.rep = new int[THREE];
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public SlotMachine2() {
        this.createNewRep();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final SlotMachine newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(SlotMachine source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof SlotMachine2 : ""
                + "Violation of: source is of dynamic type SlotMachine2";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        SlotMachine2 localSource = (SlotMachine2) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final int[] spin() {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            this.rep[i] = 1 + (int) (Math.random() * NINE);
        }
        return this.rep;
    }

    @Override
    public final void printResults(SimpleWriter out) {

        out.print("Your spin: [");
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            out.print(this.rep[i]);
            if (i < ARRAY_LENGTH - 1) {
                out.print("| ");
            }
        }
        out.println("]");
        if (this.isWin()) {
            out.println("Jackpot!");
        } else {
            out.println("Try Again");
        }
    }

    @Override
    public final boolean isWin() {
        return this.rep[0] == this.rep[1] && this.rep[1] == this.rep[2];
    }

}
