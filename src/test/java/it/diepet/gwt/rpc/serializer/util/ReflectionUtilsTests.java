package it.diepet.gwt.rpc.serializer.util;

import it.diepet.gwt.rpc.serializer.error.GwtRpcSerializerException;
import it.diepet.gwt.rpc.serializer.test.bean.SomeBean;
import it.diepet.gwt.rpc.serializer.test.bean.TestUtils;

import org.junit.Assert;
import org.junit.Test;

public class ReflectionUtilsTests {

	@Test
	public void testReadField() {
		SomeBean sb = new SomeBean();
		Assert.assertEquals("someSuperPrivateField",
				ReflectionUtils.readField(sb, "someSuperPrivateField"));
		Assert.assertEquals("someSuperPublicField",
				ReflectionUtils.readField(sb, "someSuperPublicField"));
		Assert.assertEquals("someSuperProtectedSuperField",
				ReflectionUtils.readField(sb, "someSuperProtectedSuperField"));
		Assert.assertEquals("someSuperPackageField",
				ReflectionUtils.readField(sb, "someSuperPackageField"));
		Assert.assertEquals("somePrivateField",
				ReflectionUtils.readField(sb, "somePrivateField"));
		Assert.assertEquals("somePublicField",
				ReflectionUtils.readField(sb, "somePublicField"));
		Assert.assertEquals("someProtectedSuperField",
				ReflectionUtils.readField(sb, "someProtectedSuperField"));
		Assert.assertEquals("somePackageField",
				ReflectionUtils.readField(sb, "somePackageField"));
		Assert.assertEquals("SOME_INTERFACE_FIELD",
				ReflectionUtils.readField(sb, "SOME_INTERFACE_FIELD"));
	}
	
	@Test(expected=GwtRpcSerializerException.class)
	public void testFieldNotFound() {
		ReflectionUtils.readField(new SomeBean(), "notExistingField");
	}
	
	@Test
	public void testDefaultConstructorIsPrivate() throws Exception {
		TestUtils.testPrivateDefaultConstructor(ReflectionUtils.class);
	}

}
