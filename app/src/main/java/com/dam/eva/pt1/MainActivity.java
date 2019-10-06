package com.dam.eva.pt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // TODO: 1/10/19

    public static final String EXTRA_MESSAGE="com.dam.eva.pt1";
    public static final String TAG="MainActivity";

    Button button;
    EditText edtNom;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.btnBoto);
        button3= (Button) findViewById(R.id.btnBoto3 );
        edtNom=(EditText) findViewById(R.id.edtNom);


        Log.d(TAG,"debugging");
        Toast.makeText(this,"primera app",Toast.LENGTH_LONG).show();

        //métode inline botó3
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getApplicationContext(),"Clica sign in",Toast.LENGTH_LONG);
                toast.show();
                Toast.makeText(MainActivity.this, "Signing in", Toast.LENGTH_LONG).show();
                Log.d(TAG,"boto2");

            }
        });


    }

    public void onClickHelp(View view){


        Intent intent= new Intent(this, HelpActivity.class);


        String message=edtNom.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);

        Bundle b=new Bundle();
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

