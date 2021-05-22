package BinaryTree;

public class TestBinaryTreeEA4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree<String> myTree = new BinaryTree<String>( new String("Test") );
		myTree.insert( new String("Studium") );
		myTree.insert( new String("1618") );
		myTree.insert( new String("Fernuni Hagen") );
		myTree.insert( new String("Professor") );
		myTree.insert( new String("Bibliothek") );
		//myTree.insert(7);
		//myTree.insert(8);
		myTree.inorder();	
		
		String value = new String("Professor");
		String str;
		str = myTree.contains(value) ?	" wurde gefunden im Baum." : " wurde nicht gefunden im Baum.";
		
		System.out.println( value + str );	
		
	}//end main

}//end class 
