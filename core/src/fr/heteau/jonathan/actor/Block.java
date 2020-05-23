package fr.heteau.jonathan.actor;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Block extends Actor{
	
	WorldArene mArene ;
	
	public Block( WorldArene arene , float x , float y) {
		this.mArene = arene ;
		setSize(16, 16);
		setPosition(x, y);
	}

	public Actor hit(float x, float y, boolean touchable) {
		
		if( ( x >= getX()) && ( x < (getX() + getWidth()) )&& ( y >=getY() ) && ( y < (getY()+ getHeight())) ){
			return this ;
		}
		return null;		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		batch.draw(mArene.mCaisseSprite[2],getX(),getY(),getWidth(),getHeight());
	}
}
