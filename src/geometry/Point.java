package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		setSelected(selected);
	}
	
	public Point(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		setColor(color);
	}
	
	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			if (this.getX() == p.getX() && this.getY() == p.getY()) {
				return true;				
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 3;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.x - 3, this.y, this.x + 3, this.y);
		g.drawLine(this.x, this.y - 3, this.x, this.y + 3);
		
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getX() - 3, this.getY() - 3, 6, 6);
			
		}
		
	}
	
	
	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y += byY;
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Point) {
			Point start = new Point(0,0);
			return (int) (this.distance(start.getX(), start.getY()) - 
					((Point) o).distance(start.getX(), start.getY()));
		}
		return 0;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	

	
	
}
