package com.cuthelogs.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.cuthelogs.Constants;

import static com.cuthelogs.Constants.PIXELS_IN_METER;

/**
 * Created by mrdrarek on 19/12/16.
 */

public class rama extends Actor {

    private World world;

    private Texture texture;

    private Fixture fixture;

    private Body body;



    public rama(World world,Texture texture,Vector2 position){
        this.world = world;
        this.texture = texture;

        BodyDef def = new BodyDef();
        def.position.set(position);
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);


        PolygonShape box = new PolygonShape();
        box.setAsBox(1,1);
        fixture = body.createFixture(box,3);
        fixture.setUserData("player");
        box.dispose();

        setSize(PIXELS_IN_METER ,PIXELS_IN_METER );


    }

    public void draw(Batch batch, float parentAlpha) {
        setPosition((body.getPosition().x  - 0.5f)* PIXELS_IN_METER,
                (body.getPosition().y - 0.5f) * PIXELS_IN_METER);
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }

    public void detach(){
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }
}
