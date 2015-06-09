package snake.equipment.implementations;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.scenes.scene2d.Actor;

import snake.engine.dataManagment.Loader;


/**                              Developed By:
	 *                                  NoDark
	 *                               sessaGlasses
	 *                               
	 * <br> Blinking sensor for HUD </br>
	 * 
	 * @author Agustina
	 */

public class BlinkingSensor extends Actor {

	private static final int ANIMATION_BLINK_STATES =2 ;
	
	
	
	//Animation
	private Texture blinkingSheet;
	private Animation[] animatedBlink;
	private Animation currentAnimation;
	private TextureRegion currentFrame, region;
	private String texName = "equipments/NOVASPRITEBLINKING.png";
	
	private static final int FRAME_ROWS_BLINK = 2, FRAME_COLS_BLINK = 5;
	private static final int GREEN = 0, RED = 1;
	private float blinkingSpeed = .1f;
	private float stateTime = 0;
	private BlinkingSensor(){
		
		
		Loader.load(texName, Texture.class);
		Loader.finishLoadingAsset(texName);
		blinkingSheet = Loader.get(texName);
		
		
		//cria as animacoes
		animatedBlink = new  Animation[2];
		for(int i = 0; i< ANIMATION_BLINK_STATES;i++ ){
			region = new TextureRegion(blinkingSheet, 0, (float)i/FRAME_ROWS_BLINK, 1, (float)(i+1)/FRAME_ROWS_BLINK);
			
			TextureRegion[][] tmp2 = region.split(region.getRegionWidth()/FRAME_COLS_BLINK, region.getRegionHeight());
			
			animatedBlink[i] = new Animation(blinkingSpeed,tmp2[0]);
		}
		currentAnimation = animatedBlink[GREEN];
		
	}
	public void act(float delta, boolean drone){
	stateTime += delta;
	currentFrame = currentAnimation.getKeyFrame(stateTime, true);
	if (drone)
		currentAnimation = animatedBlink[RED];
	else
		currentAnimation = animatedBlink[GREEN];
	
	
		
	}

	@Override
	public void draw (Batch batch, float parentAlpha) { 
		batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento automatico
				getWidth(), getHeight(), getScaleX(), getScaleY(), super.getRotation());
		super.draw(batch, parentAlpha);
	}

	
}
