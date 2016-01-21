package io.egen.exception;

public class AppException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6080746044029850904L;

	public AppException(String msg,Throwable cause){
	super(msg, cause );
	
	}

	public AppException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

		
}

