package com.studio124.zurvivor.bdd.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelperUser {
	
	
	public static final String TAB_USER = "user";
	public static final String COLUMN_USER_ID = "id";
	public static final String COLUMN_USER_LOGIN	="login";
	public static final String COLUMN_USER_PASSWORD = "password";
	public static final String COLUMN_USER_COUNTRY = "pays";
	public static final String COLUMN_USER_BIRTHDAY = "date_annivervaire"; 
	public static final String COLUMN_USER_MAIL = "adresse_mail";
	private static final String DATABASE_NAME = "test.db";
	private static final int DATABASE_VERSION = 1;
	
	public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "+TAB_USER+" ( "
			+COLUMN_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
			COLUMN_USER_LOGIN+" TEXT (20)," +
			COLUMN_USER_PASSWORD+" TEXT (20)," +
			COLUMN_USER_COUNTRY+" TEXT (20)," +
			COLUMN_USER_BIRTHDAY+" TEXT (20)," +
			COLUMN_USER_MAIL+" TEXT (20)" +
			");";
	

}
