package com.inovaufrpe.makeparty.fornecedor.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

import com.inovaufrpe.makeparty.R;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        final CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView1);

        // quando selecionado alguma data diferente da padrão
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                Intent intent = new Intent(CalendarActivity.this,
                        CapturaDadosCalendarActivity.class);
                intent.putExtra("dataLongMiliseconds",
                        (Long) calendarView.getDate());
                startActivity(intent);

            }
        });
    }
}
