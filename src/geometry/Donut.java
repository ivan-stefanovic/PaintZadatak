package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
	int innerRadius;
	private Color fillColor;

	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	
	public Donut(Point center, int radius, int innerRadius, Color color, Color fillColor) {
		super(center, radius);
		this.innerRadius = innerRadius;
		setColor(color);
		setFillColor(fillColor);
	}
	
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}
	
	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().distance(x, y);
		return super.contains(x, y) && dFromCenter > this.getInnerRadius();
	}
	
	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
		return super.contains(p) && dFromCenter > this.getInnerRadius();
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut d = (Donut) obj;
			if (this.getCenter().equals(d.getCenter()) &&
					this.getRadius() == d.getRadius() &&
					this.getInnerRadius() == d.getInnerRadius()) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
		
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(getCenter().getX() - getInnerRadius(),
				this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius()*2, this.getInnerRadius()*2);
		super.draw(g);
	}
	
	public void fillDonut(Graphics g) {
		super.fillCircle(g);
		g.setColor(Color.WHITE);
		g.fillOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius,
					2 * innerRadius, 2 * innerRadius);
		
		
}
	
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut)o).area());//PRoveri
		}
		return 0;
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString() {
		return super.toString() + ", inner radius = " + this.getInnerRadius();
	}
	
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}


}
