package adHoc;

import java.lang.*;
import java.util.*;

public class AH02_2 {

	private static class Fraction{ 
		
		private int nominator;
		private int denominator;
		
		public Fraction( int nominator, int denominator)
			/*throws IllegalArgumentException*/{
			
			if( denominator == 0) {
				throw new NoSuchElementException( "Nenner ist gleich 0 !");
			}//end if	
				
			this.nominator = nominator;
			this.denominator = denominator;
			
		}//end konstruktor
		
		public Fraction getProductOfThisAnd( Fraction other ) {
			/*
			 * gibt das Produkt zweier Fraction Objekte zurück
			 * obj1 = a/b; obj2 = c/d
			 * Ergebnis = a * c und b * d
			 * also new Fraction( a*c, b*d )
			 */
			int ProductNom = this.nominator * other.nominator;
			int ProductDenom = this.denominator * other.denominator;
			
			return( new Fraction( ProductNom, ProductDenom));
			
		}//end getProduktOfThisAnd
		
		
		public String toString() {
			
			return Integer.toString( nominator ) + "/" + Integer.toString( denominator);
			
		}//end toString
		
	}//end class Fraction
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fraction myFraction = new Fraction( 1, 2 );
		Fraction result = myFraction.getProductOfThisAnd( new Fraction( 1,2 ));
		
		System.out.println( result.toString() );
		
	}//end main

}//end class

