package com.category.simple.dynamic.programming;

public class ProgramTouple {

	private Integer minimumEditValue;
	private String operationName;

	public ProgramTouple(Integer minimumEditValue, String operationName) {
		super();
		this.minimumEditValue = minimumEditValue;
		this.operationName = operationName;
	}

	public ProgramTouple() {
		super();
	}

	public Integer getMinimumEditValue() {
		return minimumEditValue;
	}

	public void setMinimumEditValue(Integer minimumEditValue) {
		this.minimumEditValue = minimumEditValue;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

}
