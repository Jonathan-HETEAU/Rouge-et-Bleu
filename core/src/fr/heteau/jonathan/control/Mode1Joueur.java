package fr.heteau.jonathan.control;




import fr.heteau.jonathan.actor.World;
import fr.heteau.jonathan.control.NesPadControler.Commande;


public class Mode1Joueur implements INesPadListener , IMode{

	private float timeleft;
	private float time = 0.01f;
	
	World mWorld ;
	NesPadControler J1 ;
	NesPadOeil Oeil1 ;
	NesPadOeil Oeil2 ; 
	boolean gameScore = false;
	boolean oeilSelect = true;

	public Mode1Joueur(World world, Commande com1) {
		// TODO Auto-generated constructor stub
		
		mWorld = world; 
		Oeil1 = new NesPadOeil(mWorld.WorldBleu.oeil);
		Oeil2 = new NesPadOeil(mWorld.WorldRouge.oeil);
		J1 = new NesPadControler(com1 , this);
		mWorld.mInterface.setNameJoueur1("Player 1");
		mWorld.mInterface.setNameJoueur2("");
	}

	public void act( float delta) {
		
		timeleft += delta;
		
		if( timeleft > time ){
			timeleft = 0;
			J1.play();
		}
		
		
	}

	@Override
	public void debut(NesPadControler controler) {
		// TODO Auto-generated method stub
		
		if( oeilSelect )
			Oeil1.debut(controler);
		else
			Oeil2.debut(controler);
	}

	@Override
	public void fin(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( oeilSelect )
			Oeil1.fin(controler);
		else
			Oeil2.fin(controler);
	}

	@Override
	public void haut(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( oeilSelect )
			Oeil1.haut(controler);
		else
			Oeil2.haut(controler);
	}

	@Override
	public void bas(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( oeilSelect )
			Oeil1.bas(controler);
		else
			Oeil2.bas(controler);
	}

	@Override
	public void droit(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( oeilSelect )
			Oeil1.droit(controler);
		else
			Oeil2.droit(controler);
	}

	@Override
	public void gauche(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( oeilSelect )
			Oeil1.gauche(controler);
		else
			Oeil2.gauche(controler);
	}

	@Override
	public void select(NesPadControler controler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(NesPadControler controler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void A(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( oeilSelect )
			Oeil1.A(controler);
		else
			Oeil2.A(controler);
	}

	@Override
	public void B(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( oeilSelect )
			Oeil1.B(controler);
		else
			Oeil2.B(controler);
	}

	@Override
	public void ClickStart(NesPadControler controler) {
		// TODO Auto-generated method stub
		mWorld.restart();
	}

	@Override
	public void ClickSelect(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( !oeilSelect ){
			mWorld.mInterface.setNameJoueur1("Player 1");
			mWorld.mInterface.setNameJoueur2("");
		}
		else{
			mWorld.mInterface.setNameJoueur2("Player 1");
			mWorld.mInterface.setNameJoueur1("");
		}
			
		
		oeilSelect = ! oeilSelect;
	}

	@Override
	public void ClickBas(NesPadControler controler) {
		if( oeilSelect )
			Oeil1.ClickBas(controler);
		else
			Oeil2.ClickBas(controler);
	}

	@Override
	public void ClickGauche(NesPadControler controler) {
		if( oeilSelect )
			Oeil1.ClickGauche(controler);
		else
			Oeil2.ClickGauche(controler);
	}

	@Override
	public void ClickDroit(NesPadControler controler) {
		if( oeilSelect )
			Oeil1.ClickDroit(controler);
		else
			Oeil2.ClickDroit(controler);
	}

	@Override
	public void ClickHaut(NesPadControler controler) {
		if( oeilSelect )
			Oeil1.ClickHaut(controler);
		else
			Oeil2.ClickHaut(controler);
	}

	@Override
	public void ClickB(NesPadControler controler) {
		if( oeilSelect )
			Oeil1.ClickB(controler);
		else
			Oeil2.ClickB(controler);
		
	}

	@Override
	public void ClickA(NesPadControler controler) {
		if( oeilSelect )
			Oeil1.ClickA(controler);
		else
			Oeil2.ClickA(controler);
		
	}
	
	
}
