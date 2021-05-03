package adHoc;


interface Weightable{
	double getWeight();	
}//end of interface


interface Printable{
	void print();
}//end of interface


class Dog implements Weightable{
	
	private String name;
	private double weight;	
	
	Dog( String name, double weight ){
		this.name = name;
		this.weight = weight;
	}//end of constructor
	
	public String getName() {
		return name;
	}//end of getName
	
	public double getWeight() {
		return weight;
	}//end of getWeight
	
}//end class Dog


class PostalItem implements Weightable{
	
	private String sender;
	private String adressee;
	private double weight;
	
	PostalItem( String sender, String adressee, double weight ){
		this.sender = sender;
		this.adressee = adressee;
		this.weight = weight;
	}//end of constructor
	
	public String getSender() {
		return sender;
	}//end getSender
	
	public String getAdressee() {
		return adressee;
	}//end getAdressee
		
	public double getWeight() {
		return weight;
	}//end getWeigth
	
}//end PostalItem


class Parcel extends PostalItem{

	Parcel( String sender, String adressee, double weight ){
		super( sender, adressee, weight );
	}//end constructor
	
}//end class Parcel


class Letter extends PostalItem implements Printable{
	
	Letter( String sender, String adressee, double weight ){
		super( sender, adressee, weight );
	}//end constructor
	
	public void print() {
		System.out.println( "Ich bin ein Brief, gesendet von: " + getSender() );
		System.out.println( "gesendet an: " + getAdressee() );
		System.out.println( "Gewicht: " + getWeight() );
	}//end print
	
}//end PostalItem


class PDFDocument implements Printable{
	
	private String nameOfDocument;
	
	PDFDocument( String nameOfDocument ){
		this.nameOfDocument = nameOfDocument;
	}//end constructor
	
	public void print() {
		System.out.println( "Ich bin das PDFDokument mit dem Namen " + nameOfDocument );
	}//end of print
	
}//end class PDFDocument



public class AH03_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
