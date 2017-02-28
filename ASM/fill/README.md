**I/O handling:** this program illustrates low-level handling of the screen and keyboard devices, as follows. 

The program runs an infinite loop that listens to the keyboard input. When a key is pressed (any key), the program blackens the screen, i.e. writes "black" in every pixel; the screen should remain fully black as long as the key is pressed. 

When no key is pressed, the program clears the screen, i.e. writes "white" in every pixel; the screen should remain fully clear as long as no key is pressed.	Start by using the supplied assembler to translate your Fill.asm program into a Fill.hack file. Implementation note: your program may blacken and clear the screen's pixels in any spatial/visual order, as long as pressing a key continuously for long enough results in a fully blackened screen, and not pressing any key for long enough results in a fully cleared screen. 

The simple Fill.tst script, which comes with no compare file, is designed to do two things: (i) load the Fill.hack program, and (ii) remind you to select 'no animation', and then test the program interactively by pressing and releasing some keyboard keys. 

The FillAUtomatic.tst script, along with the compare file FillAutomatic.cmp, are designed to test the Fill program automatically, as described by the test script documentation.

>For completeness of testing, it is recommended to test the Fill program both interactively and automatically.
