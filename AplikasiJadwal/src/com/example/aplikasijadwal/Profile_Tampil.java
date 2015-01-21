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

public class Profile_Tampil extends ActionBarActivity {
	int idUser;
	DatabaseHelper mydb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile__tampil);
		
		final Intent intent = getIntent();
        idUser = Integer.parseInt(intent.getStringExtra("idUser"));
        mydb = new DatabaseHelper(this);
        
        //Toast.makeText(getBaseContext(), String.valueOf(idUser), Toast.LENGTH_SHORT).show();
        
        ///dapatin data user nya
        Profil p = mydb.getProfil(idUser);
        
        final EditText edt1 = (EditText) findViewById(R.id.editText1);
        edt1.setText(p.getNama());
        final EditText edt2 = (EditText) findViewById(R.id.editText2);
        edt2.setText(p.getTempat());
        final EditText edt3 = (EditText) findViewById(R.id.editText3);
        edt3.setText(p.getTanggal());
        final EditText edt4 = (EditText) findViewById(R.id.editText4);
        edt4.setText(p.getAlamat());
        final EditText edt5 = (EditText) findViewById(R.id.editText5);
        edt5.setText(p.getNotelepon());
        final EditText edt6 = (EditText) findViewById(R.id.editText6);
        edt6.setText(p.getUsername());
        final EditText edt7 = (EditText) findViewById(R.id.editText7);
        edt7.setText(p.getPassword());
        
        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Toast.makeText(getBaseContext(), "Sukses Update", Toast.LENGTH_LONG).show();
                mydb.updateDaftar( edt1.getText().toString(), edt2.getText().toString(), edt3.getText().toString(), edt4.getText().toString(), edt5.getText().toString(), edt6.getText().toString(), edt7.getText().toString(),Integer.parseInt(intent.getStringExtra("idUser")));

            	Intent in = new Intent(v.getContext(),Home.class);
            	in.putExtra("idUser", intent.getStringExtra("idUser"));
            	startActivity(in);
            }
        });
        
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),Home.class);
            	in.putExtra("idUser", intent.getStringExtra("idUser"));
        		startActivity(in);
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile__tampil, menu);
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
