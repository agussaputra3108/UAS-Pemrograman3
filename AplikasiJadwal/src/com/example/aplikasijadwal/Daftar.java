package com.example.aplikasijadwal;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Daftar extends ActionBarActivity {
	DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        
        mydb = new DatabaseHelper(this);
        
        final EditText nama = (EditText)findViewById(R.id.editText1);
        final EditText tempatlahir = (EditText)findViewById(R.id.editText2);
        final EditText tanggallahir = (EditText)findViewById(R.id.editText3);
        final EditText alamat = (EditText)findViewById(R.id.editText4);
        final EditText notelepon = (EditText)findViewById(R.id.editText5);
        final EditText username = (EditText)findViewById(R.id.editText6);
        final EditText password = (EditText)findViewById(R.id.editText7);
        
        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Toast.makeText(getBaseContext(), "Sukses Daftar", Toast.LENGTH_LONG).show();
                mydb.tambahDaftar( nama.getText().toString(), tempatlahir.getText().toString(), tanggallahir.getText().toString(), alamat.getText().toString(), notelepon.getText().toString(), username.getText().toString(), password.getText().toString());

            	Intent in = new Intent(v.getContext(),MainActivity.class);
            	startActivity(in);
            }
        });
        
        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),MainActivity.class);
            	startActivity(in);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
