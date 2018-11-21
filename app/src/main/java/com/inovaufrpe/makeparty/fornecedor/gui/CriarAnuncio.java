package com.inovaufrpe.makeparty.fornecedor.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.inovaufrpe.makeparty.R;

public class CriarAnuncio extends AppCompatActivity {
    private EditText titulo, valor, descricao, tags, telefone, rua, numero, bairro, cidade, cep;
    private Spinner tipoAnuncio;
    private Button cadastroAnuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_anuncio);
        opcoesSpinner();
        setTela();
        cadastrando();
    }
    public void opcoesSpinner(){

    }

    public void setTela(){
        titulo = findViewById(R.id.editTextTitulo);
        valor = findViewById(R.id.editTextValor);
        descricao = findViewById(R.id.editTextDescricao);
        tags = findViewById(R.id.editTextTags);
        telefone = findViewById(R.id.editTextTelefone);
        rua = findViewById(R.id.RuaId);
        numero = findViewById(R.id.editTextNumero);
        bairro = findViewById(R.id.editTextBairro);
        cidade = findViewById(R.id.editTextCidade);
        cep = findViewById(R.id.editTextCep);
        cadastroAnuncio = findViewById(R.id.criarAnuncioId);
        tipoAnuncio = findViewById(R.id.spinnertipoAnuncio);
    }

    public void cadastrando(){
//        tentando desvendar a api pra saber como cadastrar

    }
}
