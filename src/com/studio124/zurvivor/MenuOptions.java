package com.studio124.zurvivor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuOptions extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_options);
		
		final Button menuOptionsBoutonRetour = (Button) findViewById(R.id.retour);
		
		menuOptionsBoutonRetour.setOnClickListener(optionsRetourListener);
	}
	
	// Bouton Jouer du menu d'accueil
	private OnClickListener optionsRetourListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent(MenuOptions.this, MenuAccueil.class);
			startActivity(intent);
		}
	};
}