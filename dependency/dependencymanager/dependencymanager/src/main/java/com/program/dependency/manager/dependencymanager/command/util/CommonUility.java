package com.program.dependency.manager.dependencymanager.command.util;

import java.util.List;
import java.util.UUID;

import com.program.dependency.manager.dependencymanager.command.data.Program;

public class CommonUility {
	private static UUID uniqueID;

	

	public static Program buildProgram(String programName, boolean installed) {
		Program program = new Program();
		program.setProgramName(programName);
		program.setProgramID(uniqueID.randomUUID());
		program.setInstlled(installed);
		program.setCode();
		return program;
	}

}
