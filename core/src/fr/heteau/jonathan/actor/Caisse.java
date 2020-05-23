package fr.heteau.jonathan.actor;



import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import fr.heteau.jonathan.actor.Oeil.Sens;

public class Caisse extends Actor{

	int num ;	
	int[] connection ;
	
	WorldArene mArene ;
	WorldArene sArene ;
	
	boolean balise;
	boolean power ;
	
	float timeP = 0f;
	float timeB = 0f;
	float vitesse = 0f;
	
	
	public Caisse(int num, WorldArene mArene, WorldArene sArene,
			int[] connection , float x , float y) {
		super();
		this.num = num;
		this.mArene = mArene;
		this.sArene = sArene;
		this.connection = connection;
		setPosition(x, y);
		setSize(16, 16);
	}

	public void move(int sens) {
		
		Caisse tmp = sArene.getCaisse(num);
		
		if(canMove(sens))
		{
			if( tmp.canMove(connection[sens])){
				tmp.moveBy(Sens.vecteur[connection[sens]][0],Sens.vecteur[connection[sens]][1]);
				moveBy(Sens.vecteur[sens][0],Sens.vecteur[sens][1]);
				
				
				
			}
		}
		
	}

	public boolean canMove( int sens){
		
		switch(sens){
		case Sens.B :
			return mArene.isFree(getX(),getY()-1,getWidth(), 1,true);
		case Sens.H :
			return mArene.isFree(getX(),getY()+getHeight(),getWidth(), 1,true);
		case Sens.D :
			return mArene.isFree(getX()+getWidth(),getY(),1 , getHeight(),true);
		case Sens.G :
			return mArene.isFree(getX()-1,getY(),1 , getHeight(),true);
		}
		return false;
	}
	
	public Caisse getCaisseConnection() {
		// TODO Auto-generated method stub
		return sArene.getCaisse(num);
	}

	@Override
	public Actor hit(float x, float y, boolean touchable) {
		if( ( x >= getX()) && ( x < (getX() + getWidth()) )&& ( y >=getY() ) && ( y < (getY()+ getHeight())) ){
			return this ;
		}
		return null;		
	}
	
	public void setPower(boolean power) {
		this.power = power;
		if( !power)
			timeP = 0f;
	}
	public void setBalise(boolean balise){
		this.balise = balise;
		if( !balise)
			timeB = 0f;
	}
	
	public boolean isBalise(){
		return balise;
	}
	public boolean isPower(){
		return power;
	}

	@Override
	public void act(float delta) {
		
		if( power)
			timeP += delta;
		if( balise)
			timeB += delta;
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		batch.draw(mArene.mCaisseSprite[0],(int)getX(),(int)getY(),getWidth(),getHeight());
		if( power)
			batch.draw(mArene.mPowerAnimation.getKeyFrame(timeP,true), (int)getX(), (int)getY(),getWidth(),getHeight());
		if( balise)
			batch.draw(mArene.mBaliseAnimation.getKeyFrame(timeB,true), (int)getX(), (int)getY(),getWidth(),getHeight());
	}
	
}
