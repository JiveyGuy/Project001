(LOOP)
@16384
D = A
@SCREEN
M = D
@KBD
D = M
@FILL
D;JGT
@LOOP
0;JMP

(FILL)
@KBD
D = M
@LOOP
D;JEQ
@1
D = A
@SCREEN
M = M + D
A = M
M = -1
@FILL
0;JMP