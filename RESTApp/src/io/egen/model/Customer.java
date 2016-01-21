package io.egen.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"start_time","end_time" })
public class Customer {

	private int id ;
	private int PARTY_SIZE;
	private String END_TIME;
	private String START_TIME;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String EMAIL;
	private String PHONE;
	public Date start_time = null;
	public Date end_time = null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPARTY_SIZE() {
		return PARTY_SIZE;
	}
	public void setPARTY_SIZE(int pARTY_SIZE) {
		PARTY_SIZE = pARTY_SIZE;
	}
	public String getEND_TIME() {
		return END_TIME;
	}
	public void setEND_TIME(String eND_TIME) {
		END_TIME = eND_TIME;
		
try{
			
			end_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(END_TIME);	
		}
		catch(ParseException pex){
			
			pex.printStackTrace();
			
		}
		
	}
	
	public String getSTART_TIME() {
		return START_TIME;
	}
	public void setSTART_TIME(String sTART_TIME) {
		START_TIME = sTART_TIME;
		try{
			
			start_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(START_TIME);	
		}
		catch(ParseException pex){
			
			pex.printStackTrace();
			
		}
		
	}
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	
	public String toString(){
		
		return ""+FIRST_NAME+"  "+LAST_NAME+"  "+EMAIL+" "+PHONE+"  "+START_TIME + " " + END_TIME; 
	}
	
	
}
