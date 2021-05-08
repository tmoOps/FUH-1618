package AbstractClasses;

abstract class Tier{
	
	void druckeEigenschaften() {
		System.out.println( "Anzahl Beine: " + getLegCount() );
		System.out.println( "ist das Tier gefährlich? " + (isDangerous() ? "ja" : "nein") );
	}//end of druckeEigenschaften
	
	public abstract int getLegCount();
	public abstract boolean isDangerous();
	
}//end of class Tier

class Pinguin extends Tier{

	public int getLegCount() {
		return 2;
	}
	
	public boolean isDangerous() {
		return false;
	}
	
}//end of class Pinguin

class Loewe extends Tier{

	public int getLegCount() {
		return 4;
	}
	
	public boolean isDangerous() {
		return true;
	}

}//end of class Loewe

class Schmetterling extends Tier{

	public int getLegCount() {
		return 6;
	}
	
	public boolean isDangerous() {
		return false;
	}

}//end of class Schmetterling



public class AnimalInformationSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String artName = args[0];
		Tier tier = null;
		
		if( artName.equals("Pinguin")) {
			tier = new Pinguin();
		}//end if
		
		if( artName.equals("Löwe")) {
			tier = new Loewe();
		}//end if
		
		if( artName.equals("Schmetterling")) {
			tier = new Schmetterling();
		}//end if
		
		/* .... */
		
		if( tier == null ) {
			System.out.println("Das Tier " + artName + " wurde noch nicht implementiert.");
		}//end if
		else {
			System.out.println(artName + ":");
			tier.druckeEigenschaften();
		}//end else
		
			
	}//end main

}//end class AnimalInformationSystem
