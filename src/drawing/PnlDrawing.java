package drawing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Rectangle;
import geometry.Shape;


public class PnlDrawing extends JPanel {
	
	public Shape s;
	public ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public PnlDrawing() {
		
	}
	
	
	public void paint(Graphics g) {
			super.paint(g);
			for (Shape s : shapes) {
				if (s instanceof Circle) {
					if (s instanceof Donut) {
						Donut d = (Donut) s;
						d.fillDonut(g);
					} else {
						Circle c = (Circle) s;
						c.fillCircle(g);
					}	
				} else if(s instanceof Rectangle) {
					Rectangle r = (Rectangle) s;
					r.fillRectangle(g);
				}
				s.draw(g);	
			}
			repaint();
		
	}

	
}


