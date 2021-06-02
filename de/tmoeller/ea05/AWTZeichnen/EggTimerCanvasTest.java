package AWTZeichnen;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import EA05adhoc.BaseFrame;

public class EggTimerCanvasTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Erzeugen eines EggTimerModel für eine Laufzeit von 60s
		EggTimerModel etm = new EggTimerModel( 60 );
		
		//Erzeugen EggTimerCanvas, das das oben erzeugte Model verwendet
		EggTimerCanvas etc = new EggTimerCanvas( etm );
		
		//Erzeugen Hauptfenster mit dem Titel "Kurzzeitwecker"	
		Frame frame = new Frame();
		frame.setTitle("Kurzzeitwecker");
		
		//Anmelden eines "anonymen" Listeners, der beim Schließen des Fensters
		//die Anwendung beendet
		frame.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	
		//Canvas zum Frame hinzufügen
		frame.add( etc );
				
		//size Frame to preferred size
		frame.pack();
		
		//locate frame to Center of Screen
		frame.setLocationRelativeTo(null);  //Parameter Null plaziert den Frame
									 		//in der Mitte des Screens
	
		//Visuelle Parameter setzen
		frame.setResizable( false );
		frame.setBackground( Color.BLACK );
		
		//Fenster sichtbar machen
		frame.setVisible(true);
		
		for( int i = 0; i < 4; i++ ){
			//1s Pause
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}//end catch
			
			//"Hochzählen" des Modells um eins
			etm.increaseElapsedTime();
			
			//Anstoßen eines Neuzeichnens des EggTimerCanvas
			etc.repaint();
			
		}//end for
		
	}//end main

}
