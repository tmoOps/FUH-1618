package selftest;

import selftest.PrintableList.ListIterator;

public class ST02_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person("Will Mustermann");
		Person p2 = new Person("tmo");
		Cat c1 = new Cat();
		Book b1 = new Book("Säulen der Erde");
		Book b2 = new Book("Java für Anfänger");
		
		PrintableList pl = new PrintableList();
		pl.addLast( p1 );
		pl.addLast( p2 );
		pl.addLast( c1 );
		pl.addLast( b1 );
		pl.addLast( b2 );
		
		ListIterator iter = pl.listIterator();
		while( iter.hasNext() ) {
			iter.next().print();
		}//end while
		
	}//end main

}//end class
