package fr.heteau.jonathan.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Json;




public class World extends Actor{

	public TextureAtlas FontAtlas;
	
	public Texture[] GrandOeilTextures = new Texture[2];
	public Texture[][] PetitOeilTextures = new Texture[2][4];
	public Texture[] CaisseTextures = new Texture[2];  
	public Texture[] BaliseTextures = new Texture[2];
	public Texture[] PowerTextures = new Texture[2];
	public TextureRegion [] FondAreneWorld = new TextureRegion[2];
	public TextureRegion [][] Echantillon ;
	
	public BitmapFont mFont;
	public BitmapFont mFont2;
	
	public WorldArene WorldBleu ;
	public WorldArene WorldRouge ;
	public Profil ProfilBleu ;
	public Profil ProfilRouge;
	public Timer mTimer ;
	public Interface mInterface;
	
	private int mNumNiveau =1;
	private Niveau mNiveau ;
	
	public boolean END = false;
	
	public World(String mode) {
		setSize(256, 224);
		setPosition(0, 0);
		initRessource( mode);
		mNumNiveau = 1;
		WorldBleu  = new WorldArene( this , 0 );
		WorldRouge = new WorldArene( this , 1 );
		ProfilBleu = new Profil(this, WorldBleu.oeil,0);
		ProfilRouge= new Profil(this, WorldRouge.oeil,1);
		mTimer = new Timer(this);
		mTimer.setPosition(96, 204);
		mTimer.setSize(16, 16);
		mInterface = new Interface(this);
		mInterface.setPosition(32,192);
		initNiveau(1);
		
	}
	
	public void initRessource(String mode){
		PetitOeilTextures[0][0]=  new Texture("image/"+mode+"/bleu/oeil-petit/wait.png");
		PetitOeilTextures[0][1]=  new Texture("image/"+mode+"/bleu/oeil-petit/move.png");
		PetitOeilTextures[0][2]=  new Texture("image/"+mode+"/bleu/oeil-petit/power.png");
		PetitOeilTextures[0][3]=  new Texture("image/"+mode+"/bleu/oeil-petit/balise.png");
		PetitOeilTextures[1][0]=  new Texture("image/"+mode+"/rouge/oeil-petit/wait.png");
		PetitOeilTextures[1][1]=  new Texture("image/"+mode+"/rouge/oeil-petit/move.png");
		PetitOeilTextures[1][2]=  new Texture("image/"+mode+"/rouge/oeil-petit/power.png");
		PetitOeilTextures[1][3]=  new Texture("image/"+mode+"/rouge/oeil-petit/balise.png");
		CaisseTextures[0] = new Texture("image/"+mode+"/bleu/caisse-balise.png");
		CaisseTextures[1] = new Texture("image/"+mode+"/rouge/caisse-balise.png");
		BaliseTextures[0] = new Texture("image/"+mode+"/bleu/signal-balise.png");
		BaliseTextures[1] = new Texture("image/"+mode+"/rouge/signal-balise.png");
		PowerTextures[0] = new Texture("image/"+mode+"/bleu/signal-power.png");
		PowerTextures[1] = new Texture("image/"+mode+"/rouge/signal-power.png");
		GrandOeilTextures[0] = new Texture("image/"+mode+"/bleu/oeil-grand/animation.png");
		GrandOeilTextures[1] = new Texture("image/"+mode+"/rouge/oeil-grand/animation.png");
		Echantillon = TextureRegion.split(new Texture("image/"+mode+"/echantillon.png"), 8, 8);
		mFont = new BitmapFont(Gdx.files.internal("font/test16-1.fnt"));
		mFont2 = new BitmapFont(Gdx.files.internal("font/test16-2.fnt"));
		
		FondAreneWorld[0] =Echantillon[0][16];
		FondAreneWorld[1] =Echantillon[0][15];
		
		
	}
	
	private void initNiveau( int niv ){
		
		mTimer.stop();
		if(Gdx.files.internal("niveau/"+niv+".txt").exists())
		{
			mNiveau = new Json().fromJson(Niveau.class,Gdx.files.internal("niveau/"+niv+".txt") );
			mNiveau.charger(WorldBleu, WorldRouge, this);
			this.mNumNiveau = niv ;
			mInterface.setNameNiv(""+this.mNumNiveau);
			mTimer.start();	
			
		}else{
			END = true;
		}
			
			
	}
	
	public void restart(){
		mNiveau.restart(WorldBleu, WorldRouge, this);
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		WorldBleu.act(delta);
		WorldRouge.act(delta);
		ProfilBleu.act(delta);
		ProfilRouge.act(delta);
		mTimer.act(delta);
		
		if( isWin())
			initNiveau(mNumNiveau+1);
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
				
		mInterface.draw(batch, parentAlpha);
		WorldBleu.draw(batch,  parentAlpha);
		WorldRouge.draw(batch, parentAlpha);
		ProfilBleu.draw(batch, parentAlpha);
		ProfilRouge.draw(batch, parentAlpha);
		mTimer.draw(batch, parentAlpha);
	}

	public boolean isWin() {
		// TODO Auto-generated method stub
		return WorldBleu.isWin() && WorldRouge.isWin();
	}

	
		
	

}
