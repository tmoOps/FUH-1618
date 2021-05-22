package tryouts;

import adHoc.Person;

class Cell1<T>{
	
	//Klassenattribut, aus dem die IDs berechnet werden
	private static int count;
	private final int id;
	private final T value;
	
	public Cell1(T value) {
		this.value = value;
		id = count++;
	}//end cons
	
	public static int getCount() {
		return count;
	}//end of getCount
	
	public T getValue() {
		return value;
	}//end of getValue
	
	public int getID() {
		return id;
	}//end of getID
	
}//end of Cell1

public class TestCell1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cell1<String> a = new Cell1<String>("one");
		Cell1<Person> b = new Cell1<Person>( new Person("Person1", 11101990));
		
		System.out.println( a.getID() );
		System.out.println( b.getID() );
		System.out.println( Cell1.getCount() ); 
		/*	da getCount als static und somit als
			Klassenmethode deklariert wurde, darf der Zugriff nur über den Klassennamen
			Cell1 erfolgen und nicht über Cell1<String> oder Cell1<Person>. Der Typparameter
			muss weggelassen werden, sonst gibt es einen Compiler Fehler.
		*/
		
	}//end main
}//end TestCell1
