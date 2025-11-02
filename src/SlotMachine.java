import components.simplereader.SimpleReader;
import components.simplewriter.SimpleWriter;

/**
 * {@code SlotMachineKernel} enhanced with secondary methods.
 */
public interface SlotMachine extends SlotMachineKernel {
    /**
     * Runs the game until the player wants to quit and prints score.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @requires in != null and out !=null
     * @ensures the game will run until the player specifies they want to quit
     *          and prints final score
     */
    void gameLoop(SimpleReader in, SimpleWriter out);

    /**
     * Reports player's score and increments player's score if game is won.
     *
     * @param spin
     *            the array representing the spin result
     * @requires spin != null
     * @return an integer representing the updated score
     * @ensures the score is incremented if win condition is met, or keep
     *          current score if not
     */
    int score(int[] spin);

}