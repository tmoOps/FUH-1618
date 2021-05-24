package adHoc;

import java.util.*;

interface FilterPredicate<T>{
	boolean isMatching(T candidate);
}//end FilterPredicate

//Klassen für userdefined "Filterprädikate" definieren
class PredicateShortName implements FilterPredicate<Person>{
	@Override
	public boolean isMatching(Person candidate) {
		return candidate.getName().length() < 5;
	}//end isMatching
}//end PredicateShortName

class PredicateLightWeight implements FilterPredicate<Person>{
	@Override
	public boolean isMatching(Person candidate) {
		return candidate.getWeight() < 60;
	}//end isMatching
}//end PredicateLightweight

class PredicatePalindrome implements FilterPredicate<Person>{
	@Override
	public boolean isMatching(Person candidate) {
		StringBuilder sb = new StringBuilder( candidate.getName() );
		String reverse = sb.reverse().toString();
		return reverse.equalsIgnoreCase( candidate.getName() );
	}//end isMatching
}//end PredicatePalindrom


class Filter<T>{
	private List<T> sourceList;
	
	public Filter(List<T> sourcelist) {  //Filterklasse mit Liste initialisieren
		this.sourceList = sourcelist;
	}//end of cons
	
	//allgemeine Funktion zur Anwendung eines <userdefined>Filters, der von 
	//außen an die Methode übergeben wird. Der Filter muß das Interface von
	//Filterpredicate implementieren und hat damit eine Methode isMatching
	//Auf isMatching wird hier zugegriffen. Für jedes Element der Ursprungsliste
	//vom Typ T wird geprüft, ob das Filterkriterium zutreffend ist. Bei Überein-
	//stimmung wird das Element aus der Liste in eine Ergebnisliste übertragen.
	//Nach Abschluß der Iteration wird die Ergebnisliste an den Aufrufer zurück-
	//gegeben
	List<T> filter(FilterPredicate<T> filterPredicate){
		ArrayList<T> resultlist = new ArrayList<T>();
		for( T elem : sourceList ) {
			if( filterPredicate.isMatching(elem)) {
				resultlist.add(elem);
			}//end if
		}//end for
		
		return resultlist; //Ergebnisliste
	}//end filter
	
}//end class Filter

public class AH05_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Person> source = new ArrayList<Person>();
		source.add(new Person("Joe", 77));
		source.add(new Person("Bob", 90));
		source.add(new Person("Jenny", 44));
		source.add(new Person("Anna", 51));
		source.add(new Person("Peter", 84));
		
		Filter<Person> newPersonFilter = new Filter<Person>(source);
		
		//userdefined Filter anlegen
		FilterPredicate<Person> hasShortName = new PredicateShortName();
		
		//Filterfunktion mit userdefined Filter aufrufen
		List<Person> result = newPersonFilter.filter(hasShortName);
		for( Person p : result ) {
			System.out.println( p.getName() );
		}//end for
		
		
		Filter<Person> newPersonFilter2 = new Filter<Person>(source);
		FilterPredicate<Person> hasLigthWeigth = new PredicateLightWeight();
		
		result = newPersonFilter2.filter(hasLigthWeigth);
		for( Person p2 : result ) {
			System.out.println( p2.getName() + " weights " + p2.getWeight() + " kg");
		}//end for

		
		Filter<Person> newPersonFilter3 = new Filter<Person>(source);
		FilterPredicate<Person> hasPalindrome = new PredicatePalindrome();
		
		result = newPersonFilter3.filter(hasPalindrome);
		for( Person p2 : result ) {
			System.out.println( p2.getName() );
		}//end for		
		
		
	}//end of main

}//end of AH05_1
