@SCREEN
D = A
@POINTER
M = D

(CHECK)
	@KBD
	D = M
	@val
	M = 0
	@KBD
	D = M
	@FILL
	D;JEQ	

	(NEG)
	@val
	M = -1
	
	(FILL)
	@val
	D = M
	@POINTER
	A = M
	M = D

	@POINTER
	M = M + 1
	D = M

	@KBD
	D = D - A
	@CHECK
D;JLT
	@SCREEN
	D = A
	@POINTER
	M = D
@CHECK
0;JMP
	
	
