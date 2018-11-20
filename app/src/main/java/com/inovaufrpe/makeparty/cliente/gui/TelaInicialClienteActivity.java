package com.inovaufrpe.makeparty.cliente.gui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.inovaufrpe.makeparty.R;
//import com.inovaufrpe.makeparty.cliente.gui.fragment.AnunciosFragment;
import com.inovaufrpe.makeparty.cliente.gui.fragment.AnunciosOutroFragment;
import com.inovaufrpe.makeparty.fornecedor.gui.TelaInicialFornecedorActivity;
import com.inovaufrpe.makeparty.infra.SessaoApplication;

public class TelaInicialClienteActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private CoordinatorLayout coordinatorLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_cliente);
        //acoesReferentesAoBottomNavigation();
        toolbarComMenuNavAbreEFecha();
        viewDoMenuNavListaClicavel();
        criarFragment(savedInstanceState);


    }
    private void toolbarComMenuNavAbreEFecha(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
    private void viewDoMenuNavListaClicavel(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void criarFragment(Bundle savedInstanceState) {
        //getSupportActionBar().setTitle(getString(getIntent().getIntExtra("tipo",6)));
        if (savedInstanceState == null) {
            AnunciosOutroFragment frag = new AnunciosOutroFragment();
            //AnunciosFragment frag = new AnunciosFragment();
            frag.setArguments(getIntent().getExtras());
            //getSupportFragmentManager().beginTransaction().add(R.id.container, frag).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, frag).commit();
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!SessaoApplication.instance.getTipoDeUserLogado().equals("null"));{
            //TextView nomeUsuario, email;
            //nomeUsuario = findViewById(R.id.nomeView);
            //email = findViewById(R.id.emailView);
            //nomeUsuario.setText(SessaoApplication.instance.getPessoa().getNome());
            //email.setText(SessaoApplication.instance.getPessoa().getUsuario().getEmail());
        }

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings1) {
            return true;
        } else if (id == R.id.action_search) {
        } else if (id == R.id.action_carrinho) {
        } else if (id == R.id.action_filtrar_por_regiao) {
        } else if (id == R.id.action_filtrar_por_preco) {
        }else if (id==R.id.action_sair){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_slideshow) {
        } else if (id == R.id.nav_manage) {
            irParaTelaConfiguracoesCliente();
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    protected Context getContext() {
        return this;
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
    private void mudarTela(Class tela){
        Intent intent=new Intent(this, tela);
        startActivity(intent);
        finish();
    }
    public void irParaTelaConfiguracoesCliente(){
        this.mudarTela(AtualizarPerfilClienteActivity.class);
    }


}
