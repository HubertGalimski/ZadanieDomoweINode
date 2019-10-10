# ZadanieNaRozmoweINode

## Treść
Poniżej przekazujemy zadanie z prośbą o analizę poniższego kodu i zaimplementowanie metod findByCode, findByRenderer,
count w klasie MyStructure - najchętniej unikając powielania kodu i umieszczając całą logikę w klasie MyStructure. 
Z uwzględnieniem w analizie i implementacji interfejs ICompositeNode!

interface IMyStructure {

  // zwraca węzeł o podanym kodzie lub null
  INode findByCode(String code);
  // zwraca węzeł o podanym rendererze lub null
  INode findByRenderer(String renderer);
  //zwraca liczbę węzłów
  int count();
}
 
public class MyStructure implements IMyStructure {
  private List<INode> nodes;
}
 
interface INode {
  String getCode();
  String getRenderer();
}
 
interface ICompositeNode extends INode {
  List<INode> getNodes();
}
  
  
  ## Analiza
