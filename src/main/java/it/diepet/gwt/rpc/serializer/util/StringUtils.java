package it.diepet.gwt.rpc.serializer.util;


/**
 * The Class StringUtils.
 */
public final class StringUtils {

	/**
	 * Instantiates a new string utils.
	 */
	private StringUtils() {
		super();
	}

	/**
	 * Checks if is trim empty.
	 *
	 * @param s the s
	 * @return true, if is trim empty
	 */
	public static boolean isTrimEmpty(final String s) {
		return s == null || s.trim().length() == 0;
	}
}
