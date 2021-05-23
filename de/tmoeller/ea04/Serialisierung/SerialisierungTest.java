package Serialisierung;

import java.io.*;
import java.util.*;

public class SerialisierungTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Node root = new Node("root");
		Node n1 = new Node("1");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Node n4 = new Node("4");
		Node n5 = new Node("5");
		Node n6 = new Node("6");
		Node n7 = new Node("7");
		
		root.addEdgeTo(n7);
		root.addEdgeTo(n2);
		n2.addEdgeTo(n3);
		n3.addEdgeTo(n4);
		n4.addEdgeTo(n5);
		n5.addEdgeTo(n3);
		n3.addEdgeTo(n6);
		n1.addEdgeTo(n7);
		n7.addEdgeTo(n1);
		n6.addEdgeTo(n1);
		/*1*/
		ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("foo1"));
		oos1.writeObject(n2);
		oos1.close();
		ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("foo2"));
		oos2.writeObject(n7);
		oos2.close();
		root = new Node("root");
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("foo1"));
		root.addEdgeTo((Node) ois1.readObject());
		ois1.close();
		ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("foo2"));
		root.addEdgeTo((Node) ois2.readObject());
		ois2.close();
		/*2*/
		}
}

class Node implements Serializable{
	private static final long serialVersionUID = 1L;
	String value;

	private List<Node> edgesTo = new ArrayList<Node>();

	public Node(String value) {
		this.value = value;
	}

	void addEdgeTo(Node node) {
		edgesTo.add(node);
	}
}