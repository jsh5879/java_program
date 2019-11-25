import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeManagerTest {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Shape> shape = new ArrayList<>(); 

	public static void main(String[] args) {
		while(true) {
			final String operation = getOperation();
			String kind;
			int count = 0;

			if(operation.equals("QUIT")) {
				System.out.println("Bye");
				break;
			}
			switch(operation) {
			case "ADD":{
				kind = scanner.next().toUpperCase();
				if(kind.equals("T")) {
					Triangle t = createTriangle();
					shape.add(t);
					System.out.println(t);
				}
				else if(kind.equals("C")) {
					Circle c = createCircle();
					shape.add(c);
					System.out.println(c);
				}
				else if(kind.equals("R")) {
					Rectangle r = createRectangle();
					shape.add(r);
					System.out.println(r);
				}
				else {
					System.out.println("Invalid Operation!");
				}
				break;
			}
			case "PRINTALL":{
				if(shape.size() == 0) System.out.println("NONE");
				else {
					for( Shape s : shape) {
						System.out.println(s);
					}
				}
				break;
			}
			case "PRINT":{
				kind = scanner.next().toUpperCase();
				count = 0;
				if(kind.equals("T")) {
					for( Shape s: shape) {
						if(s instanceof Triangle) {
							System.out.println(s);
							count++;
						}
					}
					if(count == 0) System.out.println("NONE");
				}
				else if(kind.equals("C")) {
					for( Shape s: shape) {
						if(s instanceof Circle) {
							System.out.println(s);
							count++;
						}
					}
					if(count == 0) System.out.println("NONE");
				}
				else if(kind.equals("R")) {
					for( Shape s: shape) {
						if(s instanceof Rectangle) {
							System.out.println(s);
							count++;
						}
					}
					if(count == 0) System.out.println("NONE");
				}
				else System.out.println("Invalid Operation!");
				break;
			}
			case "REMOVEALL":{
				System.out.println(shape.size());
				shape.clear();
				break;
			}
			case "TOTALAREA":{
				float totalArea = 0;
				for(Shape s:shape) {
					totalArea += s.getArea();
				}
				System.out.println(totalArea);
				break;
			}
			default:
				System.out.println("Invalid Operation!");
				break;
			}
		}
	}

	private static Rectangle createRectangle() {
		final int width = scanner.nextInt();
		final int height = scanner.nextInt();
		Rectangle r = new Rectangle(width, height);
		return r;
	}

	private static Circle createCircle() {
		final int x = scanner.nextInt();
		final int y = scanner.nextInt();
		final int radius = scanner.nextInt();
		Circle c = new Circle(x, y, radius);
		return c;
	}

	private static Triangle createTriangle() {
		final int width = scanner.nextInt();
		final int height = scanner.nextInt();
		Triangle t = new Triangle(width, height);
		return t;
	}

	private static String getOperation() {
		System.out.print("Enter Operation String! ");
		final String operation = scanner.next().toUpperCase();
		return operation;
	}

}
