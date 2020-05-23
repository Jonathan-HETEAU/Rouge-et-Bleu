package fr.heteau.jonathan.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.heteau.jonathan.RBGame;
import fr.heteau.jonathan.actor.Menu;
import fr.heteau.jonathan.control.INesPadListener;
import fr.heteau.jonathan.control.NesPadControler;
import fr.heteau.jonathan.control.NesPadControler.Commande;


public class MenuScreen implements Screen , INesPadListener{

	public Texture[] PetitOeilTextures = new Texture[2];
	private RBGame mGame;
	private Stage mStage;
	private Menu mMenu ;
	private Commande mCom1;
	private Commande mCom2;
	private NesPadControler mControler;
	

	public MenuScreen(RBGame game) {
		this.mGame = game;
		this.mStage = new Stage(new FitViewport(256, 224) );
		this.mMenu = new Menu();
		this.mStage.addActor(this.mMenu);
		this.mCom1 = new Commande(Input.Keys.D, Input.Keys.Q,Input.Keys.Z, Input.Keys.S, Input.Keys.J, Input.Keys.I, Input.Keys.A, Input.Keys.E);
		this.mCom2 = new Commande(Input.Keys.RIGHT, Input.Keys.LEFT,Input.Keys.UP, Input.Keys.DOWN, Input.Keys.NUMPAD_7, Input.Keys.NUMPAD_8, Input.Keys.NUMPAD_0, Input.Keys.NUMPAD_1);
		this.mControler = new NesPadControler(mCom1, this);
	}
	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		mStage.act(delta);
		mStage.draw();
		mControler.play();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		mStage.getViewport().update(width, height);
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
		
	}


	@Override
	public void ClickSelect(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ClickBas(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		mMenu.mode = ! mMenu.mode ;
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
		mMenu.mode = ! mMenu.mode ;
	}


	@Override
	public void ClickB(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ClickA(NesPadControler nesPadControler) {
		// TODO Auto-generated method stub
		mGame.setScreen(new GameScreen(mGame, mMenu.mode, mCom1, mCom2));
	}

}
