package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	
	private Point center;
	private int radius;
	private Color fillColor;

	public Circle() {
		
	} 
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}
	
	public Circle(Point center, int radius, Color color, Color fillColor) {
		this(center, radius);
		setColor(color);
		setFillColor(fillColor);
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle c = (Circle) obj;
			if (this.getCenter().equals(c.getCenter()) 
					&& this.getRadius() == c.getRadius()) {
				return true;
			} else {
				return false;
			}			
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		return this.getCenter().distance(x, y) <= this.getRadius();
	}
	
	public boolean contains(Point p) {
		return p.distance(getCenter().getX(), getCenter().getY()) <= radius;
	}
	
	public double area() {
		return radius * radius * Math.PI;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(this.getCenter().getX() - this.getRadius(),
				this.getCenter().getY() - this.getRadius(),
				this.getRadius() * 2, this.getRadius() * 2);
		
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - this.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.getRadius() - 3, 6, 6);
		}
		
	}
	public void fillCircle(Graphics g) {
		if(fillColor == Color.WHITE) {
			g.setColor(new Color(0x00FFFFFF, true));
			g.fillOval(center.getX() - radius + 2, center.getY() - radius + 2, 2 * radius - 3, 2 * radius - 3);
		} else {
			g.setColor(getFillColor());
			g.fillOval(center.getX() - radius + 2, center.getY() - radius + 2, 2 * radius - 3, 2 * radius - 3);
		}
		
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		this.getCenter().moveBy(byX, byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return (this.getRadius() - ((Circle)o).getRadius());
		}
		return 0;
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	
	
	public void setRadius(int radius) throws Exception {
		if (radius >= 0) { 
			this.radius = radius;
		} else {
			throw new NumberFormatException("Radius has to be a value greater than 0");
		}
		
	}
	
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	
	public String toString() {
		return "Center = " + center + ", radius = " + radius; 
	}
	
	


}
