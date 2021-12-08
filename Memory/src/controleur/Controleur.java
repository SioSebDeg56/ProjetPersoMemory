package controleur;

import java.util.ArrayList;
import java.util.List;
import ihm.IOKeyBoardConsole;
import jeu.Joueur;
import jeu.carte.Carte;
import jeu.carte.PaquetCarte;

public class Controleur {
	private static final int NbrJoueur=2;
	private List<Joueur> joueurs = new ArrayList<Joueur>();
	private static PaquetCarte table=new PaquetCarte(nbrPaires());
	
	public Controleur() {
		super();
		table.melanger();
		for (int j = 1; j <= NbrJoueur; j++) {
			String nomJoueur="Joueur"+String.valueOf(j);
			joueurs.add(new Joueur(nomJoueur));
		}
		this.Jouer();
	}
	
	public void Jouer() {
		int TourJ=0;
		int resteTable=table.size();
		Joueur Gamer = this.getJoueurs(TourJ);
		Gamer.setActif();
		IOKeyBoardConsole.print(this);
		
		while (resteTable!=0) {
			int Pair1 = IOKeyBoardConsole.readANumber("N° Carte1 :");
			Carte C1=this.getCarte(Pair1);
			C1.retourner();
			int Pair2 = IOKeyBoardConsole.readANumber("N° Carte2 :");
			Carte C2=this.getCarte(Pair2);
			C2.retourner();
			IOKeyBoardConsole.print(this);
			IOKeyBoardConsole.pressEnter();
			if(C1.isCompatible(C2)==true) {
				Gamer.addCarte(C1);
				Gamer.addCarte(C2);
				Carte cVide1=new Carte();
				Carte cVide2=new Carte();
				table.remove(Pair1);
				table.addVide(cVide1,Pair1);
				table.remove(Pair2);
				table.addVide(cVide2,Pair2);
				resteTable=resteTable-2;
			}else {
				TourJ=(TourJ+1)%joueurs.size();;
				Gamer.setInactif();
				Gamer = this.getJoueurs(TourJ);
				Gamer.setActif();
				C1.retourner();
				C2.retourner();
			}
			IOKeyBoardConsole.print(this);
						
			if (resteTable==0){
				Joueur jGagne=this.gagne();
				IOKeyBoardConsole.print(this);
				System.out.println("JOUEUR : "+jGagne+" GAGNE LA PARTIE ! BRAVO");
			}	
		}
	}

	public Joueur joueurCourant() {
		int j = 0;
		for (int i = 0; i < joueurs.size(); i++) {
			boolean JCA=joueurs.get(i).getActif();
			if (JCA==true) {
				j = i;
			}
		}
		return this.getJoueurs(j);
	}
	
	public Joueur getJoueurs(int i) {
		return joueurs.get(i);
	}

	public Carte getCarte(int i) {
		return table.getCartes(i);
	}
	
	public static PaquetCarte getTable() {
		return table;
	}
	
	public Joueur gagne() {
		int Scmax=0;
		Joueur jMax = null;
		for (int i = 0; i<joueurs.size(); i++) {
			if (joueurs.get(i).getScore()>Scmax) {
				Scmax=joueurs.get(i).getScore();
				jMax=joueurs.get(i);
			}
		}
		return jMax;
	}

	public Joueur joueurSuivant(int i) {
		Joueur JS=null;
		return JS;
	}

	public static int sizeTable() {
		return table.size();
	}
	
	public static int nbrPaires() {
		return IOKeyBoardConsole.readANumber("Nombre de Paires : ");
	}
	
	public String toString() {
		return joueurs + "\n" + "JeuxTable=" + getTable();
	}

}
