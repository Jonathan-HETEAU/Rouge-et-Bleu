package fr.heteau.jonathan.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.scenes.scene2d.Actor;



public class Menu extends Actor {

	public Texture[] GrandOeilTextures = new Texture[2];
	public boolean mode = true;
	boolean animText = true;
	private Texture mTitle ;
	private TextureRegion [][] Echantillon ;
	private BitmapFont mFont;
	private BitmapFont mFont2;
	float stateTime = 0f;
	float timeleft2 = 0f;
	
	String nameTouche1[] = {"Q","S","Z","D","E","A","J","I"};
	String namTouche2[] = {"◄","▼","▲","►","1","0","7","8"};
	private Animation mAnimation;
	
	public Menu() {
		setSize(256, 224);
		setPosition(0, 0);
		this.mFont = new BitmapFont(Gdx.files.internal("font/test16-1.fnt"));
		this.mFont2 = new BitmapFont(Gdx.files.internal("font/test16-2.fnt"));
		Echantillon = TextureRegion.split(new Texture(Gdx.files.internal("image/default/echantillon.png")), 8, 8);
		this.mTitle = new Texture(Gdx.files.internal("image/titre.png")); 
		
		TextureRegion[][]mAnimationFrames= TextureRegion.split(new Texture("image/default/bleu/oeil-grand/animation.png"),32 , 32);
		mAnimation  = new Animation(0.25f, mAnimationFrames[0]); 
	}
	
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		timeleft2 += delta;
		if( timeleft2 >0.25){
			timeleft2 = 0f;
			animText = ! animText;
		}
			
		stateTime +=delta ;
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		TextBounds txt1 = mFont.getBounds("1 Player");
		TextBounds txt2 = mFont.getBounds("2 Players");
		float decal =  (txt1.width/2);
		float decal2 =  (txt2.width/2);
		
		
		
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
		
		
		if( mode ){
			if( animText)
				mFont.draw(batch, "2 Players",128-decal2 , 128);
			else
				mFont2.draw(batch, "2 Players", 128-decal2, 128);
			
			mFont.draw(batch, "1 Player", 128-decal, 112);
		}else{
			mFont.draw(batch, "2 Players", 128-decal2, 128);
			
			if( animText)
				mFont.draw(batch, "1 Player", 128-decal, 112);
			else
				mFont2.draw(batch, "1 Player", 128-decal, 112);
		}
		
		drawCommande( batch,  0 ,  0 , nameTouche1 , Echantillon[0][15]);
		if( mode)
			drawCommande( batch,  144 ,  0 , namTouche2 , Echantillon[0][16]);
		batch.draw(mTitle,0 , 160 ,256,64);	
		batch.draw(mAnimation.getKeyFrame(stateTime,true),112, 144);
	}
	
	
	
	private void drawCommande(Batch batch, int x , int y , String [] name , TextureRegion fond){
		
		int pos[][]={{0,1},{1,0},{1,2},{2,1},{3,0},{4,0},{5,1},{6,1}};
		
		
		for(int k =0; k < 8  ; k++){
			int[] p = pos[k];
			for(int i = 0 ; i < 2 ; i++ ){
				for(int j = 0 ; j < 2 ; j++ ){
					batch.draw(fond, x+(p[0]*16)+(i*8),y+(p[1]*16)+(j*8), 8,8);
					
				}
			}
			mFont2.draw(batch, name[k], x+(p[0]*16)+2, y+(p[1]*16)+14);
		}
		
	}
	
}
