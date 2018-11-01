package com.inovaufrpe.makeparty.usuario.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.cliente.dominio.PessoaFisica;
import com.inovaufrpe.makeparty.fornecedor.dominio.PessoaJuridica;
import com.inovaufrpe.makeparty.usuario.dominio.Usuario;
import com.inovaufrpe.makeparty.usuario.servico.ConexaoServidor;
import com.inovaufrpe.makeparty.cliente.servico.ClienteService;
import com.inovaufrpe.makeparty.usuario.servico.ValidacaoGuiRapida;
import com.inovaufrpe.makeparty.usuario.servico.HttpConnection;
import com.inovaufrpe.makeparty.utils.Mask;

import java.io.IOException;

public class CadastroActivity extends AppCompatActivity {
    private EditText edtEmail, edtConfEmail, edtSenha, edtConfSenha, edtNome, edtCpf, edtNasc, edtMei, edtCnpj, edtTelefone;
    private Spinner spUsuario;
    private ValidacaoGuiRapida validacaoGuiRapida = new ValidacaoGuiRapida();
    private String tipoDeUserParaCadastro;
    ConexaoServidor conexaoServidor;
    ClienteService clienteService = new ClienteService();
    private String validar = "";

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
                edtNome.setText("");
                edtEmail.setText("");
                edtConfEmail.setText("");
                edtSenha.setText("");
                edtConfSenha.setText("");
                edtTelefone.setText("");

                if (parent.getSelectedItem().toString().equals("Fornecedor")){
                    edtNome.setHint("Razão social");
                    edtMei.setVisibility(View.INVISIBLE);
                    edtCnpj.setVisibility(View.VISIBLE);
                    edtCpf.setVisibility(View.INVISIBLE);
                    edtCpf.setText("");
                    edtNasc.setText("");
                    edtNasc.setVisibility(View.INVISIBLE);
                    tipoDeUserParaCadastro = "Fornecedor";
                } else{
                    edtNome.setHint("Nome");
                    edtMei.setVisibility(View.INVISIBLE);
                    edtMei.setText("");
                    edtCnpj.setVisibility(View.INVISIBLE);
                    edtCnpj.setText("");
                    edtNasc.setVisibility(View.VISIBLE);
                    edtCpf.setVisibility(View.VISIBLE);
                    tipoDeUserParaCadastro = "Cliente";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    //Aqui embaixo ainda falta chamar os serviços para efetivar o cadastro, só ta transf em string por enq
    public void onClickCadastrar(View view) throws IOException {

        if (tipoDeUserParaCadastro.equals("Fornecedor")) {
            if(verificarCamposEspecificosFornecedor()){
                String telefone = edtTelefone.toString().trim().replace(".","").replace("-","").replace("(","").replace(")","");
                String fornecedor = setarFornecedor();
                try {
                    cadastrar(fornecedor);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "FORNECEDOR CADASTRADO(AINDA TRATAR)", Toast.LENGTH_SHORT).show();
            }
        }else if(tipoDeUserParaCadastro.equals("Cliente")){
            if(verificarCamposEspecificosCliente()){
                String cliente = setarCliente();
                try {
                    cadastrar(cliente);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "CLIENTE CADASTRADO(AINDA TRATAR)", Toast.LENGTH_SHORT).show();


            }
        }


    }

    private boolean verificarCamposEmailSenhaETelefone() {
        String nome = edtNome.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String confEmail = edtConfEmail.getText().toString().trim();
        String senha = edtSenha.getText().toString().trim();
        String confSenha = edtConfSenha.getText().toString().trim();
        String telefone = edtTelefone.getText().toString().trim();

        if (!validacaoGuiRapida.isCampoAceitavel(nome)) {
            this.edtNome.setError("Digite seu nome");
            return false;
        } else if (!validacaoGuiRapida.isEmailValido(email)) {
            this.edtEmail.setError("Formato inválido");
            return false;
        } else if (!confEmail.equals(email)) {
            this.edtConfEmail.setError("Confirmação de email diferente");
            return false;
        } else if (!validacaoGuiRapida.isSenhaValida(senha)) {
            this.edtSenha.setError("Senha inválida, coloque no min 6 caracteres");
            return false;

        } else if (!validacaoGuiRapida.isSenhaIgual(senha, confSenha)) {
            this.edtConfSenha.setError("A senha e a sua confirmação devem corresponder");
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
        }else if (!validacaoGuiRapida.isCpfValido(cpf)){
            this.edtCpf.setError("Cpf inválido");
            return false;
        }else if (!validacaoGuiRapida.isDataValida(dataNasc)){
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

        }else if (!validacaoGuiRapida.isCnpjValido(cnpj)) {
            this.edtCnpj.setError("CNPJ inválido");
            return false;
        }else{
            return true;
        }

    }

    private String setarFornecedor(){ //throws IOException {
        String email = edtEmail.getText().toString().trim();
        String senha = edtSenha.getText().toString().trim();
        String razaoSocial = edtNome.getText().toString().trim();
        String telefone = edtTelefone.getText().toString().trim().replace(".","").replace("-","").replace("(","").replace(")","");
        String cnpj = edtCnpj.getText().toString().trim().replace(".","").replace("-","").replace("/","");

        Usuario usuario = new Usuario(email, senha);
        PessoaJuridica pessoaJuridica = new PessoaJuridica(usuario, razaoSocial,cnpj,telefone);
        //FornecedorService fornecedor = new FornecedorService();
        //fornecedor.criarFornecedor(pessoaJuridica);
        Gson gson = new Gson();
        String pj = gson.toJson(pessoaJuridica);
        return pj;
    }
    private String setarCliente(){ //throws IOException { //a
        String email = edtEmail.getText().toString().trim();
        String senha = edtSenha.getText().toString().trim();
        String nome = edtNome.getText().toString().trim();
        String telefone = edtTelefone.getText().toString().trim().replace(".","").replace("-","").replace("(","").replace(")","");
        String cpf = edtCpf.getText().toString().trim().replace(".","").replace("-","");
        String dataNasc = edtNasc.getText().toString();

        Usuario usuario = new Usuario(email, senha);
        PessoaFisica pessoaFisica = new PessoaFisica(usuario,nome,cpf,validacaoGuiRapida.dataFormatoBanco(dataNasc),telefone);
        //ClienteService cliente = new ClienteService();
        //cliente.criarCliente(pessoaFisica);
        Gson gson = new Gson();
        String pf = gson.toJson(pessoaFisica);
        return pf;
    }
    private void connectToServer(){
        conexaoServidor = new ConexaoServidor();
       // conexaoServidor.delegate = this;
    }
    private void cadastrar(String json) throws InterruptedException{
        callServer("POST",json);
    }


    private void callServer(final String method, final String data)  throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //validar = HttpConnection.post("https://makepartyserver.herokuapp.com/users/signup/advertiser",data);
                if (tipoDeUserParaCadastro.equals("Cliente")){
                    validar = HttpConnection.post("https://makepartyserver.herokuapp.com/users/signup/customer",data);
                }else{
                    validar = HttpConnection.post("https://makepartyserver.herokuapp.com/users/signup/advertiser",data);
                }
//
            }
        });
        thread.start();
        thread.join();
    }

}
