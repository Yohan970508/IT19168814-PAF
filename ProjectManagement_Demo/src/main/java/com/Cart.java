package com;

import java.sql.*;
public class Cart {

	private Connection connect() {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart_management", "root", "");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
	}
	public String insertCart(String Item_Code, String Item_Name, String Price, String Qty) {
		String output = " ";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database.";

			}

			// create a prepared statement
			String query = " insert into carts values (?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, Item_Code);;
			preparedStmt.setString(3, Item_Name);
			preparedStmt.setString(4, Price);
			preparedStmt.setString(5, Qty);;
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newCarts = readCarts();
			 output =  "{\"status\":\"success\", \"data\": \"" + 
					 newCarts + "\"}"; 
			 } 

			catch (Exception e) 
			 { 
				output = "{\"status\":\"error\", \"data\": \"Error while inserting the cart.\"}";  
			 System.err.println(e.getMessage()); 
			 } 
			return output; 
			}
	
	
	public String readCarts() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Item Code</th><th>Item Name</th><th>Price</th><th>Quantity</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from carts";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set

			while (rs.next()) {
				String CID = Integer.toString(rs.getInt("CID"));
				String Item_Code = rs.getString("Item_Code");
				String Item_Name = rs.getString("Item_Name");
				String Price = rs.getString("Price");
				String Qty = rs.getString("Qty");
			

				// Add into the html table
				 output += "<tr><td><input id='hidCartIDUpdate' name='hidCartIDUpdate' type='hidden' value='" + CID + "'>"
						 + Item_Code + "</td>"; 
				output += "<td>" + Item_Name + "</td>";
				output += "<td>" + Price + "</td>";
				output += "<td>" + Qty + "</td>";
				
				// buttons
				 output += "<td><input name='btnUpdate' " 
		    			 + " type='button' value='Update' class =' btnUpdate btn btn-secondary'data-cartid='" + CID + "'></td>"
		    			 + "<td><form method='post' action='carts.jsp'>"
		    			 + "<input name='btnRemove' " 
		    			 + " type='button' value='Remove' class='btnRemove btn btn-danger' data-cartid='" + CID + "'>"
		    			 + "<input name='hidCartIDDelete' type='hidden' " 
		    			 + " value='" + CID + "'>" + "</form></td></tr>"; 
		    			 } 
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	public String updateCart(String CID,String Item_Code, String Item_Name, String Price, String Qty){
		    
		    String output = "";

		    try{

		           Connection con = connect();
		           if (con == null){
		           return "Error while connecting to the database for updating.";
		           }
		           
		           // create a prepared statement
		 
					
		           String query = "UPDATE carts SET Item_Code=?,Item_Name=?,Price=?,Qty=? WHERE CID=?";
		           PreparedStatement preparedStmt = con.prepareStatement(query);

		           preparedStmt.setString(1, Item_Code);
		           preparedStmt.setString(2,Item_Name );
		           preparedStmt.setString(3, Price);
		           preparedStmt.setString(4, Qty);
		           preparedStmt.setInt(5, Integer.parseInt(CID)); 
		           //preparedStmt.setString(5, CID);
		         

		           // execute the statement
		           preparedStmt.execute();
		           con.close();

		           String newCarts = readCarts();
		      	 output =  "{\"status\":\"success\", \"data\": \"" + 
		      			 newCarts + "\"}"; 
		      	 } 

		      	catch (Exception e) 
		      	 { 
		      		output = "{\"status\":\"error\", \"data\": \"Error while Updating the cart.\"}";  
		      	
		      	System.err.println(e.getMessage());
		      	}
		      	return output;
		      	}


			public String deleteCart(String CID) {

				String output = "";

				try { 

					Connection con = connect();
					if (con == null) {

						return "Error while connecting to the database for deleting.";
					}

					// create a prepared statement
					String query = "delete from carts where CID=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					// binding values
					preparedStmt.setInt(1, Integer.parseInt(CID));
					
					// execute the statement
					preparedStmt.execute();
					con.close();

					String newCarts = readCarts();
					 output =  "{\"status\":\"success\", \"data\": \"" + 
							 newCarts + "\"}"; 
					 } 

					catch (Exception e) 
					 { 
						output = "{\"status\":\"error\", \"data\": \"Error while deleting the cart.\"}";  
					 System.err.println(e.getMessage()); 
					 } 
					return output; 
						}
			}
