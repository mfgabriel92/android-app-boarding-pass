package com.example.android.boardingpass;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.boardingpass.databinding.ActivityMainBinding;
import com.example.android.boardingpass.databinding.BoardingTableBinding;
import com.example.android.boardingpass.databinding.FlightInfoBinding;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        BoardingPassInfo boardingPassInfo = FakeDataUtils.generateFakeBoardingPassInfo();

        mBinding.tvPassengerName.setText(boardingPassInfo.passengerName);
        mBinding.layoutFlightInfo.tvFlightCode.setText(boardingPassInfo.flightCode);
        mBinding.layoutFlightInfo.tvDepartureAirport.setText(boardingPassInfo.originCode);
        mBinding.layoutFlightInfo.tvArrivalAirport.setText(boardingPassInfo.destCode);

        SimpleDateFormat formatter = new SimpleDateFormat(getString(R.string.time_format), Locale.getDefault());

        mBinding.tvBoardingTime.setText(formatter.format(boardingPassInfo.boardingTime));
        mBinding.tvDepartureTime.setText(formatter.format(boardingPassInfo.departureTime));
        mBinding.tvArrivalTime.setText(formatter.format(boardingPassInfo.arrivalTime));

        long minutesUntilBoarding = boardingPassInfo.getMinutesUntilBoarding();
        long hoursUntilBoarding = TimeUnit.MINUTES.toHours(minutesUntilBoarding);
        long minutesLessUntilBoarding = minutesUntilBoarding - TimeUnit.HOURS.toMinutes(hoursUntilBoarding);

        String hoursAndMinsUntilBoarding = getString(R.string.countdown_format, hoursUntilBoarding, minutesLessUntilBoarding);

        mBinding.tvBoardingInTime.setText(hoursAndMinsUntilBoarding);
        mBinding.layoutBoardingTable.tvBoardTerminal.setText(boardingPassInfo.departureTerminal);
        mBinding.layoutBoardingTable.tvBoardGate.setText(boardingPassInfo.departureGate);
        mBinding.layoutBoardingTable.tvBoardSeat.setText(boardingPassInfo.seatNumber);
    }
}
