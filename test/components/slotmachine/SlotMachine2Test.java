package components.slotmachine;

/**
 * Customized JUnit test fixture for {@code SlotMachine2}.
 */
public class SlotMachine2Test extends SlotMachineTest {
    /**
     * Invokes the {@code SlotMachine2} constructor for the implementation under
     * test and returns the result.
     *
     * @return the new slot machine
     * @ensures constructorTest = new SlotMachine2()
     */
    @Override
    protected final SlotMachine constructorTest() {
        return new SlotMachine2();
    }

}
