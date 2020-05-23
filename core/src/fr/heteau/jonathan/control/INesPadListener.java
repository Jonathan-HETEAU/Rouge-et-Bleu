package fr.heteau.jonathan.control;

public interface INesPadListener {
	public void debut(NesPadControler controler);
	public void fin(NesPadControler controler);
	public void haut(NesPadControler controler);
	public void bas(NesPadControler controler);
	public void droit(NesPadControler controler);
	public void gauche(NesPadControler controler);
	public void select(NesPadControler controler);
	public void start(NesPadControler controler);
	public void A(NesPadControler controler);
	public void B(NesPadControler controler);
	public void ClickStart(NesPadControler nesPadControler);
	public void ClickSelect(NesPadControler nesPadControler);
	public void ClickBas(NesPadControler nesPadControler);
	public void ClickGauche(NesPadControler nesPadControler);
	public void ClickDroit(NesPadControler nesPadControler);
	public void ClickHaut(NesPadControler nesPadControler);
	public void ClickB(NesPadControler nesPadControler);
	public void ClickA(NesPadControler nesPadControler);

	
}
