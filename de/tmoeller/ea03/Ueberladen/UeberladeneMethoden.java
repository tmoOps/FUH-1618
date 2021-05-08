package Ueberladen;

class Super{

	void m( Tier t, Fisch f ) {
		System.out.println("1");
	}
	
	void m( Vogel v, Forelle f ) {
		System.out.println("2");
	}
	
	void m( Tier t, Huhn v ) {
		System.out.println("3");
	}
	
	void m( Huhn h, Vogel v ) {
		System.out.println("4");
	}
		
}//end of Super

class Sub extends Super{
	
	void m( Vogel v, Huhn h ) {
		System.out.println("5");
	}
	
	
	void m( Tier t, Fisch f) {
		System.out.println("6");
	}
	
}//end sub

class Tier{}
class Vogel extends Tier{}
class Huhn extends Vogel{}
class Fisch extends Tier{}
class Karpfen extends Fisch{}
class Forelle extends Fisch{}


public class UeberladeneMethoden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Super s1 = new Super();
		Super s2 = new Sub();
		Fisch f = new Forelle();
		Forelle fo = new Forelle();
		Vogel v = new Vogel();
		Huhn h = new Huhn();
		
		s1.m( v, f ); 
		s2.m( v, f ); 
		
		s1.m( v,  h ); 
		s2.m( v,  h );
		
		s1.m( h,  fo );
		//s1.m( h,  h );
	}

}
