public class Point {
	private final int x, y ;
	
	public Point(int _x, int _y) {
		x = _x;
		y = _y;
	}
	public int getX() {return x;}
	public int getY() {return y;}
	
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

}
