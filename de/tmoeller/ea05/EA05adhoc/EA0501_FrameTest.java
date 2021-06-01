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
		System.out.println("Fenster schließen angefordert");
		Window w = (Window) e.getSource();
		//dispose löst das Schließen des Fensters und löst dadurch das Event
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
		System.out.println("Fenster geöffnet");
	}
	
}
 */

/*
 * WindowAdapter fungiert als Adapterklasse vom WindowListener und
 * implementiert einen Rumpf für alle Klassen des WindowListeners, die
 * bei direkter Ableitung alle überschrieben werden müssen.
 * 
 * Durch die default Implementierung muss nur diejenige Methode überschrieben
 * werden, die auch tatsächlich genutzt werden soll - hier: windowClosing
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
