package AWTZeichnen;

import java.awt.*;

public class EggTimerCanvas extends Canvas {
		
	private static final long serialVersionUID = 8955144650320309224L;
	
	private EggTimerModel etm;
	
	public EggTimerCanvas( EggTimerModel etm ) {
		this.etm = etm;
		setPreferredSize( new Dimension( 320, 320));
	}//end constructor
			
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		int diameter = 300;
		double correctionFactor = 0;
		
		//Darstellung erfolgt über Overlay, d.h. es werden
		//2 Kreise übereinander gelegt, grün entspricht dem unteren Kreis,
		//rot dem oberen.
		//Der obere rote Kreis wird anteilig um die vergangenen Sekunden in
		//der Gradzahl gekürzt, also 360 Grad - anteiliger Kürzung
		//die Kürzung kann berechnet werden über das Modell
		//(etm.getElapsedPart() * 60 * 360)/60
		
		g.setColor(Color.GREEN);
		g.fillArc( 10, 10, diameter, diameter, 0, 360 );
		
		g.setColor( Color.RED);
		correctionFactor = (etm.getElapsedPart()*60*360)/60;
		
		g.fillArc( 10, 10, diameter, diameter, 90, 360 - (int)correctionFactor );
		
	}//end paint
	
}
