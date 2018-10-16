package com.inovaufrpe.makeparty.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.utils.Mask;

public class CadastroActivity extends AppCompatActivity {
    private EditText edtEmail, edtConfEmail, edtSenha, edtConfSenha, edtNome, edtCpf, edtNasc, edtImei, edtCnpj;
    private Spinner spUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ListandoOpçoesSpinner();
        encontrandoViews();
        saberQualTipoDeUser();
    }

    public void ListandoOpçoesSpinner() {
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(CadastroActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tipodeuser));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

    }

    public void encontrandoViews() {
        edtNome = findViewById(R.id.editTextNome);
        edtEmail = findViewById(R.id.editTextEmail);
        edtConfEmail = findViewById(R.id.editTextConfirmarEmail);
        edtSenha = findViewById(R.id.editTextSenha);
        edtConfSenha = findViewById(R.id.editTextConfirmarSenha);
        edtCpf = findViewById(R.id.editTextCpf);
        edtCpf.addTextChangedListener(Mask.insert("###.###.###-##", edtCpf));
        edtNasc = findViewById(R.id.editTextDataNasc);
        edtNasc.addTextChangedListener(Mask.insert("##/##/####", edtNasc));
        spUsuario = findViewById(R.id.spinner1);
        edtImei = findViewById(R.id.editTextIMEI);
        //edtImei.addTextChangedListener(Mask.insert("", edtImei));
        edtCnpj = findViewById(R.id.editTextCNPJ);
        edtCnpj.addTextChangedListener(Mask.insert("##.###.###/####-##", edtCnpj));

    }
    public void saberQualTipoDeUser(){
        //Metodo para quando um elemento do Spinner é selecionado()
        spUsuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getSelectedItem().toString().equals("PessoaJuridica")){
                    edtImei.setVisibility(View.VISIBLE);
                    edtCnpj.setVisibility(View.VISIBLE);
                } else{
                    edtImei.setVisibility(View.INVISIBLE);
                    edtImei.setText("");
                    edtCnpj.setVisibility(View.INVISIBLE);
                    edtCnpj.setText("");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    //Aqui embaixo ainda falta chamar os serviços para efetivar o cadastro, só ta transf em string por enq
    public void onClickCadastrar(View view) {
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        String confEmail = edtConfEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        String confSenha = edtConfSenha.getText().toString();
        String cpf = edtCpf.getText().toString();
        String dataNasc = edtNasc.getText().toString();
        String tipoUsuario = (String) spUsuario.getSelectedItem();
        String imei = edtImei.getText().toString();
        String cnjp = edtCnpj.getText().toString();

    }
}
