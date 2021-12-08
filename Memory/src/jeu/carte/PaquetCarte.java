package jeu.carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaquetCarte {
	private List<Carte> cartes = new ArrayList<Carte>();
	
	public PaquetCarte(int N) {
		super();
		for (int i=1;i<=N;i++) {
			cartes.add(new Carte(i));
			cartes.add(new Carte(i));
		}
	}
	
	public void melanger() {
		Collections.shuffle(this.cartes);
	}

	public int size() {
		return this.cartes.size();
	}
	
	public void add(Carte c1) {
		this.cartes.add(0,c1);
	}
	
	public void addVide(Carte c1,int Index) {
		this.cartes.add(Index,c1);
	}
	
	public void remove(int i) {
		this.cartes.remove(i);
	}
	
	public void addVide(int i) {
	}

	public Carte getCartes(int i) {
		return cartes.get(i);
	}

	public String toString() {
		String Ret="\n";
		String $i;
		for (int i = 0; i <= this.size()-1; i++) {
			if (i<10) {
				$i="0"+String.valueOf(i);
			}else {
				$i=String.valueOf(i);
			}
			if (i%(5)!=4) {
				Ret=Ret + $i + this.cartes.get(i)+" ";
			}else{
				Ret=Ret+ $i + this.cartes.get(i)+"\n";
			}
		}
		return Ret;
	}
	
}
