package com.example.android.boardingpass;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class FakeDataUtils {

    public static BoardingPassInfo generateFakeBoardingPassInfo() {
        BoardingPassInfo bpi = new BoardingPassInfo();
        bpi.passengerName = "MR. RANDOM NAME";
        bpi.flightCode = "UD 777";
        bpi.originCode = "DVO";
        bpi.destCode = "POA";

        long now = System.currentTimeMillis();
        long randomMinutes = (long) (Math.random() * 30);
        long totalBoardingMins = 40;
        long randomHours = (long) (Math.random() * 5 + 1);
        long boardingMills = now + minutesToMillis(randomMinutes);
        long departure = boardingMills + minutesToMillis(totalBoardingMins);
        long arrival = departure + hoursToMillis(randomHours);

        bpi.boardingTime = new Timestamp(boardingMills);
        bpi.departureTime = new Timestamp(departure);
        bpi.arrivalTime = new Timestamp(arrival);
        bpi.departureTerminal = String.valueOf((long) (Math.random() * 99) + 1) + "A";
        bpi.departureGate = String.valueOf((long) (Math.random() * 99) + 1) + "C";
        bpi.seatNumber = String.valueOf((long) (Math.random() * 200) + 1) + "Z";
        bpi.barCode = R.drawable.art_barcode;

        return bpi;
    }

    private static long minutesToMillis(long minutes) {
        return TimeUnit.MINUTES.toMillis(minutes);
    }

    private static long hoursToMillis(long hours) {
        return TimeUnit.HOURS.toMillis(hours);
    }
}
