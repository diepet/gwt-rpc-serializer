package it.diepet.gwt.rpc.serializer.util;

import it.diepet.gwt.rpc.serializer.test.bean.TestUtils;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class StringUtils.
 */
public final class StringUtilsTests {

	@Test
	public void testIsTrimEmpty() {
		Assert.assertTrue(StringUtils.isTrimEmpty(null));
		Assert.assertTrue(StringUtils.isTrimEmpty(""));
		Assert.assertTrue(StringUtils.isTrimEmpty("   "));
		Assert.assertFalse(StringUtils.isTrimEmpty(" s "));
	}

	@Test
	public void testDefaultConstructorIsPrivate() throws Exception {
		TestUtils.testPrivateDefaultConstructor(StringUtils.class);
	}
}
