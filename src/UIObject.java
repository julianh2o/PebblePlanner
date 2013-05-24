import java.awt.Graphics;

public abstract class UIObject {
	int x,y;
	
	public UIObject(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public abstract BoundingBox getBoundingBox();
	public abstract void paint(Graphics g);
}
