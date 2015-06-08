package snake.hud;

import snake.engine.creators.HUDSettings;
import snake.engine.dataManagment.Loader;
import snake.engine.models.HUD;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */

public class SnakeDialogHUD extends HUD{
	private BitmapFont font;
	private GlyphLayout layout;
	private Sprite folder;
	private String fontName = "fonts/ak_sc_o.fnt", folderName = "HUD/folderOcean_fixSize.png";
	
	public SnakeDialogHUD() {
		this.setSize(HUDSettings.getHudWidth() * 4.97f/6, HUDSettings.getHudHeight() * .9f/6);
		
		
		Loader.load(fontName, BitmapFont.class);
		Loader.finishLoadingAsset(fontName);
		this.font = Loader.get(fontName);
		
		layout = new GlyphLayout();
		
		Loader.load(folderName, Texture.class);
		Loader.finishLoadingAsset(folderName);
		Texture texture = Loader.get(folderName);
		folder = new Sprite(texture);
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(folder, getX(), getY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		
		font.getData().markupEnabled = true;
		layout.setText(font, "[GREEN]Well... [RED]here we are!");
		font.draw(batch, layout, 35, 95);
	}

	@Override
	public void hide() {
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
	public void dispose() {
		Loader.unload(fontName);
	}
	
	

}
