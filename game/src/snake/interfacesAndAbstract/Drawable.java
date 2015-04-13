package snake.interfacesAndAbstract;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */

public interface Drawable {
	
	float getScreenPosX();
	float getScreenPosY();
	
	void setScreenPosX();
	void setScreenPosY();
	
	void draw();
	void setVisible(boolean visible);
	boolean isVisible();
	
	
}
