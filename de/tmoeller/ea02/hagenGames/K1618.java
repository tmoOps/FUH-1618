package hagenGames;

class K1618 implements K1618Restricted {
	private double version = 1.0;

	public void playGame() {
		System.out.println("Running Kurs1618, Version " + version );
	}//end playGame
	
	public void update() {
		version += 0.1;
	}//end of update
	
}//end of class K1618
