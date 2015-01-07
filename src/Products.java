import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Products {
	
	private int idProduct; 
	private String article;
	private String productGroup;
	private String description;
	private double lastPurchasePrice;
	private double retailPrice;
	private int actualQuantity;
	public Products () {}
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getProductGroup() {
		return productGroup;
	}
	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getLastPurchasePrice() {
		return lastPurchasePrice;
	}
	public void setLastPurchasePrice(double lastPurchasePrice) {
		this.lastPurchasePrice = lastPurchasePrice;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public int getActualQuantity() {
		
		return actualQuantity;
	}
	public void setActualQuantity(int actualQuantity) {
		this.actualQuantity = actualQuantity ;
		}
	
	public String toString(){
		 return  getIdProduct() +  "   " + getArticle() +  "   " + getProductGroup() +  "        " 
	+ getDescription() + "  " + getLastPurchasePrice() + "  " +"UAH" + "  " 
	+ getRetailPrice() + "  "  +"UAH"+ "      " + getActualQuantity() + "\n"; 
	 }

	 
	
	public static class Product {
	    public static ArrayList<Products> sampleSQL() {

	        ArrayList<Products> products = new ArrayList<Products>();

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

	            String sql = "SELECT * FROM products;";
	            System.out.println(sql);

	            boolean hasResults = statement.execute(sql);

	            if (hasResults) {
	                do {
	                    ResultSet rs = statement.getResultSet();

	                    if (rs != null) {

	                        while (rs.next()) {

	                            Products product = new Products();
	                            product.setIdProduct(rs.getInt(1));
	                            product.setArticle(rs.getString(2));
	                            product.setProductGroup(rs.getString(3));
	                            product.setDescription(rs.getString(4));
	                            product.setLastPurchasePrice(rs.getDouble(5));
	                            product.setRetailPrice(rs.getDouble(6));
	                            product.setActualQuantity(rs.getInt(7));

	                            products.add(product);

	                        }
	                    }
	                } while (statement.getMoreResults());
	            }

	            statement.close();

	            return products;

	        } catch (SQLException e) {

	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	            return products;

	        }
	    }

	}
	
			
	}
