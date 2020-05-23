package fr.heteau.jonathan.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.heteau.jonathan.RBGame;
import fr.heteau.jonathan.actor.World;
import fr.heteau.jonathan.control.IMode;
import fr.heteau.jonathan.control.Mode1Joueur;
import fr.heteau.jonathan.control.Mode2Joueurs;
import fr.heteau.jonathan.control.NesPadControler.Commande;

public class GameScreen  implements Screen {

	private Stage mStage ;
	
	private RBGame mGame ;
	private World mWorld ;
	private IMode mMode;
	private Commande com1;
	private Commande com2;
	
	public GameScreen( RBGame game , boolean mode , Commande com1 , Commande com2) {
		this.mGame = game;
		this.mStage = new Stage(new FitViewport(256, 224) );
		
		this.com1 = com1;
		this.com2 = com2;
		
		if( !mode )
		{
			this.mWorld = new World("default");
			this.mMode = new Mode1Joueur(mWorld , com1 );
		}else{
			this.mWorld = new World("crazy");
			this.mMode = new Mode2Joueurs(mWorld, com1 , com2);
		}
		mStage.addActor(mWorld);
		
	}
	
	
	@Override
	public void render(float delta) {
		
		if( mWorld.END)
			mGame.setScreen(new ScoreScreen(mGame , mWorld ,com1 ,com2));
		
		
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		mMode.act(delta);
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


	
	

}
