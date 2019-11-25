import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidRectangleException extends Exception {
	private int width, height ;
	public InvalidRectangleException(int width, int height) {
		this.width = width ; this.height = height ;
	}
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	@Override
	public String toString() {
		return "사각형의 넓이와 높이는 양수이어야 합니다. " + getWidth() + " " + getHeight();
	}
}

public class RectangleManager {
	private ArrayList<MyRectangle> rectangles = new ArrayList<>() ;
	private Scanner scannerObject ;

	public static void main(String[] args) {
		Scanner scannerObject = new Scanner(System.in) ;
		RectangleManager manager = new RectangleManager(scannerObject) ;
		while ( true ) {
			System.out.println("Enter a command: [create width height, zoom id ratio or quit]") ;
			final String command = scannerObject.next() ;
			if ( command.equalsIgnoreCase("create")) { manager.create() ; }
			else if ( command.equalsIgnoreCase("zoom")) { manager.zoom() ; }
			else if ( command.equalsIgnoreCase("showAll")) { manager.showAll() ; }
			else if ( command.equalsIgnoreCase("quit")) { System.out.println("Bye") ; break ; }
		}
	}

	public RectangleManager(Scanner scannerObject) {
		this.scannerObject = scannerObject;
	}
	private void showAll() {
		for(MyRectangle r : rectangles) {
			System.out.println(r);
		}
	}
	private void zoom() {
		try {
			final int index = scannerObject.nextInt();
			final int zoom = scannerObject.nextInt();

			int width = rectangles.get(index).getWidth();
			int height = rectangles.get(index).getWidth();

			rectangles.get(index).setWidth(width*zoom);
			rectangles.get(index).setHeight(height*zoom);

			final int newWidth = rectangles.get(index).getWidth();
			final int newHeight = rectangles.get(index).getHeight();

			System.out.println("Before: Rectangle: wight " + width + ", height " + height);
			System.out.println("After: Rectangle: wight " + newWidth + ", height " + newHeight);
		}catch(Exception e) {
			System.out.println("존재하지 않는 배열의 원소를 접근했습니다." + e);
		}
	}
	private void create() {
		try {
			final int width = scannerObject.nextInt();
			final int height = scannerObject.nextInt();
			if((width <= 0) || (height <= 0) ) throw new InvalidRectangleException(width, height);
			MyRectangle newRectangle = new MyRectangle(width, height);
			rectangles.add(newRectangle);
			System.out.println("Rectangle: width " + newRectangle.getWidth() + ", height " + newRectangle.getHeight() + " is added at " + (rectangles.size()-1));

		}catch(InvalidRectangleException e){
			System.out.println(e);
		}
		catch(InputMismatchException e) {
			System.out.println("입력된 인자의 형식이 맞지 않습니다.");
		}
	}
}
