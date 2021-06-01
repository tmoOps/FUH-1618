package EA05adhoc;

import java.awt.*;
import java.awt.event.*;

class BaseFrame extends Frame {
	
	private static final long serialVersionUID = -8480567910224491104L;

	public BaseFrame() {
		//ClosingBeaobachter als anonyme Klasse direkt im Konstruktor
		//implementieren
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	
		setSize( 300, 400 );

		setLocationRelativeTo(null); //Parameter Null plaziert den Frame
									 //in der Mitte des Screens
	}//end constructor
	
}//end BaseFrame

public class BaseFrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new BaseFrame();
		f.setLayout( new FlowLayout());
		
		Button exitButton = new Button("Programm beenden");
		exitButton.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		f.add( new Label("test"));
		f.add(exitButton);
		
		f.setVisible(true);
	}//end main

}
