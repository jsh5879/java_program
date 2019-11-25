
public class Rectangle extends Shape {
	private int width, height ;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public float getArea() {
		return (float)(width * height);
	}

	@Override
	public String toString() {
		return "Rectangle " + width + " " + height + " " + getArea();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + height;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Rectangle))
			return false;
		Rectangle other = (Rectangle) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
}
