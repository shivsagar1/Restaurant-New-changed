package io.egen.controller;


import io.egen.dao.CustomerDAO;
import io.egen.exception.AppException;
import io.egen.model.Customer;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/Customers")
public class CustomerController {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> findAll()
	{

		
		List<Customer> Customers=null;
		try {
			CustomerDAO dao = new CustomerDAO();
			Customers = dao.findAll();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		System.out.print("GET Request");
		return Customers;
		
		
	} 
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer findOne(@PathParam ("id") int id){
		Customer customer=null;
		try {
			CustomerDAO dao = new CustomerDAO();
			customer = dao.findOne(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		 
		return customer;
		
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Customer cust){
		
		System.out.println("POST");
		System.out.println(cust);
		System.out.println(cust.start_time);
		System.out.println(cust.end_time);
		
		new CustomerDAO().insertNew(cust);
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)

	public void update(@PathParam ("id") int id,Customer cust){
		System.out.println("ID "+id);
		System.out.println("Updated Customer "+cust);
		
		
		try {
			CustomerDAO dao = new CustomerDAO();
			dao.update(cust,id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		 
		//return cust;
			
			
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam ("id") int id){
		
		try {
			CustomerDAO dao = new CustomerDAO();
			dao.delete(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		 
		return Response.ok().build();
		
		
	}
}
