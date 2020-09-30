package com.startup_heroes.courier_track_app.repositories;

import com.startup_heroes.courier_track_app.models.*;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourierRepository extends JpaRepository<CourierModel, Long> {
    List<CourierModel> findAll();

    CourierModel findById(String id);

    @Override
    <S extends CourierModel> S save(S s);
}
