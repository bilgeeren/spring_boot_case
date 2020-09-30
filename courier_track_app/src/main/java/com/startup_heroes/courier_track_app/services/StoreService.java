package com.startup_heroes.courier_track_app.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.startup_heroes.courier_track_app.models.StoreModel;
import com.startup_heroes.courier_track_app.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.file.Paths;
import java.util.List;

@Service
public class StoreService {
    @Autowired
    StoreRepository storeRepository;

    @PostConstruct
    public void loadStoreList() {
        try {
            List<StoreModel> stores = new ObjectMapper().readValue(Paths.get("./src/main/java/com/startup_heroes/courier_track_app/common/StoreList").toFile(), new TypeReference<List<StoreModel>>() {});
            stores.forEach(store -> storeRepository.save(store));
        } catch (Exception e) {
            System.out.println("Unable to save store: " + e.getMessage());
        }
    }
}
