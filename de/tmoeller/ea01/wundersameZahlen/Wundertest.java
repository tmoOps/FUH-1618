package wundersameZahlen;

public class Wundertest {

    /*
     * Klassenmethode: public static int wunder( int n )
     *
     * input: int n: Ausgangswert
     * output: int: Anzahl Schritte, die zur Berechnung benötigt wurden
     */
    public static int wunder( int n ) {

        int steps = 0;

        while( n != 1 ) {

            // Prüfen, ob der Ausgangswert gerade ist
            if( n % 2 == 0) {
                n = n / 2;
            }//end if
            else {//ungerade
                n = (n * 3) + 1;
            }//end else

            steps += 1; //Schrittanzahl erhöhen

        }//end while

        return steps; //Anzahl Schritte zurückgeben

    }//end of wunder


    public static int wunderRek( int n ) {

        if( n != 1) {

            if( n % 2 == 0) {
                n = n / 2;
            }//end if
            else {
                n = (n * 3) + 1;
            }//end else

        }//end if
        else {
            return 0;
        }

        //rekursiver Aufruf von wunderRek
        //Anzahl Schritte entspricht Anzahl der Aufrufe von wunderRek
        //die Anzahl wird hier über die Summe 1 + .... gezählt
        return ( 1 + wunderRek( n ));

    }//end of wunderRek


    public static void main( String[] args) {

        int ValueWithMaxSteps = 0;
        int MaxSteps = 0;
        int res = 0;

        MaxSteps = wunder(1);  //Anzahl Schritte sichern
        ValueWithMaxSteps = 1; //Wert sichern

        for( int j=2; j<101; j++ ) {

            //Wunder für index j berechnen (Vorgabe aus Ausgabe von 1-100)
            res = wunder(j);

            //Nach Berechnung von wunder(x) ist in res die Anzahl Schritte gespeichert
            //dieser Wert wird nun verglichen mit dem bislang ermittelten MaximalWert
            //Wird der MaximalWert überschritten, werden die Variablen aktualisiert
            if( res > MaxSteps ) {
                ValueWithMaxSteps = j;
                MaxSteps = res;
            }//end if

        }//end for

        //Nach Ermittlung aller Werte von 1-100 steht in ValueWithMaxSteps der Wert,
        //für den die meisten Schritte benötigt wurden und in MaxSteps die Anzahl der
        //benötigten Schritte.

        // Ausgabe der Werte
        System.out.println( "Für den Wert: " + ValueWithMaxSteps + " wurden " + MaxSteps + " Schritte benötigt." );

        //Gegentest Rekursion
        int resRek = wunderRek( ValueWithMaxSteps );
        System.out.println("Gegenprobe Rekursion");
        System.out.print( "Für den Wert: " + ValueWithMaxSteps + " wurden " + resRek + " Schritte benötigt." );

    }//end of main

}
