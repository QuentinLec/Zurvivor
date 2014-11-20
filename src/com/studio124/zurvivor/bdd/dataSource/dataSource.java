package com.studio124.zurvivor.bdd.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.studio124.zurvivor.bdd.DBHelper.MySQLiteDBHelper;
import com.studio124.zurvivor.bdd.DBHelper.MySQLiteHelperUser;
import com.studio124.zurvivor.bdd.modele.User;

public class dataSource {

	private SQLiteDatabase database;
	private MySQLiteDBHelper dbHelper;
	
	public dataSource (Context context){
		dbHelper = new MySQLiteDBHelper(context);
	}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		dbHelper.close();
	}
	
	
	/**
	 * Table USER
	 * 
	 */
	
	
	private String[] AllColumnUser = {	MySQLiteHelperUser.COLUMN_USER_ID, 
										MySQLiteHelperUser.COLUMN_USER_LOGIN,
										MySQLiteHelperUser.COLUMN_USER_PASSWORD,
										MySQLiteHelperUser.COLUMN_USER_COUNTRY,
										MySQLiteHelperUser.COLUMN_USER_BIRTHDAY,
										MySQLiteHelperUser.COLUMN_USER_MAIL};
	
	public User cursorToUser(Cursor cursor){
		User newUser = new User();
		newUser. setUser_id(cursor.getInt(cursor.getColumnIndex(MySQLiteHelperUser.COLUMN_USER_ID)));
		newUser.setUser_login(cursor.getString(cursor.getColumnIndex(MySQLiteHelperUser.COLUMN_USER_LOGIN)));
		newUser.setUser_password(cursor.getString(cursor.getColumnIndex(MySQLiteHelperUser.COLUMN_USER_PASSWORD)));
		newUser.setUser_country(cursor.getString(cursor.getColumnIndex(MySQLiteHelperUser.COLUMN_USER_COUNTRY)));
		newUser.setUser_birthday(cursor.getString(cursor.getColumnIndex(MySQLiteHelperUser.COLUMN_USER_BIRTHDAY)));
		newUser.setUser_mail(cursor.getString(cursor.getColumnIndex(MySQLiteHelperUser.COLUMN_USER_MAIL)));
		
		return newUser;
	}
	
	public User createUser(String login, String password, String pays,String dateDeNaissance, String mail){
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelperUser.COLUMN_USER_LOGIN, login);
		values.put(MySQLiteHelperUser.COLUMN_USER_PASSWORD, password);
		values.put(MySQLiteHelperUser.COLUMN_USER_COUNTRY, pays);
		values.put(MySQLiteHelperUser.COLUMN_USER_BIRTHDAY, dateDeNaissance);
		values.put(MySQLiteHelperUser.COLUMN_USER_MAIL, mail);
		
		long insertId = database.insert(MySQLiteHelperUser.TAB_USER, null, values);
		Cursor cursor = database.query(MySQLiteHelperUser.TAB_USER, AllColumnUser, 
				MySQLiteHelperUser.COLUMN_USER_ID+" = "+insertId, null, null, null, null);
		cursor.moveToFirst();
		User newUser = cursorToUser(cursor);
		cursor.close();
		return newUser;
	}
	
	
	/**
	 * 
	 * FIN table USER
	 */
}
