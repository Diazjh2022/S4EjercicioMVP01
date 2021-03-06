package com.example.s4ejerciciomvp01.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.s4ejerciciomvp01.R;

import androidx.appcompat.app.AppCompatActivity;

import com.example.s4ejerciciomvp01.interfaces.LoginPresenter;
import com.example.s4ejerciciomvp01.interfaces.LoginView;
import com.example.s4ejerciciomvp01.presenter.LoginPresenterImpl;

public class Login extends AppCompatActivity implements LoginView {

    EditText txtUser, txtPass;
    Button btnLogin;
    ProgressBar barraProgreso;

    LoginPresenter presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
        btnLogin = findViewById(R.id.btnLogin);
        barraProgreso = findViewById(R.id.barraProgreso);

        presentador = new LoginPresenterImpl(this);
    }

    @Override
    public void mostrarProgreso() {
        barraProgreso.setVisibility(View.VISIBLE);
    }

    @Override
    public void esconderProgreso() {
        barraProgreso.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
        txtUser.setError("Campo usuario obligatorio");
    }

    @Override
    public void setErrorPassword() {
        txtPass.setError("Campo password obligatorio");
    }

    @Override
    public void exito() {
        startActivity(new Intent(this, OtraActividad.class));
    }

    @Override
    public void noExiste() {
        Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
    }

    public void solicitarValidacion(View view){
        presentador.validarUsuario(txtUser.getText().toString(), txtPass.getText().toString());
    }
}