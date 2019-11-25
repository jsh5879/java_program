
public abstract class Shape {
	private int lineColor ;
	
	public int getLineColor() { return lineColor ; }
	public void setLineColor(int color) { lineColor = color ; }
	
	public abstract float getArea();
	
	@Override
	public String toString() {
		return "Shape [lineColor=" + lineColor + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lineColor;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Shape))
			return false;
		Shape other = (Shape) obj;
		if (lineColor != other.lineColor)
			return false;
		return true;
	}
}

