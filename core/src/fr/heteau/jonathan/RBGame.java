package fr.heteau.jonathan;


import com.badlogic.gdx.Game;


import fr.heteau.jonathan.screen.MenuScreen;

public class RBGame extends Game {
		
	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}

	
}
