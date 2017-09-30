package it.diepet.gwt.rpc.serializer.test.bean;

public class SomeBean extends SomeSuperBean implements SomeInterfaceForBeans {

	@SuppressWarnings("unused")
	private String somePrivateField = "somePrivateField";
	public String somePublicField = "somePublicField";
	protected String someProtectedSuperField = "someProtectedSuperField";
	String somePackageField = "somePackageField";
	
}
