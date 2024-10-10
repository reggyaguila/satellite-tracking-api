package com.example.demo;

import org.orekit.data.DataProvidersManager;
import org.orekit.data.ClasspathCrawler;
import org.orekit.data.DataContext;
import org.orekit.time.TimeScalesFactory;

public class OrekitInitializer {
    public static void initOrekit() {
        try {
            // Get the default DataProvidersManager
            DataProvidersManager manager = DataContext.getDefault().getDataProvidersManager();

            // Add your ClasspathCrawler to the manager
            ClasspathCrawler crawler = new ClasspathCrawler("orekit-data");
            manager.addProvider(crawler);

            // Force loading of time scales to check if data is loaded
            TimeScalesFactory.getUTC();

            System.out.println("Orekit data initialized successfully from classpath.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
