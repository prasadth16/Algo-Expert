package com.program.dependency.manager.dependencymanager.command.data;

import static com.program.dependency.manager.dependencymanager.command.util.CommonUility.buildProgram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.program.dependency.manager.dependencymanager.command.parser.DefaultInputCommandParserService;

@Component
public class DependencyGraph {

	private List<Program> programGraph;
	private static Logger LOGGER = LoggerFactory.getLogger(DefaultInputCommandParserService.class);

	public DependencyGraph() {
		programGraph = new ArrayList<>();
	}

	/**
	 * Method to handle "DEPEND" Command. Add the dependencies to Graph. If the
	 * program already exists as main or dependency then it is reused.
	 * 
	 * @InPut: Parsed Command List
	 * 
	 * @OutPut: Does not return anything
	 * 
	 **/
	public void addDependency(List<String> parsedCommandList) {
		Optional<Program> existingProgram = null;
		if (!isNodeAddedToGraph(parsedCommandList.get(1))) {
			existingProgram = searchProgramInEntireadjcList(parsedCommandList.get(1));
			Program newProgram = existingProgram.isPresent() ? existingProgram.get()
					: buildProgram(parsedCommandList.get(1), false);
			Map<String, Program> dependencyMap = createMap(parsedCommandList);
			newProgram.setBSTDependencies(dependencyMap);
			addToDependencyGraph(newProgram);
		}
	}

	/**
	 * Method to install Program along with it's dependencies which are eligible
	 * 
	 * @InPut: Name of the program to be installed
	 * @OutPut: Does not return anything
	 * 
	 **/
	public void installProgram(String prgmName, boolean explctInstall) {
		if (isProgramInstalled(prgmName)) {
			if (explctInstall)
				System.out.println(String.format("%s is already Installed", prgmName));
			return;
		}
		if (!explctInstall && !isProgramInstalled(prgmName)) {
			System.out.println(String.format("Installing %s", prgmName));
		}
		if (!isNodeAddedToGraph(prgmName)) {
			Optional<Program> optnlPrgm = searchProgramInEntireadjcList(prgmName);
			Program prgm = optnlPrgm.isPresent() ? optnlPrgm.get() : buildProgram(prgmName, true);
			prgm.setInstlled(true);
			prgm.setExplctInstall(explctInstall);
			addToDependencyGraph(prgm);
			if (explctInstall) {
				System.out.println(String.format("Installing %s", prgmName));
			}
		} else {
			Program existingProgram = shallowSearchForProgram(prgmName).isPresent()
					? shallowSearchForProgram(prgmName).get()
					: null;
			Collection<Program> dependencies = existingProgram.getBSTDependencies() != null
					? existingProgram.getBSTDependencies().values()
					: null;
			if (dependencies != null) {
				dependencies.forEach(p -> installProgram(p.getProgramName(), false));
			}
			existingProgram.setInstlled(true);
			existingProgram.setExplctInstall(explctInstall);
			if (explctInstall) {
				System.out.println(String.format("Installing %s", prgmName));
			}
		}

	}

	/**
	 * Method to remove the program if it is not at all needed. There are some
	 * checks, if it is through all those checks then only it will be removed.
	 * 
	 * @InPut: Name of the program, if this is an explicit delete command
	 * 
	 * @OutPut: It does not returns anything
	 **/
	public void removeProgram(String prgmName, boolean isRemoveCommand) {
		if (!isNodeAddedToGraph(prgmName) || !isProgramInstalled(prgmName)) {
			System.out.println(String.format("%s is not installed.", prgmName));
			return;
		}
		if (isProgramADependency(prgmName)) {
			if (isRemoveCommand)
				System.out.println(String.format("%s is still needed.", prgmName));
			return;
		}
		if (!isRemoveCommand && shallowSearchForProgram(prgmName).get().isExplctInstall()) {
			return;
		}
		System.out.println(String.format("Removing %s.", prgmName));
		Program program = shallowSearchForProgram(prgmName).isPresent() ? shallowSearchForProgram(prgmName).get()
				: null;
		programGraph.remove(program);
		if (program != null && program.getBSTDependencies() != null && program.getBSTDependencies().size() > 0) {
			program.getBSTDependencies().entrySet()
					.forEach(entry -> removeProgram(entry.getValue().getProgramName(), false));
		}
	}

	/**
	 * Method to check if the program acts as a dependency to some other installed
	 * program
	 * 
	 * @InPut: Program Name
	 * @OutPut: Boolean value based on the check
	 **/

