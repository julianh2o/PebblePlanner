import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class PebblePlanner extends Canvas implements Runnable, MouseListener, MouseMotionListener, KeyListener {
	List<UIObject> objects;
	
	String FONT_DIRECTORY = System.getProperty("user.dir")+"/fonts";
	
	FontManager fontManager;
		
	Thread t;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		final PebblePlanner pp = new PebblePlanner();
		f.add(pp);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				super.componentShown(e);
				pp.doInit();
			}
		});
		
		f.setSize(144,168);
		f.setVisible(true);
	}

	public PebblePlanner() {
		t = new Thread(this);
		t.start();
		
		objects = new LinkedList<UIObject>();
		fontManager = new FontManager(Paths.get(FONT_DIRECTORY));
	}
	
	public void doInit() {
		try {
			System.out.println("initting!");
			Font font = fontManager.getFont("Outwrite.ttf");
			Font derived = font.deriveFont(Font.PLAIN,24);
			FontMetrics metrics = getGraphics().getFontMetrics(derived);
			
			UIText text = new UIText(10,50,derived, metrics, "foo");
			UIText text2 = new UIText(10,100,derived, metrics, "foo");
			
			objects.add(text);
			objects.add(text2);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	public void run() {
		repaint();
		while(true) {
			//repaint();
			try {
				t.sleep(100); //adjust this to change FPS higher numbers = lower FPS
			} catch (InterruptedException e) {
				return;
			}
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		
		for (UIObject o : objects) {
			o.paint(g);
		}
		//g.drawString("rawr", 20,20);
		//g.drawString("rawr", 40,40);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
