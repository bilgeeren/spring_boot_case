package com.startup_heroes.courier_track_app.services;
import com.startup_heroes.courier_track_app.common.LogObserverServiceInterface;
import com.startup_heroes.courier_track_app.models.*;
import com.startup_heroes.courier_track_app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {
    @Autowired
    CourierLogRepository courierLogRepository;
    @Autowired
    DistanceService distanceService;
    @Autowired
    CourierRepository courierRepository;
    @Autowired
    CourierService courierService;
    @Autowired
    LastNearLogService lastNearLogService;

    private List<LogObserverServiceInterface> observers = new ArrayList<>();

    @PostConstruct
    public void registerObservers()
    {
        this.addObserver(courierService);
        this.addObserver(lastNearLogService);
    }

    private void addObserver(LogObserverServiceInterface observer)
    {
        this.observers.add(observer);
    }

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
        CourierLogModel newLog = courierLogRepository.save(courierLogModel);
        observers.forEach(observer -> observer.update(newLog));
        return newLog;
    }
}
