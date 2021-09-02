package geometry;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
	}

	public void paint(Graphics g)  {
		
		Point p = new Point (110, 150, true);
		//p.draw(g);
		
		Line l = new Line (new Point(180, 30), new Point(220, 300), true);
		//l.draw(g);
		
		Rectangle r = new Rectangle(new Point(300, 350), 70, 140, true);
		r.draw(g);
		
		Circle c = new Circle(new Point(400, 120), 70, true);
		//c.draw(g);
		
		Donut d = new Donut(new Point(600, 300), 100, 70, true);
		d.draw(g);
		
		/*ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		shapes.add(p);
		shapes.add(l);
		shapes.add(r);
		shapes.add(c);
		shapes.add(d);
		
		Iterator<Shape> it = shapes.iterator();
		while (it.hasNext())
			System.out.println("Selected: " + it.next().isSelected());
		
		for (Shape s : shapes) {
			s.draw(g);
		}*/
	}
}
