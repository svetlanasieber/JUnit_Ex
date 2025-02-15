package TirePressureMonitoringSystem;

import java.util.Random;

public class Sensor {

    private static final double OFFSET = 16;

    private static Random randomPressureSampleSimulator = new Random();

    public double popNextPressurePsiValue() {
        double pressureTelemetryValue = readPressureSample();
        return OFFSET + pressureTelemetryValue;
    }

    private double readPressureSample() {
        return 6 * randomPressureSampleSimulator.nextDouble() * randomPressureSampleSimulator.nextDouble();
    }
}
