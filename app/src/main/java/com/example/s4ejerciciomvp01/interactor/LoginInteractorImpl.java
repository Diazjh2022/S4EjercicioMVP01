package com.example.s4ejerciciomvp01.interactor;

import android.os.Handler;

import com.example.s4ejerciciomvp01.interfaces.LoginInteractor;
import com.example.s4ejerciciomvp01.interfaces.LoginPresenter;

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void validarUsuario(String user, String pass, LoginPresenter presentador) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user.equals("")){
                    presentador.setErrorUser();
                }
                else if(pass.equals("")){
                    presentador.setErrorPassword();
                }
                else{
                    if(user.equals("jd") && pass.equals("123")){
                        presentador.exito();
                    }
                    else{
                        presentador.noExiste();
                    }
                }
            }
        }, 5000);

    }
}
