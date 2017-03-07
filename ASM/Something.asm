@2000
D = A
@i
M = D
@n
M = 0
@5
D = A
@length
M = D
(LOOP)
@length
D = 
@n 
D = D - M
@END
D;JEQ
@5
D = A
@n
D = M + D
@sum
M = D
  
@n
D = M 
@i
D = M + D
@adress
M = D

@sum
D = M
@adress
A = M
M = D

  
@n
M = M + 1
@LOOP
0;JMP
  
(END)
@END
0;JMP