# ZadanieRekrutacyjne nr.1 "INode"

## Treść
Zaimplementuj metody findByCode, findByRenderer, count w klasie MyStructure,
unikając powielania kodu i umieszczając całą logikę w klasie MyStructure,
z uwzględnieniem w analizie i implementacji interfejsu ICompositeNode!
  
 

 ## Analiza
 ### Cel zadania
Przedmiotem zadania jest zaprojektowanie wskazanych w jego treści funkcjonalności, 
operujących się na strukturze danych składających z węzłów i krawędzi(dalej jako drzewo).

#### Założenia struktury drzewo:
- każde drzewo ma dokładnie jeden korzeń
- korzeń jest jedynym elementem struktury, który nie posiada
  elementów poprzednich
- dla każdych węzłów oprócz ostatnich(tzw. liści) istnieje co 
  najmniej jeden element następny.

### Analiza danych wejściowych zadania

#### interfejs INode
- podstawowy element drzewa
- pełniący w strukturze rolę węzła
- posiadający dwie metody(getCode() i getRender()) obie zwracające wartość String.

#### interfejs ICompositeNode
- interfejs rozszerzający interfejs INode, posiada metodę getNodes() zwracającą listę węzłów następnych
- pełniący rolę węzła pośredniego w strukturze drzewa, 
posiadający jeden element pośredni i co najmniej jeden element następny
- metoda zwracająca listę zarówno z obiektami rozszerzającymi interfejs INode lub ICompositeNode(polimorfizm)

#### interfejs IMyStructure
- posiada trzy metody, które należy zaimplementować
##### metody findBYCode i findByRenderer 
- służą do przeszukiwania drzewa w celu zwrócenia węzła posiadającego pola o takich samych wartościach jak te z parametru
- zwracają obiekt typu INode lub null
##### metoda count 
- zlicza i zwraca ilość węzłów

#### klasa MyStruture
- implementuje IMyStructure
- zawiera główną logikę projektu 
- dostępna pod adresem [link to MyStructure!](https://github.com/HubertGalimski/ZadanieDomoweINode/blob/master/src/main/java/MyStructure.java)


### Logika metod MyStructure
#### Metoda count 
działa na zasadzie rekurencji dlatego też została stworzona odzielna metoda pomocnicza przyjmująca jako parametr 
listę węzłów, którą należy przeszukać w celu ich policzenia.
W metodzie pomocniczej zastosowano strumień filtrujący, zwracający listę obiektów rozszerzających interfejs ICompositeNode, które następnie poddajemy rzutowaniu.

#### Metody findByCode, findByRender
Obie metody są niemal identyczne, różnią się jedynie przyjmowanymi parametrami dlatego też w celu zwiększenia czytelności
i usunięcia powtarzającego się kodu została stworzona metoda pomocnicza jako parametr lambdę, po której będzie przeszukana lista. 
Metody zwracają pierwszy napotkany obiekt typu INode zgodny z parametrem lub null
W celu sprawniejszego przeszukiwania drzewa dodano metodę flattenTheList, która "spłaszcza" całe drzewo i zwraca strumień.

### Testy jednostkowe wykonano za pomocą frameworka Spock, korzystajacego z jezyka Groovy

