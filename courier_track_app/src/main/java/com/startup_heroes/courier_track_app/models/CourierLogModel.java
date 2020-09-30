package com.startup_heroes.courier_track_app.models;

import javax.persistence.*;

import java.sql.Time;
@Entity
@Table(name = "courierlog")
public class CourierLogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public String id;
    @Column(name="courierId")
    public String courierId;
    @Column(name="lat")
    public double lat;
    @Column(name="lng")
    public double lng;
    @Column(name="logTime")
    public Time logTime;


    public CourierLogModel() {}

    public CourierLogModel(String courierId, double lat, double lng, String logTime ) {
        this.courierId = courierId;
        this.lat = lat;
        this.lng = lng;
        this.logTime = Time.valueOf(logTime);
    }

}
