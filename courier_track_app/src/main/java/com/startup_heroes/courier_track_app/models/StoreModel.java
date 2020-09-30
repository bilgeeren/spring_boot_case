package com.startup_heroes.courier_track_app.models;

import javax.persistence.*;

@Entity
@Table(name = "store")
public class StoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public String id;
    @Column(name="name")
    public String name;
    @Column(name="lat")
    public double lat;
    @Column(name="lng")
    public double lng;

    public StoreModel() {}

    public StoreModel(String name ,double lat, double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }
}
