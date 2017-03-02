(LOOP)
@16384
D = A
@SCREEN
M = D
@24576
D = M - 1
@FILL
D;JEQ
@LOOP
0;JMP

(FILL)
@24576
D = M - 1
@LOOP
D;JGT
@32
D = A
@SCREEN
M = M + D
A = M
M = -1
@FILL
0;JMP