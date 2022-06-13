package com.ammar.buxapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TicketDetail extends AppCompatActivity {
    Activity activity;
    TextView ratingNumber;
    public int rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);
        activity = this;
        ImageButton back_button = findViewById(R.id.back_button);
        ImageButton qrcode = findViewById(R.id.qrcode);
        TextView date = findViewById(R.id.dateDetail);
        TextView bookNumber = findViewById(R.id.bookNumberDetail);
        TextView poNameDetail = findViewById(R.id.poNameDetail);
        TextView nameDetail = findViewById(R.id.nameDetail);
        LinearLayout rating = findViewById(R.id.rating);
        ratingNumber = findViewById(R.id.ratingNumber);
        TextView phoneNumber = findViewById(R.id.phoneNumber);
        TextView seatsDetail = findViewById(R.id.seatsDetail);
        TextView statusPembayaranDetail = findViewById(R.id.statusPembayaranDetail);
        TextView poNumberDetail = findViewById(R.id.poNumberDetail);
        TextView startAt = findViewById(R.id.startAt);
        TextView endAt = findViewById(R.id.endAt);
        TextView startCity = findViewById(R.id.startCity);
        TextView endCity = findViewById(R.id.endCity);
        TextView startTerminal = findViewById(R.id.startTerminal);
        TextView endTerminal = findViewById(R.id.endTerminal);
        TextView startDate = findViewById(R.id.startDate);
        TextView endDate = findViewById(R.id.endDate);
        TextView estimateTime = findViewById(R.id.estimateTime);
        TextView seatsNo = findViewById(R.id.seatsNo);
        TextView total = findViewById(R.id.total);

        back_button.setOnClickListener(v -> {
            onBackPressed();
        });

        qrcode.setOnClickListener(v -> {
            popUpQRCode();
        });

        rating.setOnClickListener(v -> {
            popUpRating();
        });



        if(getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();

            date.setText(bundle.getString("startDate") + ", " + bundle.getString("startAt"));
            nameDetail.setText(bundle.getString("name"));
            phoneNumber.setText(bundle.getString("numberPhone"));
            seatsDetail.setText(bundle.getString("seats"));
            seatsNo.setText(bundle.getString("seatsNo"));
            poNameDetail.setText(bundle.getString("poName"));
            bookNumber.setText(bundle.getString("bookNumber"));
            poNumberDetail.setText(bundle.getString("poNumber"));
            startAt.setText(bundle.getString("startAt"));
            endAt.setText(bundle.getString("endAt"));
            startCity.setText(bundle.getString("startCity"));
            endCity.setText(bundle.getString("endCity"));
            startDate.setText(bundle.getString("startDate"));
            endDate.setText(bundle.getString("endDate"));
            startTerminal.setText(bundle.getString("startTerminal"));
            endTerminal.setText(bundle.getString("endTerminal"));

            try{
                String ESstartDate = bundle.getString("startDate") + " " + bundle.getString("startAt") + ":00";
                String ESendDate = bundle.getString("endDate") + " " + bundle.getString("endAt") + ":00";
                SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
                Date date1 = dates.parse(ESstartDate);
                Date date2 = dates.parse(ESendDate);
                long different = date2.getTime() - date1.getTime();
                long secondsInMilli = 1000;
                long minutesInMilli = secondsInMilli * 60;
                long hoursInMilli = minutesInMilli * 60;
                long daysInMilli = hoursInMilli * 24;

                long elapsedDays = different / daysInMilli;
                different = different % daysInMilli;
                String DayDifference = Long.toString(elapsedDays);
                long elapsedHours = different / hoursInMilli;
                different = different % hoursInMilli;
                String HourDifference = Long.toString(elapsedHours);
                long elapsedMinutes = different / minutesInMilli;
                different = different % minutesInMilli;
                String MinuteDifference = Long.toString(elapsedMinutes);
                long elapsedSeconds = different / secondsInMilli;
                String SecondDifference = Long.toString(elapsedSeconds);

                estimateTime.setText(DayDifference + "D" + HourDifference + "H" + MinuteDifference + "M");

            }catch (Exception exception) {
                Toast.makeText(this, "Unable to find difference", Toast.LENGTH_SHORT).show();
            }
            statusPembayaranDetail.setText(bundle.getString("statusPembayaran"));
            Double preTotal = Double.parseDouble(bundle.getString("total"));
            Locale localeID = new Locale("in", "ID");
            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
            total.setText(formatRupiah.format(preTotal));

        }

    }

    public void popUpQRCode() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = activity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.qr_code_layout, null);
        dialogBuilder.setView(layout);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        TextView back = layout.findViewById(R.id.back_detail);
        back.setOnClickListener(v -> {
            alertDialog.dismiss();
        });
    }

    public void popUpRating() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = activity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_ratings, null);
        dialogBuilder.setView(layout);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        ImageView star1 = layout.findViewById(R.id.star1);
        ImageView star2 = layout.findViewById(R.id.star2);
        ImageView star3 = layout.findViewById(R.id.star3);
        ImageView star4 = layout.findViewById(R.id.star4);
        ImageView star5 = layout.findViewById(R.id.star5);
        TextView rateThis = layout.findViewById(R.id.rate_this);
        TextView poNameReview = layout.findViewById(R.id.poNameReview);
        TextView poNumberReview = layout.findViewById(R.id.poNumberReview);
        TextView startDateReview = layout.findViewById(R.id.startDateReview);
        TextView statusPembayaranReview = layout.findViewById(R.id.statusPembayaranReview);

        Bundle bundle = getIntent().getExtras();
        poNameReview.setText(bundle.getString("poName"));
        poNumberReview.setText(bundle.getString("poNumber"));
        startDateReview.setText(bundle.getString("startDate"));
        statusPembayaranReview.setText(bundle.getString("statusPembayaran"));

        star1.setOnClickListener(v -> {
            star1.setImageResource(R.drawable.starrating_ok);
            star2.setImageResource(R.drawable.starrating);
            star3.setImageResource(R.drawable.starrating);
            star4.setImageResource(R.drawable.starrating);
            star5.setImageResource(R.drawable.starrating);
            rate = 1;

        });

        star2.setOnClickListener(v -> {
            star1.setImageResource(R.drawable.starrating_ok);
            star2.setImageResource(R.drawable.starrating_ok);
            star3.setImageResource(R.drawable.starrating);
            star4.setImageResource(R.drawable.starrating);
            star5.setImageResource(R.drawable.starrating);
            rate = 2;

        });

        star3.setOnClickListener(v -> {
            star1.setImageResource(R.drawable.starrating_ok);
            star2.setImageResource(R.drawable.starrating_ok);
            star3.setImageResource(R.drawable.starrating_ok);
            star4.setImageResource(R.drawable.starrating);
            star5.setImageResource(R.drawable.starrating);
            rate = 3;
        });

        star4.setOnClickListener(v -> {
            star1.setImageResource(R.drawable.starrating_ok);
            star2.setImageResource(R.drawable.starrating_ok);
            star3.setImageResource(R.drawable.starrating_ok);
            star4.setImageResource(R.drawable.starrating_ok);
            star5.setImageResource(R.drawable.starrating);
            rate = 4;
        });

        star5.setOnClickListener(v -> {
            star1.setImageResource(R.drawable.starrating_ok);
            star2.setImageResource(R.drawable.starrating_ok);
            star3.setImageResource(R.drawable.starrating_ok);
            star4.setImageResource(R.drawable.starrating_ok);
            star5.setImageResource(R.drawable.starrating_ok);
            rate = 5;
        });

        rateThis.setOnClickListener(v -> {
            if(rate == 1){
                ratingNumber.setText("1/5");
                alertDialog.dismiss();
            }else if(rate == 2) {
                ratingNumber.setText("2/5");
                alertDialog.dismiss();
            }else if(rate == 3) {
                ratingNumber.setText("3/5");
                alertDialog.dismiss();
            }else if(rate == 4){
                ratingNumber.setText("4/5");
                alertDialog.dismiss();
            }else if(rate == 5){
                ratingNumber.setText("5/5");
                alertDialog.dismiss();
            }

        });

    }
}