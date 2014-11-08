package com.studio124.zurvivor.bdd.modele;

public class Inventaire {
	 Arme armePrincipale, armeSecondaire;
	 Accessoire accesoire1, accessoire2; 
	 Armure armureTete, armureCorps, armureJambe ;
	public Arme getArmePrincipale() {
		return armePrincipale;
	}
	public void setArmePrincipale(Arme armePrincipale) {
		this.armePrincipale = armePrincipale;
	}
	public Arme getArmeSecondaire() {
		return armeSecondaire;
	}
	public void setArmeSecondaire(Arme armeSecondaire) {
		this.armeSecondaire = armeSecondaire;
	}
	public Accessoire getAccesoire1() {
		return accesoire1;
	}
	public void setAccesoire1(Accessoire accesoire1) {
		this.accesoire1 = accesoire1;
	}
	public Accessoire getAccessoire2() {
		return accessoire2;
	}
	public void setAccessoire2(Accessoire accessoire2) {
		this.accessoire2 = accessoire2;
	}
	public Armure getArmureTete() {
		return armureTete;
	}
	public void setArmureTete(Armure armureTete) {
		this.armureTete = armureTete;
	}
	public Armure getArmureCorps() {
		return armureCorps;
	}
	public void setArmureCorps(Armure armureCorps) {
		this.armureCorps = armureCorps;
	}
	public Armure getArmureJambe() {
		return armureJambe;
	}
	public void setArmureJambe(Armure armureJambe) {
		this.armureJambe = armureJambe;
	}
	@Override
	public String toString() {
		return "Inventaire [armePrincipale=" + armePrincipale
				+ ", armeSecondaire=" + armeSecondaire + ", accesoire1="
				+ accesoire1 + ", accessoire2=" + accessoire2 + ", armureTete="
				+ armureTete + ", armureCorps=" + armureCorps
				+ ", armureJambe=" + armureJambe + "]";
	}
	 
	 

}
