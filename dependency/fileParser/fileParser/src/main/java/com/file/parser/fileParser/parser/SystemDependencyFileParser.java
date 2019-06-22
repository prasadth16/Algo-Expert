package com.file.parser.fileParser.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SystemDependencyFileParser {

	
	private SystemDependencyInstructionStorage instructionStorage;
	private static Logger LOGGER = LoggerFactory.getLogger(SystemDependencyInstructionStorage.class);

	public SystemDependencyFileParser(SystemDependencyInstructionStorage instructionStorage) {
		this.instructionStorage = instructionStorage;
	}

	public void readInputFile(String filePath) {
		String line = null;

		try (FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {

			while ((line = bufferedReader.readLine()) != null) {
				instructionStorage.addInstructions(line);
			}
		} catch (FileNotFoundException exception) {
			LOGGER.info("Input File Does not exist", exception.getMessage());

		} catch (IOException exception) {
			LOGGER.info("IOException Occured", exception.getMessage());

		} catch (Exception exception) {
			LOGGER.info("Exception Occured", exception.getMessage());

		}

	}

	public List<String> getInstructionList() {
		return instructionStorage.getSystemInstructionList();
	}

}
