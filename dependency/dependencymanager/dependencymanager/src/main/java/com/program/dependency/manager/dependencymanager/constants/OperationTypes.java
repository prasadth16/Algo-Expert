package com.program.dependency.manager.dependencymanager.constants;

import java.util.Optional;

public enum OperationTypes {

	DEPEND(1, "DEPEND"), INSTALL(2, "INSTALL"), REMOVE(3, "REMOVE"), LIST(4, "LIST"), INVALID(5, "INVALID"),
	END(6, "END");

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

	public static OperationTypes getOperationTypes(String operationName) {
		OperationTypes returnType = null;
		for (OperationTypes type : OperationTypes.values()) {
			if (type.getOperationName().equalsIgnoreCase(operationName)) {
				returnType = type;
				break;
			}
		}
		returnType = returnType != null ? returnType : returnType.INVALID;
		return returnType;
	}

}
