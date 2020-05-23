package fr.heteau.jonathan.actor;



import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Oeil extends Actor{

	public static class Sens{
		public static final int B = 0;
		public static final int D = 1;
		public static final int G = 2;
		public static final int H = 3;
		public static final int vecteur[][] = {{0 ,-1},{1,0},{-1,0},{0,1}};
	}
	public class Etat{
		public static final int Balise = 3;
		public static final int Move = 1;
		public static final int Power = 2;
		public static final int Wait = 0;
	}
	
	

	private World mWorld ;
	private WorldArene mArene ;
	
	private int num ;
	private int etat;
	private int sens;
	private float vitesse = 0.1f;
	
	private Animation mAnimations[][] = new Animation[4][4];
	private TextureRegion[][][] mAnimationFrames = new TextureRegion[4][][];
	
	private float stateTime ;
	
	private boolean[] mBoucleAnim = {true, true , false,false};
	
	private Caisse mcaisse ;
	
	public Oeil( World wordl, WorldArene arene , int num) {
		
		this.mArene = arene;
		this.mWorld = wordl;
		this.num = num ;
		float[] timeAnim = {0.25f,0.014f, 0.05f,0.05f }; 
		for(int i = 0 ; i < 4 ; i++){
			mAnimationFrames[i] = TextureRegion.split( mWorld.PetitOeilTextures[num][i],16 , 16);
			for( int j = 0 ; j < 4 ; j++)
				mAnimations[i][j] = new Animation(timeAnim[i], mAnimationFrames[i][j]); 
		}
		setSize(16,16);
		
	}
	public void act(float delta) {
		super.act(delta);
		stateTime +=delta ;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		batch.draw(mAnimations[etat][sens].getKeyFrame(stateTime, mBoucleAnim[etat]), (int)getX(), (int)getY(),getWidth(),getHeight());
		
	}
	
	public int getNum() {
		// TODO Auto-generated method stub
		return num;
	}


	public int getEtat() {
		// TODO Auto-generated method stub
		return etat;
	}
	public int getSens() {
		return sens;
	}
	public void setSens(int sens) {
		
		if( sens != this.sens){
			vitesse = 0.0f;
			stateTime = 0f;
		}
			
		this.sens = sens;
	}
	public void setEtat(int etat) {
		
		if( etat != this.etat)
		{
			stateTime = 0f;
			vitesse = 0.0f;
			if( mcaisse != null){
				switch (this.etat) {
					case Etat.Balise:
						mcaisse.getCaisseConnection().setBalise(false);
						mcaisse.setBalise(false);
						break;
					case Etat.Power:
						mcaisse.setPower(false);
						break;
				}	
				switch (etat) {
				case Etat.Balise:
					mcaisse.getCaisseConnection().setBalise(true);
					mcaisse.setBalise(true);
					break;
				case Etat.Power:
					mcaisse.setPower(true);
					break;
				}
			}
		}
		
		this.etat = etat;
	}
	
	
	public boolean isSelect(){
		if( mcaisse != null){
			return true;
		}
		return false;
	}
	public void power() {
		
		mcaisse.move(sens) ;
	}
	public void select() {
		switch(sens){
			case Sens.B :
				mcaisse = mArene.getCaisse(getX()+7, getY()-1,2,1);
				break;
			case Sens.H :
				mcaisse = mArene.getCaisse(getX()+7, getY()+getHeight(),2,1);
				break;
			case Sens.D :
				mcaisse = mArene.getCaisse(getX()+getWidth(), getY()+7,1,2);
				break;
			case Sens.G :
				mcaisse = mArene.getCaisse(getX()-1, getY()+7,1,2);
				break;
		}
		
			
		
		
	}
	public void move(int move) {
		
		if( sens == move ){
			
			this.vitesse += 0.3;
			if( this.vitesse > 2)
				this.vitesse  = 2;
			int vitesse = (int) this.vitesse ;
			if( vitesse >= 1)
				switch(move){
					case Sens.B :
						if( mArene.isFree(getX(),getY()-vitesse,getWidth(), vitesse,false) )
						{
							moveBy(0, -vitesse);
							setEtat(Etat.Move);
						}else{
							setEtat(Etat.Wait);
						}
						setSens(move);
						break;
					case Sens.H :
						if(mArene.isFree(getX(),getY()+getHeight(),getWidth(), vitesse,false))
						{
							moveBy(0, +vitesse);
							setEtat(Etat.Move);
						}else{
							setEtat(Etat.Wait);
						}
						setSens(move);
						break;
					case Sens.D :
						if(mArene.isFree(getX()+getWidth(),getY(),vitesse , getHeight(),false))
						{
							moveBy(+vitesse,0);
							setEtat(Etat.Move);
						}else{
							setEtat(Etat.Wait);
						}
						setSens(move);
						break;
					case Sens.G :
						if(mArene.isFree(getX()-vitesse,getY(),vitesse , getHeight(),false))
						{
							moveBy(-vitesse,0);
							setEtat(Etat.Move);
						}else{
							setEtat(Etat.Wait);
						}
						setSens(move);
						break;
					
					}
		}else{
			vitesse = 0.1f;
			setSens(move);
		}
	}
	
	@Override
	public Actor hit(float x, float y, boolean touchable) {
		
		if( ( x >= getX()) && ( x < (getX() + getWidth()) )&& ( y >=getY() ) && ( y < (getY()+ getHeight())) ){
			return this ;
		}
		return null;		
	}
	public void deSelect() {
		
		setEtat(Etat.Wait);
		mcaisse = null;
		
	}
	
}
