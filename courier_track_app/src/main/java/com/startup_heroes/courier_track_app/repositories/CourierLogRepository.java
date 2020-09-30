package com.startup_heroes.courier_track_app.repositories;
import com.startup_heroes.courier_track_app.models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourierLogRepository extends JpaRepository<CourierLogModel, Long> {
    List<CourierLogModel> findAll();

    List<CourierLogModel> findAllByCourierId(String courierId);

    @Override
    <S extends CourierLogModel> S save(S s);
}
