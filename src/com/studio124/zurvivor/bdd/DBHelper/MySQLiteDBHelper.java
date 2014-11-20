package com.studio124.zurvivor.bdd.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteDBHelper extends SQLiteOpenHelper {
	
	Context context;
	private static final String DATABASE_NAME = "zurvivor.db";
	private static final int DATABASE_VERSION = 1;
	
	public MySQLiteDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(MySQLiteHelperUser.DATABASE_CREATE);
		db.execSQL(MySQLiteHelperJoueur.DATABASE_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		 Log.w(MySQLiteHelperJoueur.class.getName(),
			        "Upgrading database from version " + oldVersion + " to "
			            + newVersion + ", which will destroy all old data");
			    db.execSQL("DROP TABLE IF EXISTS " + MySQLiteHelperJoueur.TAB_JOUEUR);
			    onCreate(db);
		
	}
	
}
