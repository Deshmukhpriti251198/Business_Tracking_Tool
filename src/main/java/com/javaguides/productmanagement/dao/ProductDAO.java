package com.javaguides.productmanagement.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Blob;

import com.javaguides.productmanagement.model.Product;

public class ProductDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/master?zeroDateTimeBehavior=convertToNull";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Root@123";

    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO PRODUCTS"+"(PRODUCT_NAME,GRADE,UNIT_OF_MEASUREMENT,HS_CODE,MANUFACTURER,COUNTRY,TDS,MSDS,FREE_TRADE_AGREEMENT,IMAGE) VALUES " +
        " (?,?,?,?,?,?,?,?,?,?);";

   
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM products";
    		
    private static final String SELECT_PRODUCT_BY_ID = "select ID,PRODUCT_CODE,PRODUCT_NAME,GRADE,UNIT_OF_MEASUREMENT,HS_CODE,MANUFACTURER,COUNTRY,TDS,MSDS,FREE_TRADE_AGREEMENT,IMAGE from PRODUCTS where ID =?";
    private static final String update_product ="update products SET PRODUCT_CODE = concat(substr(PRODUCT_NAME,1,3),'0000',substr(MANUFACTURER,1,3),ID);";
    private static final String DELETE_PRODUCTS_SQL = "delete from products where ID = ?;";
    private static final String UPDATE_PRODUCTS_SQL = "update products set PRODUCT_NAME=?,GRADE=?,UNIT_OF_MEASUREMENT=?,HS_CODE=?,MANUFACTURER=?,COUNTRY=?,TDS=?,MSDS=?,FREE_TRADE_AGREEMENT=?,IMAGE=? where ID=?;";

    public ProductDAO() {}

    protected Connection getConnection() {
    	Connection connection = null;
        
        try {
        	

        	
        	 Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         return connection;
        
    }

    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCTS_SQL);
        // try-with-resource statement will auto close the connection.
     
        try (Connection connection = getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
            preparedStatement.setString(1, product.getPRODUCT_NAME());
            preparedStatement.setString(2, product.getGRADE());
            preparedStatement.setString(3, product.getUNIT_OF_MEASUREMENT());
            preparedStatement.setInt(4, product.getHS_CODE());
            preparedStatement.setString(5, product.getMANUFACTURER());
            preparedStatement.setString(6, product.getCOUNTRY());
            preparedStatement.setBytes(7, product.getTDS());
            preparedStatement.setBytes(8, product.getMSDS());
            preparedStatement.setBytes(9, product.getFREE_TRADE_AGREEMENT());         
            preparedStatement.setBytes(10, product.getIMAGE());
     
           
            preparedStatement.executeUpdate();         
          
            try (Connection conn = getConnection();
            	
    		        PreparedStatement prepareStatement = conn.prepareStatement(update_product)){
            			prepareStatement.executeUpdate();    		        	
    		        	prepareStatement.close();
    		        	
    		        } catch (SQLException e) {
    		            printSQLException(e);
    		        }
           
        }
        catch (SQLException e) {
            printSQLException(e);
        }
       
    }
    


    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
        	PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL)) {
        	
        	
        	
            	
            	statement.setString(1, product.getPRODUCT_NAME());
            	statement.setString(2, product.getGRADE());
            	statement.setString(3, product.getUNIT_OF_MEASUREMENT());
            	statement.setInt(4, product.getHS_CODE());
            	statement.setString(5, product.getMANUFACTURER());
            	statement.setString(6, product.getCOUNTRY());
             	statement.setBytes(7, product.getTDS());
            	statement.setBytes(8, product.getMSDS());
            	statement.setBytes(9, product.getFREE_TRADE_AGREEMENT());
            	statement.setBytes(10, product.getIMAGE());
            
               
                statement.setInt(11, product.getID()); 
                
    
               rowUpdated = statement.executeUpdate() > 0;
               statement.close();
        }
        return rowUpdated;
    }
        
    
		
            
   



 

    public Product selectProduct(int ID) {
        Product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            
            while (rs.next()) {
                String PRODUCT_CODE = rs.getString("PRODUCT_CODE");
                String PRODUCT_NAME = rs.getString("PRODUCT_NAME");
                String GRADE = rs.getString("GRADE");
                String UNIT_OF_MEASUREMENT = rs.getString("UNIT_OF_MEASUREMENT");
                int HS_CODE = rs.getInt("HS_CODE");
                String MANUFACTURER = rs.getString("MANUFACTURER");
                String COUNTRY = rs.getString("COUNTRY");
                Blob TDS =rs.getBlob("TDS");
                Blob MSDS = rs.getBlob("MSDS");
                Blob FREE_TRADE_AGREEMENT = rs.getBlob("FREE_TRADE_AGREEMENT");
                Blob IMAGE = rs.getBlob("IMAGE");
              
                
                product = new Product(ID,PRODUCT_CODE,PRODUCT_NAME,GRADE,UNIT_OF_MEASUREMENT,HS_CODE,MANUFACTURER,COUNTRY,TDS,MSDS,FREE_TRADE_AGREEMENT,IMAGE);
            }
        } catch (SQLException e) {
            printSQLException(e); 
        }
        return product;
    }

    public List < Product > selectAllProducts() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Product > PRODUCTS = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID=rs.getInt("ID");
            	  String PRODUCT_CODE = rs.getString("PRODUCT_CODE");
                  String PRODUCT_NAME = rs.getString("PRODUCT_NAME");
                  String GRADE = rs.getString("GRADE");
                  String UNIT_OF_MEASUREMENT = rs.getString("UNIT_OF_MEASUREMENT");
                  int HS_CODE = rs.getInt("HS_CODE");
                  String MANUFACTURER = rs.getString("MANUFACTURER");
                  String COUNTRY = rs.getString("COUNTRY");
                  Blob TDS =rs.getBlob("TDS");
                  Blob MSDS = rs.getBlob("MSDS");
                  Blob FREE_TRADE_AGREEMENT = rs.getBlob("FREE_TRADE_AGREEMENT");
                  Blob IMAGE = rs.getBlob("IMAGE");
                
               
                PRODUCTS.add(new Product(ID,PRODUCT_CODE,PRODUCT_NAME,GRADE,UNIT_OF_MEASUREMENT,HS_CODE,MANUFACTURER,COUNTRY,TDS,MSDS,FREE_TRADE_AGREEMENT,IMAGE));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return PRODUCTS;
    }
    
    
		
    
        
    
    public boolean deleteProduct(int ID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
        	PreparedStatement statement1 = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
            statement1.setInt(1, ID);
            rowDeleted = statement1.executeUpdate() > 0;
        }
        return rowDeleted;
    }

 

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

	


}
