package com.startup_heroes.courier_track_app.services;
import com.startup_heroes.courier_track_app.models.*;
import com.startup_heroes.courier_track_app.repositories.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    CourierLogRepository courierLogRepository;
    @Autowired
    DistanceService distanceService;
    @Autowired
    CourierRepository courierRepository;

    public double calculateTotalDistanceWithNewLog(CourierLogModel courierLogModel)
    {
        CourierModel courierLastPosition = courierRepository.findById(courierLogModel.courierId);

        if (courierLastPosition == null) return 0;
        else
        {
            return courierLastPosition.distance + distanceService.calculateDistanceBetweenTwoPointsInMeters(courierLogModel.lat,courierLogModel.lng, courierLastPosition.latitude,courierLastPosition.longitude);
        }

    }

    public CourierLogModel saveLog(CourierLogModel courierLogModel)
    {
        return courierLogRepository.save(courierLogModel);
    }
}
