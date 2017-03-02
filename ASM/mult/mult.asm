@0
D = M
@1
D = M - D
@XG
D;JLT
@YG
0;JMP

(XG)
@1
D = A
@FX
D;JEQ
A = 0
M = M + M
@1
M = M - 1
@XG
0;JMP

(YG)
@0
D = A
@FY
D;JEZ
@1
M = M + M
@0
M = M - 1
@YG
0;JMP

(FX)
@0
D = M
@2
M = D
@END
0;JMP

(FY)
@1
D = M
@2
M = D
@END
0;JMP

(END)
@END
0;JMP