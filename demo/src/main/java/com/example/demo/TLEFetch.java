package com.example.demo;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TLEFetch {
    HashMap<String, String> satelliteMap = new HashMap<String, String>();

    public TLEFetch() {
        OrekitInitializer.initOrekit();
        satelliteMap = new HashMap<>();
        fetchTLEData();
    }

    private void fetchTLEData() {

        try {
            String url = "https://celestrak.com/NORAD/elements/gp.php?GROUP=starlink&FORMAT=tle";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                String satelliteName = null;
                String tleLine1 = null;
                String tleLine2 = null;
                int lineCounter = 0;
                while ((inputLine = in.readLine()) != null) {
                    inputLine = inputLine.trim();
                    if (inputLine.isEmpty()) {
                        continue;
                    }
                    lineCounter++;

                    if (lineCounter % 3 == 1) {
                        satelliteName = inputLine;
                    }
                    else if (lineCounter % 3 == 2) {
                        tleLine1 = inputLine;
                    }
                    else if (lineCounter % 3 == 0) {
                        tleLine2 = inputLine;

                        if (satelliteName != null && tleLine1 != null && tleLine2 != null) {
                            String tleData = tleLine1 + "\n" + tleLine2;
                            satelliteMap.put(satelliteName, tleData);
                        }
                    }
                }
                in.close();
            }
            else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HashMap<String, String> getSatelliteMap() {
        return satelliteMap;
    }
}
