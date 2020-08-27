package com.example.fastcalc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import static com.example.fastcalc.MainActivity.getTimepickerhour;
import static com.example.fastcalc.MainActivity.getTimepikerminute;
import static com.example.fastcalc.MainActivity.setKeypad_activated;

public class NewActivity extends AppCompatActivity {

    public String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setKeypad_activated(false);

        Bundle extras = getIntent().getExtras();                                                    //trae datos del otro MainActivity
        assert extras != null;
        String txt = extras.getString("resultado");
        String newDate = extras.getString("datecalendar");
        date = newDate + " " + getTimepickerhour() + ":" + getTimepikerminute();

        //newDate
        //("dd/MM/yyyy hh:mm")

        TextView tv2 = findViewById(R.id.textView2);                                     //levanta el valor del TXT
        tv2.setText(txt);
    }

        public void openOldActivity(View view){                                                     //vuelve al layout anterior
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }


    @SuppressLint("SimpleDateFormat")
    public void AddCalendarEvent(View view) throws ParseException {
        //crea un calendar
        Calendar calendarEvent = Calendar.getInstance();
        calendarEvent.setTime(Objects.requireNonNull(new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(date)));
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", calendarEvent.getTimeInMillis());
        i.putExtra("allDay", false);
        i.putExtra("title", "END FAST!");
        i.putExtra("endTime", calendarEvent.getTimeInMillis());
        startActivity(i);
    }
    }

