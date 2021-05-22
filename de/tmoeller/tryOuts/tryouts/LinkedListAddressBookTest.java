package tryouts;

import adHoc.Person;

class LinkedList1618<ET>{
	
	private Entry<ET> header = new Entry<ET>( null, null, null);
	private int size;
	
	public LinkedList1618() {
		header.next = header;
		header.previous = header;
	}//end cons
	
	public ET getLast() {
		if( size == 0 ) throw new java.util.NoSuchElementException();
		return header.previous.element;
	}//end getLast
	
	public ET removeLast() {
		Entry<ET> lastEntry = header.previous;
		if( lastEntry == header) throw new java.util.NoSuchElementException();
		lastEntry.previous.next = lastEntry.next;
		lastEntry.next.previous = lastEntry.previous;
		size--;				
		return lastEntry.element;
	}//end removeLast
	
	public void addLast( ET e ) {
		Entry<ET> newEntry = new Entry<ET>( e, header, header );
		header.previous.next = newEntry;
		header.previous = newEntry;
		size++;
	}//end addLast
	
	public int size() {
		return size;
	}//end size
	
	//Entry als statisch, innere Klasse deklariert
	
	private static class Entry<T>{
		
		private T element;
		private Entry<T> next;
		private Entry<T> previous;
		
		private Entry( T element, Entry<T> next, Entry<T> previous ) {
			this.element = element;
			this.next = next;
			this.previous = previous;
		}//end cons
		
	}//end class Entry
	
	
	public class ListIterator{
		
		private int nextIndex;
		private Entry<ET> next = header.next;
		
		boolean hasNext() {
			return nextIndex != size;
		}//end hasNext
		
		ET next() {
			if( nextIndex == size ) throw new java.util.NoSuchElementException();
			ET elem = next.element;
			next = next.next;
			nextIndex++;
			return elem;
		}//end of next
		
	}//end ListIterator
	
	
	public ListIterator listIterator() {
		return new ListIterator();
	}//end listIterator
	
}//end of class LinkedList1618<ET>


 class LinkedListAddressBook{
	
	private LinkedList1618<Person> personList;
	
	public LinkedListAddressBook() {
		this.personList = new LinkedList1618<Person>();
	}//end cons
	
	public void addPerson( Person p ) {
		personList.addLast(p);
	}//end of addPerson

	Person getPersonByLastName( String name ) {
		LinkedList1618<Person>.ListIterator iterator = personList.listIterator();
		
		while( iterator.hasNext() ) {
			Person p = iterator.next();
			//equals vergleicht 2 Strings miteinander und gibt true bei Gleichheit zurück
			if( p.getName().equals( name )){
				return p;
			}//end if
		}//end while
		
		throw new java.util.NoSuchElementException();
		
	}//end getPersonByLastName
	
	
}//end LinkedListAdddressBook


public class LinkedListAddressBookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedListAddressBook ab = new LinkedListAddressBook();
		ab.addPerson( new Person("P1", 111020 ) );
		ab.addPerson( new Person("P2", 111120 ) );
		ab.addPerson( new Person("P3", 111220 ) );
		
		Person search = ab.getPersonByLastName("P3");
		System.out.println( search.getName() );
	}//end main
}//end LinkedListAddressBookTest
