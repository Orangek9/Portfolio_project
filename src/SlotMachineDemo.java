import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program that outputs a html file with a list of terms and the number of time
 * they appear using the given text file.
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
     * Useful constant, not a magic number: 3.
     */
    private static final int THREE = 3;
    /**
     * Useful constant, not a magic number: 3.
     */
    private static final int NINE = 9;

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.println("Input 'spin' to play!");
        String input = in.nextLine();

        if (input.equals("spin")) {
            int[] spin = spin();
            printResults(out, spin);
        } else {
            out.print("Bye!");
        }
        in.close();
        out.close();
    }

    /**
     * @param out
     *            output
     * @param spin
     *            spin results
     */
    private static void printResults(SimpleWriter out, int[] spin) {
        boolean win = false;
        for (int i = 0; i < spin.length; i++) {
            out.print(spin[i]);
            if (i < spin.length - 1) {
                out.print(" | ");
            }
        }
        out.println();
        win = isWin(spin);
        if (win) {
            out.print("Jackpot!");
        } else {
            out.print("Try Again");
        }
    }

    /**
     * Results in an integer array representing the result of the spin.
     *
     * @return an array of random integers
     */

    private static int[] spin() {
        int[] result = new int[THREE];
        int min = 0;
        int max = NINE;
        int random = 0;
        for (int i = 0; i < result.length; i++) {
            random = (int) (Math.random() * (max - min + 1));
            result[i] = random;
        }
        return result;
    }

    /**
     * Returns if game is won with the spin results.
     *
     * @param spin
     *            an int array representing the result of the spin
     * @return whether the game is won or not
     */

    private static boolean isWin(int[] spin) {
        boolean result = true;
        for (int i = 0; i < spin.length - 1; i++) {
            if (spin[i] != spin[i + 1]) {
                result = false;
            }
        }
        return result;
    }
}
