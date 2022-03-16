package com.example.s4ejerciciomvp01.presenter;

import com.example.s4ejerciciomvp01.interactor.LoginInteractorImpl;
import com.example.s4ejerciciomvp01.interfaces.LoginInteractor;
import com.example.s4ejerciciomvp01.interfaces.LoginPresenter;
import com.example.s4ejerciciomvp01.interfaces.LoginView;

public class LoginPresenterImpl implements LoginPresenter {

    LoginView vista;
    LoginInteractor interactor;

    public LoginPresenterImpl(LoginView vista) {
        this.vista = vista;
        interactor = new LoginInteractorImpl();
    }


    @Override
    public void validarUsuario(String user, String pass) {
        if(vista != null){
            vista.mostrarProgreso();
        }
        interactor.validarUsuario(user, pass, this);
    }

    @Override
    public void setErrorUser() {
        if(vista != null){
            vista.esconderProgreso();
            vista.setErrorUser();
        }
    }

    @Override
    public void setErrorPassword() {
        if(vista != null){
            vista.esconderProgreso();
            vista.setErrorPassword();
        }
    }

    @Override
    public void exito() {
        if(vista != null){
            vista.esconderProgreso();
            vista.exito();
        }
    }

    @Override
    public void noExiste() {
        vista.noExiste();
        vista.esconderProgreso();
    }
}
