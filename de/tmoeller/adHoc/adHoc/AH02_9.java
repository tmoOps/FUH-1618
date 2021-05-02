package adHoc;

//import java.lang.*;

interface Weighable{
	double getWeight();
}//end interface Weighable

class MaxWeightContainer{
	
	private Weighable heaviest;
	
	public void store( Weighable element ) {
				
		if( element == null )
			return;
		
		if ( heaviest == null || 
				element.getWeight() > heaviest.getWeight() ) {
			 heaviest = element;
		}//end if
	}//end store
		
	public Weighable getHeaviest() {
		return heaviest;
	}//end getElement
		
}//end class NumberContainerWithMaximum


class Animal implements Weighable {
	private double weight;
	
	public Animal( double weight ) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return weight;
	}
}//end class

class Apple implements Weighable {
	private double weight;
	
	public Apple( double weight ) {
		this.weight = weight;
	}
		
	public double getWeight() {
		return weight;
	}//end getWeight
}//end class

class Hammer implements Weighable{
	private double weight;
	
	public Hammer( double weight ) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return weight;
	}//end getWeight
}//end class


public class AH02_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxWeightContainer mwc = new MaxWeightContainer();
		
		mwc.store( new Animal( 377.15) );
		mwc.store( new Hammer( 20 ) );
		mwc.store( new Apple( 11.3 ) );
		mwc.store( new Animal( 1756.89 ) );
		
		Weighable w = mwc.getHeaviest();
				
		System.out.println( "Das schwerste Element wiegt: " + w.getWeight() );

	}//end main

}//end class
