import components.simplereader.SimpleReader;
import components.simplewriter.SimpleWriter;

/**
 * Layered implementations of secondary methods for Slot Machine.
 *
 * @author Irene Suh
 */
public abstract class SlotMachineSecondary implements SlotMachine {

    /**
     * Useful constant, not a magic number: 10.
     */
    private static final int TEN = 10;

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append("win: ");
        sb.append(this.isWin());
        sb.append(")");
        return sb.toString();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public final int hashCode() {
        int hash = 1;
        hash = TEN * hash + Boolean.hashCode(this.isWin());

        return hash;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object obj) {
        SlotMachine other = (SlotMachine) obj;
        return this.isWin() == other.isWin();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void gameLoop(SimpleReader in, SimpleWriter out) {
        assert in != null : "Violation of: in is not null";
        assert out != null : "Violation of: out is not null";
        boolean isPlaying = true;
        boolean validAns = false;
        int score = 0;

        while (isPlaying) {
            out.println("Press enter to spin!");
            in.nextLine();
            int[] spin = this.spin();
            this.printResults(out);
            score = this.score(spin);
            out.println("Your score: " + score);

            while (!validAns) {
                out.print("Do you want to play again? Type y or n: ");
                String answer = in.nextLine();
                if (answer.equalsIgnoreCase("n")) {
                    isPlaying = false;
                    out.print("Goodbye!");
                    validAns = true;
                } else if (answer.equalsIgnoreCase("y")) {
                    out.print("Lets go gambling!");
                    validAns = true;
                } else {
                    out.print("Please enter y or n");
                    validAns = false;
                }
            }
            out.println("Thanks for playing! Your final score is: " + score);
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int score(int[] spin) {
        assert spin != null : "Violation of : spin is not null";
        int currentScore = 0;
        if (this.isWin()) {
            currentScore++;
        }
        return currentScore;
    }
}
