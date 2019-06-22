package com.program.dependency.manager.dependencymanager.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.file.parser.fileParser.parser.SystemDependencyFileParser;
import com.program.dependency.manager.dependencymanager.command.parser.InputCommandParserService;

@Component
public class DependencyManager {
	@Autowired
	private InputCommandParserService commandParserService;

	@Autowired
	private SystemDependencyFileParser fileParser;

	public void startSystemDependencyInstallation() {
		fileParser.readInputFile("c:/uSERS/Prasad/algoexpert/Algo-Expert/instructions.txt");
		List<String> instructionList = fileParser.getInstructionList();
		commandParserService.processCommandList(instructionList);
	}
}
