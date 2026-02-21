# Slot Machine Component

Slot machine implementation following the OSU software discipline. The component demonstrates abstraction with a SlotMachineKernel interface and layered secondary implementations.

## Component Overview

SlotMachineKernel - contains primary methods
SlotMachineSecondary - contains secondary methods
SlotMachine2 - fully implements slotMachine

## Methods

### Primary Methods (SlotMachineKernel)

spin() — produces a random 3-number slot result
isWin() — checks whether all 3 numbers match
setSpin(int[] s) — sets the spin manually (used for testing)
printResults(SimpleWriter out) — prints current spin

### Secondary Methods (SlotMachine)

score() — calculates and returns the updated score
gameLoop(SimpleReader in, SimpleWriter out) — full user interaction cycle

## Use Cases

### Use Case One: SlotMachineDemo

- Implements slotMachine as a mini game that prompts the user for input. The user can choose to continue playing or quit.
- Demonstrates slotMachine as a component as a casino simulation minigame.

### Use Case Two: SlotMachineSimulation

- Implements SlotMachine by running a probability experiement.
- Demonstrates slotMachine as an analytical simulation

## Testing

- Tests every method in slotMachine, including
  - Constructor behavior (testNoArgumentConstructor(), testcreateFromArgsTest())
  - Representation updates
  - Randomization on spin()
  - Output for printResults()
  - Input and output for gameLoop()

## Component Organization

text
│   .gitattributes
│   .gitignore
│   CHANGELOG.md
│   LICENSE
│   README.md
│
├───.vscode
│       extensions.json
│       osu-cse-checkstyle-config.xml
│       osu-cse-formatter.xml
│       settings.json
│
├───doc
│   │   README.md
│   │
│   ├───01-component-brainstorming
│   │       01-component-brainstorming.md
│   │
│   ├───02-component-proof-of-concept
│   │       02-component-proof-of-concept.md
│   │
│   ├───03-component-interfaces
│   │       03-component-interfaces.md
│   │
│   ├───04-component-abstract-class
│   │       04-component-abstract-classes.md
│   │
│   ├───05-component-kernel-implementation
│   │       05-component-kernel-implementation.md
│   │
│   └───06-component-finishing-touches
│           06-component-finishing-touches.md
│
├───lib
│       components.jar
│       hamcrest-core-1.3.jar
│       junit-4.13.2.jar
│       README.md
│
├───src
│   │   SlotMachineDemo.java
│   │   README.md
│   │   SlotMachineSimulation.java
│   │
│   └───components
│       └───slotmachine
│                       SlotMachine.java
│                       SlotMachine2.java
│                       SlotMachineKernel.java
│                       SlotMachineSecondary.java
│
└───test
    │   README.md
    │
    └───components
        └───slotmachine
                        SLotMachine2Test.java
                        SlotMachineTest.java
