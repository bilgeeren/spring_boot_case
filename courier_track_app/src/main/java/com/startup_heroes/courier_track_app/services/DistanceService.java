package com.startup_heroes.courier_track_app.services;

import org.springframework.stereotype.Service;

@Service
public class DistanceService {
    public double calculateDistanceBetweenTwoPointsInMeters(double fstLat, double fstLng, double sndLat, double sndLng)
    {
        double distance = org.apache.lucene.util.SloppyMath.haversinMeters(fstLat, fstLng, sndLat, sndLng);
        return distance;
    }
}
