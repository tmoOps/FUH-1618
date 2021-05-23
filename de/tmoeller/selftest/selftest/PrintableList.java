package selftest;

interface Printable {
	void print();
}//end of interface printable

class Person implements Printable{
	
	private String name;
	
	Person( String name){
		this.name = name;
	}//end constructor
	
	@Override
	public void print() {
		System.out.println( "Person: mein Name ist " + name );
	}//end print
		
}//end class Person


class Cat implements Printable{
	
	@Override
	public void print() {
		System.out.println( "Miau");
	}//end print
	
}//end class Cat

class Book implements Printable{
	
	private String title;
	
	Book( String title ){
		this.title = title;
	}//end constructor
	
	@Override
	public void print() {
		System.out.println( title );
	}//end end print
	
}//end class Book


class PrintableList {

	//Entry als innere Klasse implementieren
	//als statisch deklarierte innere Klassen können nicht auf
	//die Referenz der einbettenden Instanz zugreifen bzw. auf
	//Funktionen zugreifen, die als nicht-statisch deklariert sind
	
	private static class Entry{
		
		private Printable element;
		private Entry next;
		private Entry prev;
		
		Entry( Printable element, Entry prevEntry, Entry nextEntry ){
			this.element = element;
			this.prev = prevEntry;
			this.next = nextEntry;
		}//end of constructor
		
	}//end class Entry
		
	class ListIterator{
		
		private int nextIndex;
		private Entry next = header.next; //jeder neue Iterator zeigt auf das erste Element der Liste
		
		boolean hasNext() {
			return nextIndex != size; 
		}//end of hasNext
		
		Printable next() {
			
			if( nextIndex == size ) {
				throw new java.util.NoSuchElementException();
			}//end if
			
			Printable nextElement = next.element;
			next = next.next;
			nextIndex++; //Vergleichsindex erhöhen
			
			return nextElement;
			
		}//end next
				
	}//end ListIterator
	
	
	private Entry header = new Entry( null, null, null ); //default header
	private int size = 0;
	
	PrintableList(){
		/*
		 * Header Entry initialisieren
		 */
		this.header.prev = header;
		this.header.next = header;		
	}//end constructor
	
	
	//Interface PrintableList
	Printable getLast() {
		if( size == 0) {
			throw new java.util.NoSuchElementException();
		}//end if
		
		return header.prev.element;	
	}//end of getLast
	
	
	Printable removeLast() {
		Entry lastEntry = header.prev;
		
		if( lastEntry == header ) {
			throw new java.util.NoSuchElementException();
		}//end if
		
		header.prev = lastEntry.prev;
		lastEntry.prev.next = header;
		size--;
				
		return lastEntry.element;
		
	}//end removeLast
	
	
	void addLast( Printable element ){
		/*
		 * Neues Entry mit Nutzobjekt element erzeugen
		 * Pointer setzen
		 * Stacksize erhöhen
		 */
		Entry newEntry = new Entry( element, header.prev, header );
		header.prev.next = newEntry;
		header.prev = newEntry;
		size++;		
	}//end addLast
	
	
	int size() {
		return size;
	}//end size
	
	
	/*
	 * Iterator zum Navigieren durch die Liste
	 */
	ListIterator listIterator() {
		return new ListIterator();
	}//end listIterator
				
	
}//end class PrintableList
