package testing;

import java.util.*;
import stapel.stack;

public class myTest {

	public static void main(String[] args) {

		//Test Beispiel mit Initialisierung
		try {
			String[] myCollection = { "Obj1", "Obj2", "Obj3", "Obj4", "Obj5" };

			stack myStack = new stack( myCollection );
			String res = new String();
		
			//Oberstes Stackelement abfragen
			while( ! myStack.isEmpty()) {
				res += myStack.pop() + " ";
			}//end while
		
			System.out.println( res );
		}//end try
		catch ( NoSuchElementException e) {
			System.out.println( e.getMessage() );
		}//end catch
			
		//Test Beispiel ohne Initialisierung
		try {
			stack myStack2 = new stack();
			myStack2.push( "test 0" );
			myStack2.push( "test 1");
			myStack2.push( "test 2");
			myStack2.pop();
				
		    System.out.println( myStack2.toString() );
		}//end try
		catch( NoSuchElementException e) {
			System.out.println( e.getMessage() );
		}//end catch
					
	}//end of main

}// end myTest
