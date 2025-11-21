import components.simplewriter.SimpleWriter;
import components.standard.Standard;

/**
 * Slot machine kernel component with primary methods.
 *
 */
public interface SlotMachineKernel extends Standard<SlotMachine> {

    /**
     * A constant, with value 3, holding the array length.
     *
     */
    int ARRAY_LENGTH = 3;

    /**
     * Generates an array of random integers given an empty integer array.
     *
     * @return an array of random integers
     * @ensures returns an integer array of length 3 where each element is a
     *          random integer from 1 - 9.
     */
    int[] spin();

    /**
     * Prints the results of the spin and whether the game is won.
     *
     * @param out
     *            output stream to print to
     * @requires spin != null and out != null
     * @ensures prints an array of integers representing the spin resuls and
     *          reports whether the game is won
     */
    void printResults(SimpleWriter out);

    /**
     * Reports whether spin results in winning the game.
     *
     * @return true if each element in array are equal
     * @ensures result is true if each element in array are equal
     */
    boolean isWin();

}