package snake.interfacesAndAbstract;

public interface Subscriber {
	
	public void drawAll();
	public void updateAll();
	
	
	
	public void subscribe(Drawable entity);
	public void unsubscribe (Drawable entity);
	
	public void subscribe(Dynamic entity);
	public void unsubscribe (Dynamic entity);
	
	public void subscribe(int key);
	public void unsubscribe (int key);
	public void addToBuffer (int key);
	
	public void subscribe(Dynamic entity, int key);
	public void unsubscribe (Dynamic entity, int key);
	
	public void unsubscribeAll(String type);
}
