import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;

public class UIText extends UIObject {
	Font font;
	FontMetrics metrics;
	String text;
	
	public UIText(int x, int y, Font font, FontMetrics metrics, String text) {
		super(x,y);
		this.font = font;
		this.metrics = metrics;
		this.text = text;
	}
	
	public int getWidth() {
		return metrics.stringWidth(text);
	}
	
	public int getHeight() {
		return metrics.getHeight();
	}

	@Override
	public BoundingBox getBoundingBox() {
		return new BoundingBox(x, y, getWidth(), getHeight());
	}
	
	public void paint(Graphics g) {
		g.setFont(font);
		g.drawString(text, x, y+getHeight());
		
		getBoundingBox().paint(g);
	}
}
