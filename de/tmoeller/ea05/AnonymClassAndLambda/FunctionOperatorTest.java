package AnonymClassAndLambda;

public class FunctionOperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FunctionOperator fo = new FunctionOperator();
		
		IntIntFunction f1 = (int x) -> x - 1;
		
		IntIntFunction f2 = (int x) -> {
			
			if( x % 2 == 0) {
				return x /2;
			}//end if
			else {
				return 3*x+1;
			}//end else
			
		};//end of iif2
		
		System.out.println( "EA05.a: " + fo.operate( f1, 10, -10 ) );
		System.out.println( "EA05.b: " + fo.operate( f2, 27, 1 ));
		
		System.out.println( "EA05.c: " + fo.operate( x -> x-1, 10, -10) );
		System.out.println( "EA05.d: " + fo.operate( x -> x%2==0 ? x/2 : 3*x+1, 27, 1) );
		
		
	}//end main

}//end FunctionOperatorTest
