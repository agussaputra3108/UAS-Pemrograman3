package com.example.aplikasijadwal;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Jadwal extends ActionBarActivity {
	String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwal);
        final Intent intent = getIntent();
        nama = intent.getStringExtra("nama");

        TextView welcome = (TextView) findViewById(R.id.textView1);
        welcome.setText(welcome.getText().toString()+" "+nama);
        
        Button senin = (Button)findViewById(R.id.button2);
        senin.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),JadwalIsi.class);
        		in.putExtra("nama", nama);
        		in.putExtra("hari", "senin");
            	in.putExtra("idUser", intent.getStringExtra("idUser"));
        		startActivity(in);
            }
        });
        
        Button selasa = (Button)findViewById(R.id.button3);
        selasa.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),JadwalIsi.class);
        		in.putExtra("nama", nama);
        		in.putExtra("hari", "selasa");
            	in.putExtra("idUser", intent.getStringExtra("idUser"));
        		startActivity(in);
            }
        });
        
        Button rabu = (Button)findViewById(R.id.button4);
        rabu.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),JadwalIsi.class);
        		in.putExtra("nama", nama);
        		in.putExtra("hari", "rabu");
            	in.putExtra("idUser", intent.getStringExtra("idUser"));
        		startActivity(in);
            }
        });
        
        Button kamis = (Button)findViewById(R.id.button5);
        kamis.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),JadwalIsi.class);
        		in.putExtra("nama", nama);
        		in.putExtra("hari", "kamis");
            	in.putExtra("idUser", intent.getStringExtra("idUser"));
        		startActivity(in);
            }
        });
        
        Button jumat = (Button)findViewById(R.id.button6);
        jumat.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),JadwalIsi.class);
        		in.putExtra("nama", nama);
        		in.putExtra("hari", "jumat");
            	in.putExtra("idUser", intent.getStringExtra("idUser"));
        		startActivity(in);
            }
        });
        
        Button kembali = (Button)findViewById(R.id.button1);
        kembali.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),Home.class);
        		in.putExtra("nama", nama);
            	in.putExtra("idUser", intent.getStringExtra("idUser"));
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
