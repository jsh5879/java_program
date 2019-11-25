public class Circle implements MyComparable {
	private final Point center;
	private final int radius ;
	
	public Circle(int x, int y, int r) {
		center = new Point(x, y);
		radius = r;
	}

	public String toString() {
		return "[" + center.toString() + " " + radius + " " + getSize() + "]";
	}

	@Override
	public int compareTo(MyComparable other) {
		int flag = 0;
		if(getSize() > other.getSize()) flag = 1;
		else if (getSize() == other.getSize()) flag = 0;
		else if( getSize() < other.getSize()) flag = -1;
		return flag;
	}

	@Override
	public long getSize() {
		return (long)Math.round((radius * radius * Math.PI));
	}
}