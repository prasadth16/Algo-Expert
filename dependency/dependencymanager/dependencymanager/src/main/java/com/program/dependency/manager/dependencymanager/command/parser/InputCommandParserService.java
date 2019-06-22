package com.program.dependency.manager.dependencymanager.command.parser;

import java.util.List;

public interface InputCommandParserService {

	/*public void parseInputCommand(String inputCommand);

	public void handleDependCommand(List<String> depndencies);

	public void handleInstallCommand(List<String> depndencies);

	public void handleRemoveCommand(List<String> depndencies);

	public void listInstalledPrograms();*/

	void processCommandList(List<String> commandList);

}
