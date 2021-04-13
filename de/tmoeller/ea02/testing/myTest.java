package testing;

import java.util.*;
import stapel.stack;

public class myTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String x1 = String.valueOf(3.0 / 4.0); 
		System.out.println(x1);
		String x2 = String.valueOf("Test"); 
		String x3 = String.valueOf("Test"); 
		System.out.println(x2 == x3);
		String x4 = new String("Test"); 
		System.out.println(x2 == x4);
		String x5 = String.valueOf("Test");
		
		//testrahmen
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

}// end myTest
