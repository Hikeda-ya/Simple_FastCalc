package com.example.fastcalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import static com.example.fastcalc.MainActivity.setKeypad_activated;

public class NewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setKeypad_activated(false);

        Bundle extras = getIntent().getExtras();                                                    //trae datos del otro MainActivity
        String txt = extras.getString("resultado");
        String txt2 = extras.getString("datecalendar");                                        //txt2 es la fecha de newDate, que esta en YYYY/MM/DD
        //("dd-MM-yyyy hh:mm:ss")

        TextView tv2 = findViewById(R.id.textView2);                                     //levanta el valor del TXT
        tv2.setText(txt);
    }

        public void openOldActivity(View view){                                                     //vuelve al layout anterior
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
        /*WIP*/
    //2020/08/14
    //it should convert to dd-MMM-yyyy hh:mm:ss

    private String newnewDate;

    public void AddCalendarEvent(View view) {
        //crea un calendar
        Calendar calendarEvent = Calendar.getInstance();
        /*calendarEvent.setTime(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(newnewDate));*/
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", calendarEvent.getTimeInMillis());
        i.putExtra("allDay", false);
        i.putExtra("title", "END FAST");
        i.putExtra("endTime",calendarEvent.getTimeInMillis());
        startActivity(i);
    }
    }

