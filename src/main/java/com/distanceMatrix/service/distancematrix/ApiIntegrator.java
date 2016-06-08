package com.distanceMatrix.service.distancematrix;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import com.google.maps.GeoApiContext;

public class ApiIntegrator {

	public static GeoApiContext getApiContext(final String credential) throws FileNotFoundException {
		return new GeoApiContext()
			.setApiKey(credential)
			.setConnectTimeout(300, TimeUnit.SECONDS)
			.setReadTimeout(300, TimeUnit.SECONDS)
			.setWriteTimeout(300, TimeUnit.SECONDS);
	}

}
