import java.io.*;
import java.util.Scanner;

public class Input{
  private final boolean DEBUG = true;
  public String file[];
  
  public static void main(String args[]){
    System.out.println("Name of dir: " + System.getProperty("user.dir"));
    Input test = new Input("test.txt");
    System.out.println("---------------------------------------------");
    test.print();
    test.clean();
    System.out.println("---------------------------------------------");
    test.print();
  }
  
  
  
  public Input(String fileName){
    
    boolean completedLoad = true;
    String[] loadedText;
    
    do{
      try{
        file = loadFile(fileName);
      }
      
      catch ( IOException e ) { //Needed inorder to do file.io
        System.out.println("File Exception, problem with "+fileName+", does it exist in " + System.getProperty("user.dir") + " ?");
        completedLoad = false;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Try another file: ");
        fileName = keyboard.nextLine();
        continue;
      }
    } while (!completedLoad);
    
  }
  public void clean(){
    String[] input = file;
    String processing = "";
    for( String current : input ){
      if(current.trim().equals(""))
        continue;
      else if(current.trim().substring(0, 2).equals("//"))
        continue;
      else
        for(int x = 0; x < current.length(); x++){
        char in = current.charAt(x);
        if( in == ' ' )
          continue;
        else
          processing += in;
      }
      processing +="$";
    }
    file = processing.split(java.util.regex.Pattern.quote("$"));
  }
  private String[] loadFile(String inputName) throws IOException{
    String fileName = inputName;
    
    //Debug statement
    if ( DEBUG ) {
      System.out.println("loadFile called");
    }
    
    String result[];
    
    
    Scanner input = new Scanner(new File(fileName));
    if ( DEBUG ) {
      System.out.println("Made input scanner");
    }
    int lines = countLines(fileName);
    if ( DEBUG ) {
      System.out.println("Counted lines");
    }
    result = new String[lines];
    for(int x = 0; x < lines; x++){
      result[x] = input.nextLine();
    }
    
    return result;
    
  }
  
  
  /*
   * Courtesy of StackOverflow.com's Martinus
   */
  public int countLines(String filename) throws IOException {
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
  
  public void print(){
    for( String iterator : file ){
      System.out.println(iterator);
    }
  }
}