	private boolean isProgramADependency(String programName) {
		boolean isProgramADependency = false;
		if (programGraph.size() > 0) {
			for (Program p : programGraph) {
				if (p.isInstlled() && p.getBSTDependencies() != null
						&& p.getBSTDependencies().get(programName) != null) {
					isProgramADependency = true;
					break;
				}
			}
		}

		return isProgramADependency;
	}

	/**
	 * Method to check if the given program is already present on the graph and
	 * installed
	 * 
	 * @InPut: Name of the program
	 * @OutPut: returns boolean result
	 */
	private boolean isProgramInstalled(String programName) {
		return programGraph.stream()
				.filter(p -> p.getProgramName().hashCode() == programName.hashCode() && p.isInstlled())
				.collect(Collectors.toList()).size() > 0;
	}

	/**
	 * Method to check if the node is present on the Graph on main level. It does
	 * not check if it is installed or if it is the Explicit Install.
	 * 
	 * @Input: Name of the program
	 * 
	 * @OutPut: returns the boolean value
	 */
	private boolean isNodeAddedToGraph(String name) {
		return programGraph.stream().filter(p -> p.getProgramName().equals(name)).collect(Collectors.toList())
				.size() > 0;
	}

	/**
	 * Overloaded Method to check if the node is present on the Graph on main level.
	 * It does not check if it is installed or if it is the Explicit Install.
	 * 
	 * @Input: program
	 * 
	 * @OutPut: returns the boolean value
	 */
	private boolean isNodeAddedToGraph(Program program) {
		return programGraph.stream().filter(p -> p.equals(program)).collect(Collectors.toList()).size() > 0;
	}

	/**
	 * Method to search the program among all the dependencies on the graph. It does
	 * not search on the main level. It does not check if it is installed or if it
	 * is the Explicit Install.
	 * 
	 * @InPut: Name of the Program
	 * 
	 * @OutPut: Returns the Instance of Optional of Program.
	 */
	private Optional<Program> searchProgramInEntireadjcList(String programName) {

		List<Program> searchedList = programGraph.stream().map(p -> {
			return p.getBSTDependencies() != null ? p.getBSTDependencies().get(programName) : null;
		}).collect(Collectors.toList());

		searchedList = searchedList != null && searchedList.size() > 0
				? searchedList.stream().filter(p -> p != null).collect(Collectors.toList())
				: null;
		return searchedList != null && searchedList.size() > 0 ? Optional.ofNullable(searchedList.get(0))
				: Optional.empty();
	}

	/**
	 * Method to iterate through the Command List and add the dependencies to the
	 * program. It reuses the dependency if it already exist on the Graph as main
	 * program or another dependency.
	 * 
	 * @InPut: Parsed Command List
	 * 
	 * @OutPut: dependency Map of <String, Program>
	 */
	private Map<String, Program> createMap(List<String> parsedCommandList) {

		List<String> actualDepedencies = parsedCommandList.subList(2, parsedCommandList.size());
		Map<String, Program> dependencyMap = new HashMap<>();
		for (String d : actualDepedencies) {
			Optional<Program> existingProgram = shallowSearchForProgram(d);
			existingProgram = !existingProgram.isPresent() ? searchProgramInEntireadjcList(d) : existingProgram;
			Program dependency = existingProgram.isPresent() ? existingProgram.get() : buildProgram(d, false);
			dependencyMap.put(dependency.getProgramName(), dependency);
		}
		return dependencyMap;
	}

	/**
	 * Method to simply add Program to the Graph on the main level.
	 * 
	 * @InPut: Program
	 * 
	 * @OutPut: Returns Nothing.
	 */
	private void addToDependencyGraph(Program program) {
		if (!isNodeAddedToGraph(program))
			programGraph.add(program);
	}

	/**
	 * Method to search for a Program on the main level. It does not check if it is
	 * installed or if it is the Explicit Install.
	 * 
	 * @Input: Program Name
	 * 
	 * @OutPut: Optional Instance of Program
	 */
	private Optional<Program> shallowSearchForProgram(String Program) {
		List<Program> programList = programGraph.stream().filter(p -> p.getProgramName().equalsIgnoreCase(Program))
				.collect(Collectors.toList());
		return programList.size() > 0 ? Optional.of(programList.get(0)) : Optional.empty();

	}

	/**
	 * Method to simply return the list of all the Programs on main level in Graph.
	 * No Filters Applied
	 * 
	 * @InPut: Not Applicable
	 * 
	 * @OutPut: List of programs Present On Graph.
	 */
	public List<String> listCurrentlyInstalled() {
		return programGraph.stream().map(p -> p.getProgramName()).collect(Collectors.toList());
	}

}
