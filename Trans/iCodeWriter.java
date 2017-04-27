
/**
 * Write a description of interface iCodeWriter here.
 * 
 * @author Jason Ivey 
 * @version V1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.01.1
 */
public interface iCodeWriter
{
    void setFileName(String fileName);
    void writeArithmetic( String commands);
    void writePushPop( Commands.C_PUSH push, Commands.C_POP pop, Sring segment, int index);
    void close();
}
