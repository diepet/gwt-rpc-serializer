package it.diepet.gwt.rpc.serializer.util;

import it.diepet.gwt.rpc.serializer.error.GwtRpcSerializerException;

/**
 * The Class ValidationUtils.
 */
public final class ValidationUtils {

	/**
	 * Instantiates a new validation utils.
	 */
	private ValidationUtils() {
		super();
	}

	/**
	 * Validate not empty trimmed strings.
	 *
	 * @param s the string
	 * @param fieldName the field name to validate
	 */
	public static void validateTrimNotEmpty(final String s, final String fieldName) {
		if (StringUtils.isTrimEmpty(s)) {
			throw new GwtRpcSerializerException("Field '" + fieldName + "' is empty");
		}
	}
	
}
