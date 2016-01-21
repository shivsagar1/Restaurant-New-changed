package io.egen.dao;

import io.egen.exception.AppException;
import io.egen.model.Customer;
import io.egen.util.DButi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;



public class CustomerDAO {

	
	Connection con = null;
	public CustomerDAO() {
		 con = DButi.connect();
	}
	
	
	public List<Customer> findAll() throws AppException {
		// TODO Auto-generated method stub
		List<Customer> Customers= new ArrayList<Customer>();
		
		PreparedStatement ps = null ;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM customers");
			
			rs=ps.executeQuery();
			 
			
			while(rs.next())
			{
			
				Customer cust = new Customer();
				cust.setId(rs.getInt("ID"));
				cust.setPARTY_SIZE(rs.getInt("PARTY_SIZE"));
				cust.setEND_TIME(rs.getTimestamp("START_TIME").toString());
				cust.setSTART_TIME(rs.getTimestamp("START_TIME").toString());
				cust.setFIRST_NAME(rs.getString("FIRST_NAME"));
				cust.setLAST_NAME(rs.getString("LAST_NAME"));
				cust.setEMAIL(rs.getString("EMAIL"));
				cust.setPHONE(rs.getString("PHONE"));
				
				
				Customers.add(cust);
				for(int i = 0;i < Customers.size() ; i++)
				{
					System.out.println(Customers.get(i));
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		
		
		return Customers;
	}
	  
	
	
	public void insertNew(Customer cust) {
		
		PreparedStatement ps = null ;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("INSERT INTO CUSTOMERS (PARTY_SIZE,START_TIME,FIRST_NAME,LAST_NAME,EMAIL,PHONE,END_TIME) VALUES (?,?,?,?,?,?,?) ",com.mysql.jdbc.PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, cust.getPARTY_SIZE());
			ps.setTimestamp(2, new java.sql.Timestamp(cust.start_time.getTime()));
			ps.setString(3, cust.getFIRST_NAME());
			ps.setString(4, cust.getLAST_NAME());
			ps.setString(5, cust.getEMAIL());
			ps.setString(6, cust.getPHONE());
			ps.setTimestamp(7,new java.sql.Timestamp(cust.end_time.getTime()));
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
			//throw new AppException(e.getMessage());
		}
		
		finally {
			
			
				try {
					if(ps != null){
						ps.close();
					}
					if(rs != null){
						rs.close();
					}
					
					if(con  != null){
						con.close();
					}
					
				}
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			
		}
	}


	public Customer findOne(int id) throws AppException {
		// TODO Auto-generated method stub
		
Customer cust = null;
Connection con = DButi.connect();
		
		PreparedStatement ps = null ;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM customers WHERE ID=?");
			ps.setInt(1, id);
			 
			rs=ps.executeQuery();
			 
			
			if(rs.next())
			{
			
				 cust = new Customer();
				cust.setId(rs.getInt("ID"));
				cust.setPARTY_SIZE(rs.getInt("PARTY_SIZE"));
				cust.setEND_TIME(rs.getTimestamp("END_TIME").toString());
				cust.setSTART_TIME(rs.getTimestamp("START_TIME").toString());
				//cust.setSTART_DATE(rs.getInt("START_DATE"));
				cust.setFIRST_NAME(rs.getString("FIRST_NAME"));
				cust.setLAST_NAME(rs.getString("LAST_NAME"));
				cust.setEMAIL(rs.getString("EMAIL"));
				cust.setPHONE(rs.getString("PHONE"));
				
				
				}
			else{
				throw new NotFoundException("Employee with this iD not found");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		
		
		return cust;
	}


	public void delete(int id) throws AppException 
	{
		// TODO Auto-generated method stub
		Connection con = DButi.connect();
		Customer cust = null;
		PreparedStatement ps = null ;
		ResultSet rs = null;
		
		try 
		{
			ps = con.prepareStatement("DELETE FROM customers WHERE ID=?");
			ps.setInt(1, id);
			 
			ps.executeUpdate();
			 
			
			
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		
		
		
	}


	public void update(Customer cust,int id) throws AppException {
		// TODO Auto-generated method stub
		
		Connection con = DButi.connect();
				
		PreparedStatement ps = null ;
		ResultSet rs = null;
		System.out.println("Updating in DAO "+ cust);
		try {
			ps = con.prepareStatement("UPDATE CUSTOMERS SET PARTY_SIZE = ?,FIRST_NAME = ?,LAST_NAME = ?,EMAIL = ? ,PHONE = ? ,START_TIME=?,END_TIME=? WHERE ID=?");
			ps.setInt(1, cust.getPARTY_SIZE());
			ps.setString(2, cust.getFIRST_NAME());
			ps.setString(3, cust.getLAST_NAME());
			ps.setString(4, cust.getEMAIL());
			ps.setString(5, cust.getPHONE());
			ps.setTimestamp(6,new java.sql.Timestamp(cust.start_time.getTime()));
			ps.setTimestamp(7,new java.sql.Timestamp(cust.end_time.getTime()));
			ps.setInt(8, id);
			ps.executeUpdate();
			 
			/*rs=ps.executeQuery();
			 
			
			if(rs.next())
			{
			
				 cust = new Customer();
				cust.setId(rs.getInt("ID"));
				cust.setPARTY_SIZE(rs.getInt("PARTY_SIZE"));
				//cust.setSTART_TIME(rs.getInt("START_TIME"));
				//cust.setSTART_DATE(rs.getInt("START_DATE"));
				cust.setFIRST_NAME(rs.getString("FIRST_NAME"));
				cust.setLAST_NAME(rs.getString("LAST_NAME"));
				cust.setEMAIL(rs.getString("EMAIL"));
				cust.setPHONE(rs.getString("PHONE"));
				
				
				
			}
			else{
				throw new NotFoundException("Employee with this iD not found");
			}
		*/	
			System.out.println(cust);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		
		
		//return cust;
	}
		
	}


 