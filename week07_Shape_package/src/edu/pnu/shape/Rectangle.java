package edu.pnu.shape;

public class Rectangle implements AreaComputable {
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	private int width, height ;

	@Override
	public float getArea() {
		return (float)(width * height);
	}
	public String toString(){
		String msg = "[ Rectangle " + width + ", " + height + " " + String.format("%.6f", getArea()) + "]";
		return msg ;
	}
}
