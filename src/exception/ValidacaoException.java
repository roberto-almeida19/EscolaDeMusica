package exception;

public class ValidacaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValidacaoException(String msg) {
		super(msg);
	}

	public ValidacaoException(String msg, Exception e) {
		super(msg, e);
	}
}
