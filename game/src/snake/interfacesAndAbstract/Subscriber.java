package snake.interfacesAndAbstract;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */



//Probably wont be used at all
public interface Subscriber {
	
	public void drawAll();
	public void updateAll();
	
	
	
	public void subscribe(Drawable entity);
	public void unsubscribe (Drawable entity);
	
	public void subscribe(Drawable entity, int key);
	public void unsubscribe (Drawable entity, int key);
	
	public void addToBuffer (int key);
	
	public void unsubscribeAll(String type);
}
