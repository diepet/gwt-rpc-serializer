package it.diepet.gwt.rpc.serializer;

/**
 * The Class GwtRpcSerializerImpl.
 */
class GwtRpcSerializerImpl implements GwtRpcSerializer {

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
	 * Instantiates a new gwt rpc serializer impl.
	 */
	GwtRpcSerializerImpl() {
		super();
	}

	/**
	 * Sets the protocol version.
	 *
	 * @param protocolVersion the new protocol version
	 */
	void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	/**
	 * Sets the flags.
	 *
	 * @param flags the new flags
	 */
	void setFlags(String flags) {
		this.flags = flags;
	}

	/**
	 * Sets the base url.
	 *
	 * @param baseUrl the new base url
	 */
	void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * Sets the policy id.
	 *
	 * @param policyId the new policy id
	 */
	void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	/**
	 * Sets the service name.
	 *
	 * @param serviceName the new service name
	 */
	void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * Sets the method name.
	 *
	 * @param methodName the new method name
	 */
	void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * Sets the return type.
	 *
	 * @param returnType the new return type
	 */
	void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	/**
	 * Sets the parameter types.
	 *
	 * @param parameterTypes the new parameter types
	 */
	void setParameterTypes(String[] parameterTypes) {
		this.parameterTypes = parameterTypes;
	}
}
