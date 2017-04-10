import java.util.Arrays;
public class SymbolTable implements ISymbolTable{
  int[] index;
  String[] names;
  int current;
  public SymbolTable(){
    index = new int[50];
    names = new String[50];
    current = 0;
  }
  public void addEntry(String symbol, int adress){
    if(current < index.length ){
      index[ current ] = adress;
      names[ current ] = symbol;
      current++;
    } else {
      this.capacity();
    }
  }
  public boolean contains(String symbol){
    return Arrays.asList(names).contains(symbol);
  }
  public void printA(){
    for(int x = 0; x < current; x++){
      System.out.println( names[x] +  ": " + index[x] );
    }
  }
  
  public int GetAdress(String symbol){
    int temp = Arrays.asList(names).indexOf(symbol);
    return index[temp];
  }
  
  private void capacity(){
    int[] temp = new int[current + 50]; 
    String[] tempS = new String[current + 50];
    for(int x = 0; x < current; x++){
      temp[x] = index[x];
      tempS[x] = names[x];
    }
    index = temp;
    names = names;
  }
}