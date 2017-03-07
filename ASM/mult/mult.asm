@2
M = 0

@0
D = M
@COMPX
D;JLT

@1 
D = M
@COMPY
D;JLT
  
(INIT)
@0
D = M
@1
D = D - M
@XG
D;JGT
  
@YG
0;JMP

(XG)
  @1
  D = M
  @END
  D;JEQ
  @0
  D = M
  @2
  M = M + D
  @1
  M = M - 1
  @XG
  0;JMP

(YG)
      @0
      D = M
      @END
      D;JEQ
      @1
      D = M
      @2
      M = M + D
      @0
      M = M - 1
@YG
0;JMP



(COMPX)
@1
D = M
@COMPLI
D;JLT
@0
M = !M
M = M + 1
D = M
@1
D = D - M
@XSUBX
D;JGT

@YSUBX
0;JMP
  
  
(COMPY)
@0
D = M
@COMPLI
D;JLT
@1
M = !M
M = M + 1
D = M
@0
D = D - M
@XSUBY
D;JGT

@XSUBX
0;JMP

(COMPLI)
@0
M = !M
M = M + 1
@1
M = !M
M = M + 1
@INIT
0;JMP
  
(END)
  @END
0;JMP
  
(XSUBX)
  @1
  D = M
  @COMPOUT
  D;JEQ
  @0
  D = M
  @2
  M = M + D
  @1
  M = M - 1
  @XSUBX
  0;JMP
(YSUBX)
      @0
      D = M
      @COMPOUT
      D;JEQ
      @1
      D = M
      @2
      M = M + D
      @0
      M = M - 1
@YSUBX
0;JMP    
(COMPOUT)
   @2
   M = !M
   M = M + 1
 @END
 0;JMP