package StroemeROT13;

import java.io.IOException;

interface CharEingabeStrom {
    int read() throws IOException;
}

class GrossBuchstabenFilter implements CharEingabeStrom {
    private CharEingabeStrom quelle;

    public GrossBuchstabenFilter(CharEingabeStrom quelle) {
        this.quelle = quelle;
    }

    @Override
    public int read() throws IOException {
        int zeichen = quelle.read();
        if(zeichen == -1) return -1;
        return Character.toUpperCase((char) zeichen);
    }
}

class UmlautSzFilter implements CharEingabeStrom {
    private CharEingabeStrom quelle;
    private int puffer = -1;

    public UmlautSzFilter(CharEingabeStrom quelle) {
        this.quelle = quelle;
    }

    @Override
    public int read() throws IOException {
        if (puffer != -1) {
            int zeichen = puffer;
            puffer = -1;
            return zeichen;
        } else {
            int zeichen = quelle.read();
            if (zeichen == -1) return -1;
            switch (zeichen) {
            case 'Ä':
                puffer = 'e';
                return 'A';
            case 'Ö':
                puffer = 'e';
                return 'O';
            case 'Ü':
                puffer = 'e';
                return 'U';
            case 'ä':
                puffer = 'e';
                return 'a';
            case 'ö':
                puffer = 'e';
                return 'o';
            case 'ü':
                puffer = 'e';
                return 'u';
            case 'ß':
                puffer = 's';
                return 's';
            default:
                return zeichen;
            }
        }
    }
}

class Rot13Filter implements CharEingabeStrom{
	private CharEingabeStrom quelle;
	
	
	public Rot13Filter(CharEingabeStrom quelle) {
		this.quelle = quelle;
	}//end cons
	 
	@Override
	public int read() throws IOException{
        int zeichen = quelle.read();
        
        //konvertiere char, sofern dieser im Bereich 'A' und 'Z' liegt   
        if(( zeichen >= 'A' ) && (zeichen <= 'Z')){
        	zeichen += 13;
        	if( zeichen > 'Z') zeichen -= 26; //Überlauf, somit zurücksetzen
        }//end if
        
        return zeichen;
	}//end read
	
}//end of ROT13Filter
