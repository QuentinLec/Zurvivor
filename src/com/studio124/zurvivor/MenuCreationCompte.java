package com.studio124.zurvivor;

import java.text.SimpleDateFormat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.studio124.zurvivor.bdd.dataSource.dataSource;

public class MenuCreationCompte extends ActionBarActivity {
	
	private dataSource dataSource;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_creation_compte);
		String test = "test!!!!!!!!!!!!!!!"; 
		String test2 = "test2";
		dataSource = new dataSource(this);
		dataSource.open();
		
		final TextView menuCreationCompteBoutonCréer = (TextView) findViewById(R.id.menu_creation_compte_bouton_creer);
	    
		final EditText loginEdit = (EditText) findViewById(R.id.menu_creation_compte_editText_pseudo);
	    final EditText dateDeNaissanceEdit = (EditText) findViewById(R.id.menu_creation_compte_editText_dateDeNaissance);
	    final EditText paysEdit = (EditText) findViewById(R.id.menu_creation_compte_editText_pays);
	    final EditText mailEdit = (EditText) findViewById(R.id.menu_creation_compte_editText_mail);
	    final EditText passwordEdit = (EditText) findViewById(R.id.menu_creation_compte_editText_motDePasse);
	    final EditText confirmationEdit = (EditText) findViewById(R.id.menu_creation_compte_editText_confirmation);
	    
		menuCreationCompteBoutonCréer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (loginEdit.getText().toString().matches("[ ]*")) {
					
				}
				
				
				try {
					dataSource.createUser(loginEdit.getText().toString(),
						passwordEdit.getText().toString(),
						confirmationEdit.getText().toString(),
						loginEdit.getText().toString(),
						loginEdit.getText().toString(),
						paysEdit.getText().toString(),
						paysEdit.getText().toString(),
						dateDeNaissanceEdit.getText().toString(),
						mailEdit.getText().toString());
				}
				catch (Exception e) {
					Log.e("Test", ""+e.getMessage());
				}
				
				Intent intent = new Intent(MenuCreationCompte.this, MenuAccueil.class);
				startActivity(intent);
			}
		});
	}
}