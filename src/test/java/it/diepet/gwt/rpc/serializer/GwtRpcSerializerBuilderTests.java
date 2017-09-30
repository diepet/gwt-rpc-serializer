package it.diepet.gwt.rpc.serializer;

import it.diepet.gwt.rpc.serializer.error.GwtRpcSerializerException;
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
				.methodName("someMethod").returnType("java.lang.Boolean")
				.policyId("442F823D25ABD9EF6E25F92FC9B39A22").build();
		Assert.assertNotNull(serializer);
		Assert.assertTrue(serializer instanceof GwtRpcSerializerImpl);
		Assert.assertEquals("http://something:8080",
				ReflectionUtils.readField(serializer, "baseUrl"));
		Assert.assertEquals("org.some.package.SomeService",
				ReflectionUtils.readField(serializer, "serviceName"));
		Assert.assertEquals("someMethod",
				ReflectionUtils.readField(serializer, "methodName"));
		Assert.assertEquals("java.lang.Boolean",
				ReflectionUtils.readField(serializer, "returnType"));
		Assert.assertEquals("442F823D25ABD9EF6E25F92FC9B39A22",
				ReflectionUtils.readField(serializer, "policyId"));
		Assert.assertEquals("7",
				ReflectionUtils.readField(serializer, "protocolVersion"));
		Assert.assertEquals("0", ReflectionUtils.readField(serializer, "flags"));
		Object params = ReflectionUtils.readField(serializer, "parameterTypes");
		Assert.assertTrue(params instanceof String[]);
		Assert.assertEquals(0, ((String[]) params).length);
	}

	@Test
	public void testBuilderWithParameters() {
		GwtRpcSerializer serializer = GwtRpcSerializerBuilder.createInstance()
				.baseUrl("http://something:8080")
				.serviceName("org.some.package.SomeService")
				.methodName("someMethod").returnType("java.lang.Boolean")
				.parameterTypes("java.lang.String", "java.lang.Integer")
				.policyId("442F823D25ABD9EF6E25F92FC9B39A22").build();
		Assert.assertNotNull(serializer);
		Assert.assertTrue(serializer instanceof GwtRpcSerializerImpl);
		Assert.assertEquals("http://something:8080",
				ReflectionUtils.readField(serializer, "baseUrl"));
		Assert.assertEquals("org.some.package.SomeService",
				ReflectionUtils.readField(serializer, "serviceName"));
		Assert.assertEquals("someMethod",
				ReflectionUtils.readField(serializer, "methodName"));
		Assert.assertEquals("java.lang.Boolean",
				ReflectionUtils.readField(serializer, "returnType"));
		Assert.assertEquals("442F823D25ABD9EF6E25F92FC9B39A22",
				ReflectionUtils.readField(serializer, "policyId"));
		Assert.assertEquals("7",
				ReflectionUtils.readField(serializer, "protocolVersion"));
		Assert.assertEquals("0", ReflectionUtils.readField(serializer, "flags"));
		Object params = ReflectionUtils.readField(serializer, "parameterTypes");
		Assert.assertTrue(params instanceof String[]);
		String[] parameterTypes = (String[]) params;
		Assert.assertEquals(2, parameterTypes.length);
		Assert.assertEquals("java.lang.String", parameterTypes[0]);
		Assert.assertEquals("java.lang.Integer", parameterTypes[1]);
	}

	@Test(expected = GwtRpcSerializerException.class)
	public void testBuilderNoBaseUrl() {
		GwtRpcSerializerBuilder.createInstance()
				.serviceName("org.some.package.SomeService")
				.methodName("someMethod").returnType("java.lang.Boolean")
				.parameterTypes("java.lang.String", "java.lang.Integer")
				.policyId("442F823D25ABD9EF6E25F92FC9B39A22").build();
	}

	@Test(expected = GwtRpcSerializerException.class)
	public void testBuilderNoServiceName() {
		GwtRpcSerializerBuilder.createInstance()
				.baseUrl("http://something:8080").methodName("someMethod")
				.returnType("java.lang.Boolean")
				.parameterTypes("java.lang.String", "java.lang.Integer")
				.policyId("442F823D25ABD9EF6E25F92FC9B39A22").build();
	}

	@Test(expected = GwtRpcSerializerException.class)
	public void testBuilderNoMethodName() {
		GwtRpcSerializerBuilder.createInstance()
				.baseUrl("http://something:8080")
				.serviceName("org.some.package.SomeService")
				.returnType("java.lang.Boolean")
				.parameterTypes("java.lang.String", "java.lang.Integer")
				.policyId("442F823D25ABD9EF6E25F92FC9B39A22").build();
	}

	@Test(expected = GwtRpcSerializerException.class)
	public void testBuilderNoReturnType() {
		GwtRpcSerializerBuilder.createInstance()
				.baseUrl("http://something:8080")
				.serviceName("org.some.package.SomeService")
				.methodName("someMethod")
				.parameterTypes("java.lang.String", "java.lang.Integer")
				.policyId("442F823D25ABD9EF6E25F92FC9B39A22").build();
	}

	@Test(expected = GwtRpcSerializerException.class)
	public void testBuilderNoPolicyId() {
		GwtRpcSerializerBuilder.createInstance()
				.baseUrl("http://something:8080")
				.serviceName("org.some.package.SomeService")
				.methodName("someMethod").returnType("java.lang.Boolean")
				.parameterTypes("java.lang.String", "java.lang.Integer")
				.build();
	}

}
