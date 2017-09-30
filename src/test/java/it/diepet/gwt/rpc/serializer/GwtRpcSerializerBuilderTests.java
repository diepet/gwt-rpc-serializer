package it.diepet.gwt.rpc.serializer;

import it.diepet.gwt.rpc.serializer.util.ReflectionUtils;

import org.junit.Assert;
import org.junit.Test;


/**
 * The Class GwtRpcSerializerBuilderTests.
 */
public class GwtRpcSerializerBuilderTests {

	@Test
	public void testBuilderNoParameters() {
		GwtRpcSerializer serializer = GwtRpcSerializerBuilder.createInstance()
				.baseUrl("http://something:8080")
				.serviceName("org.some.package.SomeService")
				.methodName("someMethod")
				.returnType("java.lang.Boolean")
				.policyId("442F823D25ABD9EF6E25F92FC9B39A22")
				.build();
		Assert.assertNotNull(serializer);
		Assert.assertTrue(serializer instanceof GwtRpcSerializerImpl);
		Assert.assertEquals("http://something:8080", ReflectionUtils.readField(serializer, "baseUrl"));
		Assert.assertEquals("org.some.package.SomeService", ReflectionUtils.readField(serializer, "serviceName"));
		Assert.assertEquals("someMethod", ReflectionUtils.readField(serializer, "methodName"));
		Assert.assertEquals("java.lang.Boolean", ReflectionUtils.readField(serializer, "returnType"));
		Assert.assertEquals("442F823D25ABD9EF6E25F92FC9B39A22", ReflectionUtils.readField(serializer, "policyId"));
		Assert.assertEquals("7", ReflectionUtils.readField(serializer, "protocolVersion"));
		Assert.assertEquals("0", ReflectionUtils.readField(serializer, "flags"));
		Object params = ReflectionUtils.readField(serializer, "parameterTypes");
		Assert.assertTrue(params instanceof Object[]);
		Assert.assertEquals(0, ((Object[]) params).length);
	}

}
