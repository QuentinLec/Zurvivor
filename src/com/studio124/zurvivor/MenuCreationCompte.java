package com.studio124.zurvivor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.studio124.zurvivor.bdd.dataSource.dataSource;

public class MenuCreationCompte extends ActionBarActivity {
	
	private dataSource dataSource;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_creation_compte);
		
		// Création et ouverture de la BDD
		dataSource = new dataSource(this);
		dataSource.open();		
		
		// Récupération des éléments de la page
		final TextView menuCreationCompteBoutonCréer = (TextView) findViewById(R.id.menu_creation_compte_bouton_creer);
	    
		final EditText loginEdit = (EditText) findViewById(R.id.menu_creation_compte_editText_pseudo);
	    final EditText paysEdit = (EditText) findViewById(R.id.menu_creation_compte_editText_pays);
	    final EditText mailEdit = (EditText) findViewById(R.id.menu_creation_compte_editText_mail);
	    final EditText passwordEdit = (EditText) findViewById(R.id.menu_creation_compte_editText_motDePasse);
	    final EditText confirmationEdit = (EditText) findViewById(R.id.menu_creation_compte_editText_confirmation);

	    final Spinner jourSpinner = (Spinner) findViewById(R.id.menu_creation_compte_liste_jour);
	    final Spinner moisSpinner = (Spinner) findViewById(R.id.menu_creation_compte_liste_mois);
	    final Spinner anneeSpinner = (Spinner) findViewById(R.id.menu_creation_compte_liste_annee);
	    
	    // Gestion de la date de naissance :
	    	// Liste du jour
	    List<String> listeJour = new ArrayList<String>();
	    
	    for (int i = 1; i <= 31; i++) {
	    	listeJour.add(Integer.toString(i));
	    }
	    
	    ArrayAdapter<String> adapterJour = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listeJour);
	    adapterJour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    jourSpinner.setAdapter(adapterJour);
	    
	    	// Liste du jour	    
	    List<String> listeMois = new ArrayList<String>();
	    
	    for (int i = 1; i <= 12; i++) {
	    	listeMois.add(Integer.toString(i));
	    }
	    
	    ArrayAdapter<String> adapterMois = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listeMois);
	    adapterMois.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    moisSpinner.setAdapter(adapterMois);
	    
	    	// Liste de l'année
	    List<String> listeAnnee = new ArrayList<String>();
	    
	    Calendar c = Calendar.getInstance();
	    int year = c.get(Calendar.YEAR);
	    
	    for (int i = year; i >= (year - 100); i--) {
	    	listeAnnee.add(Integer.toString(i));
	    }
	    
	    ArrayAdapter<String> adapterAnnee = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listeAnnee);
	    adapterAnnee.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    anneeSpinner.setAdapter(adapterAnnee);
	    
	    // Quand on clique sur le bouton "Créer"
		menuCreationCompteBoutonCréer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// Vérifie si un des champs est vide
				if ( verifChampsVide(loginEdit)
						|| verifChampsVide(paysEdit) || verifChampsVide(mailEdit)
						|| verifChampsVide(passwordEdit) || verifChampsVide(confirmationEdit) ) {
					
					Toast.makeText(MenuCreationCompte.this, "Veuillez renseigner tous les champs svp !", Toast.LENGTH_SHORT).show();
				}
				else {
					// Vérifie si certains champs contiennent un espace
					if ( verifEspace(loginEdit) || verifEspace(mailEdit) || verifEspace(passwordEdit) ) {
						
						Toast.makeText(MenuCreationCompte.this, "Attention, ne pas mettre d'espace dans le pseudo, le mail et le mot de passe svp.", Toast.LENGTH_LONG).show();
						passwordEdit.setText("");
						confirmationEdit.setText("");
					}
					else {
						// Vérifie si le mot de passe correspond à la confirmation
						if (passwordEdit.getText().toString().equals(confirmationEdit.getText().toString())) {
						
							// Mets la date dans un String
						    final String dateDeNaissance = jourSpinner.getSelectedItem().toString() + "/" 
						    				+ moisSpinner.getSelectedItem().toString() + "/" 
						    				+ anneeSpinner.getSelectedItem().toString();
							
							try {
								// Crée le user dans la BDD
								dataSource.createUser(loginEdit.getText().toString(),
									passwordEdit.getText().toString(),
									paysEdit.getText().toString(),
									dateDeNaissance,
									mailEdit.getText().toString());
								
								Toast.makeText(MenuCreationCompte.this, "Inscription Réussie", Toast.LENGTH_LONG).show();
								
								// Ferme la BDD
								dataSource.close();
								
								// Renvoie sur la page d'identification
								Intent intent = new Intent(MenuCreationCompte.this, MenuIdentification.class);
								startActivity(intent);
							}
							catch (Exception e) {
								Log.e("Test", ""+e.getMessage());
							}
						}
						else {
							Toast.makeText(MenuCreationCompte.this, "Les mots de passes ne correspondent pas.", Toast.LENGTH_LONG).show();
							passwordEdit.setText("");
							confirmationEdit.setText("");
						}
					}
				}
			}
		});
	}
	
	// Vérifie si le champs est vide
	private boolean verifChampsVide(EditText edit) {
		
		boolean champs = true;
		
		if (edit.getText().toString().trim().equals("")) {
			champs = true;
		}
		else {
			champs = false;
		}
		
		return champs;
	}
	
	// Vérifie si le champs contient un espace
	private boolean verifEspace(EditText edit) {
		
		boolean espace = false;
		
		if (edit.getText().toString().contains(" ") || edit.getText().toString().contains("	")) {
			espace = true;
		}
		else {
			espace = false;
		}
		
		return espace;
	}
}