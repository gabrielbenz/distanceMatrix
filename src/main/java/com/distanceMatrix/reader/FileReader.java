package com.distanceMatrix.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	public static Scanner read(final String filePath) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(filePath);
		Scanner scanner = new Scanner(fis);

		return scanner;
	}

	public static Scanner read(final File file) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		Scanner scanner = new Scanner(fis);

		return scanner;
	}

}
