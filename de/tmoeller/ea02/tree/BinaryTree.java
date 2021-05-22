package tree;

public class BinaryTree {

	private static class BinaryNode{
		private BinaryNode leftSon, rightSon;
		
		private int value;
		
		BinaryNode(int value) {
			this.value = value;		
		}//end of BinaryNode
		
		//setter Methoden
		void setLeft( BinaryNode n ) {
			this.leftSon = n;
		}//end of setLeft
		
		void setRight( BinaryNode n) {
			this.rightSon = n;
		}//end of setRight
		
		//getter Methoden
		BinaryNode getLeft() {
			return this.leftSon;
		}//end getLeft
		
		BinaryNode getRight() {
			return this.rightSon;
		}//end getRight		
				
	}//end of class BinaryNode
	
	
	private BinaryNode root, nullNode;
	private String resStr;
	
	public BinaryTree() {
		
		/* erzeugen eines leeren Baums
		
		 * nullNode ist ein Hilfsobjekt und repräsentiert
		 * eine "Pseudoknoten", die leere Verweise und die Blätter
		 * des Baumes kennzeichnen
		*/
		
		//Pseudoknoten erzeugen
		nullNode = new BinaryNode( 0 );
		nullNode.setRight( nullNode );
		nullNode.setLeft( nullNode );
					
	}//end of BinaryTree
	
	
	public BinaryTree(int value) {

		/* erzeugen eines Baums, der lediglich den Wurzelknoten root
		 * enthält
		 */
		
		//Pseudoknoten erzeugen
		nullNode = new BinaryNode( 0 );
		nullNode.setRight( nullNode );
		nullNode.setLeft( nullNode );
		
		root = new BinaryNode( value );
		root.setLeft( nullNode );
		root.setRight( nullNode );
		
	}//end of BinaryTree constructor
	
	
	public boolean contains (int value) {
		
		/* 
		 * Suche startet bei Root und durchläuft den Baum
		 * gemäß der definierten Ordnung. Im linken Teilbaum sind
		 * alle Werte kleiner als root.value. Im rechten Teilbaum
		 * sind alle Werte größer als root.value
		 */
			
		BinaryNode searchNode = root;
		
		while ( searchNode != nullNode ) {
			
			if( searchNode.value == value )
				return true;
			
			if( searchNode.value < value ) {
				searchNode = searchNode.getRight();
			}//end if
			else {
				if( searchNode.value > value )
					searchNode = searchNode.getLeft();
			}//end else
			
		}//end while
				
		return false;
		
	}//end of contains
	
	
	public void insert( int value ) {
				
		/* Abfrage, ob ein Wurzelknoten bereits vorhanden ist
		*/
		if( root == null ) {
		
			/* Wurzel nicht vorhanden, 
			 * dann Wurzel neu anlegen
			*/ 
			root = new BinaryNode( value );
			root.setLeft( nullNode );
			root.setRight( nullNode );
			
			return;
		}//end if
		
		/*
		 * Wurzel vorhanden
		 */

		//neuen Blattknoten anlegen
		BinaryNode newNode = new BinaryNode( value );
		newNode.setLeft( nullNode );
		newNode.setRight( nullNode );
			
		BinaryNode compareNode = root;
		
		while( compareNode != nullNode ){
			
			//value Vergleich
			if( value < compareNode.value ) {
				
				//wenn der unterste Knoten im linken Teilbaum
				//erreicht wurde, dann neuen Blattknoten einfügen
				//und abbrechen
				//wenn unterster Knoten nicht erreicht wurden,
				//dann weiter navigieren
				if( compareNode.getLeft() == nullNode ) {
					compareNode.setLeft( newNode );
					return;
				}//end if
				else {
					compareNode = compareNode.getLeft();
				}//end else
			
			}//end if
			else {
				
				if( value > compareNode.value ) {
					
					//wenn der unterste Knoten im rechten Teilbaum
					//erreicht wurde, dann neuen Blattknoten einfügen
					//und abbrechen
					//wenn unterster Knoten nicht erreicht wurden,
					//dann weiter navigieren
					if( compareNode.getRight() == nullNode ) {
						compareNode.setRight( newNode );
						return;
					}//end if
					else {
						compareNode = compareNode.getRight();
					}//end else
										
				}//end if
				else { //bei Gleichheit abbrechen
				  return;
				}//end else
			
			}//end else
			
				
		}//end while
						
		
	}//end of insert
		
	//Hilfsfunktion für inorder
	private void inorderRek( BinaryNode k ) {
		//rekursives Durchlaufen des Baumes
		if( k != nullNode ) {
			
			//Teilbaum links
			inorderRek( k.getLeft() );
		
			resStr += Integer.toString( k.value ) + " -> ";
		
			//Teilbaum rechts
			inorderRek( k.getRight() );
		}//end if
			
	}//end of inorderRek
	
	
	public void inorder() {
		resStr = new String();
		inorderRek( root );
		System.out.println( resStr );		
	}//end of inorder
		
	
}//end of class BinaryTree
