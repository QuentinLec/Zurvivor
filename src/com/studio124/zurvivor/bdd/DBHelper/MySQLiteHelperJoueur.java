package com.studio124.zurvivor.bdd.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/*
 * 
 * int idJoueur, sommeArgent, niveauContaminationJoueur, niveauAlimentationJoueur;
	String PseudoJoueur,  dateNaissanceJoueur, dateCreationJoueur, dureeSurvieJoueur, sexeJoueur;
 */
public class MySQLiteHelperJoueur extends SQLiteOpenHelper{

	public static final String TAB_JOUEUR = "user";
	public static final String COLUMN_ID_JOUEUR = "id_joueur";
	public static final String COLUMN_PSEUDO	="pseudo_joueur";
	public static final String COLUMN_DATE_NAISSANCE = "date_naissance";
	public static final String COLUMN_DATE_CREATION = "date_creation";
	public static final String COLUMN_DUREE_SURVIE = "duree_survie";
	public static final String COLUMN_SEXE_JOUEUR = "sexe_joueur";
	public static final String  COLUMN_SOMME_ARGENT = "somme_argent";
	public static final String COLUMN_LVL_CONTAMINATION = "lvl_contamination";
	public static final String COLUMN_LVL_ALIMENTATION = "lvl_alimentation";
	
	private static final String DATABASE_NAME = "test.db";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "+TAB_JOUEUR+" ( "
			+COLUMN_ID_JOUEUR+" INTEGER PRIMARY KEY AUTOINCREMENT," +
			COLUMN_PSEUDO+" TEXT (20)," +
			COLUMN_DATE_NAISSANCE+" TEXT (20)," +
			COLUMN_DATE_CREATION+" TEXT (20)," +
			COLUMN_DUREE_SURVIE+" TEXT (20)," +
			COLUMN_SOMME_ARGENT+" TEXT (100)" +
			COLUMN_LVL_CONTAMINATION+" TEXT (100)" +
			COLUMN_LVL_ALIMENTATION+" TEXT (100)" +
			");";
			
	
	public MySQLiteHelperJoueur(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public MySQLiteHelperJoueur(Context context) {
		super(context,DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		 Log.w(MySQLiteHelperJoueur.class.getName(),
			        "Upgrading database from version " + oldVersion + " to "
			            + newVersion + ", which will destroy all old data");
			    db.execSQL("DROP TABLE IF EXISTS " + TAB_JOUEUR);
			    onCreate(db);
		
	}
	
}
