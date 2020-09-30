package com.startup_heroes.courier_track_app.controllers;

import com.startup_heroes.courier_track_app.models.*;
import com.startup_heroes.courier_track_app.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    @Autowired
    StoreRepository storeRepository;

    @GetMapping("/store")
    public List<StoreModel> getAllStores() {
        return storeRepository.findAll();
    }

    @GetMapping("/store/")
    public StoreModel getStoreByID(@RequestParam String id) { return storeRepository.findById(id); }

    @PostMapping("/store")
    public StoreModel saveNewStore(@RequestBody StoreModel store) {
        return storeRepository.save(store);
    }
}
