package it.diepet.gwt.rpc.serializer.error;


import org.junit.Assert;
import org.junit.Test;

public class GwtRpcSerializerExceptionTests {

	@Test
	public void testGwtRpcSerializerException() {
		GwtRpcSerializerException ex = new GwtRpcSerializerException();
		Assert.assertNull(ex.getMessage());
		Assert.assertNull(ex.getCause());
		
		ex = new GwtRpcSerializerException("some message");
		Assert.assertEquals("some message", ex.getMessage());
		Assert.assertNull(ex.getCause());

		Exception someCause = new Exception();
		ex = new GwtRpcSerializerException(someCause);
		Assert.assertEquals("java.lang.Exception", ex.getMessage());
		Assert.assertSame(someCause, ex.getCause());

		someCause = new Exception();
		ex = new GwtRpcSerializerException("some message", someCause);
		Assert.assertEquals("some message", ex.getMessage());
		Assert.assertSame(someCause, ex.getCause());
	}

}
