# ZadanieNaRozmoweINode

## Treść
Zaimplementuj metody findByCode, findByRenderer, count w klasie MyStructure,
unikając powielania kodu i umieszczając całą logikę w klasie MyStructure,
z uwzględnieniem w analizie i implementacji interfejsu ICompositeNode!
  
 
 ## Analiza
Przedmiotem zadania jest zaprojektowanie wskazanych w jego treści funkcjonalności, 
operujących na strukturze danych składających się z węzłów i krawędzi(dalej jako drzewo).

### Założenia struktury drzewo:
- każde drzewo ma dokładnie jeden korzeń
- korzeń jest jedynym elementem struktury, który nie posiada
  elementów poprzednich
- dla każdych węzłów oprócz ostatnich(tzw. liści) istnieje co 
  najmniej jeden element następny.

### Analiza kodu/danych wejściowych zadania

#### interfejs INode
- podstawowy element drzewa
- pelniący w strukturze rolę węzła
- posiadający dwie metody(getCode() i getRender()) obie zwracające wartość String.
#### interfejs ICompositeNode
- interfejs rozszerzający interfejs INode, posiada metodę getNodes() zwracjącą listę węzłów nastepnych
- pełniący rolę węzła pośredniego w strukturze drzewa, 
posiadający jeden element pośredni i conajmniej jeden element następny
#### interfejs IMyStructure
- posiada trzy metody, które należy zaimplementować
##### metody findBYCode i findByRenderer 
- służą do przeszukiwania drzewa w celu znalezienia węzła posiadającego pola o takich samych wartościach jak te z parametru
- zwracają obiekt typu INode lub null
##### metoda count 
- przemierza drzewo zliczając węzły
- zwraca ilość węzłów
#### klasa MyStruture
- implementuje IMyStructure
- zawiera główna logikę projektu 
- dostępna pod adresem [link to MyStructure!](https://github.com/HubertGalimski/ZadanieDomoweINode/blob/master/src/main/java/MyStructure.java)





