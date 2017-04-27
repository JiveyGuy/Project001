
/**
 * Write a description of class CodeWriter here.
 * 
 * @author Jason Ivey 
 * @version V 1/2
 */
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CodeWriter implements iCodeWriter
{
    FileOutputStream fOut;
    public CodeWriter(file out){
        fOut = new FileOutPutStream(out);
    }
    
    public void setFileName(String in){
        fOut = new FileOutPutStream(new file(in));
    }
}
