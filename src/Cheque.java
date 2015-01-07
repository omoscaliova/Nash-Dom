import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Cheque {
	private int idCheque;
	private String dateCheque;
	private int idShop;
	private double chequeAmount;
	public Cheque() {}
	public int getIdCheque() {
		return idCheque;
	}
	public void setIdCheque(int idCheque) {
		this.idCheque = idCheque;
	}
	public String getDateCheque() {
		return dateCheque;
	}
	public void setDateCheque(String dateCheque) {
		this.dateCheque = dateCheque;
	}
	public int getIdShop() {
		return idShop;
	}
	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}
	public double getChequeAmount() {
		return chequeAmount;
	}
	public void setChequeAmount(double chequeAmount) {
		this.chequeAmount = chequeAmount;
	}
	public String toString(){
		 return  getIdCheque() +  "        " + getDateCheque() +  "        " + 
	getChequeAmount() +   "\n"; 
	 }

	public static class Cheques {
	    public static ArrayList<Cheque> sampleSQL() {

	        ArrayList<Cheque> cheques = new ArrayList<Cheque>();

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

	            String sql = "SELECT * FROM cheque;";
	            System.out.println(sql);

	            boolean hasResults = statement.execute(sql);

	            if (hasResults) {
	                do {
	                    ResultSet rs = statement.getResultSet();

	                    if (rs != null) {

	                        while (rs.next()) {

	                            Cheque chequeslist = new Cheque();
	                            chequeslist.setIdCheque(rs.getInt(1));
	                            chequeslist.setDateCheque(rs.getString(2));
	                            chequeslist.setChequeAmount(rs.getDouble(4));
	                            
	                           
	                            cheques.add(chequeslist);

	                        }
	                    }
	                } while (statement.getMoreResults());
	            }

	            statement.close();

	            return cheques;

	        } catch (SQLException e) {

	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	            return cheques;

	        }
	    }
	}

}
