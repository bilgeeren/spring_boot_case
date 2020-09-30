package com.startup_heroes.courier_track_app.repositories;

import com.startup_heroes.courier_track_app.models.*;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface StoreRepository extends JpaRepository<StoreModel, Long> {

    List<StoreModel> findAll();

    StoreModel findById(String Id);

    @Override
    <S extends StoreModel> S save(S s);

}
