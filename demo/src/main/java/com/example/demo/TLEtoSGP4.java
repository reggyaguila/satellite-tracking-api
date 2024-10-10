package com.example.demo;

import org.hipparchus.geometry.euclidean.threed.Vector3D;
import org.orekit.propagation.analytical.tle.TLE;
import java.util.HashMap;

public class TLEtoSGP4 {

    private HashMap<String, SatelliteInfo> satelliteInfoMap;

    public TLEtoSGP4() {
        OrekitInitializer.initOrekit();
        satelliteInfoMap = new HashMap<>();
        processSatelliteData();
    }

    private void processSatelliteData() {
        TLEFetch fetch = new TLEFetch();
        HashMap<String, String> satelliteMap = fetch.getSatelliteMap();

        for (String satelliteName : satelliteMap.keySet()) {
            String tleData = satelliteMap.get(satelliteName);
            String[] tleLines = tleData.split("\n");

            if (tleLines.length >= 2) {
                TLE tle = new TLE(tleLines[0], tleLines[1]);
                SatelliteInfo satInfo = new SatelliteInfo(satelliteName, tle);

                satelliteInfoMap.put(satelliteName, satInfo);
            }
            else {
                System.err.println("Invalid TLE data for satellite" + satelliteName);
            }
        }
    }

    public void displaySatellitePositions() {
        for (SatelliteInfo satInfo: satelliteInfoMap.values()) {
            String name = satInfo.getSatName();
            Vector3D position = satInfo.getPosition();
            Vector3D velocity = satInfo.getVelocity();

            System.out.println("com.example.demo.Satellite: " + name);
            System.out.println("Position (km): " + position);
            System.out.println("Velocity (km/s): " + velocity);
        }
    }

    public HashMap<String, SatelliteInfo> getSatelliteInfoMap() {
        return satelliteInfoMap;
    }


}
