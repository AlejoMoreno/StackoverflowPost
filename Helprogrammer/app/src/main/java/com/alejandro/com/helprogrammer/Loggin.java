package com.alejandro.com.helprogrammer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alejandro.com.helprogrammer.Object.MyDBHandler;
import com.alejandro.com.helprogrammer.Object.User;

import java.util.ArrayList;


public class Loggin extends ActionBarActivity {

    private Button Blogin;
    private Button Bsigin;
    private String Temail;
    private String Tpass;
    private EditText ETemail;
    private EditText ETpass;

    public User usuario = new User();
    public ArrayList<User> listaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        Blogin = (Button) findViewById(R.id.Blogin);
        Blogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                recolectorLoggin();
                if(validacion()==true){

                    Intent browserIntent =
                            new Intent(Loggin.this, Pregunta.class);
                    startActivity(browserIntent);
                }


                //finish();
            }
        });

        Bsigin = (Button) findViewById(R.id.Bsigin);
        Bsigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent =
                        new Intent(Loggin.this, SiginUp.class);
                startActivity(browserIntent);
            }
        });
    }

    public boolean validacion(){
        boolean valor=false;
        if(Temail.equals("") || Tpass.equals("")){
            mensaje("ERROR, Fill in missing fields");
            valor = false;
        }
        else{
            valor=lookUser(Tpass);
        }
        return valor;
    }

    public boolean lookUser (String password) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        boolean valor=false;
        User usuario = dbHandler.findUser(Temail);

        if (usuario != null) {
            mensaje("Match Found");
            valor=true;
            System.out.println("La clave es: "+usuario.getPassword());
//            quantityBox.setText(String.valueOf(product.getQuantity()));
        } else {
            mensaje("No Match Found");
            valor=false;
        }
        return valor;
    }

    public void recolectorLoggin(){
        ETemail = (EditText) findViewById(R.id.email);
        ETpass = (EditText) findViewById(R.id.Tpass);
        Temail = ETemail.getText().toString();
        Tpass = ETpass.getText().toString();
    }

    public void mensaje(String cadena){
        Toast.makeText(this, cadena, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loggin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
