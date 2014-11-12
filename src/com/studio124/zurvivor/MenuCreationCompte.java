package com.studio124.zurvivor;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.studio124.zurvivor.bdd.dataSource.dataSource;

public class MenuCreationCompte extends ActionBarActivity {
	
	final String loginString = "user_login";
	final String dateDeNaissanceString = "user_birthday";
	final String paysString = "user_country";
	final String mailString = "user_mail";
	final String passwordString = "user_password";
	final String confirmationString = "user_confirmation";
	
	private dataSource dataSource;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_creation_compte);
		
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
			}
		});
	}
}