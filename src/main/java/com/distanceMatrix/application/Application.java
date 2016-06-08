package com.distanceMatrix.application;

import java.util.List;

import com.distanceMatrix.reader.AddressDataReader;
import com.distanceMatrix.service.distancematrix.DistanceMatrixService;
import com.distanceMatrix.writer.DistanceMatrixWriter;
import com.google.maps.GeoApiContext;

public class Application {

	public static void main(String[] args) throws Exception {
		InputResolver inputResolver = new InputResolver(args);

		GeoApiContext context = new GeoApiContext().setApiKey(inputResolver.getApiKey());

		List<String> addresses = AddressDataReader.readAddressses(inputResolver.getAddressFile());

		long[][] distanceMatrix = DistanceMatrixService.getMatrixForAddresses(context, addresses);

		DistanceMatrixWriter.write(distanceMatrix);
	}

}
