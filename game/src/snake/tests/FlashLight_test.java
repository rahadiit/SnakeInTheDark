package snake.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
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
		vec.set(0, 0);
		this.localToStageCoordinates(vec); 
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT)) {
			System.out.println(getX() + ":" + getY());
			light.setActive(!light.isActive());
	}
			
		light.setPosition(vec);
		light.setDirection(this.getParent().getRotation() + 90);
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
