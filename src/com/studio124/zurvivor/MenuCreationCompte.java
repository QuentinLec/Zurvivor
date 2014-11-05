package com.studio124.zurvivor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MenuCreationCompte extends ActionBarActivity {
	
	final String loginString = "user_login";
	final String dateDeNaissanceString = "user_birthday";
	final String paysString = "user_country";
	final String mailString = "user_mail";
	final String passwordString = "user_password";
	final String confirmationString = "user_confirmation";
    
    private Intent intent = null;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_creation_compte);
		
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
				
				intent = null;
				
				String password = passwordEdit.getText().toString(),
						confirmation = confirmationEdit.getText().toString();
				
				
				if (password.equals(confirmation)) {
					intent = new Intent(MenuCreationCompte.this, MenuIdentification.class);
					intent.putExtra(loginString, loginEdit.getText().toString());
					/*intent.putExtra(dateDeNaissanceString, dateDeNaissanceEdit.getText().toString());
					intent.putExtra(paysString, paysEdit.getText().toString());
					intent.putExtra(mailString, mailEdit.getText().toString());
					intent.putExtra(passwordString, passwordEdit.getText().toString());
					intent.putExtra(confirmationString, confirmationEdit.getText().toString());*/
				}
				else {
					intent = new Intent(MenuCreationCompte.this, MenuCreationCompte.class);
					intent.putExtra(loginString, loginEdit.getText().toString());
					intent.putExtra(dateDeNaissanceString, dateDeNaissanceEdit.getText().toString());
					intent.putExtra(paysString, paysEdit.getText().toString());
					intent.putExtra(mailString, mailEdit.getText().toString());
				}
				
				startActivity(intent);
			}
		});
		
		intent = getIntent();
		
		if (intent != null) {
			loginEdit.setText(intent.getStringExtra(loginString));
			dateDeNaissanceEdit.setText(intent.getStringExtra(dateDeNaissanceString));
			paysEdit.setText(intent.getStringExtra(paysString));
			mailEdit.setText(intent.getStringExtra(mailString));
	    }
	}
}