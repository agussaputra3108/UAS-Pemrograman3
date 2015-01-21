package com.example.aplikasijadwal;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

//import databasehelper.Barang;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	// Logcat tag
    private static final String LOG = "DatabaseHelper";
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "UASPI3";
 
    // Table Names
    private static final String TABLE_JADWAL = "jadwal";
    private static final String TABLE_PROFILE = "profile";
	
    // Table Columns - Jadwal
    private static final String KEY_ID = "id";
    private static final String KEY_HARI = "hari";
    private static final String KEY_JAM = "jam";
    private static final String KEY_MAPEL = "mapel";
    private static final String KEY_NAMA = "nama_guru";
    
    // Table Columns - Profile
    private static final String KEY_ID_PROFILE = "id_profile";
    private static final String KEY_NAMA_PROFILE = "nama";
    private static final String KEY_TEMPAT = "tempat";
    private static final String KEY_TANGGAL = "tanggal";
    private static final String KEY_ALAMAT = "alamat";
    private static final String KEY_NO_TELEPON = "notelepon";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    
    
    //Create table query - Diary
    private static final String CREATE_TABLE_JADWAL = "CREATE TABLE "+TABLE_JADWAL+"("
    		+KEY_ID+" INTEGER, "+KEY_HARI+ " TEXT, "+
    		KEY_JAM+ " TEXT, "+ KEY_MAPEL + " TEXT," + KEY_NAMA + " TEXT" +")";
    
  //Create table query - Diary
    private static final String CREATE_TABLE_PROFILE = "CREATE TABLE "+TABLE_PROFILE+"("
    		+KEY_ID_PROFILE+" INTEGER, "+KEY_NAMA_PROFILE+ " TEXT, "+
    		KEY_TEMPAT+ " TEXT, "+ KEY_TANGGAL + " TEXT," + KEY_ALAMAT + " TEXT,"+ KEY_NO_TELEPON + " TEXT," + KEY_USERNAME + " TEXT,"
    		+ KEY_PASSWORD + " TEXT"+")";
    
	public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_JADWAL);
		db.execSQL(CREATE_TABLE_PROFILE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_JADWAL);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);
		onCreate(db);
	}

	
	//PROSES QUERY KE DATABASE NYA/////////
	public void tambahJadwal(int id,String hari,String jam,String mapel,String guru){
		SQLiteDatabase db = this.getWritableDatabase();
   	 
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("hari", hari);
        values.put("jam", jam);
        values.put("mapel", mapel);
        values.put("nama_guru", guru);
        
        db.insert(TABLE_JADWAL, "", values);
        db.close();
	}
	
	//public boolean cekLogin(String username,String pass){
	public int cekLogin(String username,String pass){
		String selectQuery = "SELECT * FROM " + TABLE_PROFILE +" WHERE username like '"+username+"' AND password like '"+pass+"'";
		 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	//if(cursor.getInt(0) > 0){
            		//return true;
            		return cursor.getInt(0);
            		//return 100;
            	//}
            } while (cursor.moveToNext());
        }
        // return contact list
        
        //return false;
        return 0;
	}
	
	public boolean cekJadwalExist(String hari){
		String selectQuery = "SELECT COUNT(*) FROM " + TABLE_JADWAL +" WHERE hari like '"+hari+"' ";
		 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	if(cursor.getInt(0) > 0){
            		return true;
            	}
            } while (cursor.moveToNext());
        }
        // return contact list
        
        return false;
	}
	
	//PROSES QUERY KE DATABASE NYA/////////
	public void tambahDaftar(String nama,String tempat,String tanggal,String alamat,String notelepon,String username,String password){
		SQLiteDatabase db = this.getWritableDatabase();
	   	 
	    ContentValues values = new ContentValues();
	    values.put("id_profile", getNextId());
	    values.put("nama", nama);
	    values.put("tempat", tempat);
	    values.put("tanggal", tanggal);
	    values.put("alamat", alamat);
	    values.put("notelepon", notelepon);
	    values.put("username", username);
	    values.put("password", password);
	        
	    db.insert(TABLE_PROFILE, "", values);
	    db.close();
	}
	
	public int updateDaftar(String nama,String tempat,String tanggal,String alamat,String notelepon,String username,String password,int IdUser){
		SQLiteDatabase db = this.getWritableDatabase();
	   	 
        ContentValues values = new ContentValues();
        values.put("nama", nama);
	    values.put("tempat", tempat);
	    values.put("tanggal", tanggal);
	    values.put("alamat", alamat);
	    values.put("notelepon", notelepon);
	    values.put("username", username);
	    values.put("password", password);
	    
        return db.update(TABLE_PROFILE, values, KEY_ID_PROFILE + "=" + IdUser, null);
	}
	
	public Profil getProfil(int idUser){
		String selectQuery = "SELECT * FROM " + TABLE_PROFILE +" WHERE " + KEY_ID_PROFILE + " = " +idUser;
		//String selectQuery = "SELECT * FROM " + TABLE_PROFILE +" WHERE " + KEY_USERNAME + " = 'satu'" ;
		 
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Profil p = null;
        
        if(cursor != null){
        	if(cursor.moveToFirst()){
        		p = new Profil();
            	p.setId(cursor.getInt(0));
            	p.setNama(cursor.getString(1));
            	p.setTempat(cursor.getString(2));
            	p.setTanggal(cursor.getString(3));
            	p.setAlamat(cursor.getString(4));
            	p.setNotelepon(cursor.getString(5));
            	p.setUsername(cursor.getString(6));
            	p.setPassword(cursor.getString(7));
            	
            	return p;
        	}
        	cursor.close();
        }
        //Profil p = new Profil();
        //p.setNama("luki");
    	return null;
	}
	
	public int teReturn(){
		return 1;
	}
	
	//public int updateProfil
	
	public List<Schedule> getJadwal(String hari){
		List<Schedule> jadwalList = new ArrayList<Schedule>();
	       
		String selectQuery = "SELECT * FROM " + TABLE_JADWAL +" WHERE hari = '"+hari+"' ";
		 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Schedule jadwal = new Schedule();
            	jadwal.setId(cursor.getInt(0));
            	jadwal.setHari(cursor.getString(1));
            	jadwal.setJam(cursor.getString(2));
            	jadwal.setMapel(cursor.getString(3));
            	jadwal.setNamaguru(cursor.getString(4));
            	jadwalList.add(jadwal);
            } while (cursor.moveToNext());
        }
        // return contact list
        
        return jadwalList;
	}
	
	public boolean hapusDiary(int idDiary){
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(TABLE_JADWAL, KEY_ID + "=" + idDiary, null) > 0;
	}
	
	public int updateDiary(int idDiary, String isi, String judul){
		SQLiteDatabase db = this.getWritableDatabase();
	   	 
        ContentValues values = new ContentValues();
        values.put("isi", isi);
        values.put("judul", judul);
        
        return db.update(TABLE_JADWAL, values, KEY_ID + "=" + idDiary, null);
	}
	
	//buat pengganti auto increment nya
	public int getNextId(){ 
		String query = "SELECT COUNT(*) FROM "+TABLE_PROFILE;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor c = db.rawQuery(query, null);
		
		if(c != null){
			c.moveToFirst();
		}
		int hasil = Integer.parseInt(c.getString(0))+1;
		return hasil;
	}
	
}
