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


public class MainActivity extends ActionBarActivity {
	EditText username;
	EditText password;
	DatabaseHelper mydb;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mydb = new DatabaseHelper(this);
        //Toast.makeText(getBaseContext(), String.valueOf(mydb.cekJadwalExist("senin")), Toast.LENGTH_LONG).show();
        if(!mydb.cekJadwalExist("senin")){
        	mydb.tambahJadwal(1,"senin","07:00-08:00","Upacara","Pembina");
        	mydb.tambahJadwal(2,"senin","08:00-09:00","Agama","Guru Agama");
        	mydb.tambahJadwal(3,"senin","09:00-10:00","B.Indonesia","Guru B.Indonesia");
        	mydb.tambahJadwal(4,"senin","10:00-11:00","IPA","Guru IPA");
        	mydb.tambahJadwal(5,"senin","11:00-12:00","IPS","Guru IPS");
        	mydb.tambahJadwal(6,"senin","13:30-13:30","B. Inggris","Guru B. Inggris");
        	mydb.tambahJadwal(7,"senin","13:30-14:30","B. Jerman","Guru B. Jerman");
        }
        if(!mydb.cekJadwalExist("selasa")){
        	mydb.tambahJadwal(8,"selasa","07:00-08:00","Upacara","Pembina");
        	mydb.tambahJadwal(9,"selasa","08:00-09:00","Agama","Guru Agama");
        	mydb.tambahJadwal(10,"selasa","09:00-10:00","B.Indonesia","Guru B.Indonesia");
        	mydb.tambahJadwal(11,"selasa","10:00-11:00","IPA","Guru IPA");
        	mydb.tambahJadwal(12,"selasa","11:00-12:00","IPS","Guru IPS");
        	mydb.tambahJadwal(13,"selasa","13:30-13:30","B. Inggris","Guru B. Inggris");
        	mydb.tambahJadwal(14,"selasa","13:30-14:30","B. Jerman","Guru B. Jerman");
        }
        if(!mydb.cekJadwalExist("rabu")){
        	mydb.tambahJadwal(15,"rabu","07:00-08:00","Upacara","Pembina");
        	mydb.tambahJadwal(16,"rabu","08:00-09:00","Agama","Guru Agama");
        	mydb.tambahJadwal(17,"rabu","09:00-10:00","B.Indonesia","Guru B.Indonesia");
        	mydb.tambahJadwal(18,"rabu","10:00-11:00","IPA","Guru IPA");
        	mydb.tambahJadwal(19,"rabu","11:00-12:00","IPS","Guru IPS");
        	mydb.tambahJadwal(20,"rabu","13:30-13:30","B. Inggris","Guru B. Inggris");
        	mydb.tambahJadwal(21,"rabu","13:30-14:30","B. Jerman","Guru B. Jerman");
        }
        if(!mydb.cekJadwalExist("kamis")){
        	mydb.tambahJadwal(22,"kamis","07:00-08:00","Upacara","Pembina");
        	mydb.tambahJadwal(23,"kamis","08:00-09:00","Agama","Guru Agama");
        	mydb.tambahJadwal(24,"kamis","09:00-10:00","B.Indonesia","Guru B.Indonesia");
        	mydb.tambahJadwal(25,"kamis","10:00-11:00","IPA","Guru IPA");
        	mydb.tambahJadwal(26,"kamis","11:00-12:00","IPS","Guru IPS");
        	mydb.tambahJadwal(27,"kamis","13:30-13:30","B. Inggris","Guru B. Inggris");
        	mydb.tambahJadwal(28,"kamis","13:30-14:30","B. Jerman","Guru B. Jerman");
        }
        if(!mydb.cekJadwalExist("jumat")){
        	mydb.tambahJadwal(29,"jumat","07:00-08:00","Upacara","Pembina");
        	mydb.tambahJadwal(30,"jumat","08:00-09:00","Agama","Guru Agama");
        	mydb.tambahJadwal(31,"jumat","09:00-10:00","B.Indonesia","Guru B.Indonesia");
        	mydb.tambahJadwal(32,"jumat","10:00-11:00","IPA","Guru IPA");
        	mydb.tambahJadwal(33,"jumat","11:00-12:00","IPS","Guru IPS");
        	mydb.tambahJadwal(34,"jumat","13:30-13:30","B. Inggris","Guru B. Inggris");
        	mydb.tambahJadwal(35,"jumat","13:30-14:30","B. Jerman","Guru B. Jerman");
        }
        
        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	username = (EditText)findViewById(R.id.editText1);
                password = (EditText)findViewById(R.id.editText2);
                
                // TODO Auto-generated method stub
                int idUser = mydb.cekLogin(username.getText().toString(), password.getText().toString());
            	//if(mydb.cekLogin(username.getText().toString(), password.getText().toString())){
                if(idUser > 0){
            		Intent in = new Intent(v.getContext(),Home.class);
            		in.putExtra("idUser", String.valueOf(idUser));
            		in.putExtra("nama", username.getText().toString());
            		startActivity(in);
                	//Toast.makeText(getBaseContext(), String.valueOf(idUser), Toast.LENGTH_LONG).show();
            	}
            	else{
            		Toast.makeText(getBaseContext(), "Username/Password Salah!!!", Toast.LENGTH_LONG).show();
            	}
           
            }
        });
        
        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),Daftar.class);
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
