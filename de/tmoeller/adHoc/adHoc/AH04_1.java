package adHoc;

import java.util.NoSuchElementException;

class ListWithArray<ET>{
	
	//private ET[] elements;
	private Object[] elements;
	private int nextFreeIndex = 0;
	
	private void doubleSizeOfElementsArray() {
		//ET[] doubleSizedArray = new ET[ elements.length*2 ];
		Object[] doubleSizedArray = new Object[ elements.length*2 ];
		System.arraycopy(elements, 0, doubleSizedArray, 0, elements.length );
		elements = doubleSizedArray;
	}//end doublePersonArray
	
	public ListWithArray( int initialSizeOfArray ) {
		//elements = new ET[ (initialSizeOfArray<1? 1 : initialSizeOfArray ];
		elements = new Object[ (initialSizeOfArray<1? 1 : initialSizeOfArray) ];
	}//end ListWithArray
	
	public void addLast( ET element ) {
		
		if( nextFreeIndex >= elements.length ) {
			doubleSizeOfElementsArray();
		}//end if
		
		elements[nextFreeIndex] = element;
		nextFreeIndex++; //Indexzähler
	}//end addLast
	
	@SuppressWarnings("unchecked")
	public ET getLast() {
		if( nextFreeIndex == 0) {
			throw new NoSuchElementException(); 
		}//end if
		return (ET)elements[nextFreeIndex-1];
	}//end getLast
	
	@SuppressWarnings("unchecked")
	public ET removeLast() {
		if( nextFreeIndex == 0) {
			throw new NoSuchElementException(); 
		}//end if
		//ET savedElement = elements[nextFreeIndex-1];
		
		Object savedElement = elements[nextFreeIndex-1];
		nextFreeIndex--;
		
		//Da Referenzen auf Instanzen im Array gespeichert sind
		//wird durch das Setzen des Werts auf null der Garbage
		//Collector aufgefordert, das Object aus dem Speicher zu löschen
		elements[nextFreeIndex] = null;
		
		return (ET)savedElement;
	}//end removeLast
	
	public int getSize() {
		return nextFreeIndex;
	}//end getSize
		
}//end of class ListWithArray


public class AH04_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListWithArray<String> myList = new ListWithArray<String>(3);
		myList.addLast("1");
		myList.addLast("2");
		myList.addLast("3");
		
		myList.addLast("4");//Test, ob Verdoppelung der Größe funktioniert
	
		while( myList.getSize()>0 ) {
			System.out.println( "Element: " + myList.removeLast() );
		}//end while
		
	}

}
