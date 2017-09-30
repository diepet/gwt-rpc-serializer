package it.diepet.gwt.rpc.serializer;

import it.diepet.gwt.rpc.serializer.util.ReflectionUtils;

import org.junit.Assert;
import org.junit.Test;


/**
 * The Class GwtRpcSerializerBuilderTests.
 */
public class GwtRpcSerializerBuilderTests {

	@Test
	public void testBuilder() throws IllegalAccessException {
		GwtRpcSerializer serializer = GwtRpcSerializerBuilder.createInstance()
				.baseUrl("http://something:8080")
				.serviceName("org.some.package.SomeService")
				.methodName("someMethod")
				.returnType("java.lang.Boolean")
				.policyId("442F823D25ABD9EF6E25F92FC9B39A22")
				.build();
		
		Assert.assertNotNull(serializer);
		String s = (String) ReflectionUtils.readField(serializer, "baseUrl");
		Assert.assertEquals("http://something:8080", s);
	}

}
