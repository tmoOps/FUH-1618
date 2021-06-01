package StroemeROT13;

import java.io.*;

class Adapter implements CharEingabeStrom{
	
	private Reader r;
	
	public Adapter( Reader isr) {
		this.r = isr;
	}//end constructor

	@Override
    public int read() throws IOException {
		return r.read();
	}//read
	
}//end Adapter

public class Rot13FileTest {
	
    public static void main(String[] args) throws IOException {
    	
        FileOutputStream fos = new FileOutputStream("testout.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        FileInputStream fis = new FileInputStream("testin.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        
        Adapter adapter = new Adapter(isr);
        CharEingabeStrom cs = new UmlautSzFilter(adapter);
        
        cs = new GrossBuchstabenFilter(cs);
        cs = new Rot13Filter(cs);
        
        int zeichen = -1;
        while ((zeichen = cs.read()) != -1) {
            osw.write(zeichen);
        }
        
        isr.close();
        osw.close();
    }
}//end Rot13FileTest