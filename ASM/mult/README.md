'Mult.asm'

**Multiplication: in the Hack computer, the top 16 RAM words (RAM[0] ... RAM[15]) are also referred to as the so-called virtual registers R0 ... R15.**



>With this terminology in mind, this program computes the value R0*R1 and stores the result in R2.



Note that in the context of this program, we assume that R0>=0, R1>=0, and R0*R1<32768 (you are welcome to ponder where this limiting value comes from). Your program need not test these conditions, but rather assume that they hold.

Start by using the supplied assembler to translate your Mult.asm program into a Mult.hack file. 

To test your program, load Mult.hack into the ROM. Next, put some values in R0 and R1, run the code, and inspect R2. 

Alternatively, use the supplied Mult.tst script and Mult.cmp compare file (that's how we test your program). These supplied files are designed to test your program by running it on several representative data values.
