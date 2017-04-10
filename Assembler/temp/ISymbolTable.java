public interface ISymbolTable{
  void addEntry(String symbol, int adress);
  boolean contains(String symbol);
  int GetAdress(String symbol);
}