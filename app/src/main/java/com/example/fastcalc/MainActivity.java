package com.example.fastcalc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity{

    private EditText editTexto;
    private KeyListener keyListener1;                                                               //encapsulo un atributo
    private Boolean eshoy = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                                                     // espesifica que el codigo se usa dentro del xml de activity_main

        setTitle("SIMPLE FAST CALC");                                                               //Le da un titulo a la app, se lo agrega por codigo


        /* ver si en Land layout el titulo se muestra y si el TimePiker funciona bien, puede ser el setContentView */

        TimePicker tp = this.findViewById(R.id.timePicker1);
        tp.setIs24HourView(true);

        editTexto = findViewById(R.id.fastLasttext);
        Button buttonText = findViewById(R.id.button5);
        keyListener1 = editTexto.getKeyListener();                                                  //Guardo el Keylistner del EditText para poder usarlo en otro lado mas adelante

        buttonText.setOnClickListener(new View.OnClickListener() {                                  //ejecución del boton de FAST LAST, or Last For

            @Override
            public void onClick(final View view) {

                editTexto.setText("");
                editTexto.setKeyListener(keyListener1);                                             //guardo el metodo de imput del editor de texto para que no me abra el pad numerico, y no el del boton que no tiene
                editTexto.requestFocus();

                InputMethodManager input = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                input.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);



                editTexto.setOnKeyListener(
                        new View.OnKeyListener() {
                            //si apreta ENTER le modifica el numero, en el caso de que no sean 2 numeros, caso contenido debajo
                            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {

                                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                                    EditText flt = findViewById(R.id.fastLasttext);
                                    String j = flt.getText().toString();
                                    //metodo para setear el texto del boton, nuestro equivalente al EJECUTAR/run/enter
                                    if(j.equals("")){
                                        flt.setText("-");
                                        setButtontextmetod();
                                        return true;
                                    }else
                                    setButtontextmetod();
                                    return true;
                                }
                                return false;
                            }
                        });

                editTexto.addTextChangedListener(new TextWatcher() {                                //te mira el texto que estan escribiendo
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        if (filterLongEnough()) {                                                   //mientras mira el texto, si se escriben 2 caracteres te cierra el teclado y te configura el numer
                            setButtontextmetod();
                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }

                    }

                    private boolean filterLongEnough() {                                            //cuenta hasta 2 caracteres
                        return editTexto.getText().toString().trim().length() >= 2;
                    }

                });



            }
        });
    }


    public void setButtontextmetod() {   //no View view metodo usado internamente                   //ME cambia el nombre del boton para reflejar lo que esta en el EditText invisible
        EditText et = findViewById(R.id.fastLasttext);
        Editable hourfasttext = et.getText();
        Button bt = findViewById(R.id.button5);
        bt.setText(hourfasttext);
    }

    public void siguienteMediahora(View view) {                                                      //Va a la siguiente media hora
        TimePicker tp = this.findViewById(R.id.timePicker1);
        if (tp.getHour()==24 && tp.getMinute() < 30){
            tp.setHour(00);
            tp.setMinute(30);
        }else if (tp.getMinute() < 30) {
            tp.setMinute(30);
        }else {
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
        } else if (tp.getMinute() == 00 && (tp.getHour() == 00 || tp.getHour()==24)){
            tp.setMinute(30);
            tp.setHour(23);
        }else{
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

    public void twelveHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("12");
        setButtontextmetod();
    }

    public void sixteenHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("16");
        setButtontextmetod();
    }

    public void eighteenHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("18");
        setButtontextmetod();
    }

    public void twentyHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("20");
        setButtontextmetod();
    }

    public void twentyfourHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("24");
        setButtontextmetod();
    }

    public void thirtysixHours(View view) {
        EditText et = findViewById(R.id.fastLasttext);
        et.setText("36");
        setButtontextmetod();
    }



    public void go(View view) {
        TimePicker tp = this.findViewById(R.id.timePicker1);
        EditText et = findViewById(R.id.fastLasttext);
        int fastDuration = Integer.parseInt(et.getText().toString());
        int timepickerHour = tp.getHour();
        int minute = tp.getMinute();
        int sumfast = timepickerHour + fastDuration;

        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String textendat =  "your fast" + "\n" + "should end at " + "\n\n";

        if (eshoy) {
            if (sumfast < 24) {
                //si es hoy dara la fecha de  hoy
                cal.add(Calendar.DAY_OF_MONTH, 0);                                                  //nos da una fecha con los dias aumentados en 0
                String newDate = dt.format(cal.getTime());
                TextView tv = findViewById(R.id.textView3);
                tv.setText(textendat + sumfast + ":" + minute + "hs" + "\n\n" + "TODAY" + "\n" + newDate);
                TextView tv2 = findViewById(R.id.textView6);           /*WIP*/                          //guarda la fecha en un texto invisible textView6, "dd-MM-yyyy hh:mm:ss"
                tv2.setText(newDate);
            } else if (sumfast < 48) {
                cal.add(Calendar.DAY_OF_MONTH, 1);                                                  //nos da una fecha con los dias aumentados en 1
                String newDate = dt.format(cal.getTime());                                              //si es mañana restara 24 hs y dira que es mañana
                TextView tv = findViewById(R.id.textView3);
                int sumfasttomorrow = sumfast - 24;
                tv.setText(textendat + sumfasttomorrow + ":" + minute + "hs" + "\n\n" + " TOMORROW" + "\n" + newDate);
                TextView tv2 = findViewById(R.id.textView6);
                tv2.setText(newDate);
            } else if (sumfast < 72) {
                cal.add(Calendar.DAY_OF_MONTH, 2);                                                  //nos da una fecha con los dias aumentados en 2
                String newDate = dt.format(cal.getTime());
                TextView tv = findViewById(R.id.textView3);
                int sumfastaftertomorrow = sumfast - 48;
                tv.setText(textendat + sumfastaftertomorrow + ":" + minute + "hs" + "\n\n" + " the DAY AFTER TOMORROW" + "\n" + newDate);
                TextView tv2 = findViewById(R.id.textView6);
                tv2.setText(newDate);
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
                tv.setText(textendat + sumfast + ":" + minute + "hs" + "\n\n" + "TOMORROW" + "\n" + newDate);
                TextView tv2 = findViewById(R.id.textView6);
                tv2.setText(newDate);
            } else if (sumfast < 48) {
                cal.add(Calendar.DAY_OF_MONTH, 2);                                                  //nos da una fecha con los dias aumentados en 2
                String newDate = dt.format(cal.getTime());
                TextView tv = findViewById(R.id.textView3);
                int sumfasttomorrow = sumfast - 24;
                tv.setText(textendat + sumfasttomorrow + ":" + minute + "hs" + "\n\n" + " the DAY AFTER TOMORROW" + "\n" + newDate);
                TextView tv2 = findViewById(R.id.textView6);
                tv2.setText(newDate);
            } else if (sumfast < 72) {
                cal.add(Calendar.DAY_OF_MONTH, 3);                                                  //nos da una fecha con los dias aumentados en 3
                String newDate = dt.format(cal.getTime());
                TextView tv = findViewById(R.id.textView3);
                int sumfastaftertomorrow = sumfast - 48;
                tv.setText(textendat + sumfastaftertomorrow + ":" + minute + "hs" + "\n\n" + " on " + newDate);
                TextView tv2 = findViewById(R.id.textView6);
                tv2.setText(newDate);

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
        TextView tv2 = findViewById(R.id.textView6);
        CharSequence tx = tv.getText();
        CharSequence tx2 = tv2.getText();
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
       // tp.setMinute();
       // tp.setHour();
    }
}