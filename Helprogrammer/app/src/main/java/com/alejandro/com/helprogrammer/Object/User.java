package com.alejandro.com.helprogrammer.Object;

import java.util.ArrayList;

/**
 * Created by GSN on 26/04/2015.
 */
public class User {
    private int id;
    private String usuario;
    private String password;
    private String eMail;
    private String interes;
    ArrayList<User> lista;

    //*************************************Constructores********************************************
    public User(){}
    public User(int id,String usuario,String password, String eMail,String interes){
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public void ingresoUsuario(User usuario){
        lista.add(usuario);
    }
    public void eliminarUsuario(int id){
        lista.remove(id);
    }
    public ArrayList<User> listarUsuario(){
        for (int i=0;i>lista.size();i++)
            lista.get(i);
        return lista;
    }

}
