package Subtyping;

class ListWithInternalArray{
	
	private Object[] ArrayImpl; 
	
	public void add( Object elem, int index ) {
		
		//inital erzeugen, sofern das Array noch nicht existiert
		if( ArrayImpl == null ) {
			ArrayImpl = new Object[1];
		}//end if
		else {
			//neues Array anlegen
			Object[] newArrayImpl = new Object[ index+1 ];
		
			//alte Inhalte kopieren
			System.arraycopy(ArrayImpl, 0, newArrayImpl, 0, index );
		
			ArrayImpl = newArrayImpl;
		}//end else
		
		ArrayImpl[index] = elem;
	}//end add
	
	public Object getElementAt( int index ) {
		return ArrayImpl[index];
	}//end getElementAt
	
	public Object removeElementAt( int index ) {
		
		Object res = ArrayImpl[index];

		//neues Array anlegen mit einem Element weniger als ArrayImpl
		Object[] newArrayImpl = new Object[ ArrayImpl.length - 1 ];
		
		if( index == 0 ) {//Abfrage ob erstes Element im Array
			System.arraycopy( ArrayImpl, 1, newArrayImpl, 0, ArrayImpl.length-1 );
		}//end if
				
		if( index == ArrayImpl.length - 1) {//Abfrage auf letztes Element im Array
			System.arraycopy( ArrayImpl, 0, newArrayImpl, 0, ArrayImpl.length-1 );
		}//end if
		
		if( index > 0 && index < ArrayImpl.length-1 ) {//Index liegt zwischen 1 und Länge-1
			//Bereich von 0 bis index kopieren
			System.arraycopy( ArrayImpl, 0, newArrayImpl, 0, index );
			//Bereich von index bis Ende kopieren
			System.arraycopy( ArrayImpl, index+1, newArrayImpl, index, ArrayImpl.length-index-1);
		}//end if
		
		ArrayImpl = newArrayImpl;
				
		return res;
	}//end removeElementAt
	
	public int getSize() {
		return ArrayImpl.length;
	}//end getSize
	
}//end of class ListWithInternalArray


public class Stapel extends ListWithInternalArray{

	private int size = 0;
	
	//legt ein Element auf den Stapel
	public void push( Object element ) {
	
		//Einfügen eines neuen Elements am Ende der Liste
		super.add( element, size);
		size++;
	}//end push
	
	//liefert eine Referenz auf das oberste Element des Stapels
	public Object peek() {
		return super.getElementAt( size-1 );
	}//end peek
	
	//entfernt das oberste Element im Stapel und gibt das
	//Element zurück
	public Object pop() {
		size--;
		return super.removeElementAt( size );
	}//end pop
	
	
	public boolean isEmpty() {
		return ( super.getSize()==0 ? true : false ); 
	}//end is Empty
	
}//end of class Stapel
