package UnveraenderlicheKlassen;

class IntPair{
	private int a;
	private int b;
	
	IntPair( int ai, int bi ){
		a = ai;
		b = bi;
	}//end cons
	
	int sum() { return this.add(); }//end sum
	
	private int add() { //Methode wurde als private deklariert, steht also 
					    //in Subklassen nicht zur Verfügung
		return a + b;
	}//end add
	
}//end IntPair

class IntTriple extends IntPair{
	private int a;
	
	IntTriple( int ai, int bi, int ci ){
		super( ai, bi );
		a = ci;
	}//end cons
	
	@Override
	int sum(){ return this.add(); }//end sum
	
	private int add() {
		return super.sum() + a;
	}//end add
	
}//end class IntTriple


public class PairTriple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IntPair ip = new IntPair( 3, 9 );
		IntTriple it = new IntTriple( 1, 2, 27 );
		System.out.println( ip.sum() );
		System.out.println( it.sum() );
		//System.out.println("" + ip.sum() + " " + it.sum());
	}//end of main

}
