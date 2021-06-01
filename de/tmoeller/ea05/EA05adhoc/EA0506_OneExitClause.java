package EA05adhoc;

import java.awt.*;
import java.awt.event.*;


//beide Listener Methoden implementieren für Button und für das Hauptfenster (Frame)
class ProgramExitClause extends WindowAdapter implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ExitProgramm();
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		ExitProgramm();
	}
	
	private void ExitProgramm() {
		System.exit(0);
	}
	
}//end ProgramExitClause

public class EA0506_OneExitClause {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame();
		
		ProgramExitClause pec = new ProgramExitClause();
				
		f.addWindowListener(pec);
		f.setLayout( new FlowLayout() );
		
		Button btn = new Button("Programm verlassen");
		btn.addActionListener(pec);
		
		f.add(btn);
		f.setSize( 300, 400 );
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
