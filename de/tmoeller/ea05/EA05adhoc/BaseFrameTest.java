package EA05adhoc;

import java.awt.*;
import java.awt.event.*;

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
