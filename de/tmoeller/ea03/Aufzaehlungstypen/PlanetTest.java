package Aufzaehlungstypen;

enum Planet{
	
	/*
	 * Planet(numberOfMoons, distanceFromSun)
	 */
	MERKUR( 0, 57910000 ), 
	VENUS( 0, 108200000 ), 
	ERDE( 1, 149600000 ), 
	MARS( 2, 227900000 ), 
	JUPITER( 79, 778500000 ), 
	URANUS(27, 2.871*10e9 ), 
	NEPTUN( 14, 4.495*10e9 ), 
	SATURN( 82, 1.434*10e9 );

	private int numberOfMoons;
	private double distanceFromSun;
	
	Planet( int numberOfMoons, double distanceFromSun ){
		this.numberOfMoons = numberOfMoons;
		this.distanceFromSun = distanceFromSun;
	}//end cons
	
	int getNumberOfMoons() {
		return numberOfMoons;
	}//end getNumberOfMoons
	
	boolean isCloserToSunThan( Planet p2 ) {
		return distanceFromSun < p2.distanceFromSun;
	}//end isCloserToSunThan
	
}//end of enum Planet


public class PlanetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Planet p1 = Planet.MARS;
		Planet p2 = Planet.JUPITER;
		
		System.out.println("Anzahl Monde " + p1 + ": " + p1.getNumberOfMoons());
		System.out.println("Anzahl Monde " + p2 + ": " + p2.getNumberOfMoons());
		
		if( p1 != p2 ) {
			
			if( p1.isCloserToSunThan(p2)) {
				System.out.println( p1 + " ist näher an der Sonne als " + p2 );
			} else {
				System.out.println( p2 + " ist näher an der Sonne als " + p1 );
			}//end else
			
		}//end if
				
	}//end main

}//end PlanetTest
