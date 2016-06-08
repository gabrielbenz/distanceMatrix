package com.distanceMatrix.service.distancematrix;

import java.util.List;

import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.Distance;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;

public class DistanceMatrixService {

	private static final String PT_BT = "pt-BR";

	public static long[][] getMatrixForAddresses(final GeoApiContext context, final List<String> addresses) throws Exception {
		long[][] longDistanceMatrix = new long[addresses.size()][addresses.size()];

		for (int i = 0; i < addresses.size(); i++) {
			String originAddress = addresses.get(i);

			for (int j = 0; j < addresses.size(); j++) {
				if (i == j) {
					longDistanceMatrix[i][j] = 0;
				} else {
					if (i < j) {
						longDistanceMatrix[i][j] = getDistanceForMatrix(getMatrixOriginsAndDestinations(context, originAddress, addresses.get(j))); 
					} else {
						longDistanceMatrix[i][j] = longDistanceMatrix[j][i];
					}
				}
			}
		}

		return longDistanceMatrix;
	}

	private static DistanceMatrix getMatrixOriginsAndDestinations(final GeoApiContext context, final String origin, final String destination) throws Exception {
		return DistanceMatrixApi
			.newRequest(context)
			.origins(origin)
			.destinations(destination)
			.mode(TravelMode.DRIVING)
			.language(PT_BT)
			.avoid(RouteRestriction.TOLLS)
			.units(Unit.METRIC)
		.await();
	}

	private static long getDistanceForMatrix(final DistanceMatrix matrix) {
		for (DistanceMatrixRow distanceMatrixRow : matrix.rows) {
			for (DistanceMatrixElement distanceMatrixElement : distanceMatrixRow.elements) {
				Distance distance = distanceMatrixElement.distance;

				if (distance != null) {
					return distance.inMeters;
				}
			}
		}

		return -1;
	}

}
