package com.example.demo;

import jakarta.persistence.Id;


//@Entity
public class Satellite {
    /*//@Id
    private long id;
    private String name;
    private double latitude;
    private double longitude;*/
    public static void main(String[] args) {
        OrekitInitializer.initOrekit();
        TLEtoSGP4 tlEtoSGP4 = new TLEtoSGP4();

        //tlEtoSGP4.displaySatellitePositions();
    }
}
//annotate with JPA annotations (@Entity, @Id, @GeneratedValue)
