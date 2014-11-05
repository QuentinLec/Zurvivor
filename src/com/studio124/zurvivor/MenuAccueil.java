package com.studio124.zurvivor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MenuAccueil extends ActionBarActivity {
	
	private Intent intent = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_accueil);
		
		final Button menuAccueilBoutonJouer = (Button) findViewById(R.id.menu_accueil_bouton_jouer);
		final Button menuAccueilBoutonOptions = (Button) findViewById(R.id.menu_accueil_bouton_options);
		final Button menuAccueilBoutonDeconnexion = (Button) findViewById(R.id.menu_accueil_bouton_deconnexion);
		
		menuAccueilBoutonJouer.setOnClickListener(accueilJouerListener);
		menuAccueilBoutonOptions.setOnClickListener(accueilOptionsListener);
		menuAccueilBoutonDeconnexion.setOnClickListener(accueilDeconnexionListener);
	}

	// Bouton Jouer du menu d'accueil
	private OnClickListener accueilJouerListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			intent = new Intent(MenuAccueil.this, MenuAccueil.class);
			startActivity(intent);
		}
	};
	
	// Bouton Options du menu d'accueil
	private OnClickListener accueilOptionsListener = new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
				
			intent = new Intent(MenuAccueil.this, MenuOptions.class);
			startActivity(intent);
		}
	};
	
	// Bouton Déconnexion du menu d'accueil
	private OnClickListener accueilDeconnexionListener = new View.OnClickListener() {
					
		@Override
		public void onClick(View v) {
				
			intent = new Intent(MenuAccueil.this, MenuIdentification.class);
			startActivity(intent);
			Toast.makeText(MenuAccueil.this, "Vous êtes déconnecté", Toast.LENGTH_SHORT).show();
		}
	};
}
