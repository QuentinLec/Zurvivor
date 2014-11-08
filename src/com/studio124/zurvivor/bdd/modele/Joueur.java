package com.studio124.zurvivor.bdd.modele;

public class Joueur {
	int idJoueur, sommeArgent, niveauContaminationJoueur, niveauAlimentationJoueur;
	String PseudoJoueur,  dateNaissanceJoueur, dateCreationJoueur, dureeSurvieJoueur, sexeJoueur;
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public int getSommeArgent() {
		return sommeArgent;
	}
	public void setSommeArgent(int sommeArgent) {
		this.sommeArgent = sommeArgent;
	}
	public int getNiveauContaminationJoueur() {
		return niveauContaminationJoueur;
	}
	public void setNiveauContaminationJoueur(int niveauContaminationJoueur) {
		this.niveauContaminationJoueur = niveauContaminationJoueur;
	}
	public int getNiveauAlimentationJoueur() {
		return niveauAlimentationJoueur;
	}
	public void setNiveauAlimentationJoueur(int niveauAlimentationJoueur) {
		this.niveauAlimentationJoueur = niveauAlimentationJoueur;
	}
	public String getPseudoJoueur() {
		return PseudoJoueur;
	}
	public void setPseudoJoueur(String pseudoJoueur) {
		PseudoJoueur = pseudoJoueur;
	}
	public String getDateNaissanceJoueur() {
		return dateNaissanceJoueur;
	}
	public void setDateNaissanceJoueur(String dateNaissanceJoueur) {
		this.dateNaissanceJoueur = dateNaissanceJoueur;
	}
	public String getDateCreationJoueur() {
		return dateCreationJoueur;
	}
	public void setDateCreationJoueur(String dateCreationJoueur) {
		this.dateCreationJoueur = dateCreationJoueur;
	}
	public String getDureeSurvieJoueur() {
		return dureeSurvieJoueur;
	}
	public void setDureeSurvieJoueur(String dureeSurvieJoueur) {
		this.dureeSurvieJoueur = dureeSurvieJoueur;
	}
	public String getSexeJoueur() {
		return sexeJoueur;
	}
	public void setSexeJoueur(String sexeJoueur) {
		this.sexeJoueur = sexeJoueur;
	}
	@Override
	public String toString() {
		return "Joueur [idJoueur=" + idJoueur + ", sommeArgent=" + sommeArgent
				+ ", niveauContaminationJoueur=" + niveauContaminationJoueur
				+ ", niveauAlimentationJoueur=" + niveauAlimentationJoueur
				+ ", PseudoJoueur=" + PseudoJoueur + ", dateNaissanceJoueur="
				+ dateNaissanceJoueur + ", dateCreationJoueur="
				+ dateCreationJoueur + ", dureeSurvieJoueur="
				+ dureeSurvieJoueur + ", sexeJoueur=" + sexeJoueur + "]";
	}
	
	
}
