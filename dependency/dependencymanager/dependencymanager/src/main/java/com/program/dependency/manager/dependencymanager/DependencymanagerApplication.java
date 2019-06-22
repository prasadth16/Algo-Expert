package com.program.dependency.manager.dependencymanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.file.parser.fileParser.FileParserApplication;
import com.program.dependency.manager.dependencymanager.command.data.DependencyGraph;
import com.program.dependency.manager.dependencymanager.command.parser.DefaultInputCommandParserService;
import com.program.dependency.manager.dependencymanager.command.parser.InputCommandParserService;
import com.program.dependency.manager.dependencymanager.manager.DependencyManager;

@Configuration
@ComponentScan({ "com.program.dependency.manager.dependencymanager.command.data",
		"com.program.dependency.manager.dependencymanager.command.parser",
		"com.program.dependency.manager.dependencymanager.manager" })
@Import(FileParserApplication.class)
public class DependencymanagerApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(DependencymanagerApplication.class);

	public static void main(String[] args) {
		System.out.println("Installations Started!!!!");
		AnnotationConfigApplicationContext SpringContext = new AnnotationConfigApplicationContext(
				DependencymanagerApplication.class, FileParserApplication.class);
		DependencyManager dependencyManager = SpringContext.getBean(DependencyManager.class);
		dependencyManager.startSystemDependencyInstallation();
		System.out.println("Installations Finished!!!!");
	}

	@Bean
	DependencyGraph dependencyGraph() {
		return new DependencyGraph();
	}

	@Bean
	InputCommandParserService defaultInputCommandParserService(DependencyGraph dependencyGraph) {
		return new DefaultInputCommandParserService(dependencyGraph);
	}

}
