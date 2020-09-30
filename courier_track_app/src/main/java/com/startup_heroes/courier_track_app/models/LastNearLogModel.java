package com.startup_heroes.courier_track_app.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

class LastNearLogId implements Serializable {
    private String courierId;

    private String storeId;
    public LastNearLogId() {}

    public LastNearLogId(String courierId, String storeId) {
        this.courierId = courierId;
        this.storeId = storeId;
    }
}
@Entity
@Table(name = "lastnearlog")
@IdClass(LastNearLogId.class)
public class LastNearLogModel {

    @Id
    @Column(name="courierId")
    public String courierId;
    @Id
    @Column(name="storeId")
    public String storeId;
    @Column(name="logTime")
    public Time logTime;

    public LastNearLogModel() {}

    public LastNearLogModel(String courierId, String storeId, Time logTime) {
        this.courierId = courierId;
        this.storeId = storeId;
        this.logTime = logTime;
    }
}
