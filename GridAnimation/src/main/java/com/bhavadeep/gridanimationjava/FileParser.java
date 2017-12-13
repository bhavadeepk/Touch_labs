package com.bhavadeep.gridanimationjava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileParser {

	private BufferedReader bfreader;


    /**
     * Constructor
      * @param inputFileName - User input file name
     */

    FileParser(String inputFileName) {
		try {
			FileReader fr = new FileReader(inputFileName);
			bfreader = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			System.err.println("Exception as input file not found");
			System.exit(1);
		}
    }

	/***
	 * Reads data from the file
     * @return - List of strings each representing a line from file(An actor)
	 */
	List<String> getActorsFromFile() {
		List<String> actorStringList = new ArrayList<>();
		try {

                String line ;
		        while((line= bfreader.readLine()) != null) {
                    actorStringList.add(line);
                }

		} catch (IOException e) {
			System.err.println("Exception due Stream Reader I/O operation ");
			System.exit(1);
		}
		return actorStringList;
	}

}
