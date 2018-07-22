package restService.jersey.exception;

public class NoLoginException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2664757289379973402L;
	
	public NoLoginException(String msg){
		super(msg);
	}

}
