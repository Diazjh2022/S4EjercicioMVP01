package com.example.s4ejerciciomvp01.interfaces;

public interface LoginView {

    void mostrarProgreso();
    void esconderProgreso();
    void setErrorUser();
    void setErrorPassword();
    void exito();
    void noExiste();

}
