package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeftPoint;
	private int height;
	private int width;
	private int n;
	private Color fillColor;
	

	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width) {
		this.upperLeftPoint = upperLeftPoint;
		setHeight(height);
		setWidth(width);
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected) {
		this(upperLeftPoint, height, width);
		setSelected(selected);
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, Color color, Color fillColor) {
		this.upperLeftPoint = upperLeftPoint;
		setHeight(height);
		setWidth(width);
		setColor(color);
		setFillColor(fillColor);
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, int n, boolean selected) {
		this(upperLeftPoint, height, width);
		setSelected(selected);
		this.n = n;
	}
	

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle r = (Rectangle) obj;
			if (this.getUpperLeftPoint().equals(r.getUpperLeftPoint()) &&
					this.getHeight() == r.getHeight() && this.getWidth() == r.getWidth()) { 
				return true;
			} else {
				return false;
			}			
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		if (this.getUpperLeftPoint().getX() <= x &&
				this.getUpperLeftPoint().getY() <= y &&
				x <= this.getUpperLeftPoint().getX() + width &&
				y <= this.getUpperLeftPoint().getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(Point p) {
		if (this.getUpperLeftPoint().getX() <= p.getX() &&
				this.getUpperLeftPoint().getY() <= p.getY() &&
				p.getX() <= this.getUpperLeftPoint().getX() + width &&
				p.getY() <= this.getUpperLeftPoint().getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	public int area() {
		return height * width;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(this.getUpperLeftPoint().getX(),
				this.getUpperLeftPoint().getY(),
				this.getWidth(), this.getHeight());
		
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getUpperLeftPoint().getX() - 3, this.getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() + this.width - 3, this.getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() - 3, this.getUpperLeftPoint().getY() + this.height - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() + this.width - 3, this.getUpperLeftPoint().getY() + this.height - 3, 6, 6);
		}
		
	}
	public void fillRectangle(Graphics g) {
		if(fillColor == Color.WHITE) {
			g.setColor(new Color(0x00FFFFFF, true));
			g.fillRect(upperLeftPoint.getX() + 2, upperLeftPoint.getY() + 2, width - 3, height- 3);
		}else {
			g.setColor(getFillColor());
			g.fillRect(upperLeftPoint.getX() + 2, upperLeftPoint.getY() + 2, width - 3, height- 3);
			
		}
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.upperLeftPoint.moveBy(byX, byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return (this.area() - ((Rectangle) o).area());
			
		}
		return 0;
	}
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	
	public String toString() {
		return "Upper left point = " + upperLeftPoint + ", height = " + height + ", width = " + width;
	}


	
	
	
	
	
	
}
