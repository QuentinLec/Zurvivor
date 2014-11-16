package com.studio124.zurvivor.interfaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.studio124.zurvivor.R;
import com.studio124.zurvivor.menus.MenuCreationCompte;

public class InterfaceCarte extends ActionBarActivity {
	
	private DrawerLayout drawerLayout;
	
    private ActionBarDrawerToggle drawerToggle;
    
	private Intent intent = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interface_carte);
		
		initBoutonsMenuGauche();
		initMenuGauche(R.id.menu_gauche);
	}
	
	private void initBoutonsMenuGauche() {
		
		/* Bouton Profil */
		final Button boutonProfil = (Button) findViewById(R.id.menu_gauche_bouton_profil);
		
		boutonProfil.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceCarte.this, InterfaceProfil.class);
				startActivity(intent);
			}
		});
		
		/* Bouton Inventaire */
		final Button boutonInventaire = (Button) findViewById(R.id.menu_gauche_bouton_inventaire);
		
		boutonInventaire.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceCarte.this, InterfaceInventaire.class);
				startActivity(intent);
			}
		});

		/* Bouton Chat */
		final Button boutonChat = (Button) findViewById(R.id.menu_gauche_bouton_chat);
		
		boutonChat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceCarte.this, InterfaceChat.class);
				startActivity(intent);
			}
		});
		
		/* Bouton Options */
		final Button boutonOptions = (Button) findViewById(R.id.menu_gauche_bouton_options);
		
		boutonOptions.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceCarte.this, InterfaceOptions.class);
				startActivity(intent);
			}
		});
	}
	
	private void initMenuGauche(int id) {
		
		drawerLayout = (DrawerLayout) findViewById(id);
        
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

        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {
               
        if (keyCode == KeyEvent.KEYCODE_BACK) {
        	Toast.makeText(InterfaceCarte.this, "Quitter l'appli.", Toast.LENGTH_LONG).show();
        }
           return false;
    }
}
