package com.studio124.zurvivor.interfaces;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.studio124.zurvivor.R;

public class InterfaceInventaire extends ActionBarActivity {

	private String choix = null,
			titre = null,
			descriptif = null;
	
	private DrawerLayout drawerLayout;
	
    private ActionBarDrawerToggle drawerToggle;
    
	private Intent intent = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interface_inventaire);

		initBoutonsMenuGauche();
		initMenuGauche(R.id.menu_gauche);
		
		final Button imageArmePrincipale = (Button) findViewById(R.id.image_inventaire_arme_principale);
		final Button imageArmeSecondaire = (Button) findViewById(R.id.image_inventaire_arme_secondaire);
		final Button imageObjet1 = (Button) findViewById(R.id.image_inventaire_objet1);
		final Button imageObjet2 = (Button) findViewById(R.id.image_inventaire_objet2);
		
		imageArmePrincipale.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				choix = "Arme principale";
				
				FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		        // Create and show the dialog.
		        SomeDialog newFragment = new SomeDialog ();
		        newFragment.show(ft, "dialog");
			}
		});
		
		imageArmeSecondaire.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				choix = "Arme secondaire";
				
				FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		        // Create and show the dialog.
		        SomeDialog newFragment = new SomeDialog ();
		        newFragment.show(ft, "dialog");
			}
		});
		
		imageObjet1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				choix = "Objet 1";
				
				FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		        // Create and show the dialog.
		        SomeDialog newFragment = new SomeDialog ();
		        newFragment.show(ft, "dialog");
			}
		});
		
		imageObjet2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				choix = "Objet 2";
				
				FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		        // Create and show the dialog.
		        SomeDialog newFragment = new SomeDialog ();
		        newFragment.show(ft, "dialog");
			}
		});
	}
	
	public class SomeDialog extends DialogFragment {

	    @Override
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	    	
	    	switch (choix) {
	    	case "Arme principale" :
	    		titre = choix;
	    		descriptif = "Descriptif de l'" + choix; break;
	    	case "Arme secondaire" :
	    		titre = choix;
	    		descriptif = "Descriptif de l'" + choix; break;
	    	case "Objet 1" :
	    		titre = choix;
	    		descriptif = "Descriptif de l'" + choix; break;
	    	case "Objet 2" :
	    		titre = choix;
	    		descriptif = "Descriptif de l'" + choix; break;
	    	}
	    
	        return new AlertDialog.Builder(getActivity())
	            .setTitle(titre)
	            .setMessage(descriptif)
	            .setNeutralButton("Retour", new DialogInterface.OnClickListener() {
	            	
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						
					}
				}).create();
				/*.setPositiveButton("Ja",  new DialogInterface.OnClickListener() {
	            	
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						Toast.makeText(MenuQuitter.this, "Tu rêves", 5).show();
					}
				}).create();*/
	    }
	}
	
	private void initBoutonsMenuGauche() {
		
		/* Bouton Profil */
		final Button boutonProfil = (Button) findViewById(R.id.menu_gauche_bouton_profil);
		
		boutonProfil.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceInventaire.this, InterfaceProfil.class);
				startActivity(intent);
			}
		});
		
		/* Bouton Carte */
		final Button boutonCarte = (Button) findViewById(R.id.menu_gauche_bouton_carte);
		
		boutonCarte.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceInventaire.this, InterfaceCarte.class);
				startActivity(intent);
			}
		});

		/* Bouton Chat */
		final Button boutonChat = (Button) findViewById(R.id.menu_gauche_bouton_chat);
		
		boutonChat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceInventaire.this, InterfaceChat.class);
				startActivity(intent);
			}
		});
		
		/* Bouton Options */
		final Button boutonOptions = (Button) findViewById(R.id.menu_gauche_bouton_options);
		
		boutonOptions.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(InterfaceInventaire.this, InterfaceOptions.class);
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
}