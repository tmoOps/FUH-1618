import hagenGames.HagenGames;
import hagenGames.K1618Restricted;

//import hagenGames.K1618; //Compilermeldung: type K1618 is not visible

public class HagenGamesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HagenGames hg = new HagenGames();
		K1618Restricted game = hg.buyGame();
		
		/*
		 * Durch die Begrenzung der Sichtbarkeit von K1618 kann dieser
		 * Cast nicht programmiert werden
		 */
		//K1618 test = (K1618)hg.buyGame();
		//test.update();
		
		game.playGame();
		hg.updateK1618( game );
		game.playGame();
	
	}//end of main

}//end of class HagenGamesTest
