package com.inovaufrpe.makeparty.fornecedor.gui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.inovaufrpe.makeparty.R;

import java.util.Date;

public class CapturaDadosCalendarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura_dados_calendar);

        // capturando dado
        Intent intent = getIntent();
        Long dateSelected = intent.getLongExtra("dataLongMiliseconds", 0);
        Date date = new Date(dateSelected);

        // fazendo alguma coisa com o dado capturado
        TextView txt = (TextView) findViewById(R.id.textView1);
        txt.setText(date.toString());

    }
}
