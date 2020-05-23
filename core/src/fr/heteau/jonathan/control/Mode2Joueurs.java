package fr.heteau.jonathan.control;

import fr.heteau.jonathan.actor.World;
import fr.heteau.jonathan.control.NesPadControler.Commande;

public class Mode2Joueurs implements IMode , INesPadListener {

	
	private float timeleft;
	private float time = 0.01f;
	
	World mWorld ;
	NesPadControler J1 ;
	NesPadControler J2 ;
	NesPadOeil Oeil1 ;
	NesPadOeil Oeil2 ; 
	boolean gameMenu = true;
	

	public Mode2Joueurs(World world, Commande com1 , Commande com2 ) {
		
		mWorld = world;
		Oeil1 = new NesPadOeil(mWorld.WorldBleu.oeil);
		Oeil2 = new NesPadOeil(mWorld.WorldRouge.oeil);
		J1 = new NesPadControler(com1 , this);
		J2 = new NesPadControler(com2, this);
		
	}
	public void act( float delta) {
		
		timeleft += delta;
		
		if( timeleft > time ){
			timeleft = 0;
			J1.play();
			J2.play();
		}
		
		
	}
	@Override
	public void debut(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.debut(controler);
		}else{
			Oeil2.debut(controler);
		}
	}

	@Override
	public void fin(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.fin(controler);
		}else{
			Oeil2.fin(controler);
		}
	}

	@Override
	public void haut(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.haut(controler);
		}else{
			Oeil2.haut(controler);
		}
	}

	@Override
	public void bas(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.bas(controler);
		}else{
			Oeil2.bas(controler);
		}
	}

	@Override
	public void droit(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.droit(controler);
		}else{
			Oeil2.droit(controler);
		}
	}

	@Override
	public void gauche(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.gauche(controler);
		}else{
			Oeil2.gauche(controler);
		}
	}

	@Override
	public void select(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.select(controler);
		}else{
			Oeil2.select(controler);
		}
	}

	@Override
	public void start(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.start(controler);
		}else{
			Oeil2.start(controler);
		}
	}

	@Override
	public void A(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.A(controler);
		}else{
			Oeil2.A(controler);
		}
	}

	@Override
	public void B(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.B(controler);
		}else{
			Oeil2.B(controler);
		}
	}

	@Override
	public void ClickStart(NesPadControler controler) {
		// TODO Auto-generated method stub
		mWorld.restart();
	}

	@Override
	public void ClickSelect(NesPadControler controler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ClickBas(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.ClickBas(controler);
		}else{
			Oeil2.ClickBas(controler);
		}
	}

	@Override
	public void ClickGauche(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.ClickGauche(controler);
		}else{
			Oeil2.ClickGauche(controler);
		}
	}

	@Override
	public void ClickDroit(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.ClickDroit(controler);
		}else{
			Oeil2.ClickDroit(controler);
		}
	}

	@Override
	public void ClickHaut(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.ClickHaut(controler);
		}else{
			Oeil2.ClickHaut(controler);
		}
	}

	@Override
	public void ClickB(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.ClickB(controler);
		}else{
			Oeil2.ClickB(controler);
		}
	}

	@Override
	public void ClickA(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( controler == J1){
			Oeil1.ClickA(controler);
		}else{
			Oeil2.ClickA(controler);
		}
	}

	

	
	
	
	
	
}
