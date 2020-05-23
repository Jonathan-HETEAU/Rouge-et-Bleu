package fr.heteau.jonathan.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Resultat extends Actor{

	
	
	private boolean select ;
	public boolean mode = true;
	boolean animText = true;
	private Texture mTitle ;
	private TextureRegion [][] Echantillon ;
	private BitmapFont mFont;
	private BitmapFont mFont2;
	float stateTime = 0f;
	float stateTime2 = 0f;
		
	private Animation mAnimation;
	private Animation mAnimation2;
	private Texture mVisage;
	
	private float time ;
	private String mTime;
	
	public Resultat(float time) {
		super();
		
		
		this.time = time ;
		
		mTime ="" ;
		
		if( time < 3600)
			mTime = ""+(int)time/60+" m "+(int)time%60+" s ";
		else
			mTime ="W T F !  y o u   w a s   r e a l l y   s l o w !   t r y    a g a i n";
		this.mFont = new BitmapFont(Gdx.files.internal("font/test16-1.fnt"));
		this.mFont2 = new BitmapFont(Gdx.files.internal("font/test16-2.fnt"));
		Echantillon = TextureRegion.split(new Texture(Gdx.files.internal("image/default/echantillon.png")), 8, 8);
		this.mTitle = new Texture(Gdx.files.internal("image/titre.png")); 
		this.mVisage = new Texture(Gdx.files.internal("image/fin.png")); 
		TextureRegion[][]mAnimationFrames= TextureRegion.split(new Texture(Gdx.files.internal("image/default/bleu/oeil-petit/move.png")),16 , 16);
		mAnimation  = new Animation(0.02f, mAnimationFrames[(int)time %4]); 
		mAnimationFrames= TextureRegion.split(new Texture(Gdx.files.internal("image/default/rouge/oeil-petit/move.png")),16 , 16);
		mAnimation2  = new Animation(0.02f, mAnimationFrames[(3-(((int)time) %4))]);
	}


	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		stateTime += delta;
		stateTime2 += delta;
		if( stateTime > 0.25f){
			stateTime = 0;
			select = !select;
		}
		
	}


	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		for( int x = 0 ; x < 128 ; x = x + 8){
			for( int y = 0 ; y < 224 ; y = y + 8){
				batch.draw(Echantillon[0][16], x, y, 8,8);				
			}
		}
		for( int x = 128 ; x < 256 ; x = x + 8){
			for( int y = 0 ; y < 224 ; y = y + 8){
				batch.draw(Echantillon[0][15], x, y, 8,8);	
			}
		}
		
		if( select  )
		{
			mFont2.draw(batch, "C o n g r a t u l a t i o n !", 60,160);
			mFont2.draw(batch, "Y o u   a r e   o u t   o f   t h e   r o o m !  ", 30,140);
			if( time > 3600)
				mFont2.draw(batch, mTime, 20,120);
			else
				mFont2.draw(batch, mTime, 100,120);
		}else
		{
			mFont.draw(batch, "C o n g r a t u l a t i o n !", 60,160);
			mFont.draw(batch, "Y o u   a r e   o u t   o f   t h e   r o o m !  ", 30,140);
			if( time > 3600)
				mFont.draw(batch, mTime, 20,120);
			else
				mFont.draw(batch, mTime, 100,120);
		}
		
		
		
		
		batch.draw(mTitle,0 , 160);	
		batch.draw(mVisage,96 ,30);	
		batch.draw(mAnimation.getKeyFrame(stateTime2,true),110, 55);
		batch.draw(mAnimation2.getKeyFrame(stateTime2,true),130, 55);
		mFont2.draw(batch, "c r e a t e d   b y   J o n a t h a n H e t e a u", 0,10);
	}
	
}
