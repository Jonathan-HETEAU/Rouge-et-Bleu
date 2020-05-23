package fr.heteau.jonathan.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Interface extends Actor {

	World mWorld ;
	BitmapFont mFont ;
	String NameJoueur1 = "Player 1" ;
	String NameJoueur2 = "Player 2" ;
	String NameNiv = "";
	TextBounds tx1 ;
	TextBounds tx2 ;
	TextBounds tx3 ;
	
	short interfa[][] = {
			{12,13,13,13,13,13,13,14,4,4,4,4,10,10,10,10,12,13,13,13,13,13,13,14},
			{0,1,1,1,1,1,1,2,4,4,4,4,10,10,10,10,0,1,1,1,1,1,1,2},
			{0,1,1,1,1,1,1,6,13,13,13,13,13,13,13,13,8,1,1,1,1,1,1,2},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}};
	
	
	public Interface(World mWorld) {
		super();
		this.mWorld = mWorld;
		this.mFont = mWorld.mFont;
		tx1 = mFont.getBounds(NameJoueur1);
		tx2 = mFont.getBounds(NameJoueur2);
		tx3 = mFont.getBounds("Niv :"+NameNiv);
		setSize(192,32);
	}

	

	public String getNameJoueur1() {
		return NameJoueur1;
	}



	public void setNameJoueur1(String nameJoueur1) {
		NameJoueur1 = nameJoueur1;
		tx1 = mFont.getBounds(NameJoueur1);
	}



	public String getNameJoueur2() {
		return NameJoueur2;
	}



	public void setNameJoueur2(String nameJoueur2) {
		NameJoueur2 = nameJoueur2;
		tx2 = mFont.getBounds(NameJoueur2);
	}


	

	public String getNameNiv() {
		return NameNiv;
	}



	public void setNameNiv(String nameNiv) {
		NameNiv = nameNiv;
		tx3 = mFont.getBounds("Niv :"+NameNiv);
	}



	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		for( int x = 0 ; x < 24 ; x++){
			for( int y = 0 ; y < 4 ; y++){
				batch.draw(mWorld.Echantillon[0][interfa[y][x]], getX()+(x*8), getY()+(y*8));
			}
		}
		mFont.draw(batch, "Niv :"+NameNiv, getX()+80,getY()+30);
		mFont.draw(batch, NameJoueur1, getX()+4,getY()+16);
		mFont.draw(batch, NameJoueur2, getX()+140 ,getY()+16);
		
	}
	
}
