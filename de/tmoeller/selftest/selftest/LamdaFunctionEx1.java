package selftest;

interface Mathe{
	int fkt( int a, int b);
}//end of Mathe

public class LamdaFunctionEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Mathe addiere = ( int a, int b ) -> a + b;
		Mathe multipliziere = (int a, int b) -> a * b;	
		
		System.out.println( "add: " + addiere.fkt( 2, 3 ) );
		System.out.println( "mul: " + multipliziere.fkt(2, 3));
	}
	
}
