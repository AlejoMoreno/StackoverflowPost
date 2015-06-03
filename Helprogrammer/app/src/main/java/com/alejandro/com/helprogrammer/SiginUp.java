package com.alejandro.com.helprogrammer;

import android.content.Intent;
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

import org.w3c.dom.Text;

import java.lang.String;


public class SiginUp extends ActionBarActivity {

    private Button Bregistrer;
    private int Tid=1;
    private String Tpass;
    private String Tpass2;
    private String Tinteres;
    private String TeMail;
    private String Tname;
    //private EditText ETid;
    private EditText ETpass;
    private EditText ETpass2;
    private EditText ETinteres;
    private EditText ETeMail;
    private EditText ETname;

    public User usuario = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin_up);

        Bregistrer = (Button) findViewById(R.id.Bregistrer);
        Bregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recolectorRegistro();
                if(validacion()==true){
                    System.out.println("Correct validation");
                    mensaje("Correct validation");
                    crearUsuario();
                    Intent browserIntent =
                            new Intent(SiginUp.this, Loggin.class);
                    setResult(RESULT_OK, browserIntent);
                    startActivity(browserIntent);
                    finish();
                }
                else{
                    System.out.println("Error, is not correct");
                    mensaje("Error, is not correct");
                }
            }
        });

    }

    public void crearUsuario () {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        User usuario =
                new User(Tid,Tname,Tpass,TeMail,Tinteres);

        dbHandler.addUsuario(usuario);
    }
    public void mensaje(String cadena){
        Toast.makeText(this, cadena, Toast.LENGTH_SHORT).show();
    }

    public boolean validacion(){
        if(Tname.equals("")||Tpass.equals("")||Tpass2.equals("")||TeMail.equals("")||Tinteres.equals("")){
            mensaje("ERROR, Fill in missing fields ");
            return false;
        }
        else{
            if(Tpass.equals(Tpass2))
                return true;
            else{
                mensaje("ERROR, The password is not equals");
                return false;
            }
        }
    }

    public void recolectorRegistro(){
        //ETid = (EditText) findViewById(R.id.iduser);
        ETpass = (EditText) findViewById(R.id.Tpass);
        ETpass2 = (EditText) findViewById(R.id.Tpass2);
        ETname = (EditText) findViewById(R.id.Tname);
        ETeMail = (EditText) findViewById(R.id.TeMail);
        ETinteres = (EditText) findViewById(R.id.Tinteres);
        //Tid = Integer.parseInt(ETid.getText().toString());
        Tpass = ETpass.getText().toString();
        Tpass2 = ETpass2.getText().toString();
        Tname = ETname.getText().toString();
        TeMail = ETeMail.getText().toString();
        Tinteres = ETinteres.getText().toString();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sigin_up, menu);
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
