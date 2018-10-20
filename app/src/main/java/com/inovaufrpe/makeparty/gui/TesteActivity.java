package com.inovaufrpe.makeparty.gui;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.inovaufrpe.makeparty.R;

public class TesteActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);
    }
    public void acoesReferentesAoBottomNavigation(){
        bottomNavigationView =  (BottomNavigationView) findViewById(R.id.tab_bar_opcoes_embaixo);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.action_pacotes){

                }else if (item.getItemId()==R.id.action_casa_festa){

                }else if (item.getItemId()==R.id.action_buffet){

                }else if (item.getItemId()==R.id.action_decoracao){

                }else if (item.getItemId()==R.id.action_animacao){

                }
                return false;
            }
        });

    }
}
