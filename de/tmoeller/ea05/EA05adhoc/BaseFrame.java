package EA05adhoc;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BaseFrame extends Frame {
	
	private static final long serialVersionUID = -8480567910224491104L;

	public BaseFrame() {
		
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	
		//set preferred size
		setPreferredSize( new Dimension( 320, 340));
		
		//size Frame to preferred size
		pack();
		
		//locate frame to Center of Screen
		setLocationRelativeTo(null); //Parameter Null plaziert den Frame
									 //in der Mitte des Screens
	}//end constructor
	
}//end BaseFrame
