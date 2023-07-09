package dev.pascan.commands.orbits;

import dev.pascan.Constants;
import dev.pascan.commands.orbits.sgp4.SGP4;
import dev.pascan.commands.orbits.sgp4.TLE;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Satellite {
    public static void getPosition(TLE tle, Date date) {
        System.out.println(Arrays.deepToString(tle.getRV(date)));
    }

    public SphericalPoint rToSpherical(double[] xyz) {
        double x = xyz[0];
        double y = xyz[1];
        double z = xyz[2];

        double rho = Math.sqrt(x*x + y*y + z*z);
        double theta = Math.atan2(y, x);
        double phi = Math.acos(z / rho);

        return new SphericalPoint(rho, theta, phi);
    }

    public GroundPos convertToLatLon(SphericalPoint point) {
        double rho = point.rho;
        double theta = point.theta;
        double phi = point.phi;
        double gmst = calculateGMST(new Date());

        double longitude = theta + gmst;
        longitude = Math.toDegrees(normalizeAngle(longitude));
        double latitude = Math.toDegrees(Math.PI / 2 - phi);
        return new GroundPos(latitude, longitude, rho);
    }

    private static double normalizeAngle(double angle) {
        double normalized = angle % (2 * Math.PI);
        if (normalized < 0) {
            normalized += 2 * Math.PI;
        }
        return normalized;
    }

    public static double calculateJulianDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Adjust the month and year for the Julian calendar
        if (month <= 2) {
            year -= 1;
            month += 12;
        }

        int a = year / 100;
        int b = a / 4;
        int c = 2 - a + b;
        int e = (int) (365.25 * (year + 4716));
        int f = (int) (30.6001 * (month + 1));

        double julianDay = c + day + e + f - 1524.5;

        return julianDay;
    }

    public static double calculateGMST(Date date) {
        double julianDay = calculateJulianDay(date);
        double centuriesSinceEpoch = (julianDay - 2451545.0) / 36525.0;
        double wholeDaysSinceEpoch = Math.floor(julianDay - 0.5) - 2451545.0;
        double hoursSinceMidnight = ((julianDay - 0.5) % 1.0) * 24.0;

        double gmst = 6.697374558 +
            0.06570982441908 * wholeDaysSinceEpoch +
            1.00273790935 * hoursSinceMidnight +
            0.000026 * Math.pow(centuriesSinceEpoch, 2);

        double gmstHours = gmst % 24;
        double gmstMinutes = Math.floor((gmstHours % 1) * 60);
        double gmstSeconds = Math.floor(((gmstHours * 60) % 1) * 60);

        return Math.toRadians(gmstHours + gmstMinutes / 60.0 + gmstSeconds / 3600.0);
    }


    class SphericalPoint {
        double rho;
        double theta;
        double phi;

        public SphericalPoint(double rho, double theta, double phi) {
            this.rho = rho;
            this.theta = theta;
            this.phi = phi;
        }

        public SphericalPoint(RectangularPoint xyz) {
            double x = xyz.x;
            double y = xyz.y;
            double z = xyz.z;

            double rho = Math.sqrt(x*x + y*y + z*z);
            double theta = Math.atan2(y, x);
            double phi = Math.acos(z / rho);
        }
    }

    class RectangularPoint {
        double x;
        double y;
        double z;

        public RectangularPoint(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public RectangularPoint(SphericalPoint rtp) {
            double rho = rtp.rho;
            double theta = rtp.theta;
            double phi = rtp.phi;
        }
    }

    class GroundPos {
        double lat;
        double lon;
        double elevation;

        public GroundPos(double latitude, double longitude, double rho) {
            this.lat = latitude;
            this.lon = longitude;
            this.elevation = rho - Constants.EARTH_RADIUS;
        }
    }
}