package adHoc;

class Toy {
	
	public String print() {
		return "Toy";
	}//end print
	
}//end class Toy

class RubberDuck extends Toy {
	
	@Override
	public String print() {
		return "RubberDuck";
	}//end print
	
}//end RubberDuck

class TeddyBear extends Toy {
	
	@Override
	public String print() {
		return "TeddyBear";
	}//end print
	
}//end TeddyBear

class PlasticCar extends Toy {
	
	public String print() {
		return "PlasticCar";
	}//end print
	
}//end PlasticCar

class NoSuchToyException extends Exception{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchToyException( String msg ) {
		super( msg );
	}//end of constructor
	
}//end NoSuchToyException


class ToyFactory {
	
	public Toy getToy( String className )
	  throws NoSuchToyException {
		
		Toy res = null;
		
		//Polymorphe Zuweisung je gewünschter Klasse
		switch( className ) {
		
		case "Toy" : 
			res = new Toy();
		    break;
		    
		case "RubberDuck" :
			res = new RubberDuck();
			break;
			
		case "TeddyBear" :
			res = new TeddyBear();
			break;
			
		case "PlasticCar" :
			res = new PlasticCar();
			break;
			
		default:
			throw new NoSuchToyException( "<unknown ClassName> - Creation failed !" );
		
		}//end switch
		
		return res;
		
	}//end getToy

	
}//end ToyFactory


public class AH02_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ToyFactory tf = new ToyFactory();
		
		try {		
			System.out.println( tf.getToy( "Toy").print() );
			System.out.println( tf.getToy( "TeddyBear").print() );
			System.out.println( tf.getToy( "PlasticCar").print() );
			System.out.println( tf.getToy( "RubberDuck").print() );
			System.out.println( tf.getToy( "Toy").print() );		
		}//end try
		catch( NoSuchToyException ex )
		{
			System.out.println( ex.getMessage() );
		}//end catch
	
	}//end main
}//end clasee
