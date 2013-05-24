import java.awt.Graphics;

public class BoundingBox {
	int x,y,width,height;
	
	public BoundingBox(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean pointInside(int x, int y) {
		if (x < getLeft()) return false;
		if (y < getTop()) return false;
		if (x > getRight()) return false;
		if (y > getBottom()) return false;
		return true;
	}

	public int getLeft() {
		return x;
	}
	
	public int getRight() {
		return x+width;
	}
	
	public int getTop() {
		return y;
	}
	
	public int getBottom() {
		return y+height;
	}
	
	public void paint(Graphics g) {
		g.drawRect(x,y, width, height);
	}
}
