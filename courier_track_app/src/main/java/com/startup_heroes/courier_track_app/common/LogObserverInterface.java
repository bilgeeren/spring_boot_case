package com.startup_heroes.courier_track_app.common;

import com.startup_heroes.courier_track_app.models.CourierLogModel;

public interface LogObserverInterface {
    void update(CourierLogModel newLog);
}
