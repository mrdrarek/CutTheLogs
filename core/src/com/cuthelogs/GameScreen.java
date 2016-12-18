package com.cuthelogs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.cuthelogs.entities.rama;

/**
 * Created by mrdrarek on 18/12/16.
 */

public class GameScreen extends BaseScreen {
    private Stage stage;
    private World world;
    private Vector3 position;

    private rama rama;

    public GameScreen(MainGame game) {
        super(game);
        stage = new Stage(new FitViewport(640,320));

        position = new Vector3(stage.getCamera().position);

        world = new World(new Vector2(0,-10),true);
    }

    @Override
    public void show() {
        Texture ramaTexture = game.getManager().get("rama.png");

        rama = new rama(world,ramaTexture,new Vector2(10f,8f));

        stage.addActor(rama);



    }

    @Override
    public void hide() {
        rama.detach();
        rama.remove();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f,0.5f,0.8f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

      /*  if(player.getX() > 150 && player.isAlive() ){
            stage.getCamera().translate(Constants.SPEED_PLAYER * delta * Constants.PIXELS_IN_METER,0,0);
        }

        if(Gdx.input.justTouched() ){
            jumpSong.play();
            player.jump();
        }*/
        stage.act();

        world.step(delta,6,2);

        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        world.dispose();
    }


}
