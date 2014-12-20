import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShopSupply {

	public static void main(String[] args) {

		// prints info about Supplier, but we don't need it really I guess.
		
//		Supplier supplier = new Supplier ();
//		System.out.println (supplier.toString());
		
		List <ProductSupply> productsupply = new ArrayList <ProductSupply>();
		
		productsupply.add (new ProductSupply (3,"31/10/2014",1000004,1,2438));
		productsupply.add (new ProductSupply (2,"31/10/2014",1000003,1,2755));
		productsupply.add (new ProductSupply (3,"01/11/2014",1000002,2,755));
		productsupply.add (new ProductSupply (1,"31/10/2014",1000001,2,155));
		productsupply.add (new ProductSupply (3,"01/11/2014",1000005,1,2838));
		
			
		// checks function;
		
//			List<ProductSupply> n = getSupplyDocument(productsupply, 3);
//				for (ProductSupply m: n)	{	
//					System.out.println (m.toString());
//			}
		
		// checks function;
//				double amountDocument  = getAmountDocument(productsupply,3);
//				System.out.println ( "Total amount: "+ amountDocument + " " + "UAH");
	
		
		// sorts the List bu Id of supply documents;
		
//	Comparator <ProductSupply> p = new ProductIdDocumentComp ();
//	Collections.sort (productsupply,p);
		//	for (ProductSupply l: productsupply)	{	
			//	System.out.println (l.toString());
		//	}
		
		
		// prints a certain supply document;
		
		PrintSupplyDocument(productsupply,3);
	}
	
	
	// returns the total amount of the certain supply document;
	public static double getAmountDocument(List<ProductSupply>x, int idDocument) {
	
	double amountDocument = 0.0;
	for (ProductSupply p : x ){
		if(p.getIdDocument() == idDocument){
			amountDocument += p.getPurchaseAmount();
	 }
	}return amountDocument;
}
	
	// returns the list of goods in one certain supply document;
	
	public static List<ProductSupply>  getSupplyDocument(List<ProductSupply>x, int idDocument) {
		List <ProductSupply> n = new ArrayList <ProductSupply>();
		for (ProductSupply p : x ){
			if(p.getIdDocument() == idDocument){
				n.add (p);
		 }
		}return n;
	}
	
	// function to print a certain supply document;
	
	public static void PrintSupplyDocument (List<ProductSupply>x, int idDocument){
		List <ProductSupply> n = new ArrayList <ProductSupply>();
		double amountDocument = 0.0;
		System.out.println ("id product" + "  " + "quantity"+ "      " + "price"+ "           " + "total sum" );
		for (ProductSupply p : x ){
			if(p.getIdDocument() == idDocument){
				n.add (p);
				System.out.println (p.toString());
		 		amountDocument += p.getPurchaseAmount();
		 }
		
	} System.out.println ( "_________________________________" + "\n"+"Total amount: "+ amountDocument + " " + "UAH");
	}
	
	
}
	
