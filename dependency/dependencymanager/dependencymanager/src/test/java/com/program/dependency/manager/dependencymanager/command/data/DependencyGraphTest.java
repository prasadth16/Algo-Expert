package com.program.dependency.manager.dependencymanager.command.data;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class DependencyGraphTest {

	public DependencyGraph graph;

	private List<String> commandList;
	private List<String> commandList1;
	private List<String> commandList2;
	private List<String> commandList3;
	private List<String> commandList4;

	@Before
	public void onSetUp() {
		graph = new DependencyGraph();
		commandList = new ArrayList<>();
		commandList.add("DEPEND");
		commandList.add("TELNET");
		commandList.add("TCPIP");
		commandList.add("NETCARD");

		commandList1 = new ArrayList<>();
		commandList1.add("DEPEND");
		commandList1.add("DNS");
		commandList1.add("TCPIP");
		commandList1.add("NETCARD");

		commandList2 = new ArrayList<>();
		commandList2.add("DEPEND");
		commandList2.add("BROWSER");
		commandList2.add("TCPIP");
		commandList2.add("HTML");

		commandList3 = new ArrayList<>();
		commandList3.add("DEPEND");
		commandList3.add("TCPIP");
		commandList3.add("NETCARD");

		commandList4 = new ArrayList<>();
		commandList4.add("DEPEND");
		commandList4.add("TCPIP");
		commandList4.add("NETCARD");

	}

	@Test
	void testaddDependency() {
		onSetUp();
		List<String> result = new ArrayList<>();
		result.add("TELNET");
		result.add("DNS");
		result.add("BROWSER");
		result.add("TCPIP");

		graph.addDependency(commandList);
		graph.addDependency(commandList1);
		graph.addDependency(commandList2);
		graph.addDependency(commandList3);
		assertIterableEquals(result, graph.listCurrentlyInstalled());
		List<String> commandList5 = new ArrayList<>();
		commandList5.add("DEPEND");
		commandList5.add("TCPIP");
		commandList5.add("NETCARD");
		graph.addDependency(commandList5);
		assertIterableEquals(result, graph.listCurrentlyInstalled());
	}

	@Test
	void testInstallDependencies() {
		testaddDependency();
		graph.installProgram("NETCARD", false);
		graph.installProgram("TELNET", false);
		graph.installProgram("BROWSER", false);
		assertTrue(graph.listCurrentlyInstalled().size() == 6);
	}

	@Test
	void testRemoveDepndency() {

	}

	@Test
	void testListDependencies() {

	}

}
