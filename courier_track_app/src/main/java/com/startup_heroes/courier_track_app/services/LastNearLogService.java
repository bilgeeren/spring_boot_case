package com.startup_heroes.courier_track_app.services;

import com.startup_heroes.courier_track_app.common.LogObserverServiceInterface;
import com.startup_heroes.courier_track_app.models.CourierLogModel;
import com.startup_heroes.courier_track_app.models.LastNearLogModel;
import com.startup_heroes.courier_track_app.models.StoreModel;
import com.startup_heroes.courier_track_app.repositories.CourierLogRepository;
import com.startup_heroes.courier_track_app.repositories.LastNearLogRepository;
import com.startup_heroes.courier_track_app.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class LastNearLogService implements LogObserverServiceInterface {

    @Autowired
    CourierLogRepository courierLogRepository;
    @Autowired
    LastNearLogRepository lastNearLogRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    DistanceService distanceService;

    private String resultString = "";

    public String getResultString()
    {
        return this.resultString;
    }

    public void updateResultString(String newString)
    {
        this.resultString = newString + "\n" + this.resultString;
    }


    private void isCourierNearAnyStore(CourierLogModel courierLogModel)
    {
        List<StoreModel> lisOfStores = storeRepository.findAll();
        List<String> resultList = new ArrayList<String>();
        for(int i = 0; i < lisOfStores.size(); i++)
        {
            StoreModel store = lisOfStores.get(i);
            double distance = distanceService.calculateDistanceBetweenTwoPointsInMeters(courierLogModel.lat,courierLogModel.lng,store.lat,store.lng);
            if ( distance <= 100 )
            {
                if( !this.checkIfLessThanOneMinute(courierLogModel.courierId, store.id, courierLogModel.logTime) )
                    resultList.add(store.name);
            }
        }
        if(resultList.size() > 0 ){
            String responseString = "TIME: " +courierLogModel.logTime + " - Courier with " + courierLogModel.courierId + " id is in 100 meter range of given stores: \n" + String.join(",", resultList);
            this.updateResultString(responseString);
        }
    }

    private boolean checkIfLessThanOneMinute(String courierId, String storeId, Time time)
    {
        LastNearLogModel lastNearLogModel = lastNearLogRepository.findLastNearLogModelByCourierIdAndStoreId(courierId,storeId);
        if (lastNearLogModel != null && time.getTime() - lastNearLogModel.logTime.getTime() > 60000) {
            this.updateNearStoreLog(lastNearLogModel, time);
            return false;
        }
        else if (lastNearLogModel == null){
            LastNearLogModel newLastNearLogModel = new LastNearLogModel(courierId, storeId, time);
            lastNearLogRepository.save(newLastNearLogModel);
            return false;
        }
        return true;
    }

    private void updateNearStoreLog(LastNearLogModel lastNearLogModel, Time time)
    {
        lastNearLogModel.logTime = time;
        lastNearLogRepository.save(lastNearLogModel);
    }

    @Override
    public void update(CourierLogModel newLog) {
        this.isCourierNearAnyStore(newLog);
    }
}
