
import components.slotmachine.SlotMachine;
import components.slotmachine.SlotMachine2;

/**
 * Program that conducts a slot machine simulation to estimate win rate.
 *
 * @author Irene Suh
 *
 */
public final class SlotMachineSimulation {

    /**
     * Useful constant, not a magic number: 10000.
     */
    private static final int NUMBER_OF_TRIALS = 10000;

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private SlotMachineSimulation() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SlotMachine sm = new SlotMachine2();
        int wins = 0;

        for (int i = 0; i < NUMBER_OF_TRIALS; i++) {
            sm.spin();
            if (sm.isWin()) {
                wins++;
            }
        }

        System.out.println("After " + NUMBER_OF_TRIALS + " spins, wins: " + wins
                + ", win rate: " + ((double) wins / NUMBER_OF_TRIALS));
    }
}
