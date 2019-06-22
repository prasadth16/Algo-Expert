package com.file.parser.fileParser.parser;

import java.util.List;
import java.util.function.Supplier;

public class SystemDependencyInstructionStorage {

	private List<String> systemInstructionList;

	public SystemDependencyInstructionStorage(List<String> systemInstructionList) {
		this.systemInstructionList = systemInstructionList;
	}

	public List<String> getSystemInstructionList() {
		return systemInstructionList;
	}

	public void setSystemInstructionList(List<String> systemInstructionList) {
		this.systemInstructionList = systemInstructionList;
	}

	public void addInstructions(String instruction) {
		systemInstructionList.add(instruction);
	}

}
