package snake.interfacesAndAbstract;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */


/// Probably won't be used anymore
public interface Drawable {
	
	public float getScreenPosX();
	public float getScreenPosY();
	
	public void setScreenPosX();
	public void setScreenPosY();
	
	public void draw();
	public void setVisible(boolean visible);
	public boolean isVisible();
	public boolean isSubscribed();
	
	
	public void update(float delta);
	
	
}
