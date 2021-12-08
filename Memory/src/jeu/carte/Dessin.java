package jeu.carte;


public enum Dessin {
	STATUE("Glob"),VELO("Velo"),TASSE("Tass"),MINE("Mine"),AVION("Plan"),TOUR("Tour"),LION("Lion"),LIT("Lits"),BAGUE("Bagg"),FOUE("fouè"),CHAT("cats"),CHIEN("dogs"),OURS("ours"),MAISON("home"), ARBRE("tree"), FANION("drap"), ETOILE("star"), BALLON("ball"), LAPIN("rabi"), CARRE("sqrt"), DOS("****"), VIDE("    ");
	
	private static final Dessin[] LES_DESSINS=Dessin.values();
	public static final int NBR_DESSIN=LES_DESSINS.length;
	private String texte;
		
	private Dessin (String string) {
		this.texte=string;
	}
		
	public String toString() {
		return this.texte;
	}
	
	public static Dessin get(int i) {
		return LES_DESSINS[i-1];
	}


}
