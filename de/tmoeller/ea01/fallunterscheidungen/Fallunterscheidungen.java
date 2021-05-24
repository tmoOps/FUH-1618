package fallunterscheidungen;

public class Fallunterscheidungen {

    public static void main(String[] args) {

        /* Datencontainer für die Tiere mit folgenden Attributen:
         * 1. Tierart
         * 2. AnzahlBeine
         * 3. Flugfähigkeit
         * 4. Hat Federn,
         * 5. Ist für Menschen gefährlich
         */

        String[][] Tiersammlung = {
                { "Spinne", "8", "nein", "nein", "eventuell" },
                { "Loewe", "4", "nein", "nein", "ja" },
                { "Hund", "4", "nein", "nein", "nein" },
                { "Papagei", "0", "ja", "ja", "nein"},
                { "Elefant", "4", "nein", "nein", "ja" },
                { "Schlange", "0", "nein", "nein", "eventuell" },
                { "Katze", "4", "nein", "nein", "nein" },
                { "Hai", "0", "nein", "nein", "ja" },
                { "Adler", "0", "ja", "ja", "eventuell" },
                { "Bär", "4", "nein", "nein", "ja" },
        };

        /* Argumentliste prüfen
         *
         */
        if( args.length == 0 || args.length > 1) {
            String s1 = Tiersammlung[0][0];
            for( int i=1; i<Tiersammlung.length; i++) {
                s1 += ", " + Tiersammlung[i][0];
            };

            System.out.println("Bitte übergeben Sie ein Tier aus dieser Liste als Parameter an das Programm: " + s1 );
            return;
        }//end if


        String gesuchtesTier = new String();

        gesuchtesTier = args[0].toUpperCase();

        int foundIndex = -1;

        /* ANMERKUNG - VARIANTE 1 -
         *
         * Iteration über if-else Anweisung
         *
         * also Vergleich des gesuchten Tiers mit dem Eintrag[0] der Tiersammlung.
         * Sofern das Tier gefunden wurde, wird ausgegeben, sofern nicht
         * wird ein else zweig erstellt und dort mit dem Eintrag[1] der Tiersammlung verglichen
         * Sofern das Tier gefunden wurde, wird ausgegeben, sofern nicht
         * wir erneut ein else zwei erstellt und dort mit dem nächsten Eintrag verglichen.
         *
         * Solange wiederholt, bis alle 10 Einträge durchlaufen wurden
         *
         */

        if( gesuchtesTier.equals(Tiersammlung[0][0].toUpperCase() )) {
            foundIndex = 0;
        }//end if
        else {
            if( gesuchtesTier.equals(Tiersammlung[1][0].toUpperCase() )) {
                foundIndex = 1;
            }//end if
            else {
                if( gesuchtesTier.equals(Tiersammlung[2][0].toUpperCase() )) {
                    foundIndex = 2;
                }//end if
                else {
                    if( gesuchtesTier.equals(Tiersammlung[3][0].toUpperCase() )) {
                        foundIndex = 3;
                    }//end if
                    else {
                        if( gesuchtesTier.equals(Tiersammlung[4][0].toUpperCase() )) {
                            foundIndex = 4;
                        }//end if
                        else {
                            if( gesuchtesTier.equals(Tiersammlung[5][0].toUpperCase() )) {
                                foundIndex = 5;
                            }//end if
                            else {
                                if( gesuchtesTier.equals(Tiersammlung[6][0].toUpperCase() )) {
                                    foundIndex = 6;
                                }//end if
                                else {
                                    if( gesuchtesTier.equals(Tiersammlung[7][0].toUpperCase() )) {
                                        foundIndex = 7;
                                    }//end if
                                    else {
                                        if( gesuchtesTier.equals(Tiersammlung[8][0].toUpperCase() )) {
                                            foundIndex = 8;
                                        }//end if
                                        else {
                                            if( gesuchtesTier.equals(Tiersammlung[9][0].toUpperCase() )) {
                                                foundIndex = 9;
                                            }//end if
                                        }//end else
                                    }//end else
                                }//end else
                            }//end else
                        }//end else
                    }//end else
                }//end else
            }//end else
        }//end else


        /* ANMERKUNG - VARIANTE 2 -
         *
         * Iteration erfolgt eleganter über Nutzung einer for-Schleife
         *
         * Die Liste der Tiere aus dem Tierpark wird durchsucht und der Eintrag[0] der Sammlung
         * verglichen mit der Eingabe des Benutzers
         *
         */

        String TierImTierpark = new String();

        for( int i=0; i<Tiersammlung.length; i++ ) {

            TierImTierpark = Tiersammlung[i][0].toUpperCase();

            if( gesuchtesTier.equals( TierImTierpark )) {
                foundIndex = i;
            }//end if

        }//end for


        if( foundIndex == -1 ) {
            System.out.println( "Das gesuchte Tier: " + args[0] + " lebt nicht im Dortmunder Tierpark.");
        }//end if
        else {
            System.out.println( gesuchtesTier );
            System.out.println( Tiersammlung[foundIndex][1] + " Beine" );
            System.out.println( "flugfähig: " + Tiersammlung[foundIndex][2] );
            System.out.println( "hat Federn: " + Tiersammlung[foundIndex][3] );
            System.out.println( "gefährlich für Menschen: " + Tiersammlung[foundIndex][4] );
        }//end else

    }//end main

}
