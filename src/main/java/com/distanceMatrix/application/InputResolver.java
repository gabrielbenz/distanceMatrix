package com.distanceMatrix.application;

import java.io.File;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.FileConverter;

public class InputResolver {

	@Parameter(names = "-apiKey", description = "The Google API credential")
	private String apiKey;

	@Parameter(names = "-file", converter = FileConverter.class)
	private File addressFile;

	public InputResolver(String[] argsv) {
		new JCommander(this, argsv);
	}

	public String getApiKey() {
		return apiKey;
	}

	public File getAddressFile() {
		return addressFile;
	}

}
