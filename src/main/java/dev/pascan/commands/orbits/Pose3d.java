package dev.pascan.commands.orbits;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Pose3d {
    public double x, y, z, rho, theta, phi, latitude, longitude, elevation;

    public void fromCoordinates(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.rho = Math.sqrt(x*x + y*y + z*z);
        this.theta = Math.atan2(y, x);
        this.phi = Math.acos(z / rho);
    }

    public void fromSpherical(double rho, double theta, double phi) {
        this.x = rho * Math.cos(theta) * Math.sin(phi);
        this.y = rho * Math.sin(theta) * Math.sin(phi);
        this.z = rho * Math.cos(phi);

        this.rho = rho;
        this.theta = theta;
        this.phi = phi;
    }

    private static double normalizeAngle(double angle) {
        double normalized = angle % (2 * Math.PI);
        if (normalized < 0) {
            normalized += 2 * Math.PI;
        }
        return normalized;
    }

    public static double toJDUt1(Instant instant) {
        long epochSeconds = instant.getEpochSecond();
        long millisecond = instant.toEpochMilli() % 1000;
        double jdUt1Days = epochSeconds / 86400.0 + millisecond / 86400000.0 + 2440587.5;
        return jdUt1Days;
    }

    public static double calcGMST() {
        Instant now = Instant.now();
        double jdUt1 = toJDUt1(now);
        double jdUt1Start = Math.floor(jdUt1);
        double fractionOfDay = jdUt1 - jdUt1Start;
        double jdUt1StartNoon = jdUt1Start + 0.5;
        double tUt1 = (jdUt1StartNoon - 2451545.0) / 36525.0;

        double gmstSeconds = 24110.54841 +
            8640184.812866 * tUt1 +
            0.093104 * Math.pow(tUt1, 2) -
            6.2 * Math.pow(10, -6) * Math.pow(tUt1, 3);

        gmstSeconds += 86400.0 * fractionOfDay;
        gmstSeconds = gmstSeconds % 86400.0;

        return gmstSeconds;
    }

    public void fromGroundPoseNow(double latitude, double longitude, double elevation) {

    }

    public void toGroundPoseNow() {

    }


}
