package stapel;

//package für LinkedList und NoSuchElementException
import java.util.*;

public class stack{

	/*stack Implementierung - Aufgabe 02 aus EA02
	
		Implementierung eines Stacks mit den Methoden
	
		- push - legt ein Objekt auf den Stapel ab
		- peek - liefert eine Referenz auf das oberste Objekt im Stapel
		- pop - liefert eine Referenz auf das oberste Objekt auf den Stapel und entfernt es
		- isEmpty - liefert die Information, ob der Stapel leer ist
		
		- toString - liefert eine Repräsentation des Stacks (alle Elemente) als String
	
		Anm. Der Stack wird auf Basis einer LinkedList implementiert.
	*/
	
	//Vorinitialisierung der internen Datenstruktur (hier als Liste aus Stringelementen), 
	// die für die Implementierung des Stacks intern genutzt wird. 
	private LinkedList<String> stackImpl = new LinkedList<String>(); 
	
	//Konstruktor mit Übergabe von Elementen
	stack( String[] collection ){
		
		// Initialisierung des Stacks erfolgt nur dann, wenn collection != null
		if( collection != null ) {
			
			for( int i = 0; i < collection.length; i++ ) {
				
				//Initialisierung des Stacks erfolgt nur für Stringelemente aus der Collection, die nicht null sind
				if( collection[i] != null) {
					stackImpl.addFirst( collection[i] );
				}//end if
				
			}//end for
			
		}//end if
		
	}//end stack
	
	
	public void push ( String s ) {
		//legt den String s auf den Stack
	
		if( s != null) {
			//da Stack eine LiFo Struktur hat, wird das Element in der Liste
			//immer als ERSTES Element plaziert über addFirst
			stackImpl.addFirst( s );
		}//end if
		
	}//end push

	
	public String pop () {
		// pop liefert das oberste Element vom Stack zurück
		// und löscht gleichzeitig das Objekt
		
		if( stackImpl.size() > 0 ) {
			String upperElement = stackImpl.getFirst();
			stackImpl.removeFirst();
			return upperElement;
		}//end if
		else {
			throw new NoSuchElementException( "Stack is empty !");
		}//end else
		
	}//end of pop
		
	
	public String peek() {
		// liefert eine Referenz auf das oberste Objekt des Stapels
		
		if( stackImpl.size() > 0) {
			return stackImpl.getFirst();
		}//end if
		else {
			throw new NoSuchElementException( "Stack is empty !" );
		}//end else
						
	}//end of peek
	
	
	public boolean isEmpty() {
		// liefert die Information, ob der Stapel leer ist
		return (stackImpl.size() > 0 ? false : true);
		
	}//end isEmpty
	
	
	public String toString() {
		// liefert die Stringelemente zurück, die auf dem Stack liegen
		
		String res = new String();
		String pos = "top : ";
				
		if( stackImpl.size() > 0) {
					
			for( int i=0; i < stackImpl.size(); i++) {
				
			res += pos + stackImpl.get(i) + ", ";
			pos = Integer.toString( (i+1) * -1 ) + ": ";
	
			}//end for
		
			return res;
			
		}//end if
		else {
			throw new NoSuchElementException( "Stack is empty !" );
		}//end else	
		
	}//end toString
		
	
	public static void main ( String[] args ){
		
		//testrahmen
		//-> 
		try {
			String[] str1 = new String[5];
			str1[3] = "test3";
			//stack s1 = new stack( null );
			stack s1 = new stack( str1 );
			
			boolean x = s1.isEmpty();
			
			System.out.println( s1.pop() );
			System.out.println( s1.peek() );
		}//end try
		catch( NoSuchElementException e ) {
			System.out.println( e.getMessage());
		}//end catch
		
		
		String[] myCollection = { "Obj1", "Obj2", "Obj3", "Obj4", "Obj5" };
				
		stack myStack = new stack( myCollection );
		System.out.println( myStack.pop());
		myStack.push("Dummy1");
		myStack.push("Dummy2");
		System.out.println( "Element " + myStack.pop() + " vom Stack entfernt.");
		myStack.push("Dummy3");
		System.out.println( myStack.toString() );
				
	}//end of main
	

}//end of class Stack