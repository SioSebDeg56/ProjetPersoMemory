package jeu.carte;


public class Carte {
	public Dessin dos;
	public Dessin face;
	public boolean visible;
	
	
	public Carte(int face) {
		super();
		this.face=Dessin.get(face);
		this.dos=Dessin.DOS;
		this.visible=false;
	}
	
	public Carte() {
		super();
		this.face=Dessin.VIDE;
		this.dos=Dessin.VIDE;
		this.visible=true;
	}

	public Dessin getDos() {
		return dos;
	}

	public Dessin getFace() {
		return face;
	}

	public boolean isVisible() {
		return this.visible;
	}
	
	public void retourner() {
		this.visible=!this.visible;
	}
	
	public boolean isCompatible(Carte c2) {
		Dessin D1=this.face;
//		System.out.println(D1);
		Dessin D2=c2.face;
//		System.out.println(D2);
		return this.face==c2.face & this.face!=Dessin.VIDE & c2.face!=Dessin.VIDE;
	}

	public String toString() {
		if (this.isVisible() ==true){
			return "[" + face + "]";
		}else {
			return "[" + dos + "]";
		}
	}
	

}
