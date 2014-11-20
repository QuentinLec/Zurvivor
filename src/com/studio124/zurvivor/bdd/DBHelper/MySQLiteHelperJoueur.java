package com.studio124.zurvivor.bdd.DBHelper;

/*
 * 
 * int idJoueur, sommeArgent, niveauContaminationJoueur, niveauAlimentationJoueur;
	String PseudoJoueur,  dateNaissanceJoueur, dateCreationJoueur, dureeSurvieJoueur, sexeJoueur;
 */
public class MySQLiteHelperJoueur {

	public static final String TAB_JOUEUR = "user";
	public static final String COLUMN_ID_JOUEUR = "id_joueur";
	public static final String COLUMN_PSEUDO	="pseudo_joueur";
	public static final String COLUMN_DATE_NAISSANCE = "date_naissance";
	public static final String COLUMN_DATE_CREATION = "date_creation";
	public static final String COLUMN_DUREE_SURVIE = "duree_survie";
	public static final String COLUMN_SEXE_JOUEUR = "sexe_joueur";
	public static final String COLUMN_SOMME_ARGENT = "somme_argent";
	public static final String COLUMN_LVL_CONTAMINATION = "lvl_contamination";
	public static final String COLUMN_LVL_ALIMENTATION = "lvl_alimentation";
	

	
	public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "+TAB_JOUEUR+" ( "
			+COLUMN_ID_JOUEUR+" INTEGER PRIMARY KEY AUTOINCREMENT," +
			COLUMN_PSEUDO+" TEXT (20)," +
			COLUMN_DATE_NAISSANCE+" TEXT (20)," +
			COLUMN_DATE_CREATION+" TEXT (20)," +
			COLUMN_DUREE_SURVIE+" TEXT (20)," +
			COLUMN_SOMME_ARGENT+" TEXT (100)," +
			COLUMN_LVL_CONTAMINATION+" int (2)," +
			COLUMN_LVL_ALIMENTATION+" int (2)" +
			");";
			
	
	
	
	
}
