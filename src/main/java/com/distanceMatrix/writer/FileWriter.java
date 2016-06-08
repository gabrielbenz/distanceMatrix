package com.distanceMatrix.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {

	public static void write(final String[] contentLines, String filepath) throws FileNotFoundException {
		try {
			File output = new File(filepath);

			PrintWriter printer = new PrintWriter(output);

			for (String line : contentLines) {
				printer.write(line);
				printer.write("\n");
			}
			printer.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found. Please scan in new file.");
		}
	}

}
