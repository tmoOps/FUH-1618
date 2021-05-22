package BinaryTree;

public class BinaryTree<T extends Comparable<T>> {

    private BinaryNode root;

    public BinaryTree(T value) { 
		/* erzeugen eines Baums, der lediglich den Wurzelknoten root enthält
		 */
		root = new BinaryNode( value );
		root.setLeft( null );
		root.setRight( null );
    }//end of constructor

    public BinaryTree() { 
    	/* ... 
    	*/ 
    }

    public boolean contains(T value) { 
		/* 
		 * Suche startet bei Root und durchläuft den Baum
		 * gemäß der definierten Ordnung. Im linken Teilbaum sind
		 * alle Werte kleiner als root.value. Im rechten Teilbaum
		 * sind alle Werte größer als root.value
		 */
		
		BinaryNode searchNode = root;
		
		while ( searchNode != null ) {
			
			if( searchNode.value.compareTo(value) == 0 )
				return true;
			
			if( searchNode.value.compareTo(value) < 0 ) {
				searchNode = searchNode.getRight();
			}//end if
			else {
				if( searchNode.value.compareTo(value) > 0 )
					searchNode = searchNode.getLeft();
			}//end else
			
		}//end while
				
		return false;
    }

    public void insert(T value) { 
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
			if( value.compareTo( compareNode.value ) < 0 ) {
				
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
				
				if( value.compareTo( compareNode.value) > 0 ) {
					
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
    }

    public void inorder() { 
		root.inOrderTraversal( root );
		System.out.println();
    }//end of inorder

    
    private class BinaryNode implements Comparable<BinaryNode> {
        private BinaryNode leftSon, rightSon;

        private T value;

        public BinaryNode(T value) {
            this.value = value;
        }
        
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
		
		@Override
		public int compareTo(BinaryNode o) {
			return value.compareTo( o.value  );
		}//end CompareTo
		
    }//end class BinaryNode
	
}//end of class BinaryTree
