

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;



public class ProductSupply {
	private int idDocument;
	private String dateDocument;
	private int idProduct; 
	private int quantity;
	private double purchasePrice;
	
	public ProductSupply () {}
	
	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}
	
	public void setDateDocument( String dateDocument) {
		this.dateDocument = dateDocument;
		}
		
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPurchasePrice(double purchasePrice) {
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

		
		

		
		public  int getIdProduct() {
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
			 return  getIdProduct() +  "        " + getQuantity() +  "        " + getPurchasePrice() + "  " + "UAH"+ "      "
					 +getPurchaseAmount() +  "  " + "UAH" + "  " +  getDateDocument() + "\n"; 
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
				
	public static class Supply {
				    public static ArrayList<ProductSupply> sampleSQL() {

				        ArrayList<ProductSupply> productsupply = new ArrayList<ProductSupply>();

				        try {

				            Class.forName("org.postgresql.Driver");

				        } catch (ClassNotFoundException e) {

				            System.out.println("Where is your PostgreSQL JDBC Driver? ");
				            e.printStackTrace();
				        }

				        Connection connection = null;

				        try {

				            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/NashDom",
				                    "postgres", "345olga");
				            Statement statement = connection.createStatement();

				            String sql = "SELECT * FROM product_supply;";
				            System.out.println(sql);

				            boolean hasResults = statement.execute(sql);

				            if (hasResults) {
				                do {
				                    ResultSet rs = statement.getResultSet();

				                    if (rs != null) {

				                        while (rs.next()) {

				                            ProductSupply productsupplylist = new ProductSupply();
				                            productsupplylist.setIdDocument(rs.getInt(1));
				                            productsupplylist.setIdProduct(rs.getInt(2));
				                            productsupplylist.setQuantity(rs.getInt(3));
				                            productsupplylist.setPurchasePrice(rs.getDouble(4));
				                            productsupplylist.setDateDocument(rs.getString(5));
				                           
				                            productsupply.add(productsupplylist);

				                        }
				                    }
				                } while (statement.getMoreResults());
				            }

				            statement.close();

				            return productsupply;

				        } catch (SQLException e) {

				            System.out.println("Connection Failed! Check output console");
				            e.printStackTrace();
				            return productsupply;

				        }
				    }
				}
}
		

				


