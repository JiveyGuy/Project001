import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Parser implements IParser{
  
  private  Scanner fileReader;
  public  String currentLine;
  public int line = 0;
  
  
  public Parser(File asmFile) throws FileNotFoundException{
    fileReader = new Scanner(asmFile);
    this.advance();
  }
  
  public Parser(String asmFile)throws FileNotFoundException{
    File f = new File(asmFile);
    fileReader = new Scanner(f);
    this.advance();
  }
  
  public boolean hasMoreCommands(){
    return fileReader.hasNextLine();
  }
  
  public boolean hasNextCommand(){
    return hasMoreCommands();
  }
  
  public void advance(){
    if (hasMoreCommands()){
      currentLine = fileReader.nextLine();
      currentLine = currentLine.replaceAll("\\s*",""); //this will clear all spaces
      if( commandType() != Commands.COMMENT && commandType() != Commands.UNKNOWN )
        line++;
    }
  }
  
  public Commands commandType(){
    //check for A Command
    if(currentLine.startsWith("@") && 
       currentLine.lastIndexOf("@") == 0){
      return Commands.A_COMMAND;
    }
    //Check for C Command
    //TO DO: Revisit when dest and comp hash maps are implemented
    String tokens[] = currentLine.split("=");
    if (tokens.length == 2){
      return Commands.C_COMMAND;
    }
    tokens = currentLine.split(";");
    if (tokens.length == 2){
      return Commands.C_COMMAND;
    }
    //Check for L command
    if(currentLine.startsWith("(") &&
       currentLine.endsWith(")") &&
       !currentLine.substring(1, currentLine.length()-1).contains("(") &&
       !currentLine.substring(1, currentLine.length()-1).contains(")")){
      return Commands.L_COMMAND; 
    }
    //Check for Comments
    if (currentLine.startsWith("//")){
      return Commands.COMMENT;
    }
    return Commands.UNKNOWN;
  }
  
  public String symbol(){
    String result = currentLine;
    if( getCommandType() == Commands.C_COMMAND || getCommandType() == Commands.L_COMMAND ){
      result = result.replaceAll("^\\p{Alpha}", "");
    }
    return result;
  }
  
  public Commands getCommandType(){
    return commandType();
  }
  
  public String dest(){
    String result = "000";
    if( getCommandType() == Commands.C_COMMAND ) {
      String[] meta = currentLine.split("=");
      switch(meta[0].trim()){
        case "M" : 
          result = "001";
          break;
        case "D" : 
          result = "010";
          break;
        case "MD" : 
          result = "011";
          break;
        case "A" : 
          result = "100";
          break;
        case "AM" : 
          result = "101";
          break;
        case "AD" : 
          result = "110";
          break;
        case "AMD" : 
          result = "111";
          break;  
      }
    }
    return result;
  }
  
  public String comp(){
    String result = "";
    try{
    if( getCommandType() == Commands.C_COMMAND ) {
      String[] meta = currentLine.split("=");
      result += (meta[1].trim().contains("M") ? 1 : 0 );
      if (meta[1].trim().contains("M")) meta[1] = meta[1].trim().replace("M", "A");
      switch(meta[1].trim()) {
        case "0" : 
          result += "101010";
          break;
        case "1" :
          result += "111111";
          break;
        case "-1" :
          result += "111010";
          break;
        case "D" : 
          result += "001100";
          break;
        case "A" :
          result += "110000";
          break;
        case "!D" :
          result += "001101";
          break;
        case "!A" :
          result += "110001";
          break;
        case "-D" :
          result += "001111";
          break;
        case "-A" :
          result += "110011";
          break;
        case "D+1" :
          result += "011111";
          break;
        case "A+1" :
          result += "110111";
          break;
        case "D-1" :
          result += "001110";
          break;
        case "A-1" :
          result += "110010";
          break;
        case "D+A" :
          result += "000010";
          break;
        case "D-A" :
          result += "010011";
          break;
        case "A-D" :
          result += "000111";
          break;
        case "D&A" :
          result += "000000";
          break;
        case "D|A" :
          result += "010101";
          break;
        default :
          result += "______";
          break;
      }
    }
    return result;
    } catch (Exception e){
      String input = currentLine.substring(0, 1);
      switch(input.trim()) {
        case "0" : 
          result += "101010";
          break;
        case "1" :
          result += "111111";
          break;
        case "-1" :
          result += "111010";
          break;
        case "D" : 
          result += "001100";
          break;
        case "A" :
          result += "110000";
          break;
        case "!D" :
          result += "001101";
          break;
        case "!A" :
          result += "110001";
          break;
        case "-D" :
          result += "001111";
          break;
        case "-A" :
          result += "110011";
          break;
        case "D+1" :
          result += "011111";
          break;
        case "A+1" :
          result += "110111";
          break;
        case "D-1" :
          result += "001110";
          break;
        case "A-1" :
          result += "110010";
          break;
        case "D+A" :
          result += "000010";
          break;
        case "D-A" :
          result += "010011";
          break;
        case "A-D" :
          result += "000111";
          break;
        case "D&A" :
          result += "000000";
          break;
        case "D|A" :
          result += "010101";
          break;
        default :
          result += "______";
          break;
      }
    }
    return result;
  }
  
  public String jump(){
    String in = currentLine.trim();
    String result = "000";
    if( getCommandType() == Commands.C_COMMAND ) {
      if(in.toUpperCase().substring(2, in.length()).equals("JMP")){
        result = "111";
      }else if(in.toUpperCase().substring(2, in.length()).equals("JEQ")){
        result = "010";
      }else if(in.toUpperCase().substring(2, in.length()).equals("JLT")){
        result = "100";
      }else if(in.toUpperCase().substring(2, in.length()).equals("JGE")){
        result = "011";
      }else if(in.toUpperCase().substring(2, in.length()).equals("JNE")){
        result = "101";
      }else if(in.toUpperCase().substring(2, in.length()).equals("JLE")){
        result = "110";
      }else if(in.toUpperCase().substring(2, in.length()).equals("JGT")){
        result = "001";
      } 
    }
    return result;
  } 
}