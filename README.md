**State Machine template**

Ich habe mal ein grundlegendes Konzept bzw. besser gesagt zwei Konzepte ausgearbeitet wie die State Machine aussehen könnte. Habe mich dabei an die *state pattern* orientiert.
Grundlegende Kenntnisse über das *state pattern* sind vorteilhaft. ;-) 


---

## First option

Im ersten Konzept sind drei Packages (*global*, *standard*, *wl*) ersichtlich.
Dabei muss man beachten bzw. davon ausgehen, dass eine State Machine für diverse Produkte (Wiener Linien, switchh) verschieden konfiguriert sein kann.
Das heißt die State Machines der Produkte können verschiedene Zustände und auch Aktionen, die von einem Zustand ausgeführt werden, aufweisen.

Im Package *global* sind alle Zustände und Aktionen definiert, die im System (also für alle Produkte) verwendet werden können. In der enumeration **StateEnum** werden die Zustände defininert, die in allen State Machines möglich sind.
Die Aktionen, die im System möglich sind, werden in **StateDefault** und **StateContext** festgehalten, mittels Definition von Methoden, die dabei die Aktionen darstellen.
**StateDefault** spiegelt hierbei den abstrakten Zustanden wieder, der alle Aktionen als leere Methoden implementiert. Hierbei ist, wie für das *state pattern* üblich, dass der **StateContext** als Methodenparameter übergeben wird.
Das ist deswegen sinnvoll, damit der neue Zustand im **StateContext** gesetzt werden kann. Im **StateContext** ist immer der aktuelle Zustand gespeichert. Eingaben an die State Machine werden auch immer im **StateContext** durchgeführt, der wiederum die 
Methode im gespeicherten Zustand aufruft.

Im Package *standard* werden all jene Zustände abgelegt, die für alle Produkte gültig sind, dabei können schon Aktionen implementiert werden, die für alle Produkte gelten sollen.

Im Package *wl* werden all jene Zustände abgelegt, die spezifisch für das Produkt *Wiener Linien* sind. Hier können auch Zustände überschrieben werden und Aktionen neu definiert bzw. erweitert werden.

In der Klasse **Main** ist ein Beispieldurchlauf der State Machine zu sehen. Eingabe werden über den **StateContext** durchgeführt, der dann die Aktionen des Zustandes ausführt. In der Methode im Zustand wird dann der neue Zustand des **StateContext** gesetzt.
Die **StateFactory** hat die Aufgabe, dass die für ein Produkt richtigen Zustände für die State Machine gesetzt werden, weshalb auch der Produkt Typ als Parameter übergeben wird.
Hintergedanke eine Factory für diese Aufgabe zu nehmen, war, dass nicht immer neue Zustände erzeugt werden, wenn mit der State Machine gearbeitet wird, sondern die Zustände wiederverwendet werden. Außerdem bietet sich auch eine Factory an, wenn
Objekte in Abhängigkeit eines Parameters gebaut werden müssen.

Nachteil diese Konzepts ist, dass man die Zustände und Aktionen für alle Produkte definieren muss (in diesem Fall im Package **global**)

---

## Second option

Die zweite Variante hat sich daraus entwickelt, dass ich nicht alle Zustände und Aktionen an zentraler Stelle definieren wollte, sondern eine Basis State Machine haben wollte, die man für gewisse Produkte beliebig erweitern kann.

Im Package *standard* ist die Basis State Machine definiert. Es war notwendig, die Parameter für die Methoden in den Zuständen als Optional zu definieren, da es sowohl möglich sein soll, den Basis Zustandskontext als auch einen
erweiterten Zustandskontext in unserem Fall (*StateContextWL*) übergeben zu können.

Bezogen auf ein Produkt, das Veränderungen in der State Machine benötigt, werden die notwendigen Änderungen im Package *wl* durchgeführt. Zusätzliche Aktionen werden im Default Zustand des Produktes WL in **StateWL** festgelegt, das von **StateDefault** erbt. Außerdem muss diese
zusätzliche Aktion auch im erweiterten Zustandskontext definiert werden. Hier ist zu beachten, dass man überprüfen muss, ob der aktuelle Zustand überhaupt die neue Aktion zur Verfügung stellt/implementiert, da auch Basis Zustände im erweiterten Kontext abgearbeitet werden. (Falls es hierbei eine schönere Variante gibt, bitte anmerken ;-) )
Zusätzliche Zustände werden ebenfalls in diesem Package definiert.

Vorteil dieses Konzepts ist auf alle Fälle, dass man eine bessere Trennung zwischen Basis State Machine und erweiterter State Machine erzielt. Man muss nur mehr die Zustände des gesamten Systems innerhalb des Enums festhalten. Aktionen müssen NICHT
mehr in **StateDefault** und **StateContext** hinzugefügt werden, falls für ein Produkt eine zusätzliche Aktion benötigt wird.

In der Klasse **Main** kann wieder ein Beispieldurchlauf gestartet werden. Zu beachten ist, dass der erweiterte Zustandskontext verwendet werden muss.