package AnonymClassAndLambda;

interface IntIntFunction{
	int perform( int input );
}//end interface IntIntFunction


public class FunctionOperator {

	public int operate( IntIntFunction function, int start, int target) {
		int counter = 0;
		int value = start;
		while( value != target) {
			value = function.perform(value);
			counter++;
		}//end of while
		
		return counter;		
	}//end operate

}//end class FuntionOperater
