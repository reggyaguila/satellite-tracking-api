package com.example.demo;

import org.hipparchus.geometry.euclidean.threed.Vector3D;
import org.orekit.propagation.analytical.tle.TLE;
import org.orekit.propagation.analytical.tle.TLEPropagator;
import org.orekit.propagation.SpacecraftState;
import org.orekit.time.AbsoluteDate;

public class SatelliteInfo {
    private String satName;
    private TLE tle;
    private AbsoluteDate targetDate;
    private SpacecraftState state;
    private Vector3D position;
    private Vector3D velocity;

    public SatelliteInfo(String satName, TLE tle) {
        OrekitInitializer.initOrekit();
        this.satName = satName;
        this.tle = tle;
        propagateTLE();
    }
    public String getSatName() {
        return satName;
    }
    public TLE getTle(){
        return tle;
    }

    private void propagateTLE() {
        TLEPropagator propagator = TLEPropagator.selectExtrapolator(tle);
        targetDate = new AbsoluteDate();
        state = propagator.propagate(targetDate);
        position = state.getPVCoordinates().getPosition();
        velocity = state.getPVCoordinates().getVelocity();
    }

    public Vector3D getPosition() {
        return position;
    }

    public Vector3D getVelocity() {
        return velocity;
    }
}
