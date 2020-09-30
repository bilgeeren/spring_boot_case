package com.startup_heroes.courier_track_app.controllers;

import com.startup_heroes.courier_track_app.models.*;
import com.startup_heroes.courier_track_app.repositories.CourierRepository;
import com.startup_heroes.courier_track_app.services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CourierController {
    @Autowired
    CourierRepository courierRepository;
    @Autowired
    CourierService courierService;

    @GetMapping("/courier")
    public List<CourierModel> getCourierList() {
        return courierRepository.findAll();
    }

    @GetMapping("/courier/")
    public CourierModel getCourierById(@RequestParam String id) { return courierRepository.findById(id); }

    @GetMapping("/courier/totalDistance/")
    public double getTotalDistance(@RequestParam String id) { return courierService.getTotalDistance(id); }

    @PostMapping("/courier")
    public CourierModel saveNewCourier (@RequestBody CourierModel courier) {
        return courierRepository.save(courier);
    }
}
