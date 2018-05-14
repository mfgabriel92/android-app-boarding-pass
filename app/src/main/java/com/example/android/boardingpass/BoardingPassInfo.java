package com.example.android.boardingpass;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class BoardingPassInfo {

    public String passengerName,
                  flightCode,
                  originCode,
                  destCode,
                  departureTerminal,
                  departureGate,
                  seatNumber;
    public Timestamp boardingTime,
                     departureTime,
                     arrivalTime;
    public int barCode;

    public long getMinutesUntilBoarding() {
        long millis = boardingTime.getTime() - System.currentTimeMillis();
        return TimeUnit.MILLISECONDS.toMinutes(millis);
    }
}
