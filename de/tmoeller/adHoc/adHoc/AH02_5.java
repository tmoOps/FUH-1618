package adHoc;

class Person {
    
	String name;
    int birthday; /* in der Form JJJJMMTT */

    Person(String name, int birthday)
    { 
      this.name = name;
      this.birthday = birthday;
    }
    
    void print() {
    	System.out.println("Name: " + this.name); System.out.println("Geburtsdatum: " + this.birthday);
    }
    
    boolean isBirthday(int date) 
    {
    	return birthday % 10000 == date % 10000;
    	// Das Prozentzeichen ist der Modulo-Operator, welcher // den Rest einer ganzzahligen Division liefert.
    }
}//end class Person


class Entry {
    Person element;
    Entry next;
    Entry previous;

    Entry(Person element, Entry next, Entry previous) 
    { 	
    	this.element = element;
    	this.next = next;
    	this.previous = previous;
    }//end constructor
}


class LinkedList1618 {
		Entry header = new Entry(null, null, null);
		int size;
		
		/* Constructs an empty Linked List. */ 
		LinkedList1618() {
			header.next = header;
			header.previous = header; }
		
		/* Returns the Element @ Position */
		Person getElementAt( int Position ) {
			if( Position < 0 || Position >= size )	throw new java.util.NoSuchElementException();
					
			Entry current = header.next;
			
			for( int cnt=0; cnt < Position; cnt++ ) {
				// iterieren bis Element Position gefunden
				current = current.next;				
			}//end for
						
			return current.element;
		}//end getElementAt
		
		
		/* Returns the last Element in this List. */ 
		Person getLast() {
			if (size == 0) throw new java.util.NoSuchElementException();
			return header.previous.element; 
		}//end getLast()

		/* Removes and returns the last Element from this List. */ 
		Person removeLast() {
			Entry lastEntry = header.previous;

			if (lastEntry == header) throw new java.util.NoSuchElementException(); 
			lastEntry.previous.next = lastEntry.next;
			lastEntry.next.previous = lastEntry.previous;
			size--;

			return lastEntry.element;
		}//end removeLast
		
		/* Appends the given element to the end of this List. */ 
		void addLast(Person p) {
			Entry newEntry = new Entry(p, header, header.previous); 
			header.previous.next = newEntry;
			header.previous = newEntry;
			size++;
		}//end addLast
		
		/* Returns the number of elements in this List. */ 
		int size() {
          return size;
		}//end size
}//end class LinkedList1618


public class AH02_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList1618 myList = new LinkedList1618();
		myList.addLast( new Person("p1", 101067 ) );
		myList.addLast( new Person("p2", 111067 ) );
		myList.addLast( new Person("p3", 121067 ) );
		
		System.out.println( myList.getElementAt(2).name );
		System.out.println( myList.getElementAt(1).name );
		System.out.println( myList.getElementAt(0).name );
		System.out.println( myList.getElementAt(3).name );
		System.out.println( myList.getElementAt(55).name );		
	}//end Test
}//end class

