package adHoc;

//import java.lang.*;

class NumberContainer{
	
	private Number element;
	
	public void store( Number number ) {
		element = number;
	}//end store
	
	public Number getElement() {
		return element;
	}//end getElement
		
}//end class NumberContainer


class NumberContainerWithMaximum extends NumberContainer{
	
	private Number maximum;
	
	@Override
	public void store( Number number ) {
		
		super.store(number);
				
		if ( maximum == null ||
			 number.doubleValue() > maximum.doubleValue() ) {	
			maximum = number;
		}//end if
	}//end store
		
	public Number getMaximum() {
		return maximum;
	}//end getElement
		
}//end class NumberContainerWithMaximum


public class AH02_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double dMax = Double.MAX_VALUE;
		int iMin = Integer.MIN_VALUE;
		short sMax = Short.MAX_VALUE;
		
		double pi = Math.PI; 
				
		NumberContainerWithMaximum ncwm = new NumberContainerWithMaximum();
		
		/*
		 * Übergabe von Basisdatentypen an store
		 * Übergabeparameter in Store ist vom Typ Number
		 * Damit erfolgt hier automatisch ein BOXING der Basisdatentypen in
		 * den Typ Number über Wrapperklasse.
		 * 
		 * UNBOXING, also der umgekehrte Weg, kommt im Programm nicht vor
		 * 
		 */
		ncwm.store( dMax );
		ncwm.store( iMin );
		ncwm.store( sMax );
		ncwm.store( pi );

		int abc = Integer.valueOf(iMin);
				
		Number myMax = ncwm.getMaximum();
		
		System.out.println( "Maximum = " + myMax );

	}//end main

}//end class
