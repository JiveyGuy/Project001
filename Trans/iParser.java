
/**
 * Write a description of interface iParser here.
 * 
 * @author Jason Ivey
 * @version V 1.0
 */
public interface iParser{
    boolean hasMoreCommands();

    void advance();

    Commands commandType();
    
    String arg1();
    
    int arg2();
}

