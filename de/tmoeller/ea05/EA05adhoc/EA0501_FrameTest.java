package EA05adhoc;

import java.awt.Frame;
import java.awt.event.*;

/*
class FensterBeobachter implements WindowListener {
	
	@Override
	public void windowClosed( WindowEvent e ) {
		System.out.println("Fenster geschlossen");
		System.exit(0);
	}

	@Override
	public void windowIconified( WindowEvent e ) {
		System.out.println("Fenster ikonifiziert");
	}

	@Override
	public void windowDeiconified( WindowEvent e ) {
		System.out.println("Fenster deikonifiziert");
	}

	@Override
	public void windowClosing( WindowEvent e ) {
		System.out.println("Fenster schlie�en angefordert");
		Window w = (Window) e.getSource();
		//dispose l�st das Schlie�en des Fensters und l�st dadurch das Event
		//windowClosed aus. In windowClosed wird das Programm beendet.
		w.dispose();
	}

	@Override
	public void windowActivated( WindowEvent e ) {
		System.out.println("Fenster aktiviert");
	}

	@Override
	public void windowDeactivated( WindowEvent e ) {
		System.out.println("Fenster deaktiviert");
	}

	@Override
	public void windowOpened( WindowEvent e ) {
		System.out.println("Fenster ge�ffnet");
	}
	
}
 */

/*
 * WindowAdapter fungiert als Adapterklasse vom WindowListener und
 * implementiert einen Rumpf f�r alle Klassen des WindowListeners, die
 * bei direkter Ableitung alle �berschrieben werden m�ssen.
 * 
 * Durch die default Implementierung muss nur diejenige Methode �berschrieben
 * werden, die auch tats�chlich genutzt werden soll - hier: windowClosing
 */

class ClosingBeobachter extends WindowAdapter {
	@Override
	public void windowClosing( WindowEvent e ) {
		System.exit(0);
	}//end of windowClosing
}

public class EA0501_FrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame();
		f.setSize(300, 400);
		f.setLocation(100, 100);
		f.setVisible(true);
		
		f.addWindowListener( new ClosingBeobachter() );
		
	}//end of main

}
