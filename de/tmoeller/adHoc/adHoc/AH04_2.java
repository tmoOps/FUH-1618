package adHoc;

import java.util.*;

class ArrayListAddressBook{
	
	private ArrayList<Person> persons;
	
	
	public ArrayListAddressBook(){
		persons = new ArrayList<Person>();
	}//end cons
	
	
	public void addPerson( Person p ) {
		persons.add( p );
	}//end of addPerson
	
	
	public void print() {

		System.out.println( persons.size() + " Personen"); 		
		for ( Person person : persons) {
			person.print();
		}//end for
			
	}//end of print
	
}//end class ArrayAddressBook

	
public class AH04_2 {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub
		ArrayListAddressBook book = new ArrayListAddressBook();

		book.print(); System.out.println("---------------------------------"); 
    	book.addPerson(new Person("Person1", 11101990)); 
    	book.addPerson(new Person("Person2", 12101990)); 
    	book.print(); System.out.println("---------------------------------"); 
    	book.addPerson(new Person("Person3", 13101990)); 
    	book.addPerson(new Person("Person4", 14101990)); 
    	book.print(); System.out.println("---------------------------------"); 
    	book.addPerson(new Person("Person5", 15101990)); 
    	book.addPerson(new Person("Person6", 16101990)); 
    	book.print(); System.out.println("---------------------------------"); 
    	book.addPerson(new Person("Person7", 17101990)); 
    	book.addPerson(new Person("Person8", 18101990)); 
    	book.print(); System.out.println("---------------------------------");
	
	}//end main

}//end class AH04_2

