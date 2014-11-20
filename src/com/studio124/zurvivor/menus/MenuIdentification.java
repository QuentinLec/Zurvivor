package com.studio124.zurvivor.menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.studio124.zurvivor.R;

public class MenuIdentification extends ActionBarActivity {
		
	final String loginEdit = "user_login";
	final String passwordEdit = "user_password";
	
	private Intent intent = null;
	
	private DrawerLayout drawerLayout;
	
    private ActionBarDrawerToggle drawerToggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_identification);

		final Button menuIdentificationBoutonJouer = (Button) findViewById(R.id.menu_identification_bouton_jouer);
		final TextView menuIdentificationBoutonCréer = (TextView) findViewById(R.id.menu_identification_bouton_creer);
		
		final EditText menuIdentifiantEditTextLogin = (EditText) findViewById(R.id.menu_identifictaion_editText_identification);
		final EditText menuIdentifiantEditTextPassword = (EditText) findViewById(R.id.menu_identification_editText_motDePasse);
		
		intent = getIntent();
		
		if (intent != null) {
			menuIdentifiantEditTextLogin.setText(intent.getStringExtra(loginEdit));
			menuIdentifiantEditTextPassword.setText(intent.getStringExtra(passwordEdit));
	    }
		
		menuIdentificationBoutonJouer.setOnClickListener(identificationJouerListener);
		menuIdentificationBoutonCréer.setOnClickListener(identificationCreerListener);
	}
	
	// Bouton Jouer du menu d'identification
	private OnClickListener identificationJouerListener = new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
				
			Intent intent = new Intent(MenuIdentification.this, MenuAccueil.class);
			startActivity(intent);
		}
	};
		
	// Bouton Créer du menu d'identification
	private OnClickListener identificationCreerListener = new View.OnClickListener() {
				
		@Override
		public void onClick(View v) {
					
			intent = new Intent(com.studio124.zurvivor.menus.MenuIdentification.this, com.studio124.zurvivor.menus.MenuCreationCompte.class);
			startActivity(intent);
		}
	};
}