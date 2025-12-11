package components.slotmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * JUnit tests for SlotMachine.
 */
public abstract class SlotMachineTest {

    /**
     * Useful constant, not a magic number: 3.
     */
    private static final int THREE = 3;
    /**
     * Useful constant, not a magic number: 9.
     */
    private static final int NINE = 9;

    /**
     * Invokes the {@code SlotMachine} constructor for the implementation under
     * test and returns the result.
     *
     * @return the new SlotMachine
     * @ensures constructor = (new SlotMachine())
     */
    protected abstract SlotMachine constructorTest();

    /**
     * Creates and returns a SlotMachine of the implementation under test type
     * with the given entries.
     *
     * @param first
     *            the first entry
     * @param second
     *            the second entry
     * @param third
     *            the third entry
     * @return the constructed SlotMachine
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private SlotMachine createFromArgsTest(int first, int second, int third) {
        SlotMachine sm = this.constructorTest();
        int[] spin = { first, second, third };
        sm.setSpin(spin);
        return sm;
    }

    /**
     * Test SlotMachineKernel constructor(s).
     */
    @Test
    public final void testNoArgumentConstructor() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine s = this.constructorTest();
        SlotMachine sExpected = this.constructorTest();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test SlotMachineKernel constructor(s) with arguments.
     */
    public final void testCreateFromArgsTest() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine s = this.createFromArgsTest(1, 2, THREE);
        SlotMachine sExpected = this.constructorTest();
        int[] spin = { 1, 2, THREE };
        sExpected.setSpin(spin);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test SlotMachineKernel spin method.
     */
    @Test
    public final void testSpin() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine sm = this.constructorTest();
        int[] result = sm.spin();
        /*
         * Assert that values of variables match expectations
         */

        // Check correct length
        assertEquals(THREE, result.length);

        // Check each value is within expected range (1–9)
        assertTrue(result[0] >= 1 && result[0] <= NINE);
        assertTrue(result[1] >= 1 && result[1] <= NINE);
        assertTrue(result[2] >= 1 && result[2] <= NINE);
    }

    /**
     * Test SlotMachineKernel printResults method.
     */
    @Test
    public void testPrintResults() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine sm = this.constructorTest();
        SlotMachine expected = this.constructorTest();
        SimpleWriter out = new SimpleWriter1L();
        sm.printResults(out);
        out.close();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expected, sm);
    }

    /**
     * Test SlotMachineKernel isWin method when true.
     */
    @Test
    public final void testIsWinTrue() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine sm = this.createFromArgsTest(THREE, THREE, THREE);
        boolean result = sm.isWin();
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(result);
    }

    /**
     * Test SlotMachineKernel isWin method when true.
     */
    @Test
    public final void testIsWinFalse() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine sm = this.createFromArgsTest(1, 2, 1);
        boolean result = sm.isWin();
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(!result);
    }

    /**
     * Test SlotMachineKernel setSpin method when empty.
     */
    @Test
    public final void testSetSpinEmpty() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine sm = this.constructorTest();
        SlotMachine expected = this.createFromArgsTest(2, 2, 2);
        int[] newSpin = { 2, 2, 2 };
        sm.setSpin(newSpin);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expected, sm);
    }

    /**
     * Test SlotMachineKernel setSpin method when replacing.
     */
    @Test
    public final void testSetSpinReplacing() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine sm = this.createFromArgsTest(THREE, THREE, THREE);
        SlotMachine expected = this.createFromArgsTest(2, 2, 2);
        int[] newSpin = { 2, 2, 2 };
        sm.setSpin(newSpin);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expected, sm);
    }

    /**
     * Test SlotMachine score() winning case.
     */
    @Test
    public final void testScoreWin() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine sm = this.createFromArgsTest(1, 1, 1);
        int result = sm.score();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(1, result);
    }

    /**
     * Test SlotMachine score() losing case.
     */
    @Test
    public final void testScoreLose() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine sm = this.createFromArgsTest(1, THREE, 1);
        int result = sm.score();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, result);
    }

    /**
     * Test SlotMachine score() winning case starting from one point.
     */
    @Test
    public final void testScoreWinStartingFromOne() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine sm = this.constructorTest();
        int[] winningSpin1 = { 2, 2, 2 };
        int[] winningSpin2 = { THREE, THREE, THREE };
        sm.setSpin(winningSpin1);
        sm.score();
        sm.setSpin(winningSpin2);
        int result = sm.score();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(2, result);
    }

    /**
     * Test SlotMachine score() losing case starting from one point.
     */
    @Test
    public final void testScoreLoseStartingFromOne() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine sm = this.constructorTest();
        int[] winningSpin = { 2, 2, 2 };
        int[] losingSpin = { 1, 2, 1 };
        sm.setSpin(winningSpin);
        sm.score();
        sm.setSpin(losingSpin);
        int result = sm.score();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(1, result);
    }

    /**
     * Test SlotMachine gameLoop().
     */
    @Test
    public final void testGameLoop() {
        /*
         * Set up variables and call method under test
         */
        String inputPath = "bin\\GameLoopTest";
        String outputPath = "bin\\GameLoopOutput";
        SimpleReader in = new SimpleReader1L(inputPath);
        SimpleWriter out = new SimpleWriter1L(outputPath);
        SlotMachine sm = this.constructorTest();
        sm.gameLoop(in, out);
        in.close();
        out.close();

        SimpleReader output = new SimpleReader1L(outputPath);

        /*
         * Assert that values of variables match expectations
         */

        String line = output.nextLine();
        assertEquals("Press enter to spin!", line);
        String line2 = output.nextLine();
        assertTrue(line2.contains("Your spin: ["));
        String line3 = output.nextLine();
        assertTrue(line3.equals("Try Again") || line3.equals("Jackpot!"));
        output.close();
    }

    /**
     * Test SlotMachineKernel newInstance().
     */
    @Test
    public final void testNewInstance() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine s = this.constructorTest();
        SlotMachine sNew = s.newInstance();
        SlotMachine sExpected = this.constructorTest();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, sNew);
    }

    /**
     * Test SlotMachineKernel clear().
     */
    @Test
    public final void testClear() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine s = this.createFromArgsTest(1, 2, THREE);
        SlotMachine sExpected = this.constructorTest();
        s.clear();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test SlotMachineKernel transferFrom().
     */
    @Test
    public final void testTransferFrom() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine s = this.createFromArgsTest(1, 2, THREE);
        SlotMachine sExpected = this.constructorTest();
        SlotMachine sSource = this.createFromArgsTest(THREE, 2, 1);
        s.transferFrom(sSource);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, sSource);
        assertEquals(this.createFromArgsTest(THREE, 2, 1), s);
    }

    /**
     * Test SlotMachineSecondary hashCode().
     */
    @Test
    public final void testHashCode() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine s1 = this.createFromArgsTest(1, 2, THREE);
        SlotMachine s2 = this.createFromArgsTest(1, 2, THREE);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    /**
     * Test SlotMachineSecondary toString().
     */
    @Test
    public final void testtoString() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine s1 = this.createFromArgsTest(1, 2, THREE);
        String result = s1.toString();
        String expected = "(win: false)";
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(result.equals(expected));
    }

    /**
     * Test SlotMachineSecondary equals().
     */
    @Test
    public final void testEquals() {
        /*
         * Set up variables and call method under test
         */
        SlotMachine s1 = this.createFromArgsTest(1, 2, THREE);
        SlotMachine s2 = this.createFromArgsTest(1, 2, THREE);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(s1.equals(s2));
    }
}
