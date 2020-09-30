package com.startup_heroes.courier_track_app.controllers;

import com.startup_heroes.courier_track_app.models.CourierLogModel;
import com.startup_heroes.courier_track_app.models.LastNearLogModel;
import com.startup_heroes.courier_track_app.repositories.CourierLogRepository;
import com.startup_heroes.courier_track_app.repositories.LastNearLogRepository;
import com.startup_heroes.courier_track_app.services.CourierService;
import com.startup_heroes.courier_track_app.services.LastNearLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.startup_heroes.courier_track_app.services.LogService;

import java.util.List;

@RestController
public class LogController {
    @Autowired
    CourierLogRepository courierLogRepository;
    @Autowired
    LastNearLogRepository lastNearLogRepository;
    @Autowired
    LogService logService;
    @Autowired
    LastNearLogService lastNearLogService;
    @Autowired
    CourierService courierService;

    @GetMapping("/courierLogs/")
    public List<CourierLogModel> getAllCourierLogsById(@RequestParam String id) {
        return courierLogRepository.findAllByCourierId(id);
    }

    @GetMapping("/courierLogs")
    public List<CourierLogModel> getAllCourierLogs() { return courierLogRepository.findAll(); }

    @GetMapping("/lastNearLogs")
    public List<LastNearLogModel> getAllLastNearLogs() {
        return lastNearLogRepository.findAll();
    }

    @PostMapping("/courierLogs/addLog")
    public String saveNewLog(@RequestBody CourierLogModel courierLog) {
        CourierLogModel newLog = logService.saveLog(courierLog);
        return lastNearLogService.getResultString();
    }
}
