package exception;


public class NegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegocioException(Exception e) {
		super(e.getMessage());
	}

	public NegocioException(String msg) {
		super(msg);
	}

}