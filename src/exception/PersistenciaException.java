package exception;

public class PersistenciaException extends Exception {

	private static final long serialVersionUID = -4403216176950646252L;

	public PersistenciaException(String erro) {
		super(erro);
	}

	public PersistenciaException(String erro, Exception e) {
		super(erro, e);
	}

	public PersistenciaException(Exception e) {
		super(e.getMessage());
	}
}
