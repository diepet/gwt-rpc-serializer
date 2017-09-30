package it.diepet.gwt.rpc.serializer.util;

import it.diepet.gwt.rpc.serializer.error.GwtRpcSerializerException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Reflection utils class.
 * 
 * This class is a simpler copy version of several classes of
 * apache-commong-lang3.
 * 
 * Made a simpler copy for avoiding to add other dependencies.
 */
public final class ReflectionUtils {

	/**
	 * Instantiates a new reflection utils.
	 */
	private ReflectionUtils() {
		super();
	}

	/**
	 * Read field.
	 *
	 * @param target the target
	 * @param fieldName the field name
	 * @return the object
	 */
	public static Object readField(final Object target, final String fieldName) {
		final Class<?> cls = target.getClass();
		final Field field = getField(cls, fieldName);

		// already forced access above, don't repeat it here:
		if (!field.isAccessible()) {
			 field.setAccessible(true);
		}
		
		try {
			Object result = field.get(target);
			return result;
		} catch (IllegalArgumentException e) {
			throw new GwtRpcSerializerException(e);
		} catch (IllegalAccessException e) {
			throw new GwtRpcSerializerException(e);
		}
	}

	/**
	 * Gets the field.
	 *
	 * @param cls            the cls
	 * @param fieldName            the field name
	 * @return the field
	 */
	private static final Field getField(final Class<?> cls, 
			final String fieldName) {
		// check up the superclass hierarchy
		for (Class<?> acls = cls; acls != null; acls = acls.getSuperclass()) {
			try {
				final Field field = acls.getDeclaredField(fieldName);
				if (!Modifier.isPublic(field.getModifiers())) {
					field.setAccessible(true);
				}
				return field;
			} catch (final NoSuchFieldException ex) {
				// do nothing
			}
		}

		Field match = null;
		for (final Class<?> class1 : getAllInterfaces(cls)) {
			try {
				final Field test = class1.getField(fieldName);
				match = test;
			} catch (final NoSuchFieldException ex) {
				// do nothing
			}
		}
		return match;
	}

	/**
	 * Gets the all interfaces.
	 *
	 * @param cls
	 *            the cls
	 * @return the all interfaces
	 */
	private static List<Class<?>> getAllInterfaces(final Class<?> cls) {
		final LinkedHashSet<Class<?>> interfacesFound = new LinkedHashSet<Class<?>>();
		getAllInterfaces(cls, interfacesFound);
		return new ArrayList<Class<?>>(interfacesFound);
	}

	/**
	 * Gets the all interfaces.
	 *
	 * @param cls
	 *            the cls
	 * @param interfacesFound
	 *            the interfaces found
	 * @return the all interfaces
	 */
	private static void getAllInterfaces(Class<?> cls,
			final HashSet<Class<?>> interfacesFound) {
		while (cls != null) {
			final Class<?>[] interfaces = cls.getInterfaces();
			for (final Class<?> i : interfaces) {
				if (interfacesFound.add(i)) {
					getAllInterfaces(i, interfacesFound);
				}
			}
			cls = cls.getSuperclass();
		}
	}
}
