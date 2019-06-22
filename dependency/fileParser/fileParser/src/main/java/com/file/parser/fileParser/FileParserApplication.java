package com.file.parser.fileParser;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.file.parser.fileParser.parser.SystemDependencyFileParser;
import com.file.parser.fileParser.parser.SystemDependencyInstructionStorage;

@Configuration
@ComponentScan("com.file.parser.fileParse.parser")
public class FileParserApplication {

	@Bean(name = "systemInstructionList")
	public List<String> supplyList() {
		 return new ArrayList<String>();
	}

	@Bean("instructionStorage")
	public SystemDependencyInstructionStorage systemDependencyInstructionStorage(
			@Qualifier("systemInstructionList") List<String> systemInstructionList) {
		return new SystemDependencyInstructionStorage(systemInstructionList);
	}

	@Bean
	public SystemDependencyFileParser systemDependencyFileParser(
			@Qualifier("instructionStorage") SystemDependencyInstructionStorage systemDependencyInstructionStorage) {
		return new SystemDependencyFileParser(systemDependencyInstructionStorage);
	}

}
