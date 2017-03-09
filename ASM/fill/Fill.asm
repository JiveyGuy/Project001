@SCREEN
M = A
(LOOP)
@KBD
D = M
@FILL
D;JGT
@LOOP
0;JMP


(RESTART)
@SCREEN
M = A

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
@SCREEN
D = M
@24575
D = D - A
@RESTART
D;JEQ
@FILL
0;JMP
