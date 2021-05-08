package Subtyping2;

/**
 * @author kokol
 *
 */
public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stapel myStack = new Stapel();
		
		myStack.push( "0" );
		myStack.push( "1" );
		myStack.push( "2" );
	
		while( ! myStack.isEmpty() ) {
			
			System.out.println("Stack ist nicht leer");
			System.out.println("Oberstes Element ist: " + (String) myStack.pop() );	
		}//end while
		
		System.out.println("Stack ist leer");
		
	}//end main

}//end StackTest

