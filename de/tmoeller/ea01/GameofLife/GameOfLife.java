package GameofLife;

public class GameOfLife {

    boolean[][] feld = {
            { false, false, false, false, false },
            { false, false, true, false, false },
            { false, false, true, false, false },
            { false, false, true, false, false },
            { false, false, false, false, false }
    };//end of feld

    void print() {

        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                if (feld[i][j]) {
                    System.out.print("o ");
                } else {
                    System.out.print(". ");
                }//end else
            }//end for
            System.out.println();
        }//end for

    }//end print

    void nextGeneration() {
        /*
         * Feld für Folgegeneration dynamisch allokieren
         * auf Basis der vorgegebenen Matrix in feld
         * newGenField wird mit false Werten vorinitialisiert
         */
        boolean[][] newGenField = new boolean[feld.length][feld[0].length];

        // Da Randbereiche ausgeschlossen sind, kann die ersten und letzte Zeile
        // und die erste und letzte Spalte ausgeschlossen werden
        // Das erfolgt über Anpassung der Indices für Zeile und Spalte
        // Beginn also bei zweiter Zeile / Spalte (StartIndex=1 statt 0) und Ende
        // bei vorletzter Zeile / Spalte (EndIndex=lenth-1 statt length)

        int[] cellConditions = new int[8];
        int sumAlive = 0;

        for( int row = 1; row < feld.length-1; row++ ) {
            for( int col = 1; col < feld[0].length-1; col++ ) {

                //Anzahl lebender Zellen ermitteln aus dem Status der 8 Nachbarzellen von feld[row][col]
                cellConditions[0] = feld[row-1][col-1] ? 1 : 0;
                cellConditions[1] = feld[row-1][col] ? 1 : 0;
                cellConditions[2] = feld[row-1][col+1] ? 1 : 0;
                cellConditions[3] = feld[row][col-1] ? 1 : 0;
                cellConditions[4] = feld[row][col+1] ? 1 : 0;
                cellConditions[5] = feld[row+1][col-1] ? 1 : 0;
                cellConditions[6] = feld[row+1][col] ? 1 : 0;
                cellConditions[7] = feld[row+1][col+1] ? 1 : 0;

                sumAlive = cellConditions[0] + cellConditions[1] + cellConditions[2] + cellConditions[3];
                sumAlive += cellConditions[4] + cellConditions[5] + cellConditions[6] + cellConditions[7];

                //in Abhängigkeit vom Status der Zelle (ob lebend oder tot)
                //werden die Werte der Folgegeneration gesetzt
                if( feld[row][col] ) {
                    //Zelle lebt

                    switch( sumAlive ) {
                        case 2: newGenField[row][col]=true; //Zelle in Folgegeneration bleibt lebendig
                            break;
                        case 3: newGenField[row][col]=true; //Zelle in Folgegeneration bleibt lebendig
                            break;
                        default: newGenField[row][col]=false; //Zelle in Folgegeneration stirbt durch Einsamkeit oder Überbevölkerung
                            break;
                    }//end switch

                }//end if
                else {
                    //Zelle ist tot
                    if( sumAlive == 3) {
                        //Zelle in Folgegeneration wird lebendig
                        newGenField[row][col]=true;
                    }//end if

                }//end if


            }//end for
        }//end for


        //Da Ausgabe auf feld array basiert, muss das Feld für die neue Generation
        //nach feld kopiert werden
        System.arraycopy( newGenField, 0, feld, 0, newGenField.length );

    }//end nextGeneration

    public static void main(String[] args) {

        GameOfLife myGame = new GameOfLife();

        for (int i = 0; i < 10; i++) {
            myGame.nextGeneration();
            myGame.print();
            System.out.println();
        }//end for

    }//end main

}
