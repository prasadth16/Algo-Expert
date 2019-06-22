package com.file.parser.fileParser.parser.constants;

public enum OperationTypes {

	DEPEND(1, "DEPEND"), 
	INSTALL(2, "INSTALL"), 
	REMOVE(3, "REMOVE"), 
	LIST(4, "LIST");

	int operationType;
	String operationName;

	OperationTypes(int operationType, String operationName) {
		this.operationType = operationType;
		this.operationName = operationName;
	}

	public int getOperationType() {
		return this.operationType;
	}

	public String getOperationName() {
		return this.operationName;
	}

}
