package fr.heteau.jonathan.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BaliseFin extends Actor{

	WorldArene mArene ;
	
	public BaliseFin(WorldArene arene) {
		// TODO Auto-generated constructor stub
		this.mArene = arene ;
		setSize(16, 16);
	}
	
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		batch.draw(mArene.mCaisseSprite[1], getX(), getY(),getWidth(),getHeight());
		
	}
}
