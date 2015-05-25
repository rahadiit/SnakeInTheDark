package snake.engine.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.engine.MainMenu;
import snake.engine.creators.ScreenCreator;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> SnakeInTheDark main menu Sketch. </br>
 * <br> NOTE: Seems that the GlyphLayout isn't working well in the emulator (not tested yet)
 * @author Mr.Strings
 */

public class SnakeHub implements MainMenu {
	private SpriteBatch batch;
	private BitmapFont font;
	private GlyphLayout layout;
	private float w, h;
	String instructions[]; //will be changed to buttons

	public SnakeHub() {
		this.batch = ScreenCreator.getBatch();
		this.font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
		this.layout = new GlyphLayout();

		font.setColor(Color.GREEN);

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();

		Gdx.input.setInputProcessor(this);
		
		instructions = new String[3];
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	
	/** Does the rendering -- keeps repeating for updating and drawing the game */
	@Override
	public void render(float delta) {
		update();
		draw();
		
		if (ScreenCreator.updateRequested())
			ScreenCreator.updateScreens();
	}

	/** Draws figures on Screen */
	private void draw() {
		//Starts drawing
		batch.begin();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		//Drawing touch input
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isTouched())
			font.draw(batch, "You're touching it! (maybe pressing space button).", 0, 80);

		//Drawing instructions
		layout.setText(font, instructions[0]);
		font.draw(batch, layout, w / 2 - layout.width / 2, h / 2 - layout.height / 2 + 50);
		layout.setText(font, instructions[1]);
		font.draw(batch, layout, w / 2 - layout.width / 2, h / 2 - layout.height / 2 - 20);


		font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 0, h*99/100);
		batch.end();
		//Ends drawing
	}

	
	/** updates Screen logic */
	private void update() {
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.justTouched()) {
			String[] param = {"SnakeLevel", "TempleMap", "Some random Data"};
			
			try {
				ScreenCreator.switchAndGo(param);
			} catch (Exception e) {
				System.out.println("Cannot create Screen.");
			}
		}

		instructions[0] = "Para comecar o jogo";
		instructions[1] = "tecle ENTER";
	}

	
	/** Called when the Screen is resized. */
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}
	/** Called when the Screen is paused. */
	public void pause() {
		// TODO Auto-generated method stub

	}

	
	/** Called when the Screen returns from a paused state. */
	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	
	/** Called when Game changes Screens (this to other ones). */
	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	
	/** Disposes the Screen -- is done automatically by the ScreenCreator if used. */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.F1) {
			// set resolution to default and toggles full-screen
			Gdx.graphics.setDisplayMode(
					Gdx.graphics.getDesktopDisplayMode().width,
					Gdx.graphics.getDesktopDisplayMode().height,
					!Gdx.graphics.isFullscreen());
		}

		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
