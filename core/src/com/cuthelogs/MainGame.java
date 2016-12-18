package com.cuthelogs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {
	private AssetManager manager;
	private GameScreen gameScreen;

	@Override
	public void create () {
		manager = new AssetManager();

		manager.load("rama.png", Texture.class);
		manager.finishLoading();

		gameScreen = new GameScreen(this);
		setScreen(gameScreen);
	}
	public AssetManager getManager(){
		return manager;
	}

}
