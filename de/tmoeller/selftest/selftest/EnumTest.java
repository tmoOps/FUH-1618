package selftest;

enum LEVEL{
	LOW,
	MIDDLE,
	HIGH
}//end of enum LEVEL


public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//enhanced for statement
		for( LEVEL lvl : LEVEL.values() ) {
			System.out.println( lvl );
		}//end for
		
		LEVEL l = LEVEL.MIDDLE;
		
		switch( l ) {
		
		case MIDDLE : 
			System.out.println( "Middle" );
			break;
			
		case LOW :
			System.out.println( "Low" );
			break;
			
		case HIGH :
			System.out.println( "High");
			break;
			
		default:
			break;
		
		}//end switch
		
		
		
		
	}//end main

}//end class EnumTest
