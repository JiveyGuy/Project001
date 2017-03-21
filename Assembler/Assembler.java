/*
 * Instructions:
 * A = @
 * C = A
 * L = ( )
 * //
 * Blank Spaces
 * 
 */

import java.io.*;
import java.util.Scanner;

public class Assembler{
  public static final boolean DEBUG = true;
  public static void main(String args[]){
    
  }
  
  public static String[] keywordsInput(boolean firstTry, String inputSel){
    String fileName = inputSel;
    if(!firstTry){
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Try another file: ");
      fileName = keyboard.nextLine();
    }
    //Debug statement
    if ( DEBUG ) {
      System.out.println("keywordsInput called");
    }
    
    String result[];
    
    try{
      Scanner input = new Scanner(new File(fileName));
      int lines = countLines(fileName);
      result = new String[lines];
        for(int x = 0; input.hasNext(); x++){
        result[x] = input.nextLine();
      }
      
      return result;
    } catch ( IOException e ) { //Needed inorder to do file.io
      System.out.println("File Exception, problem with keywords.txt, does it exist in " + System.getProperty("user.dir") + " ?");
      return keywordsInput(false, fileName);
    }
  }
  /*
   * Courtesy of StackOverflow.com's Martinus
   */
  public static int countLines(String filename) throws IOException {
    InputStream is = new BufferedInputStream(new FileInputStream(filename));
    try {
      byte[] c = new byte[1024];
      int count = 0;
      int readChars = 0;
      boolean empty = true;
      while ((readChars = is.read(c)) != -1) {
        empty = false;
        for (int i = 0; i < readChars; ++i) {
          if (c[i] == '\n') {
            ++count;
          }
        }
      }
      return (count == 0 && !empty) ? 1 : count;
    } finally {
      is.close();
    }
  }
  
  public static String[] clean(String input[]){
    String processing = "";
    for( String current : input ){
      if(current.trim().equals(""))
        continue;
      else if(current.trim().substring(0, 2).equals("//"))
        continue;
      else
        processing += current + "$";
    }
    return processing.split("$");
  }
  
  public static String parse(String input){
    String result = ("0000000000000000");
    if (input.trim().substring(0, 1).equals("@")){
      
    }
    
    return result;
  }
  
  
}