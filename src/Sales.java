import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Sales {
	
	private int idCheque;
	private int idProduct;
	private int salesQuantity;
	public Sales () {}
	
	public int getIdCheque() {
		return idCheque;
	}
	public void setIdCheque(int idCheque) {
		this.idCheque = idCheque;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(int salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	public String toString(){
		 return  getIdCheque() +  "        " + getIdProduct() +  "        " + 
	getSalesQuantity() +   "\n"; 
	 }
	
	public static class Sale {
	    public static ArrayList<Sales> sampleSQL() {

	        ArrayList<Sales> sales = new ArrayList<Sales>();

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

	            String sql = "SELECT * FROM sales;";
	            System.out.println(sql);

	            boolean hasResults = statement.execute(sql);

	            if (hasResults) {
	                do {
	                    ResultSet rs = statement.getResultSet();

	                    if (rs != null) {

	                        while (rs.next()) {

	                            Sales productsaleslist = new Sales();
	                            productsaleslist.setIdCheque(rs.getInt(1));
	                            productsaleslist.setIdProduct(rs.getInt(2));
	                            productsaleslist.setSalesQuantity(rs.getInt(3));
	                            
	                           
	                            sales.add( productsaleslist);

	                        }
	                    }
	                } while (statement.getMoreResults());
	            }

	            statement.close();

	            return sales;

	        } catch (SQLException e) {

	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	            return sales;

	        }
	    }
	}

}
