package it.diepet.gwt.rpc.serializer.error;

/**
 * The Class GwtRpcSerializerException.
 */
public class GwtRpcSerializerException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6433374220991104552L;

	/**
	 * Instantiates a new gwt rpc serializer exception.
	 */
	public GwtRpcSerializerException() {
		super();
	}

	/**
	 * Instantiates a new gwt rpc serializer exception.
	 *
	 * @param message the message
	 */
	public GwtRpcSerializerException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new gwt rpc serializer exception.
	 *
	 * @param cause the cause
	 */
	public GwtRpcSerializerException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new gwt rpc serializer exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public GwtRpcSerializerException(String message, Throwable cause) {
		super(message, cause);
	}

}
