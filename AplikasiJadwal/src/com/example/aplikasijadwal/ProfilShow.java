package com.example.aplikasijadwal;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilShow extends ActionBarActivity {
	int idUser;
	DatabaseHelper mydb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profil_tampil);
		
		final Intent intent = getIntent();
        idUser = Integer.parseInt(intent.getStringExtra("idUser"));
        mydb = new DatabaseHelper(this);
        
        //Toast.makeText(getBaseContext(), String.valueOf(idUser), Toast.LENGTH_SHORT).show();
        
        ///dapatin data user nya
        Profil p = mydb.getProfil(idUser);
        
        final TextView edt1 = (TextView) findViewById(R.id.editText1);
        edt1.setText(p.getNama());
        final TextView edt2 = (TextView) findViewById(R.id.editText2);
        edt2.setText(p.getTempat());
        final TextView edt3 = (TextView) findViewById(R.id.editText3);
        edt3.setText(p.getTanggal());
        final TextView edt4 = (TextView) findViewById(R.id.editText4);
        edt4.setText(p.getAlamat());
        final TextView edt5 = (TextView) findViewById(R.id.editText5);
        edt5.setText(p.getNotelepon());
        final TextView edt6 = (TextView) findViewById(R.id.editText6);
        edt6.setText(p.getUsername());
        final TextView edt7 = (TextView) findViewById(R.id.editText7);
        edt7.setText(p.getPassword());
        
        Button btn2 = (Button) findViewById(R.id.button1);
        btn2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),Home.class);
            	in.putExtra("idUser", intent.getStringExtra("idUser"));
        		startActivity(in);
            }
        });
	}

}
