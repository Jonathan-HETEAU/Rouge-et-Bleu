package fr.heteau.jonathan.actor;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Profil  extends Actor{

	private World mWorld ;
	private Oeil mOeil ; 
	private Animation mAnimations[] = new Animation[4];
	private float[] mAnimationDelays = {0.25f,0.04f,0.15f,0.05f};
	private boolean[] mAnimationLoops = {true,true,false,false};
	private float stateTime ;
	private int  stateAnimation ;
	private TextureRegion[][] mAnimationFrames ;
	private int color ;
	
	public Profil(World world , Oeil oeil ,int color )  {
		
		
		super();
		this.color = color;
		this.mWorld = world ;
		this.mOeil = oeil;
		setSize(32,32);
		setPosition(color* 224, 192);
		mAnimationFrames= TextureRegion.split(mWorld.GrandOeilTextures[color],32 , 32);
		
				
		for( int i = 0 ; i < 4 ; i++)
			mAnimations[i] = new Animation(mAnimationDelays[i], mAnimationFrames[i]); 
	}
	
	
	@Override
	public void act(float delta) {
		super.act(delta);
		int state = mOeil.getEtat();
		
		if( state != stateAnimation){
			stateAnimation = state;
			stateTime = 0f;
		}
		else
			stateTime +=delta ;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		for( int x =0 ; x < 32 ; x +=8){
			for( int y =0 ; y < 32 ; y +=8){
				batch.draw( mWorld.Echantillon[0][10 -(color*6)], getX() + x , getY() + y);
			}
		}
		
		batch.draw(mAnimations[stateAnimation].getKeyFrame(stateTime, mAnimationLoops[stateAnimation]), getX(), getY(),getWidth(),getHeight());
		
	}
	
}
