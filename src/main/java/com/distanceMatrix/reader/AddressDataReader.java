package com.distanceMatrix.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressDataReader {

	public static List<String> readAddressses(final String filePath) throws FileNotFoundException {
		Scanner scanner = FileReader.read(filePath);

		return getAddresses(scanner);
	}

	public static List<String> readAddressses(final File file) throws FileNotFoundException {
		Scanner scanner = FileReader.read(file);

		return getAddresses(scanner);
	}

	private static List<String> getAddresses(final Scanner scanner) {
		List<String> addresses = new ArrayList<>();

		while (scanner.hasNextLine()) {
			addresses.add(scanner.nextLine());
		}

		return addresses;
	}

}
