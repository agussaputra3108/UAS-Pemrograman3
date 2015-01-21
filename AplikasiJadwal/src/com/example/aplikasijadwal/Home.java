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


public class Home extends ActionBarActivity {
	String nama;
	String idUser;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        idUser = intent.getStringExtra("idUser");
        
        TextView welcome = (TextView) findViewById(R.id.textView1);
        welcome.setText(welcome.getText().toString()+" "+nama);
        
        Button btnProfil = (Button) findViewById(R.id.btnProfil);
        btnProfil.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), Profile_Tampil.class);
				intent.putExtra("idUser", idUser);
				startActivity(intent);
				//Toast.makeText(getBaseContext(), idUser, Toast.LENGTH_SHORT).show();
			}
		});
        
        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),Jadwal.class);
        		in.putExtra("nama", nama);
            	in.putExtra("idUser", idUser);
        		startActivity(in);
            }
        });
        
        Button btn7 = (Button) findViewById(R.id.button2);
        btn7.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),ProfilShow.class);
        		in.putExtra("nama", nama);
            	in.putExtra("idUser", idUser);
        		startActivity(in);
            }
        });

        /*Button btn1 = (Button) findViewById(R.id.button2);
        btn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent in = new Intent(v.getContext(),ProfilShow.class);
        		in.putExtra("nama", nama);
            	in.putExtra("idUser", idUser);
        		startActivity(in);
            }
        });*/
        
        Button btn2 = (Button) findViewById(R.id.button3);
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
