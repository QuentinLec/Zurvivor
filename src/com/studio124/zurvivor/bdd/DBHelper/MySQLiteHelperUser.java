package com.studio124.zurvivor.bdd.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelperUser extends SQLiteOpenHelper{
	
	
	public static final String TAB_USER = "user";
	public static final String COLUMN_USER_ID = "id";
	public static final String COLUMN_USER_LOGIN	="login";
	public static final String COLUMN_USER_PASSWORD = "password";
	public static final String COLUMN_USER_PASSWORD_CHECK = "password_check";
	public static final String COLUMN_USER_COUNTRY = "pays";
	public static final String COLUMN_USER_LASTNAME = "nom";
	public static final String COLUMN_USER_FIRSTNAME = "prenom";
	public static final String COLUMN_USER_ADDRESS = "adresse";
	public static final String COLUMN_USER_BIRTHDAY = "date_annivervaire"; 
	public static final String COLUMN_USER_MAIL = "adresse_mail";
	private static final String DATABASE_NAME = "test.db";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "+TAB_USER+" ( "
			+COLUMN_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
			COLUMN_USER_LOGIN+" TEXT (20)," +
			COLUMN_USER_PASSWORD+" TEXT (20)," +
			COLUMN_USER_PASSWORD_CHECK+" TEXT (20)," +
			COLUMN_USER_LASTNAME+" TEXT (20)," +
			COLUMN_USER_FIRSTNAME+" TEXT (20)," +
			COLUMN_USER_COUNTRY+" TEXT (20)," +
			COLUMN_USER_ADDRESS+" TEXT (100)" +
			COLUMN_USER_BIRTHDAY+" TEXT (20)," +
			COLUMN_USER_MAIL+" TEXT (20)," +
			");";
			
	
	public MySQLiteHelperUser(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public MySQLiteHelperUser(Context context) {
		super(context,DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		 Log.w(MySQLiteHelperUser.class.getName(),
			        "Upgrading database from version " + oldVersion + " to "
			            + newVersion + ", which will destroy all old data");
			    db.execSQL("DROP TABLE IF EXISTS " + TAB_USER);
			    onCreate(db);
		
	}
	
	

}
