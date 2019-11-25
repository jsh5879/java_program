package edu.pnu.shape;

public class Circle implements AreaComputable {
	public Circle(Point point, int radius) {
		this.center = point;
		this.radius = radius;
	}
	private Point center ;
	private int radius ;
	
	@Override
	public float getArea() {
		return (float)3.14 *(float)radius * (float)radius;
	}
	public String toString(){
		String msg = "[ Circle [" + center.getX() + ", " + center.getY() + "] " + radius + " " + String.format("%.6f", getArea()) + "]";
		return msg ;
	}

}
