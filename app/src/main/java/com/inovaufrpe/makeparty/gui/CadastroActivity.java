package com.inovaufrpe.makeparty.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.servico.ValidacaoGuiRapida;
import com.inovaufrpe.makeparty.utils.Mask;

public class CadastroActivity extends AppCompatActivity {
    private EditText edtEmail, edtConfEmail, edtSenha, edtConfSenha, edtNome, edtCpf, edtNasc, edtMei, edtCnpj, edtTelefone;
    private Spinner spUsuario;
    private ValidacaoGuiRapida validacaoGuiRapida = new ValidacaoGuiRapida();
    private String tipoDeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        listandoOpçoesSpinner();
        encontrandoViews();
        saberQualTipoDeUser();

    }
    public void listandoOpçoesSpinner() {
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
        edtMei = findViewById(R.id.editTextMEI);
        //edtMei.addTextChangedListener(Mask.insert("", edtMei));
        edtCnpj = findViewById(R.id.editTextCNPJ);
        edtCnpj.addTextChangedListener(Mask.insert("##.###.###/####-##", edtCnpj));
        edtTelefone = findViewById(R.id.editTextTelefone);
        edtTelefone.addTextChangedListener(Mask.insert("(##)#####-####",edtTelefone));

    }
    public void saberQualTipoDeUser(){
        //Metodo para quando um elemento do Spinner é selecionado()
        spUsuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getSelectedItem().toString().equals("Fornecedor")){
                    edtNome.setText("");
                    edtNome.setHint("Razão social");
                    edtMei.setVisibility(View.INVISIBLE);
                    edtCnpj.setVisibility(View.VISIBLE);
                    edtCpf.setVisibility(View.INVISIBLE);
                    edtCpf.setText("");
                    edtNasc.setText("");
                    edtNasc.setVisibility(View.INVISIBLE);
                    tipoDeUser = "Fornecedor";
                } else{
                    edtNome.setText("");
                    edtNome.setHint("Nome");
                    edtMei.setVisibility(View.INVISIBLE);
                    edtMei.setText("");
                    edtCnpj.setVisibility(View.INVISIBLE);
                    edtCnpj.setText("");
                    edtCpf.setVisibility(View.VISIBLE);
                    tipoDeUser = "Cliente";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    //Aqui embaixo ainda falta chamar os serviços para efetivar o cadastro, só ta transf em string por enq
    public void onClickCadastrar(View view) {
        String tipoUsuario = (String) spUsuario.getSelectedItem();

        String cadastroAtual="Cliente";
        if (tipoDeUser.equals("Fornecedor")) {
            cadastroAtual = "Fornecedor";
            if(verificarCamposEspecificosFornecedor()){
            }
        }


    }
    private boolean verificarCamposEmailSenhaETelefone() {
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString().trim();
        String confEmail = edtConfEmail.getText().toString().trim();
        String senha = edtSenha.getText().toString().trim();
        String confSenha = edtConfSenha.getText().toString().trim();
        String telefone = edtTelefone.getText().toString().trim();

        if (validacaoGuiRapida.isCampoVazio(nome)) {
            this.edtNome.setError("Campo vazio");
            return false;
        } else if (validacaoGuiRapida.isEmailValido(email)) {
            this.edtEmail.setError("Formato inválido");
            return false;
        } else if (!confEmail.equals(email)) {
            this.edtConfEmail.setError("Confirmação de email diferente");
            return false;
        } else if (validacaoGuiRapida.isSenhaValida(senha)) {
            this.edtSenha.setError("Senha inválida");
            return false;

        } else if (!validacaoGuiRapida.isSenhaIgual(senha, confSenha)) {
            this.edtConfSenha.setError("Senhas diferentes");
            return false;

        } else if (!validacaoGuiRapida.isTelefoneValido(telefone)) {
            this.edtTelefone.setError("Telefone inválido");
            return false;
        } else {
            return true;
        }
    }
    private boolean verificarCamposEspecificosCliente(){
        String cpf = edtCpf.getText().toString().trim();
        String dataNasc = edtNasc.getText().toString().trim();

        if (!verificarCamposEmailSenhaETelefone()){
            return false;
        }else if (validacaoGuiRapida.isCpfValido(cpf)){
            this.edtCpf.setError("Cpf inválido");
            return false;
        }else if (validacaoGuiRapida.isDataValida(dataNasc)){
            this.edtNasc.setError("Data inválida");
            return false;
        } else{
            return true;
        }

    }
    private  boolean verificarCamposEspecificosFornecedor(){
        String mei = edtMei.getText().toString().trim();
        String cnpj = edtCnpj.getText().toString().trim();

        if (!verificarCamposEmailSenhaETelefone()) {
            return false;

        }else if (validacaoGuiRapida.isCnpjValido(cnpj)) {
            this.edtCnpj.setError("CNPJ inválido");
            return false;
        }else{
            return true;
        }

    }

}
