package com.alejandro.com.helprogrammer.Object;

/**
 * Created by GSN on 26/04/2015.
 */
public class User {
    String usuario;
    String password;
    String eMail;
    String interes;

    //*************************************Constructores********************************************
    public User(){}
    public User(String usuario,String password, String eMail,String interes){
        this.usuario = usuario;
        this.password = password;
        this.eMail = eMail;
        this.interes = interes;
    }
    //****************************************GetAndSetter*****************************************
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public String getInteres() {
        return interes;
    }
    public void setInteres(String interes) {
        this.interes = interes;
    }
    //*************************************Funciones***********************************************
    public boolean checkLoggin(){
        if((usuario.equals("usuario") && password.equals("password"))
                ||(eMail.equals("email@email.com") && password.equals("password"))){
            System.out.println("es correcto el usuario");
            return true;
        }
        else
            return false;
    }
}
