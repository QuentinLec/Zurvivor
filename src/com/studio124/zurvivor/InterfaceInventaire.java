package com.studio124.zurvivor;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InterfaceInventaire extends ActionBarActivity {
	
	String choix = null,
			titre = null,
			descriptif = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interface_inventaire);
		
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
}