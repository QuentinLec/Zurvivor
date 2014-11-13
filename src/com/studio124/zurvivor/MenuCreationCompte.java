package com.studio124.zurvivor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.studio124.zurvivor.bdd.dataSource.dataSource;

public class MenuCreationCompte extends ActionBarActivity {
	
	private dataSource dataSource;
	
	private Pattern pattern;
	private Matcher matcher;
    
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
				
				verifIsEmpty(loginEdit);
				verifIsEmpty(dateDeNaissanceEdit);
				verifIsEmpty(paysEdit);
				verifIsEmpty(mailEdit);
				verifIsEmpty(passwordEdit);
				verifIsEmpty(confirmationEdit);
				
				if (validate(dateDeNaissanceEdit.getText().toString())) {
					Toast.makeText(MenuCreationCompte.this, "Date ok", Toast.LENGTH_SHORT).show();
				}
				else {
					Toast.makeText(MenuCreationCompte.this, "Date pas ok", Toast.LENGTH_SHORT).show();
				}
				
//				if (!test.isEmpty())
//				{
//					Toast.makeText(MenuCreationCompte.this, "Veuillez saisir un Pseudo !", Toast.LENGTH_SHORT).show();
//				}
				
//				if (test.contains(" ")) {
//					Toast.makeText(MenuCreationCompte.this, "Un espace", Toast.LENGTH_SHORT).show();
//				}
//				else {
//					Toast.makeText(MenuCreationCompte.this, "Pas d'espace", Toast.LENGTH_SHORT).show();
//				}
				
				
//				try {
//					dataSource.createUser(loginEdit.getText().toString(),
//						passwordEdit.getText().toString(),
//						confirmationEdit.getText().toString(),
//						loginEdit.getText().toString(),
//						loginEdit.getText().toString(),
//						paysEdit.getText().toString(),
//						paysEdit.getText().toString(),
//						dateDeNaissanceEdit.getText().toString(),
//						mailEdit.getText().toString());
//				}
//				catch (Exception e) {
//					Log.e("Test", ""+e.getMessage());
//				}
				
//				Intent intent = new Intent(MenuCreationCompte.this, MenuAccueil.class);
//				startActivity(intent);
			}
		});
	}
	
	private boolean verifIsEmpty(EditText edit) {
		
		boolean result = false;
		
		if (edit.getText().toString().trim().equals("")) {
			Toast.makeText(MenuCreationCompte.this, "Veuillez renseigner tous les champs !", Toast.LENGTH_SHORT).show();
			result = false;
		}
		else {
			result = true;
		}
		
		return result;
	}
	
	public boolean validate(final String date){
		 
	     matcher = pattern.matcher(date);
	 
	     if(matcher.matches()){
	 
		 matcher.reset();
	 
		 if(matcher.find()){
	 
	             String day = matcher.group(1);
		     String month = matcher.group(2);
		     int year = Integer.parseInt(matcher.group(3));
	 
		     if (day.equals("31") && 
			  (month.equals("4") || month .equals("6") || month.equals("9") ||
	                  month.equals("11") || month.equals("04") || month .equals("06") ||
	                  month.equals("09"))) {
				return false; // only 1,3,5,7,8,10,12 has 31 days
		     } else if (month.equals("2") || month.equals("02")) {
	                  //leap year
			  if(year % 4==0){
				  if(day.equals("30") || day.equals("31")){
					  return false;
				  }else{
					  return true;
				  }
			  }else{
			         if(day.equals("29")||day.equals("30")||day.equals("31")){
					  return false;
			         }else{
					  return true;
				  }
			  }
		      }else{				 
			return true;				 
		      }
		   }else{
	    	      return false;
		   }		  
	     }else{
		  return false;
	     }			    
	   }
}