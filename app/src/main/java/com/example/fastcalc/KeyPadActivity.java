
package com.example.fastcalc;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.fastcalc.MainActivity.setKeypad_activated;

public class KeyPadActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbpad);

        setKeypad_activated(true);              //se activa el keypadactivated

        TextView redbuttontext = findViewById(R.id.textView7);
        redbuttontext.setText("00");


    }

    public void openOldActivity2() {                                                                  //va a la otra layout y se lleva consigo el valor de TXT y TXT2 como string, el texto de la fecha y la fecha
        TextView rbt = findViewById(R.id.textView7);
        CharSequence crbt = rbt.getText();
        String redbuttonstring = String.valueOf(crbt);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("textorojo", redbuttonstring);
        startActivity(intent);

    }

    public void openOldActivity2(View view) {                                                                  //va a la otra layout y se lleva consigo el valor de TXT y TXT2 como string, el texto de la fecha y la fecha
        TextView rbt = findViewById(R.id.textView7);
        CharSequence crbt = rbt.getText();
        String redbuttonstring = String.valueOf(crbt);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("textorojo", redbuttonstring);
        startActivity(intent);

    }

    public void setkey1(View view) {

        TextView redbuttontext = findViewById(R.id.textView7);
        int actual_int = Integer.parseInt(String.valueOf(redbuttontext.getText()));

        int keypress = 1;

        if (actual_int == 00) {
            int result = keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
        } else {
            int result = actual_int * 10 + keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
            openOldActivity2();
        }
    }

    public void setkey2(View view) {

        TextView redbuttontext = findViewById(R.id.textView7);
        int actual_int = Integer.parseInt(String.valueOf(redbuttontext.getText()));

        int keypress = 2;

        if (actual_int == 00) {
            int result = keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
        } else {
            int result = actual_int * 10 + keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
            openOldActivity2();
        }
    }

    public void setkey3(View view) {

        TextView redbuttontext = findViewById(R.id.textView7);
        int actual_int = Integer.parseInt(String.valueOf(redbuttontext.getText()));

        int keypress = 3;

        if (actual_int == 00) {
            int result = keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
        } else {
            int result = actual_int * 10 + keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
            openOldActivity2();
        }
    }

    public void setkey4(View view) {

        TextView redbuttontext = findViewById(R.id.textView7);
        int actual_int = Integer.parseInt(String.valueOf(redbuttontext.getText()));

        int keypress = 4;

        if (actual_int == 00) {
            int result = keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
        } else {
            int result = actual_int * 10 + keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
            openOldActivity2();
        }
    }

    public void setkey5(View view) {

        TextView redbuttontext = findViewById(R.id.textView7);
        int actual_int = Integer.parseInt(String.valueOf(redbuttontext.getText()));

        int keypress = 5;

        if (actual_int == 00) {
            int result = keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
        } else {
            int result = actual_int * 10 + keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
            openOldActivity2();
        }
    }

    public void setkey6(View view) {

        TextView redbuttontext = findViewById(R.id.textView7);
        int actual_int = Integer.parseInt(String.valueOf(redbuttontext.getText()));

        int keypress = 6;

        if (actual_int == 00) {
            int result = keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
        } else {
            int result = actual_int * 10 + keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
            openOldActivity2();
        }
    }

    public void setkey7(View view) {

        TextView redbuttontext = findViewById(R.id.textView7);
        int actual_int = Integer.parseInt(String.valueOf(redbuttontext.getText()));

        int keypress = 7;

        if (actual_int == 00) {
            int result = keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
        } else {
            int result = actual_int * 10 + keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
            openOldActivity2();
        }
    }

    public void setkey8(View view) {

        TextView redbuttontext = findViewById(R.id.textView7);
        int actual_int = Integer.parseInt(String.valueOf(redbuttontext.getText()));

        int keypress = 8;

        if (actual_int == 00) {
            int result = keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
        } else {
            int result = actual_int * 10 + keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
            openOldActivity2();
        }
    }

    public void setkey9(View view) {

        TextView redbuttontext = findViewById(R.id.textView7);
        int actual_int = Integer.parseInt(String.valueOf(redbuttontext.getText()));

        int keypress = 9;

        if (actual_int == 00) {
            int result = keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
        } else {
            int result = actual_int * 10 + keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
            openOldActivity2();
        }
    }

    public void setkey0(View view) {

        TextView redbuttontext = findViewById(R.id.textView7);
        int actual_int = Integer.parseInt(String.valueOf(redbuttontext.getText()));

        int keypress = 0;

        if (actual_int == 00) {
            int result = keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
        } else {
            int result = actual_int * 10 + keypress;
            String resultado = Integer.toString(result);
            redbuttontext.setText(resultado);
            openOldActivity2();
        }
    }
}





