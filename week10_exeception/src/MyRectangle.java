
public class MyRectangle {
	private int width, height ;

	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Rectangle: width " + width + ", height " + height;
	}
	public MyRectangle(int width, int height) {

		this.width = width;
		this.height = height;
	}
}
