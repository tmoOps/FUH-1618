package tree;

public class BinaryTree2 {

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
		
		void inOrderTraversal( BinaryNode k ) {
			/* inorder Traversal - Ergebnis wird auf system.out ausgegeben
			 */
			if( k != null ) {
				//Teilbaum links
				inOrderTraversal( k.getLeft() );
						
				System.out.print( k.value + " -> " );
								
				//Teilbaum rechts
				inOrderTraversal( k.getRight() );
			}//end if
		}//end inOrderTraversal

	}//end of class BinaryNode
	
	
	private BinaryNode root, nullNode;
	
	public BinaryTree2() {
		/* erzeugen eines leeren Baums */		
	}//end of BinaryTree
	
	
	public BinaryTree2(int value) {

		/* erzeugen eines Baums, der lediglich den Wurzelknoten root
		 * enthält
		 */
		root = new BinaryNode( value );
		root.setLeft( null );
		root.setRight( null );
		
	}//end of BinaryTree constructor
	
	
	public boolean contains (int value) {
		/* 
		 * Suche startet bei Root und durchläuft den Baum
		 * gemäß der definierten Ordnung. Im linken Teilbaum sind
		 * alle Werte kleiner als root.value. Im rechten Teilbaum
		 * sind alle Werte größer als root.value
		 */
		
		BinaryNode searchNode = root;
		
		while ( searchNode != null ) {
			
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
			root.setLeft( null );
			root.setRight( null );
			
			return;
		}//end if
		
		/*
		 * Wurzel vorhanden
		 */

		//neuen Blattknoten anlegen
		BinaryNode newNode = new BinaryNode( value );
		newNode.setLeft( null );
		newNode.setRight( null );
			
		BinaryNode compareNode = root;
		
		while( compareNode != null ){
			
			//value Vergleich
			if( value < compareNode.value ) {
				
				//wenn der unterste Knoten im linken Teilbaum
				//erreicht wurde, dann neuen Blattknoten einfügen
				//und abbrechen
				//wenn unterster Knoten nicht erreicht wurden,
				//dann weiter navigieren
				if( compareNode.getLeft() == null ) {
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
					if( compareNode.getRight() == null ) {
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
		
	
	public void inorder() {
		if( root != nullNode ) {	
			root.inOrderTraversal( root );
			System.out.println();
		}//end if
		
	}//end of inorder
		
	
}//end of class BinaryTree2
