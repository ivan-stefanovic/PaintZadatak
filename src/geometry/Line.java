package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	
	private Point startPoint;
	private Point endPoint;
	
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this (startPoint, endPoint);
		setSelected(selected);
		/*
		super (selected);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		*/
	}
	
	public Line(Point startPoint, Point endPoint, Color color) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		setColor(color);
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line l = (Line) obj;
			if (this.getStartPoint().equals(l.getStartPoint()) && 
					this.getEndPoint().equals(l.getEndPoint())) {
				return true;
			} else {
				return false;
			}			
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		return this.getStartPoint().distance(x, y) +
				this.getEndPoint().distance(x, y) - this.length() <= 0.05;
	}
	
	
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(),
				this.getEndPoint().getX(), this.getEndPoint().getY());
		
		if (isSelected())  {
			g.setColor(Color.BLUE);
			g.drawRect(this.getStartPoint().getX() - 3, this.getStartPoint().getY() - 3, 6, 6);
			g.drawRect(this.getEndPoint().getX() - 3, this.getEndPoint().getY() - 3, 6, 6);
			g.drawRect(middleOfLine().getX() - 3, middleOfLine().getY() - 3, 6, 6);
		}
	}
	
	public Point middleOfLine() {
		int middleByX = (this.getStartPoint().getX() + this.getEndPoint().getX()) / 2;
		int middleByY = (this.getStartPoint().getY() + this.getEndPoint().getY()) / 2;
		Point p = new Point (middleByX, middleByY);
		return p;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		this.getStartPoint().moveBy(byX, byY);
		this.getEndPoint().moveBy(byX, byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Line) {
			return (int) (this.length() - ((Line)o).length());
			
		}
		return 0;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public String toString() {
		return "lenght: " + this.length();
	}

	
	

	
	
}
