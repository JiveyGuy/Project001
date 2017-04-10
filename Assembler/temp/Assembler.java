import java.io.FileNotFoundException;
public class Assembler{
  public static void main(String [] args){
    
    String fileName = "prog.asm";
    StringBuilder asm = new StringBuilder();
    try{
      
      Parser asmParser = new Parser(fileName);
      SymbolTable table = new SymbolTable();
      
      while(asmParser.hasMoreCommands()){
        String aVal;
        try{
          aVal = asmParser.currentLine.substring(1);
        }catch (Exception e){
          aVal = asmParser.currentLine;
        }
        
        if( ! ( isNumeric( aVal  ) ) &&  asmParser.commandType() == Commands.A_COMMAND  ) {
          $( asmParser.currentLine.substring(1) );
          table.addEntry( asmParser.currentLine.substring(1) , asmParser.line );
        } if ( asmParser.commandType() == Commands.L_COMMAND ){
          table.addEntry( asmParser.currentLine.substring( 1, asmParser.currentLine.length() - 1 )   , asmParser.line );
        }
        asmParser.advance();
      }
      
      table.printA();
      asmParser = new Parser(fileName);
      $("-----------------------------------");
      while(asmParser.hasMoreCommands()){
        if(  asmParser.commandType() == Commands.A_COMMAND   && table.contains(asmParser.currentLine.substring(1)  ) ) {
          asm.append(aZero(table.GetAdress(asmParser.currentLine.substring(1))) + "\n");
        } else if (  asmParser.commandType() == Commands.L_COMMAND   && table.contains(asmParser.currentLine.substring(1, asmParser.currentLine.length() - 1 )  )) {
          asm.append(aZero(table.GetAdress(asmParser.currentLine.substring(1, asmParser.currentLine.length() - 1 ))) + "\n");
        } else if ( asmParser.commandType() == Commands.C_COMMAND ) {
          asm.append( asmParser.comp() + asmParser.dest() + asmParser.jump() +"\n");
        }
        
        asmParser.advance();
      }
      $("-----------------------------------");
      System.out.println(asm.toString());
    } catch (FileNotFoundException fnfe){
      System.out.println(String.format("File %s was not found", fileName));
    }
    
  }
  
  private static boolean isNumeric(String input ){
    try{
      int test = Integer.parseInt( input );
      return true;
    } catch ( Exception e ) {
      return false; 
    }
  }
  
  public static void $(String in){
    if(true){ System.out.println(in); }
  }
  
  public static void $(boolean in){
    if(true){ System.out.println(in); }
  }
  
  static String aZero(int x){
    String val = Integer.toBinaryString(x);
    String xeros = "0000000000000000";
    xeros = xeros.substring(val.length() );
    xeros += val;
    $(xeros);
    return xeros;
  }
}