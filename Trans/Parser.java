import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Parses file into useable form. 
 * 
 * @author Jason Ivey
 * @version V 1.0
 */
public class Parser implements iParser
{
    // instance variables 
    private  Scanner fileReader;
    private String currentLine;

    /**
     * Constructor for objects of class Parser
     * @param file input for fileName
     */
    public Parser(File file)
    {
        fileReader = new Scanner(asmFile);
        this.advance();
    }

    /**
     * Moves to the next line and cleans spaces
     * 
     */
    public void advance(){
        if (hasMoreCommands()){
            currentLine = fileReader.nextLine();
            currentLine = currentLine.replaceAll("\\s*",""); //this will clear all spaces
        }
    }

    /**
     * returns if this file reader has more commands
     * 
     * @return     if has more commands 
     */
    public boolean hasMoreCommands(){
        return fileReader.hasNextLine();
    }

    /**
     * Returns the command type fo current command
     * 
     * @return     command type
     */
    public Commands commandType(){
        return Commands.C_PUSH;
    }

    /**
     * returns argument one
     * 
     * @return     arg 1
     */
    public String arg1(){
        String[] splitted = currentLine.split(" ");
        try{
            return splitted[1];
        } catch (Exception e ) {
            return splitted[0];
        }
    }
    
    /**
     * returns argument one
     * 
     * @return     arg 1
     */
    public String arg2(){
        Commands ct = commandType();
        if(  ct == Commands.C_PUSH || ct == Commands.C_POP || ct == Command.C_FUNCTION || ct == Commands.C_CALL ){  
            String[] splitted = currentLine.split(" ");
            return splitted[2];
        }
    }
}
