package it.diepet.gwt.rpc.serializer.util;

import it.diepet.gwt.rpc.serializer.error.GwtRpcSerializerException;
import it.diepet.gwt.rpc.serializer.test.bean.TestUtils;

import org.junit.Test;

public final class ValidationUtilsTests {

	@Test
	public void testValidationSuccessTrimNotEmpty() {
		ValidationUtils.validateTrimNotEmpty(" s ", "someField");
	}

	@Test(expected = GwtRpcSerializerException.class)
	public void testValidationFailureTrimNotEmpty() {
		ValidationUtils.validateTrimNotEmpty("  ", "someField");
	}

	@Test
	public void testDefaultConstructorIsPrivate() throws Exception {
		TestUtils.testPrivateDefaultConstructor(ValidationUtils.class);
	}

}
