package com.startup_heroes.courier_track_app.repositories;

import com.startup_heroes.courier_track_app.models.LastNearLogModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LastNearLogRepository extends JpaRepository<LastNearLogModel, Long> {
    List<LastNearLogModel> findAll();

    @Override
    <S extends LastNearLogModel> S save(S s);

    LastNearLogModel findLastNearLogModelByCourierIdAndStoreId(String courierId, String storeId);


}
