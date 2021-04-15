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
			
	// Nested class Entry zur Verwaltung der Objekte auf dem Stack
	// als static deklariert, da: a non-static nested class has full access to the members of
	// the class within which it is nested. a static nested class does not have a reference
	// to a nesting instance, so a static nested class cannot invoke non-static methods, or
	// access non-static fields of an instance of the class within which it is nested
	private static class Entry{
		
		private String element;
		private Entry nextEntry;
		
		Entry( String element, Entry nextEntry ){
			this.element = element;
			this.nextEntry = nextEntry;
		}//end of constructor		
	}//end of class Entry
	
	
	//Implementation of class stack
	private Entry header = new Entry( null, null );
	private int stackSize = 0;
	
	
	public stack() {
		//header Entry referenziert initial auf sich selbst
		this.header.nextEntry = header;	
	}//end of constructor stack
	
	
	public stack( String[] collection ) {
		
		this.header.nextEntry = header;
		
		// Initialisierung des Stacks erfolgt nur dann, wenn collection != null
		if( collection != null ) {
						
			Entry newEntry;
			Entry savedEntry;
			
			for( int i = 0; i < collection.length; i++ ) {
						
				//Initialisierung des Stacks erfolgt nur für Stringelemente aus der Collection, die nicht null sind
				if( collection[i] != null) {
					
					//Elemente sind vorhanden
					savedEntry = header.nextEntry;
					newEntry = new Entry( collection[i], savedEntry );
					header.nextEntry = newEntry;
												
					//Stacksize erhöhen
					stackSize++;	
						
				}//end if							
			}//end for					
		}//end if
	}//end of constructor 	

	
	public String peek() {
	//peek() liefert eine Referenz auf das oberste Element im Stapel		
		
		if( stackSize > 0) {
			//top Element ausgeben
			return header.nextEntry.element;
		}//end if
		else {
			throw new NoSuchElementException( "Stack is empty !" );
		}//end else
		
	}//end of peek
	
	
	public boolean isEmpty() {
		// liefert die Information, ob der Stapel leer ist
		
		return (stackSize > 0 ? false : true);
		
	}//end isEmpty
	
	
	public String pop() {
		// pop löscht das oberste Element auf dem Stack und
		// liefert das gelöschte Element zurück		
		// Erzeugt bei leerem Stapel eine Exception
		
		if( stackSize > 0 ) {
			
			//oberstes Element löschen und Referenzierung aktualisieren
			Entry savedEntry = header.nextEntry;
			header.nextEntry = savedEntry.nextEntry;
									
			//Stackgröße reduzieren
			stackSize--;
			
			return savedEntry.element;
			
		}//end if
		else {
			throw new NoSuchElementException( "Stack is empty !");
		}//end else
		
	}//end of pop
	
	
	public void push( String s) {
		// push legt ein neues Element auf den Stack
		
		if( s!= null ) {
			Entry newEntry = new Entry( s, header.nextEntry );
			// Referenzierung aktualisieren
			header.nextEntry = newEntry;
			// StackSize erhöhen
			stackSize++;
		}//end if		
	}//end push
	
	
	public String toString() {
		//liefert die Stackelemente zurück, die auf dem Stack liegen
		
		String res = new String();
		String pos = "top: ";
				
		if( stackSize > 0 ) {
		
			Entry currentEntry = header;
			
			for( int i=0; i < stackSize; i++) {
				
				currentEntry = currentEntry.nextEntry;
				res += pos + currentEntry.element + ", ";
				pos = Integer.toString( (i+1) * -1 ) + ": ";
				
			}//end for
			
		}//end if
		
		return res;
	}//end toString

}//end of class Stack
