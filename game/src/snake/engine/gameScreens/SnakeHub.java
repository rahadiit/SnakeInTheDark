package snake.engine.gameScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.engine.MainMenu;
import snake.engine.core.SnakeStart;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */

public class SnakeHub implements MainMenu {
	private SnakeStart game;
	private SpriteBatch batch;
	private BitmapFont font;
	private GlyphLayout layout;
	private float w, h;
	String instructions[]; //will be changed to buttons

	public SnakeHub(SnakeStart game) {
		this.game = game;
		this.batch = game.getBatch();
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

	@Override
	public void render(float delta) {
		update();
		draw();
	}

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

	private void update() {
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER))
			game.setScreen(new SnakeLevel(game, "Generic Level"));

		instructions[0] = "Para comecar o jogo";
		instructions[1] = "tecle ENTER";
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

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

			System.out.println("Toogled fullscreen\n");
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
