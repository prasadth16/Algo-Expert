package com.program.dependency.manager.dependencymanager.command.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.program.dependency.manager.dependencymanager.command.data.DependencyGraph;
import com.program.dependency.manager.dependencymanager.constants.OperationTypes;

@Service
public class DefaultInputCommandParserService implements InputCommandParserService {

	private static Logger LOGGER = LoggerFactory.getLogger(DefaultInputCommandParserService.class);

	DependencyGraph dependencyGraph;

	public DefaultInputCommandParserService(DependencyGraph dependencyGraph) {
		super();
		this.dependencyGraph = dependencyGraph;
	}

	@Override
	public void processCommandList(List<String> commandList) {
		commandList.forEach(this::parseInputCommand);
	}

	private void parseInputCommand(String inputCommand) {
		Optional<List<String>> optionalParsedCommand = splitCommand(inputCommand);
		List<String> parsedCommandList = optionalParsedCommand.isPresent() ? optionalParsedCommand.get()
				: new ArrayList<String>();
		OperationTypes OperationType = OperationTypes.getOperationTypes(parsedCommandList.get(0));

		if (parsedCommandList.size() > 0) {
			switch (OperationType) {
			case DEPEND:
				System.out.println(inputCommand);
				handleDependCommand(parsedCommandList);
				break;
			case INSTALL:
				System.out.println(inputCommand);
				handleInstallCommand(parsedCommandList);
				break;
			case REMOVE:
				System.out.println(String.format("REMOVE %s", parsedCommandList.get(1)));
				handleRemoveCommand(parsedCommandList);
				break;
			case LIST:
				System.out.println("LIST");
				listInstalledPrograms();
				break;
			case END:
				System.out.println("End of File Reached!!!");
				break;
			case INVALID:
				System.out.println(String.format("%s is an Invalid Operation", parsedCommandList.get(0)));
			}
		}
	}

	private void handleDependCommand(List<String> depndencies) {
		if (depndencies.size() > 2) {
			dependencyGraph.addDependency(depndencies);
		}
	}

	private void handleInstallCommand(List<String> depndencies) {
		dependencyGraph.installProgram(depndencies.get(1), true);
	}

	private void handleRemoveCommand(List<String> depndencies) {
		dependencyGraph.removeProgram(depndencies.get(1), true);
	}

	private void listInstalledPrograms() {
		dependencyGraph.listCurrentlyInstalled().forEach(System.out::println);
	}

	private Optional<List<String>> splitCommand(String commandString) {
		return Optional.of(Arrays.asList(commandString.split("\\s+")));
	}

}
