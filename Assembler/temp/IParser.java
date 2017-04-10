import java.io.*;
public interface IParser{
   boolean hasNextCommand();
   void advance();
   Commands getCommandType();
   String symbol();
   String dest();
   String jump();
   String comp();
}