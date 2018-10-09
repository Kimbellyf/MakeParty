package com.inovaufrpe.makeparty.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.inovaufrpe.makeparty.R;

public class LoginActivity extends AppCompatActivity{
    private EditText edtEmail, edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    //Por enq só pegando os dados e transf em string, sem chamar o serviço
    public void onClickLogar(View view){
        edtEmail= findViewById(R.id.editTextEmail);
        edtSenha= findViewById(R.id.editTextSenha);
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();

    }
}
