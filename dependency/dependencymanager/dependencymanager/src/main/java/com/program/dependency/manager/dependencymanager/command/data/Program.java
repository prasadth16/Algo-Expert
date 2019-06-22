package com.program.dependency.manager.dependencymanager.command.data;

import java.util.Map;
import java.util.UUID;

public class Program implements Comparable<Program> {
	private String programName;
	private UUID programID;
	private boolean instlled;
	private boolean explctInstall;
	private Program leftChild;
	private Program rightChild;
	private Map<String, Program> BSTDependencies;
	private int code;

	public Program() {
		super();
		explctInstall = false;
	}

	public Program(String programName, UUID programID, boolean instlled, boolean explctInstall, Program leftChild,
			Program rightChild, Map<String, Program> bSTDependencies) {
		super();
		this.programName = programName;
		this.programID = programID;
		this.instlled = instlled;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.explctInstall = explctInstall;

		BSTDependencies = bSTDependencies;
	}

	public int getCode() {
		return code;
	}

	public void setCode() {
		this.code = programName.hashCode();
	}

	public boolean isExplctInstall() {
		return explctInstall;
	}

	public void setExplctInstall(boolean explctInstall) {
		this.explctInstall = explctInstall;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public UUID getProgramID() {
		return programID;
	}

	public void setProgramID(UUID programID) {
		this.programID = programID;
	}

	public boolean isInstlled() {
		return instlled;
	}

	public void setInstlled(boolean instlled) {
		this.instlled = instlled;
	}

	public Program getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Program leftChild) {
		this.leftChild = leftChild;
	}

	public Program getRightChild() {
		return rightChild;
	}

	public void setRightChild(Program rightChild) {
		this.rightChild = rightChild;
	}

	public Map<String, Program> getBSTDependencies() {
		return BSTDependencies;
	}

	public void setBSTDependencies(Map<String, Program> bSTDependencies) {
		BSTDependencies = bSTDependencies;
	}

	@Override
	public String toString() {
		return this.getProgramName();
	}

	@Override
	public boolean equals(Object object) {
		Program anotherProgram = (Program) object;
		if (!(anotherProgram instanceof Program))
			return false;
		if (this.hashCode() == anotherProgram.hashCode())
			return true;
		if (this.getProgramName().equalsIgnoreCase(anotherProgram.getProgramName()))
			return true;
		return false;
	}

	@Override
	public int compareTo(Program anotherProgram) {
		return this.getProgramName().compareTo(anotherProgram.getProgramName());
	}

}
