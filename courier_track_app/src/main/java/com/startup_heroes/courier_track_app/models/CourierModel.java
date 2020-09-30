package com.startup_heroes.courier_track_app.models;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "courier")
public class CourierModel {

    @Id
    @Column(name="id")
    public String id;

    @Column(name="latitude")
    public double latitude;
    @Column(name="longitude")
    public double longitude;
    @Column(name="time")
    public Time time;
    @Column(name="distance")
    public double distance;

    public CourierModel() {}

    public CourierModel(String id,double latitude, double longitude, Time time, double distance) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
        this.distance = distance;
    }
}
