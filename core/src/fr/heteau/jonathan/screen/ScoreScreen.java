package fr.heteau.jonathan.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.heteau.jonathan.RBGame;
import fr.heteau.jonathan.actor.Resultat;
import fr.heteau.jonathan.actor.World;
import fr.heteau.jonathan.control.INesPadListener;
import fr.heteau.jonathan.control.NesPadControler;
import fr.heteau.jonathan.control.NesPadControler.Commande;

public class ScoreScreen implements Screen , INesPadListener {

	private RBGame mGame ;
	private Stage mStage ;
	private Resultat mResult ;
	private NesPadControler J1;
	private NesPadControler J2;
	 
	
	public ScoreScreen(RBGame game ,World world,Commande com1 , Commande com2) {
		// TODO Auto-generated constructor stub
		this.mStage = new Stage(new FitViewport(256, 224) );
		this.mResult = new Resultat(world.mTimer.secondes) ;
		this.mResult.setPosition(0, 0);
		this.mResult.setSize(256, 224);
		this.mGame = game;
		this.J1 = new NesPadControler(com1, this);
		this.J2 = new NesPadControler(com2, this);
		mStage.addActor(mResult);	
	}
	
	
	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		J1.play();
		J2.play();
		mStage.act(delta);
		mStage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
				mStage.getViewport().update(width , height);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debut(NesPadControler controler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fin(NesPadControler controler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void haut(NesPadControler controler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bas(NesPadControler controler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void droit(NesPadControler controler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gauche(NesPadControler controler) {
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void B(NesPadControler controler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ClickStart(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		mGame.setScreen(new MenuScreen(mGame));
	}

	@Override
	public void ClickSelect(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		mGame.setScreen(new MenuScreen(mGame));
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
		mGame.setScreen(new MenuScreen(mGame));
	}

	@Override
	public void ClickA(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		mGame.setScreen(new MenuScreen(mGame));
	}
	

}
