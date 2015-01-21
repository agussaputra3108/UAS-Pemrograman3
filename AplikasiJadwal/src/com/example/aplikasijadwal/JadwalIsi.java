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


public class JadwalIsi extends ActionBarActivity {
	String nama;
	DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwal_isi);
        final Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        String hari = intent.getStringExtra("hari");
        
        mydb = new DatabaseHelper(this);
        List<Schedule> listJadwal = mydb.getJadwal(hari);
        
        TextView isi = (TextView)findViewById(R.id.textView1);
        isi.setText("");
        for(int i=0;i<listJadwal.size();i++){
        	isi.setText(isi.getText()+" "+listJadwal.get(i).getHari());
            isi.setText(isi.getText()+" "+listJadwal.get(i).getJam());
            isi.setText(isi.getText()+" "+listJadwal.get(i).getMapel());
            isi.setText(isi.getText()+" "+listJadwal.get(i).getNamaguru());
            isi.setText(isi.getText()+"\n");
        }
        
        Button kembali = (Button)findViewById(R.id.button1);
        kembali.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),Jadwal.class);
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
