
public class Line implements MyComparable {
	private final Point point1, point2 ;

	public Line(int x1, int y1, int x2, int y2) {
		point1 = new Point(x1, y1);
		point2 = new Point(x2, y2);
		
	}

	@Override
	public String toString() {
		return "[" + point1.toString() + " " + point2.toString() + " " + getSize() + "]";
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
		double abs1 = Math.abs((double)point1.getX() - (double)point2.getX());
		double abs2 = Math.abs((double)point1.getY() - (double)point2.getY());
				
		return (long)Math.round(Math.sqrt(Math.pow(abs1, 2.0) + Math.pow(abs2, 2.0)));
	}
}
