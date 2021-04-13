package controlStructure;

public class Foo {

	   public static void main( String[] args ) {

	        if( args.length % 2 != 0) {

	            System.out.println("Die Anzahl der Parameter ist ungerade. Bitte geben Sie vollstände Wertepaare ein.");

	            return;
	        }

	        for (int i = 0; i < args.length; i = i + 2) {

	            int x;

	            try {

	                x = Integer.parseInt( args[i] );

	            } catch (NumberFormatException e) {

	                System.out.println("Fehler im Eingabewert - Bitte geben Sie nur ganze Zahlen als Parameter an.");

	                return;
	            }

	            int y;

	            try {

	                y = Integer.parseInt(args[i + 1]);

	            } catch (NumberFormatException e) {

	                System.out.println("Fehler im Eingabewert - Bitte geben Sie nur ganze Zahlen als Parameter an.");

	                return;
	            }

	            x = x < 0 ? x * -1 : x;
	            y = y < 0 ? y * -1 : y;
	            int ergebnis = x + y;

	            while (ergebnis >= 3) {

	                ergebnis = ergebnis - 3;

	            }

	            int paarNr = i / 2 + 1;

	            switch (ergebnis) {

	                case 0:
	                    System.out.println(paarNr + ". Paar: 0");
	                    break;

	                case 1:
	                    System.out.println(paarNr + ". Paar: 1");
	                    break;

	                case 2:
	                    System.out.println(paarNr + ". Paar: 2");
	                    break;

	                default:
	                    System.out.println("Das kann nicht sein!");
	                    break;
	            }

	        }

	    }
	
	
}
