package com.distanceMatrix.writer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DistanceMatrixWriter {

	public static final String DISTANCE_MATRIX_FILE_PATH = "distanceMatrix.txt";

	public static void write(final long[][] matrix) throws FileNotFoundException {
		List<String> raw = new ArrayList<String>();

		for (int i = 0; i < matrix.length; i++) {
			String line = new String();

			for (int j = 0; j < matrix[0].length; j++) {
				line += matrix[i][j];
				line += "\t";
			}

			raw.add(line);
		}

		String[] distArr = raw.toArray(new String[raw.size()]);

		FileWriter.write(distArr, DISTANCE_MATRIX_FILE_PATH);
	}

}
