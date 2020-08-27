package com.example.fastcalc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private static boolean Keypad_activated;
    private static int timepickerhour;
    private Boolean eshoy = true;
    private static int timepikerminute;

    public static int getTimepickerhour() {
        return timepickerhour;
    }

    public static void setTimepickerhour(int timepickerhour) {
        MainActivity.timepickerhour = timepickerhour;
    }

    public static int getTimepikerminute() {
        return timepikerminute;
    }

    public static void setTimepikerminute(int timepikerminute) {
        MainActivity.timepikerminute = timepikerminute;
    }

    public boolean isKeypad_activated() {
        return Keypad_activated;
    }

    public static void setKeypad_activated(boolean keypad_activated) {
        Keypad_activated = keypad_activated;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// espesifica que el codigo se usa dentro del xml de activity_main


        if (isKeypad_activated()) {                                                                    //fue activado el ekeypad?
            Bundle extras = getIntent().getExtras();                                                 //trae datos del KeyPadActivity
            assert extras != null;
            String redbuttonstring = extras.getString("textorojo");
            TextView et = findViewById(R.id.fastLasttext);
            et.setText(redbuttonstring);
            setButtontextmetod();
        }


        TimePicker tp = this.findViewById(R.id.timePicker1);
        tp.setIs24HourView(true);


    }


    public void setButtontextmetod() {   //no View view metodo usado internamente                   //ME cambia el nombre del boton para reflejar lo que esta en el EditText invisible
        EditText et = findViewById(R.id.fastLasttext);
        Editable hourfasttext = et.getText();
        Button bt = findViewById(R.id.button5);
        bt.setText(hourfasttext);
    }

    public void siguienteMediahora(View view) {                                                      //Va a la siguiente media hora
        TimePicker tp = this.findViewById(R.id.timePicker1);
        if (tp.getHour() == 24 && tp.getMinute() < 30) {
            tp.setHour(00);
            tp.setMinute(30);
        } else if (tp.getMinute() < 30) {
            tp.setMinute(30);
        } else {
            int plushour = tp.getHour() + 1;
            tp.setMinute(00);
            tp.setHour(plushour);
        }
    }

    public void anteriorMediahora(View view) {                                                       //va a la anterior media hora
        TimePicker tp = this.findViewById(R.id.timePicker1);
        if (tp.getMinute() > 30) {
            tp.setMinute(30);
        } else if (tp.getMinute() <= 30 && tp.getMinute() != 00) {
            tp.setMinute(00);
        } else if (tp.getMinute() == 00 && (tp.getHour() == 00 || tp.getHour() == 24)) {
            tp.setMinute(30);
            tp.setHour(23);
        } else {
            int minushour = tp.getHour() - 1;
            tp.setMinute(30);
            tp.setHour(minushour);
        }
    }

    public void siguienteHora(View view) {
        TimePicker tp = this.findViewById(R.id.timePicker1);
        int plushour = tp.getHour() + 1;
        tp.setHour(plushour);
    }

    public void anteriorHora(View view) {
        TimePicker tp = this.findViewById(R.id.timePicker1);
        if (tp.getHour() != 00) {
            int minushour = tp.getHour() - 1;
            tp.setHour(minushour);
        } else {
            tp.setHour(23);
        }
    }

    @SuppressLint("SetTextI18n")
    public void twelveHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("12");
        setButtontextmetod();
    }

    @SuppressLint("SetTextI18n")
    public void sixteenHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("16");
        setButtontextmetod();
    }

    @SuppressLint("SetTextI18n")
    public void eighteenHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("18");
        setButtontextmetod();
    }

    @SuppressLint("SetTextI18n")
    public void twentyHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("20");
        setButtontextmetod();
    }

    @SuppressLint("SetTextI18n")
    public void twentyfourHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("24");
        setButtontextmetod();
    }

    @SuppressLint("SetTextI18n")
    public void thirtysixHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("36");
        setButtontextmetod();
    }

    @SuppressLint("SetTextI18n")
    public void go(View view) {
        TimePicker tp = this.findViewById(R.id.timePicker1);
        EditText et = findViewById(R.id.fastLasttext);
        int fastDuration = Integer.parseInt(et.getText().toString());
        int timepickerHour = tp.getHour();
        int minute = tp.getMinute();
        DecimalFormat df = new DecimalFormat("00");                                             //me genera un string con el int en dos digitos
        String minutes = df.format(minute);
        int formatedminute = Integer.parseInt(minutes);
        int sumfast = timepickerHour + fastDuration;

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String textendat = "your fast" + "\n" + "should end at " + "\n\n";

        if (eshoy) {
            if (sumfast < 24) {
                //si es hoy dara la fecha de  hoy
                cal.add(Calendar.DAY_OF_MONTH, 0);                                                  //nos da una fecha con los dias aumentados en 0
                String newDate = dt.format(cal.getTime());
                TextView tv = findViewById(R.id.textView3);
                tv.setText(textendat + sumfast + ":" + minutes + "hs" + "\n\n" + "TODAY" + "\n" + newDate);
                TextView tv2 = findViewById(R.id.textView6);                                           //guarda la fecha en un texto invisible textView6, "dd-MM-yyyy hh:mm:ss"
                tv2.setText(newDate);
                setTimepickerhour(sumfast);
                setTimepikerminute(formatedminute);
            } else if (sumfast < 48) {
                cal.add(Calendar.DAY_OF_MONTH, 1);                                                  //nos da una fecha con los dias aumentados en 1
                String newDate = dt.format(cal.getTime());                                              //si es mañana restara 24 hs y dira que es mañana
                TextView tv = findViewById(R.id.textView3);
                int sumfasttomorrow = sumfast - 24;
                tv.setText(textendat + sumfasttomorrow + ":" + minutes + "hs" + "\n\n" + " TOMORROW" + "\n" + newDate);
                TextView tv2 = findViewById(R.id.textView6);
                tv2.setText(newDate);
                setTimepickerhour(sumfasttomorrow);
                setTimepikerminute(formatedminute);
            } else if (sumfast < 72) {
                cal.add(Calendar.DAY_OF_MONTH, 2);                                                  //nos da una fecha con los dias aumentados en 2
                String newDate = dt.format(cal.getTime());
                TextView tv = findViewById(R.id.textView3);
                int sumfastaftertomorrow = sumfast - 48;
                tv.setText(textendat + sumfastaftertomorrow + ":" + minutes + "hs" + "\n\n" + " the DAY AFTER TOMORROW" + "\n" + newDate);
                TextView tv2 = findViewById(R.id.textView6);
                tv2.setText(newDate);
                setTimepickerhour(sumfastaftertomorrow);
                setTimepikerminute(formatedminute);
            } else {
                TextView tv = findViewById(R.id.textView3);
                String txtset = "you should not fast for that long";
                tv.setText(txtset);
            }
        } else {

            if (sumfast < 24) {
                //si es hoy dara la fecha de  hoy
                cal.add(Calendar.DAY_OF_MONTH, 1);                                                  //nos da una fecha con los dias aumentados en 1
                String newDate = dt.format(cal.getTime());
                TextView tv = findViewById(R.id.textView3);
                tv.setText(textendat + sumfast + ":" + minutes + "hs" + "\n\n" + "TOMORROW" + "\n" + newDate);
                TextView tv2 = findViewById(R.id.textView6);
                tv2.setText(newDate);
                setTimepickerhour(sumfast);
                setTimepikerminute(formatedminute);
            } else if (sumfast < 48) {
                cal.add(Calendar.DAY_OF_MONTH, 2);                                                  //nos da una fecha con los dias aumentados en 2
                String newDate = dt.format(cal.getTime());
                TextView tv = findViewById(R.id.textView3);
                int sumfasttomorrow = sumfast - 24;
                tv.setText(textendat + sumfasttomorrow + ":" + minutes + "hs" + "\n\n" + " the DAY AFTER TOMORROW" + "\n" + newDate);
                TextView tv2 = findViewById(R.id.textView6);
                tv2.setText(newDate);
                setTimepickerhour(sumfasttomorrow);
                setTimepikerminute(formatedminute);
            } else if (sumfast < 72) {
                cal.add(Calendar.DAY_OF_MONTH, 3);                                                  //nos da una fecha con los dias aumentados en 3
                String newDate = dt.format(cal.getTime());
                TextView tv = findViewById(R.id.textView3);
                int sumfastaftertomorrow = sumfast - 48;
                tv.setText(textendat + sumfastaftertomorrow + ":" + minutes + "hs" + "\n\n" + " on " + newDate);
                TextView tv2 = findViewById(R.id.textView6);
                tv2.setText(newDate);
                setTimepickerhour(sumfastaftertomorrow);
                setTimepikerminute(formatedminute);

            } else {
                TextView tv = findViewById(R.id.textView3);
                String txtset = "you should not fast for that long";
                tv.setText(txtset);
            }
        }
        openNewActivity();
    }

    public void openNewActivity() {                                                                  //va a la otra layout y se lleva consigo el valor de TXT y TXT2 como string, el texto de la fecha y la fecha
        TextView tv = findViewById(R.id.textView3);
        TextView tv2 = findViewById(R.id.textView6);  //newDate
        CharSequence tx = tv.getText();
        CharSequence tx2 = tv2.getText(); //coment
        String txt = String.valueOf(tx);
        String txt2 = String.valueOf(tx2);
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("resultado", txt);
        intent.putExtra("datecalendar", txt2);
        startActivity(intent);

    }

    public void changeTodayColor(View view) {

        TextView tv = findViewById(R.id.textView4);
        TextView ntv = findViewById(R.id.textView5);
        tv.setTextColor(ResourcesCompat.getColor(getResources(), R.color.textdayColor, null)); //levanta el color del xml y se lo pone al textview4
        ntv.setTextColor(ResourcesCompat.getColor(getResources(), R.color.notextdayColor, null));
        eshoy = true;

    }

    public void changeTomorrowColor(View view) {

        TextView tv = findViewById(R.id.textView5);
        TextView ntv = findViewById(R.id.textView4);
        tv.setTextColor(ResourcesCompat.getColor(getResources(), R.color.textdayColor, null)); //levanta el color del xml y se lo pone al textview4
        ntv.setTextColor(ResourcesCompat.getColor(getResources(), R.color.notextdayColor, null));
        eshoy = false;
    }

    public void setClockNow(View view) {
        TimePicker tp = this.findViewById(R.id.timePicker1);
        Calendar cale = Calendar.getInstance();
        View timePickerPart = tp.findViewById(Resources.getSystem().getIdentifier("hours", "id", "android"));
        timePickerPart.performClick();
        int integer1 = cale.get(Calendar.HOUR_OF_DAY);
        int integer2 = cale.get(Calendar.MINUTE);               //timepiker no toma el dato mientras se esta modificando, habria que hacer un "on release" mientras selecciona el timepiker para que cambie el foco a otro lado y aplique este botton
        tp.setHour(integer1);
        tp.setMinute(integer2);
    }

    public void frontAndNumbKey(View view) {

        Intent intent = new Intent(this, KeyPadActivity.class);
        startActivity(intent);

    }
}