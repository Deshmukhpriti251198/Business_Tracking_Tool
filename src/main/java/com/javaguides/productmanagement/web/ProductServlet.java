package com.javaguides.productmanagement.web;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.Blob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.javaguides.productmanagement.dao.ProductDAO;
import com.javaguides.productmanagement.model.Product;



@WebServlet("/")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	  
  			

  			response.setContentType("text/html");
  			  PrintWriter out = response.getWriter();
  			  Connection conn = null;
  			  String url = "jdbc:mysql://localhost:3306/";
  			  String dbName = "master";
  			  String driver = "com.mysql.cj.jdbc.Driver";
  			  String userName = "root"; 
  			  String password = "Root@123";
  			  Statement st=null;
  			  try {
  			  Class.forName(driver).newInstance();
  			  
  			  conn = DriverManager.getConnection(url + dbName, userName, password);
  			  System.out.println("Connected to the database");
  			  String  PRODUCT_NAME= request.getParameter("txtContent");
  			

  			  ArrayList al=null;
  			  ArrayList emp_list =new ArrayList();
  			 String query ="SELECT * FROM products WHERE PRODUCT_NAME LIKE '%" +PRODUCT_NAME+ "%'";
  			 //"SELECT * FROM users WHERE company_name LIKE=?";
  		// "select * from users where company_name LIKE '%company_name%' and country LIKE '%country%' and state LIKE '%state%' and city LIKE '%city%'";			 
  					 // "SELECT * FROM users WHERE company_name LIKE '%" +company_name+ "%'";
  					// "select * from users where company_name LIKE '%company_name%' or country LIKE '%country%' or state LIKE '%state%' or city LIKE '%city%' ";
  					// "SELECT * FROM users WHERE company_name LIKE ('%" +company_name+ "%') OR country LIKE ('%" +country + "%')OR state LIKE ('%" +state + "%')OR city LIKE ('%" +city + "%')";
 //String query="SELECT * FROM users  WHERE CustomerName LIKE '%".$search."%' OR Address LIKE '%".$search."%' OR City LIKE '%".$search."%'OR PostalCode LIKE '%".$search."%'OR Country LIKE '%".$search."%';";
  		  System.out.println("query " + query);
  			  st = conn.createStatement();
  			  ResultSet  rs = st.executeQuery(query);


  			  while(rs.next()){
  			  al  = new ArrayList();
  			  
  			  al.add(rs.getString(1));
  			  al.add(rs.getString(2));
  			  al.add(rs.getString(3));
  			  al.add(rs.getString(4));
  			  al.add(rs.getString(5));
  			  al.add(rs.getString(6));
  			  al.add(rs.getString(7));
  			  al.add(rs.getString(8));
  			  al.add(rs.getString(9));
  			  al.add(rs.getString(10));
  			  al.add(rs.getString(11));
  			  al.add(rs.getString(12));
  			
  			  System.out.println("al :: "+al);
  			  emp_list.add(al);
  			  }

  			  request.setAttribute("empList",emp_list);
  			  
  			// System.out.println("empList " + emp_list);

  			  // out.println("emp_list " + emp_list);

  			  // String nextJSP = "/viewSearch.jsp";
  			  RequestDispatcher dispatcher = 
  			   request.getRequestDispatcher("viewSearch.jsp");
  			  dispatcher.forward(request,response);
  			
  			  conn.close();
  			  System.out.println("Disconnected from database");
  			  } catch (Exception e) {
  			  e.printStackTrace();
  			  }
  			  }
  			
  		
    	
    	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertProduct(request, response);
                    break;
               
                case "/update_product":
                	updateProductCode(request,response);
                	break;
                case "/update":
                    updateProduct(request, response);
                    break;
             
                case "/delete":
                    deleteProduct(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    

	private void listProduct(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Product > listProduct = productDAO.selectAllProducts();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }
    
   
    private void updateProductCode(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
    	        dispatcher.forward(request, response);
    	    }
    

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        Product existingProduct= productDAO.selectProduct(ID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
       

    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    
    
        String PRODUCT_NAME = request.getParameter("PRODUCT_NAME");
        String GRADE = request.getParameter("GRADE");
        String UNIT_OF_MEASUREMENT = request.getParameter("UNIT_OF_MEASUREMENT");
        int HS_CODE = Integer.parseInt(request.getParameter("HS_CODE"));
        String MANUFACTURER = request.getParameter("MANUFACTURER");
        String COUNTRY = request.getParameter("COUNTRY");
        Part TDS =request.getPart("TDS");
        Part MSDS = request.getPart("MSDS");
        Part FREE_TRADE_AGREEMENT = request.getPart("FREE_TRADE_AGREEMENT");
        Part IMAGE = request.getPart("IMAGE");
       
        
         
        Product newProduct = new Product(PRODUCT_NAME,GRADE,UNIT_OF_MEASUREMENT,HS_CODE,MANUFACTURER,COUNTRY,TDS,MSDS,FREE_TRADE_AGREEMENT,IMAGE);
        productDAO.insertProduct(newProduct);
      
        
        response.sendRedirect("list");
      
       
        
    }
  

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	int ID=Integer.parseInt(request.getParameter("ID"));
    	 String PRODUCT_CODE = request.getParameter("PRODUCT_CODE");
         String PRODUCT_NAME = request.getParameter("PRODUCT_NAME");
         String GRADE = request.getParameter("GRADE");
         String UNIT_OF_MEASUREMENT = request.getParameter("UNIT_OF_MEASUREMENT");
         int HS_CODE = Integer.parseInt(request.getParameter("HS_CODE"));
         String MANUFACTURER = request.getParameter("MANUFACTURER");
         String COUNTRY = request.getParameter("COUNTRY");
         Part TDS =request.getPart("TDS");
         byte[] TDS1 = getByteArrayFromPart(TDS1);
         Part MSDS = request.getPart("MSDS");
         byte[] MSDS1 = getByteArrayFromPart(MSDS1);
         Part FREE_TRADE_AGREEMENT = request.getPart("FREE_TRADE_AGREEMENT");
         byte[] FREE_TRADE_AGREEMENT1 = getByteArrayFromPart(FREE_TRADE_AGREEMENT1);
         Part IMAGE = request.getPart("IMAGE");
         byte[] IMAGE1 = getByteArrayFromPart(IMAGE1);
         
       
       
       
       Product newProduct = new Product(ID,PRODUCT_CODE,PRODUCT_NAME,GRADE,UNIT_OF_MEASUREMENT,HS_CODE,MANUFACTURER,COUNTRY,TDS,MSDS,FREE_TRADE_AGREEMENT,IMAGE1);
      
       productDAO.updateProduct(newProduct);
       response.sendRedirect("list");
    }
     
    private byte[] getByteArrayFromPart(byte[] iMAGE) {
		// TODO Auto-generated method stub
		return null;
	}
	private byte[] getByteArrayFromPart(Part imagePart) {
		// TODO Auto-generated method stub
		return null;
	}
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        productDAO.deleteProduct(ID);
        response.sendRedirect("list");

    }}


