package Exceptions;

public class CommandParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandParseException() {
		super();
	}

	public CommandParseException(String message) {
		super(message);
	}

	public CommandParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandParseException(Throwable cause) {
		super(cause);
	}

	public CommandParseException(String message, Throwable cause, boolean enableSuppression, boolean writeableStackTrace){
		super(message, cause, enableSuppression, writeableStackTrace);
	}

}
