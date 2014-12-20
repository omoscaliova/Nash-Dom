
import java.util.Comparator;


public class ProductSupply {
	private int idDocument ;
	private String  dateDocument = "31.10.2014";
	private int idProduct;
	private int quantity;
	private double purchasePrice;
	
	
	public ProductSupply (int idDocument, String dateDocument, int idProduct, int quantity, double purchasePrice){
	this.idDocument = idDocument;
	this.dateDocument = dateDocument;
	this.idProduct = idProduct;
	this.quantity = quantity;
	this.purchasePrice = purchasePrice;
	
	}
	
	
		

		public int getIdDocument() {
			if (idDocument < 1){
				return -1;
			}
			else {
				return idDocument;
			}
			}
		


		public String getDateDocument() {
			
			return dateDocument;
		}

		
		

		
		public int getIdProduct() {
			return idProduct;
		}

		
		public int getQuantity() {
			return quantity;
		}

		
		public double getPurchasePrice() {
			return purchasePrice;
		}

		
		public double getPurchaseAmount() {
			return purchasePrice * quantity;
		}
		
		
		
		
		 public String toString(){
			 return  idProduct +  "        " + quantity +  "        " + purchasePrice + "  " + "UAH"+ "      " +getPurchaseAmount() +  "  " + "UAH"; 
		 }
		 
		
} 
		class ProductIdDocumentComp implements Comparator <ProductSupply> {
				public int  compare (ProductSupply a,ProductSupply b) {
					double x = a.getIdDocument() - b.getIdDocument();
					int result = 0;
					if (x==0.0) result = 0;
					else if (x< 0.0) result = -1;
					else result = 1;
				return result;
			}
		
}

