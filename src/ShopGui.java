import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ShopGui {

	public static void main(String[] args) {
		
		
//	        ArrayList<Products> products = new ArrayList <Products>();
//	        products = Products.Product.sampleSQL();
//	     	System.out.println (products.toString());	
//
//	     	
//	     	ArrayList<ProductSupply> productsupply = new ArrayList <ProductSupply>();
//		    productsupply = ProductSupply.Supply.sampleSQL();
//		    System.out.println (productsupply.toString());
//		    
//		    ArrayList<Sales> sales = new ArrayList <Sales>();
//		    sales = Sales.Sale.sampleSQL();
//		    System.out.println (sales.toString());	
//		    
//		    ArrayList<Cheque> cheques = new ArrayList <Cheque>();
//		    cheques = Cheque.Cheques.sampleSQL();
//		    System.out.println (cheques.toString());
//		    
//		    
		            EventQueue.invokeLater(new Runnable() {
		                @Override
		                public void run() {
		                    ShopJFrame frame = new ShopJFrame();
		                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                    frame.setVisible(true);
		                }
		            });
		        }
		        public static ArrayList<Products> products() {
		            ArrayList<Products> products;
		            products = Products.Product.sampleSQL();
		            return products;
		        }
		        public static ArrayList<ProductSupply> supply() {
		            ArrayList<ProductSupply> productsupply;
		            productsupply = ProductSupply.Supply.sampleSQL();
		            return productsupply;
		        }
		    }

		    class ShopJFrame extends JFrame {


		        /**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				public ShopJFrame() {
		            setTitle("Shop");
		            setSize(DEFAULT_WIDTH, DEFAULT_HEIGTH);

		            ShopJPanel panel = new ShopJPanel();
		            add(panel);

		        }

		        public static final int DEFAULT_WIDTH = 1000;
		        public static final int DEFAULT_HEIGTH = 700;
		    }

		    class ShopJPanel extends JPanel {
		        /**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				public ShopJPanel() {

		            setLayout(new BorderLayout());

//		            textArea = new JTextArea("");
//		            textArea.setEnabled(false);
//		            add(textArea, BorderLayout.NORTH);
//		            text = new JTextArea("");
//		            text.setEnabled(false);
//		            add(text, BorderLayout.SOUTH);

		            ActionListener insert = new InsertAction();

		            panel = new JPanel();
//		            panel.setLayout(new GridLayout());

		            addButton("Report", insert);
		            addButton("Sales", insert);
		            addButton("Products", insert);
		            addButton("Supply", insert);

		            panel.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		            panel.add(new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		            add(panel, BorderLayout.CENTER);
		        }

		        private void addButton(String label, ActionListener listener) {
		            JButton button = new JButton(label);
		            button.addActionListener(listener);
		            panel.add(button);
		        }

		        public class InsertAction implements ActionListener {

		            @Override
		            public void actionPerformed(ActionEvent event) {
		                String input = event.getActionCommand();
		                if (input.equals("Report")) {
		                    
		                }
		                if (input.equals("Sales")) {
		                	
		                }
		                if (input.equals("Products")) {
		                	ArrayList<Products> products;
		                    products = ShopGui.products();

		                    textArea.getClientProperty(products);
		                    textArea.setText(String.valueOf(products));
		                }
		                if (input.equals("Supply")) {
		                	ArrayList<ProductSupply> productsupply;
		                    productsupply = ShopGui.supply();

		                    textArea.getClientProperty(productsupply);
		                    textArea.setText(String.valueOf(productsupply));

		                }
		            }
		        }
		    

		        private JPanel panel;
		        private JTextArea textArea = new JTextArea(20, 60);
		        private JTextArea text = new JTextArea(20, 20);
		    
	

}


