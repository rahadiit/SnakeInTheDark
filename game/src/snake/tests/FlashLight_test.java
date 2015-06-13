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
		setSize(1, 1);
		vec = new Vector2();
		
		//createLights();
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
		float rotation = 90;
		while (parent != null) {
			rotation += parent.getRotation();
			parent = parent.getParent();
		}
		
		this.setRotation(rotation);
		light.setDirection(rotation);
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT)) {
			System.out.println("Toggled flashlight");
			light.setActive(!light.isActive());
		}
	}
	
	
	@Override
	public void createLights () {
		super.createLights();
		light = new ConeLight (Lights.getRayhandler(), 5000, new Color(1f, 1f, .5f, 1f),
				90, getX(), getY(), 90, 30);
		light.setActive(true); //Comeca acessa
	}
	
	
	public void dispose() {
		super.dispose();
		
		if (light != null) {
			light.remove();
			light.dispose();
		}
			
	}

	@Override
	public String getType() {
		return "flashlight";
	}
}
