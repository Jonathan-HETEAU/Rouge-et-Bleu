package fr.heteau.jonathan.control;

import fr.heteau.jonathan.actor.Oeil;
import fr.heteau.jonathan.actor.Oeil.Etat;
import fr.heteau.jonathan.actor.Oeil.Sens;

public class NesPadOeil implements INesPadListener {

	private Oeil oeil ;
	private boolean action;
	
	
	public NesPadOeil(Oeil oeil ) {
		this.oeil = oeil;
	}
	
	
	@Override
	public void haut(NesPadControler controler) {
		// TODO Auto-generated method stub
		move(Sens.H);
	}

	@Override
	public void bas(NesPadControler controler) {
		// TODO Auto-generated method stub
		move(Sens.B);
	}

	@Override
	public void droit(NesPadControler controler) {
		// TODO Auto-generated method stub
		move(Sens.D);
	}

	@Override
	public void gauche(NesPadControler controler) {
		// TODO Auto-generated method stub
		move(Sens.G);
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
		if( oeil.isSelect()){
			oeil.power();
			oeil.setEtat(Etat.Power);
			action |=true;
			
		}else{
			oeil.select();
			oeil.setEtat(Etat.Wait);
		}
	}

	@Override
	public void B(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( oeil.isSelect()){
			oeil.setEtat(Etat.Balise);
			action |=true;
		}else{
			oeil.select();
			oeil.setEtat(Etat.Wait);
		}
	}
	
	private void move(int sens){
		if( oeil.isSelect()){
			oeil.deSelect();
		}else{
			oeil.move(sens);
			action |=true;
		}
	}


	@Override
	public void debut(NesPadControler controler) {
		// TODO Auto-generated method stub
		action = false;
	}


	@Override
	public void fin(NesPadControler controler) {
		// TODO Auto-generated method stub
		if( !action)
			oeil.setEtat(Etat.Wait);
	}


	@Override
	public void ClickStart(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ClickSelect(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ClickBas(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ClickGauche(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ClickDroit(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ClickHaut(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ClickB(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		oeil.deSelect();
	}


	@Override
	public void ClickA(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		oeil.deSelect();
	}
	
}
