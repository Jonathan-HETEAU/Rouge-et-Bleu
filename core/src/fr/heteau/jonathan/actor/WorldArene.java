package fr.heteau.jonathan.actor;






import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;



public class WorldArene extends Actor{
	
	public Animation mBaliseAnimation ;
	public Animation mPowerAnimation ;
	public TextureRegion mCaisseSprite[];
	
	
	private int num ;
	
	public Caisse[] mCaises ;
	public Block[] mBlock; 
	
	public Oeil oeil ;
	public BaliseFin baliseFin  ;
	
	private World mWorld ;
	 
	
	public WorldArene(World world ,int i ) {
		
		this.num = i;
		this.mWorld = world ;
		this.oeil = new Oeil(world,this,i);
		
		setPosition(i*128, 0);
		
		this.mCaisseSprite = TextureRegion.split(mWorld.CaisseTextures[num] , 16 , 16 )[0];
		this.mBaliseAnimation = new Animation(0.1f,TextureRegion.split(mWorld.BaliseTextures[num] , 16 , 16 )[0]); 
		this.mPowerAnimation  = new Animation(0.1f,TextureRegion.split(mWorld.PowerTextures[num] , 16 , 16 )[0]); 
		this.baliseFin = new BaliseFin(this);
		setSize(128, 192);
	}


	@Override
	public void act(float delta) {
		
		oeil.act(delta);
		baliseFin.act(delta);
		
			for( Caisse actor : mCaises)
				actor.act(delta);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch,parentAlpha);
		
		for(float x = getX() ; x < getX()+getWidth() ; x += 8){
			for(float y = getY() ; y < getY()+getHeight() ; y += 8){
				batch.draw(mWorld.FondAreneWorld[num], x, y, 8, 8);
			}
		}
		
		
		baliseFin.draw(batch,parentAlpha);
		for( Block actor : mBlock)
			actor.draw(batch, parentAlpha);
		for( Caisse actor : mCaises)
			actor.draw(batch, parentAlpha);
		oeil.draw(batch,parentAlpha);
	}


	public boolean isFree(float x, float y, float width, float height, boolean to) {
		
		if( x >= getX() && (x+width) <= (getX()+ getWidth())){
			if( y >= getY() && ( y + height) <= (getY() + getHeight()) ){
				
				for(int i = 0 ; i < width ; i ++ ){
					for(int j = 0 ; j < height ; j++){
							if(to)
								if( oeil.hit(x+i, y+j, true) != null ){
									return false;
								}
						
							for( Caisse act : mCaises ){
								if( act.hit(x+i, y+j, true) != null ){
									return false;
								}
							}
							for( Block block : mBlock){
								if( block.hit(x+i, y+j, true) != null ){
									return false;
								}
							}
					}
				}
				
				return true;
			}
		}
		return false;		
	}


	public Caisse getCaisse(float x, float y, int width, int height) {
		if( x >= getX() && (x+width) <= (getX()+ getWidth())){
			if( y >= getY() && ( y + height) <= (getY() + getHeight()) ){
				for(int i = 0 ; i < width ; i ++ ){
					for(int j = 0 ; j < height ; j++){
							for( Caisse act : mCaises ){
								if( act.hit(x+i, y+j, true) != null ){
									return  act;
								}
							}
					}
				}
			}
		}
				
		return null;	
	}


	public Caisse getCaisse(int num2) {
		return mCaises[num2];
	}


	public boolean isWin() {
		
		if( oeil.hit(baliseFin.getX()+(baliseFin.getWidth()/2),baliseFin.getY()+(baliseFin.getHeight()/2), true) != null   )
			return true;
		return false;
	}
	
	
	
}
