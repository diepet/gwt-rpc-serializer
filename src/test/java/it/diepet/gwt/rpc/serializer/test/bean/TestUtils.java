package it.diepet.gwt.rpc.serializer.test.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Assert;

public class TestUtils {

	public static void testPrivateDefaultConstructor(
			Class<? extends Object> clazz) throws Exception {
		Constructor<? extends Object> constructor = clazz
				.getDeclaredConstructor();
		Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
		constructor.setAccessible(true);
		constructor.newInstance();
	}

}
