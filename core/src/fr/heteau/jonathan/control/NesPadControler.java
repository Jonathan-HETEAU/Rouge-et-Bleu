package fr.heteau.jonathan.control;

import com.badlogic.gdx.Gdx;


public class NesPadControler {
	
	Commande commande ;
	INesPadListener listener ;
	
	
	boolean select = false;
	boolean start = false;
	boolean droit = false;
	boolean gauche = false;
	boolean haut = false;
	boolean bas = false;
	boolean a = false;
	boolean b = false;
	
	public static class Commande{
		public int Droit ;
		public int Gauche ;
		public int Haut ;
		public int Bas ;
		public int A ;
		public int B;
		public int Start ;
		public int Select ;
		
		public Commande(int droit, int gauche, int haut, int bas, int A,
				int B, int start, int select) {
			super();
			this.Droit = droit;
			this.Gauche = gauche;
			this.Haut = haut;
			this.Bas = bas;
			this.A = A;
			this.B = B;
			this.Start = start;
			this.Select = select;
		}
		
		
	}
	
	public NesPadControler(Commande commande , INesPadListener listener) {
		this.commande = commande;
		this.listener = listener ;
	}
			
	
	public void  play(){
		listener.debut(this);
		if( Gdx.input.isKeyPressed(commande.A) ){
			listener.A(this);
			a= true;
		}else{
			if( a ){
				listener.ClickA(this);
			}
			a= false;
		}
		if( Gdx.input.isKeyPressed(commande.B) ){
			listener.B(this);
			b= true;
		}else{
			if( b ){
				listener.ClickB(this);
			}
			b= false;
		}
		if(  Gdx.input.isKeyPressed(commande.Haut) ){
			listener.haut(this);
			haut= true;
		}else{
			if( haut ){
				listener.ClickHaut(this);
			}
			haut= false;
		}
		if(  Gdx.input.isKeyPressed(commande.Droit) ){
			listener.droit(this);
			droit= true;
		}else{
			if( droit ){
				listener.ClickDroit(this);
			}
			droit= false;
		}
		if(  Gdx.input.isKeyPressed(commande.Gauche) ){
			listener.gauche(this);
			gauche= true;
		}else{
			if( gauche ){
				listener.ClickGauche(this);
			}
			gauche= false;
		}
		if(  Gdx.input.isKeyPressed(commande.Bas) ){
			listener.bas(this);
			bas= true;
		}else{
			if( bas ){
				listener.ClickBas(this);
			}
			bas= false;
		}
		if(  Gdx.input.isKeyPressed(commande.Select) ){
			listener.select(this);
			select = true;
		}
		else
		{
			if( select )
				listener.ClickSelect(this);
			select = false;
		}
		if(  Gdx.input.isKeyPressed(commande.Start) ){
			listener.start(this);
			start = true;
		}
		else
		{
			if( start )
				listener.ClickStart(this);	
			start = false;
		}
		listener.fin(this);	
	}

}
