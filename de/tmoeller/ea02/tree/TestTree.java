package tree;

public class TestTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree myTree = new BinaryTree(6);
		myTree.insert(5);
		myTree.insert(4);
		myTree.insert(12);
		myTree.insert(11);
		myTree.insert(10);
		myTree.insert(7);
		myTree.insert(8);
		myTree.inorder();	
		
		int value = 8;
		String str;
		str = myTree.contains(value) ?	" wurde gefunden im Baum." : " wurde nicht gefunden im Baum.";
		
		System.out.println( Integer.toString(value) + str );
						
	}//end of main

}//end of TestTree
