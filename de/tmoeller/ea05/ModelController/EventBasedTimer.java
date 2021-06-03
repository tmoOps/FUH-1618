package ModelController;

import java.util.*;

interface TickListener{
	void tickPerformed();
}

//Instanzen der Klasse EventBasedTimer sind ereignisbasierte Timer. Man kann bei
//Ihnen mit der Methode addTickListener Objekte des Typs TickListener als Beobachter
//anmelden
//Wenn der Timer gestartet wird, werden alle angemeldeten Beobachter im Sekundentakt
//durch Aufruf ihrer Methode tickPerformed informiert, solange der Timer läuft
//Der Timer kann mit start gestartet und mit stop beendet werden
public class EventBasedTimer {

	private Timer internalTimer = new Timer();
	
	private List<TickListener> listeners = new ArrayList<TickListener>();
	
	//meldet einen TickListener beim Timer an
	public void addTickListener( TickListener listener ) {
		listeners.add( listener );
	}//end of addTickListener
	
	//startet diesen Timer
	public void start() {
		internalTimer.scheduleAtFixedRate( new TimerTask() {
			@Override
			public void run() {
				for ( TickListener tickListener : listeners ) {
					tickListener.tickPerformed();
				}//end for
			}//end run	
		}, 1000, 1000);
	}//end of start
	
	public void stop() {
		internalTimer.cancel();
	}//end of stop
	
}
