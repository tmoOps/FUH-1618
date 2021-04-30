package hagenGames;

public class HagenGames{
	
	public K1618Restricted buyGame() {
		return new K1618();
	}//end of buyGame
	
	
	public void updateK1618( K1618Restricted game ) {
		
		if( game != null ) {
			
			/*
			 * Prüfung, ob game vom Typ K1618 ist.
			 * sofern das zutrifft, erfolgt ein Downcasting
			 * und der Aufruf der Methode update
			 */
			if ( game instanceof K1618) {
				((K1618)game).update();
			}//end if
			
		}//end of if
		
	}//end of updateK1618
		
}//end of class HagenGames
