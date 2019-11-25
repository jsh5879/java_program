public class Circle extends Shape {
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	private int x;
	private int y;
	private int radius ;
	
	@Override
	public float getArea() {
		return (float)3.141592 *(float)radius * (float)radius;
	}

	@Override
	public String toString() {
		return "Circle " + x + " " + y + " " + radius + " " +getArea();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + radius;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Circle))
			return false;
		Circle other = (Circle) obj;
		if (radius != other.radius)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}