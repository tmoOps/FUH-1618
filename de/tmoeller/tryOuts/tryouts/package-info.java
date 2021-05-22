package tryouts;

//TestCell1 siehe Skript S225, 8.2 - Parametrische Klassen
/*

Die Instanzen aller parametrischen Klassen wie Cell1<String>, Cell1<Person>, Cell1<Object>, 
... verwenden alle DIESELBEN STATISCHEN KOMPONENTEN !!! und alle greifen auf dieselbe statische
Variable count zu.

Im Beispiel wird count hochgezählt und erhält den Wert 2 nach Deklarion der Typen

Cell1<String> a und Cell1<Person> b.

Wäre das nicht so, würde count jeweils den Wert 1 haben.


*/