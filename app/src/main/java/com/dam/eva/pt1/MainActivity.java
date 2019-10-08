package com.dam.eva.pt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_MESSAGE="com.dam.eva.pt1.claumessage";
    public static final String TAG="MainActivity";

    Button button;
    EditText edtNom;
    Button button3;


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart:");
    }

    //torna a ser visible , carregar dades
    @Override
    protected void onResume() {
        super.onResume();
    }


    //perd el focus, parcialment amagat, guardar dades...
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.btnBoto);
        button3= (Button) findViewById(R.id.btnBoto3 );
        edtNom=(EditText) findViewById(R.id.edtNom);


        Log.d(TAG,"debugging");
        //Toast.makeText(this,"primera app",Toast.LENGTH_LONG).show();

        //métode inline botó3
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast toast=Toast.makeText(getApplicationContext(),"Clica sign in",Toast.LENGTH_LONG);
                //toast.show();
                Toast.makeText(MainActivity.this, "Signing in", Toast.LENGTH_LONG).show();
                Log.d(TAG,"boto2");

                EditText editText = findViewById(R.id.edtNom);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
                intent.setType("text/plain");

                intent.setPackage("com.whatsapp");
                Log.d("test","Invoking whatsapp");

                if (intent.resolveActivity(getPackageManager()) == null) {
                    Log.d("test","Couldn't find whatsapp:alternatives showing");
                    intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
                    intent.setType("text/plain");
                }
                startActivity(intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar say_hola = Snackbar.make(view, "Se ha completat el sign in", Snackbar.LENGTH_LONG);
                final Snackbar action = say_hola.setAction("Desfer", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Desfarà el sign in", Toast.LENGTH_SHORT).show();
                    }
                });

                say_hola.show();
            }
        });

    }

    public void onClickHelp(View view){


        Intent intent= new Intent(this, HelpActivity.class);

        // Cóm fer el pas de paràmetres
        String message=edtNom.getText().toString();

        //manera 1 - mètode putExtra (clau, valor)
        intent.putExtra(EXTRA_MESSAGE,message);

        //manera 2 - classe Bundle
        Bundle b=new Bundle();
        message = message + " recollit en bundle";
        b.putString("NOM",message);
        intent.putExtras(b);

        startActivity(intent);

    }

    public void onClickCreaCompte(View v){


        String nomUser=edtNom.getText().toString();

        Toast.makeText(this, "Crearà una nova compta per a:"
                +  nomUser, Toast.LENGTH_LONG).show();
        Log.d(TAG,"crearà nova compta");
        TextView textView= (TextView) findViewById(R.id.txtView1);
        textView.setText(nomUser);

    }

}

