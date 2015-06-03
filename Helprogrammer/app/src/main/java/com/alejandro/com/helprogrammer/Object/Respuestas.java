package com.alejandro.com.helprogrammer.Object;

import com.alejandro.com.helprogrammer.Respuesta;

/**
 * Created by GSN on 15/05/2015.
 */
public class Respuestas {
    private String respuesta;
    private String Tag;
    private String Id;
    private String Resultado;

    public Respuestas(){
        //constructor vasio
    }
    public Respuestas(String respuesta,String Tag,String Id){
        this.respuesta=respuesta;
        this.Tag=Tag;
        this.Id=Id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String resultado) {
        Resultado = resultado;
    }
}
