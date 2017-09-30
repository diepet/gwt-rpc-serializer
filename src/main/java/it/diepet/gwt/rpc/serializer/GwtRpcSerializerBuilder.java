package it.diepet.gwt.rpc.serializer;

import it.diepet.gwt.rpc.serializer.util.ValidationUtils;

/**
 * The GWT RPC Serializer builder class.
 */
public class GwtRpcSerializerBuilder {

	/** The Constant EMPTY_STRING_ARRAY. */
	private static final String[] EMPTY_STRING_ARRAY = new String[0];

	/** The Constant DEFAULT_PROTOCOL_VERSION. */
	private static final String DEFAULT_PROTOCOL_VERSION = "7";

	/** The Constant DEFAULT_FLAGS. */
	private static final String DEFAULT_FLAGS = "0";

	/** The protocol version. */
	private String protocolVersion;

	/** The flags. */
	private String flags;

	/** The base url. */
	private String baseUrl;

	/** The policy id. */
	private String policyId;

	/** The service name. */
	private String serviceName;

	/** The method name. */
	private String methodName;

	/** The return type. */
	private String returnType;

	/** The parameter types. */
	private String[] parameterTypes;

	/**
	 * Creates the instance.
	 *
	 * @return the gwt rpc serializer builder
	 */
	public static final GwtRpcSerializerBuilder createInstance() {
		return new GwtRpcSerializerBuilder();
	}

	/**
	 * Instantiates a new gwt rpc serializer builder.
	 * 
	 * For now only GWT Protocol version 7 and no special flags set cases are
	 * managed.
	 */
	private GwtRpcSerializerBuilder() {
		super();
		this.protocolVersion = DEFAULT_PROTOCOL_VERSION;
		this.flags = DEFAULT_FLAGS;
	}

	/**
	 * Base url.
	 *
	 * @param baseUrl
	 *            the base url
	 * @return the gwt rpc serializer builder
	 */
	public GwtRpcSerializerBuilder baseUrl(final String baseUrl) {
		this.baseUrl = baseUrl;
		return this;
	}

	/**
	 * Policy id.
	 *
	 * @param policyId
	 *            the policy id
	 * @return the gwt rpc serializer builder
	 */
	public GwtRpcSerializerBuilder policyId(final String policyId) {
		this.policyId = policyId;
		return this;
	}

	/**
	 * Service name.
	 *
	 * @param serviceName
	 *            the service name
	 * @return the gwt rpc serializer builder
	 */
	public GwtRpcSerializerBuilder serviceName(final String serviceName) {
		this.serviceName = serviceName;
		return this;
	}

	/**
	 * Method name.
	 *
	 * @param methodName
	 *            the method name
	 * @return the gwt rpc serializer builder
	 */
	public GwtRpcSerializerBuilder methodName(final String methodName) {
		this.methodName = methodName;
		return this;
	}

	/**
	 * Return type.
	 *
	 * @param returnType
	 *            the return type
	 * @return the gwt rpc serializer builder
	 */
	public GwtRpcSerializerBuilder returnType(final String returnType) {
		this.returnType = returnType;
		return this;
	}

	/**
	 * Parameter types.
	 *
	 * @param parameterTypes
	 *            the parameter types
	 * @return the gwt rpc serializer builder
	 */
	public GwtRpcSerializerBuilder parameterTypes(
			final String... parameterTypes) {
		this.parameterTypes = parameterTypes;
		return this;
	}

	/**
	 * Builds the.
	 *
	 * @return the gwt rpc serializer
	 */
	public GwtRpcSerializer build() {
		ValidationUtils.validateTrimNotEmpty(this.baseUrl, "baseUrl");
		ValidationUtils.validateTrimNotEmpty(this.flags, "flags");
		ValidationUtils.validateTrimNotEmpty(this.methodName, "methodName");
		ValidationUtils.validateTrimNotEmpty(this.policyId, "policyId");
		ValidationUtils.validateTrimNotEmpty(this.protocolVersion,
				"protocolVersion");
		ValidationUtils.validateTrimNotEmpty(this.returnType, "returnType");
		ValidationUtils.validateTrimNotEmpty(this.serviceName, "serviceName");
		// null-safization
		if (this.parameterTypes == null) {
			this.parameterTypes = EMPTY_STRING_ARRAY;
		}
		// validate parameter types
		for (int i = 0; i < parameterTypes.length; i++) {
			ValidationUtils.validateTrimNotEmpty(parameterTypes[i],
					String.format("parameterType[%d]", i));
		}
		final GwtRpcSerializerImpl serializer = new GwtRpcSerializerImpl();
		serializer.setBaseUrl(this.baseUrl);
		serializer.setFlags(this.flags);
		serializer.setMethodName(this.methodName);
		serializer.setParameterTypes(this.parameterTypes);
		serializer.setPolicyId(this.policyId);
		serializer.setProtocolVersion(this.protocolVersion);
		serializer.setReturnType(this.returnType);
		serializer.setServiceName(this.serviceName);
		return serializer;
	}

}