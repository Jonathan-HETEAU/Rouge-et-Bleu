package fr.heteau.jonathan.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Timer extends Actor{
	
	private World mWorld;
	
	public Timer(World world) {
		super();
		this.mWorld = world;
	}
	
	public float secondes ;
	boolean start ;
	
	public void start(){
		start = true;
	}
	public void stop(){
		start = false;
	}
	public void init (int seconde){
		
	}
	public int getSeconde(){
		return (int) (secondes%60) ;
	}
	public int getMinute(){
		return (int) (secondes/60) ;
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		
		if( start )
			secondes += delta ;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if( getMinute() > 59){
			mWorld.mFont2.draw(batch,"W",  getX()+4,getY());
			mWorld.mFont.draw(batch,"T", getX()+16+4,getY());
			mWorld.mFont2.draw(batch,"F", getX()+32+4,getY());
			mWorld.mFont.draw(batch,"!", getX()+48+4,getY());
		}else{
			
			mWorld.mFont2.draw(batch,""+(int)(getMinute()/10),  getX()+4,getY());
			mWorld.mFont2.draw(batch,""+(int)(getMinute()%10), getX()+16+4,getY());
			mWorld.mFont2.draw(batch,""+(int)(getSeconde()/10), getX()+32+4,getY());
			mWorld.mFont2.draw(batch,""+(int)(getSeconde()%10), getX()+48+4,getY());
		
		}
	}
	
	public boolean isStart(){
		return start;
	}
	
	public void setStart(boolean bol){
		start = bol;
	}
}
