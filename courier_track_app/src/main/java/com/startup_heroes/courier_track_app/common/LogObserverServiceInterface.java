package com.startup_heroes.courier_track_app.common;

import com.startup_heroes.courier_track_app.models.CourierLogModel;

public interface LogObserverServiceInterface {
    void update(CourierLogModel newLog);
}
