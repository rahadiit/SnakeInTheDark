package snake.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import box2dLight.ConeLight;
import box2dLight.Light;
import snake.engine.models.GameWorld;
import snake.visuals.Lights;
import snake.visuals.enhanced.LightMapEntity;

public class FlashLight_test extends LightMapEntity {
	Light light;
	Vector2 vec;
	
	
	public FlashLight_test (GameWorld world) {
		super(world);
		setBounds(0, 0, 1, 1);
		vec = new Vector2();
	}
	
	@Override
	public boolean hasLights() {
		return true;
	}
	
	
	@Override
	public void act(float delta) {
		
		//Set lights' position
		vec.set(0, 0);
		this.localToStageCoordinates(vec);
		light.setPosition(vec);
		//And rotation
		
		Actor parent = this.getParent();
		float rotation = 0;
		while (parent != null) {
			rotation += parent.getRotation();
			parent = parent.getParent();
		}
		
		light.setDirection(rotation);
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			light.setActive(!light.isActive());
		}
	}
	
	
	@Override
	public void createLights () {
		super.createLights();
		light = new ConeLight (Lights.getRayhandler(), 5000, new Color(1f, 1f, .5f, 1f),
				100, getX(), getY(), 90, 30);
		light.setActive(false); //Comeca apagada
	}
	
	
	public void dispose() {
		super.dispose();
		
		if (light != null) {
			light.remove();
			light.dispose();
		}
			
	}
	
	

}
