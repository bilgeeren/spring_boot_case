package com.startup_heroes.courier_track_app.services;

import com.startup_heroes.courier_track_app.models.CourierLogModel;
import com.startup_heroes.courier_track_app.models.CourierModel;
import com.startup_heroes.courier_track_app.repositories.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierService {
    @Autowired
    CourierRepository courierRepository;
    @Autowired
    LogService logService;

    public void updateCourierCurrentPosition(CourierLogModel courierLog)
    {
        double totalDistance = logService.calculateTotalDistanceWithNewLog(courierLog);
        CourierModel courier = new CourierModel(courierLog.courierId, courierLog.lat, courierLog.lng, courierLog.logTime, totalDistance);
        courierRepository.save(courier);
    }

    public double getTotalDistance(String courierId)
    {
        return courierRepository.findById(courierId).distance;
    }
}
