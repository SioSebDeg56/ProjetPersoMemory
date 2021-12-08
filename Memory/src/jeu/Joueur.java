package jeu;

import java.util.Collections;

import controleur.Controleur;
import jeu.carte.Carte;
import jeu.carte.PaquetCarte;

public class Joueur {
	private String nom;
	private PaquetCarte PJ;
	private boolean actif;
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
		PJ = new PaquetCarte(0);
		actif=false;
	}
	
	public void addCarte(Carte c2){
		PJ.add(c2);
	}
	public int getScore() {
		return PJ.size();
	}

	public String getNom() {
		return nom;
	}
	
	public boolean getActif() {
		return actif;
	}
	
	public void setActif() {
			this.actif=true;
	}
	
	public void setInactif() {
		this.actif=false;
	}

	public PaquetCarte getPJ() {
		return PJ;
	}
	
	public boolean gagne() {
		return this.getScore()>Controleur.sizeTable();
	}

	public String toString() {
		return "nom=" + nom +", Joue =" + actif + ", Score=" + getScore()+ "\n"+"PJ=" + PJ;
	}
}
