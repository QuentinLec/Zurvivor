package com.studio124.zurvivor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
		
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        
        // On crée une instance de la classe prenant pour paramètres :
        // 1. l'activité
        // 2. le drawer layout
        // 3. la ressource graphique
        // 4 et 5. des ressources textuelles permettant d'indiquer l'état du drawer.
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.hello_world, R.string.zurvivor);

        // On définit notre ActionBarDrawerToggle comme listener.
        drawerLayout.setDrawerListener(drawerToggle);

        // On précise que l'on souhaite afficher la ressource graphique
        drawerToggle.setDrawerIndicatorEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // On synchronise.
        drawerToggle.syncState();
        
        
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
	
	// ActionBar
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if(android.R.id.home == item.getItemId()) {
            if (drawerLayout.isDrawerOpen(Gravity.LEFT) == false) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
            else {
                drawerLayout.closeDrawers();
            }
        }
        else if(R.id.refresh == item.getItemId()) {
            MenuItemCompat.setActionView(item, R.layout.progress_bar);
        }

        return super.onOptionsItemSelected(item);
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
					
			intent = new Intent(MenuIdentification.this, MenuCreationCompte.class);
			startActivity(intent);
		}
	};
}