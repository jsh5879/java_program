import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum OperationKind{
	ADDL("ADDL"), ADDC("ADDC"), SORTA("SORTA"), SORTD("SORTD"), CLEAR("CLEAR"), LIST("LIST"), QUIT("QUIT"), INVALID("INVALID");
	
	private String operation;
	
	private OperationKind(final String operation) {this.operation = operation;}
}
enum SortKind{
	ASCENDING, DESCENDING;
}

public class SortInterfaceTest {
	private static Scanner scanner = new Scanner(System.in);
	private static List<MyComparable> comparableList = new ArrayList<>() ;
	public static void main(String[] args) {
		while ( true ) {
			final OperationKind op = getOperation(scanner) ;
			if ( op == OperationKind.QUIT ) {
				System.out.println("Bye") ;
				break;
			}
			if ( op == OperationKind.INVALID ) {
				System.out.println("Invalid Operation!") ;
				continue ;
			}
			switch ( op ) {
			case ADDL : {
				final Line newLine = createLine(scanner) ;
				comparableList.add(newLine);
				System.out.println(newLine) ;
				break ;
			}
			case ADDC : {
				final Circle newCircle = createCircle(scanner) ;
				comparableList.add(newCircle);
				System.out.println(newCircle) ;
				break ;
			}
			case SORTA:
				sortList(comparableList, SortKind.ASCENDING) ;
				break ;
			case SORTD:
				sortList(comparableList, SortKind.DESCENDING) ;
				break ;
			case CLEAR:
				comparableList.clear() ;
				break ;
			case LIST:
				System.out.println(comparableList) ;
				break ;
			default: break;
			}
		}
	}
	

	private static Circle createCircle(Scanner scanner2) {
		final int x = scanner.nextInt();
		final int y = scanner.nextInt();
		final int r = scanner.nextInt();
		
		Circle newCircle = new Circle(x,y,r);
		
		return newCircle;
	}


	private static Line createLine(Scanner scanner) {
		final int x1 = scanner.nextInt();
		final int y1 = scanner.nextInt();
		final int x2 = scanner.nextInt();
		final int y2 = scanner.nextInt();
		
		final Line newLine = new Line(x1,y1,x2,y2);
		
		return newLine;
	}


	private static OperationKind getOperation(Scanner scanner) {
		System.out.print("Enter Operation String! ");
		final String operation = scanner.next();
		OperationKind kind;
		try {
			kind = OperationKind.valueOf(operation.toUpperCase());
		} catch(IllegalArgumentException e) {
			kind = OperationKind.INVALID;
		}
		return kind;
	}
	
	private static void sortList(final List<MyComparable> comparableList, final SortKind sortKind) {
		if(sortKind == SortKind.ASCENDING) {
			for(int i = 0; i < comparableList.size()-1; i++) {
				for(int j = i+1; j < comparableList.size(); j++) {
					if ( comparableList.get(i).compareTo(comparableList.get(j)) > 0) {
						MyComparable temp = comparableList.get(j);
						comparableList.set(j, comparableList.get(i));
						comparableList.set(i, temp);
					}
				}
			}
		}
		else if(sortKind == SortKind.DESCENDING) {
			for(int i = 0; i < comparableList.size()-1; i++) {
				for(int j = i+1; j < comparableList.size(); j++) {
					if ( comparableList.get(i).compareTo(comparableList.get(j)) < 0) {
						MyComparable temp = comparableList.get(j);
						comparableList.set(j, comparableList.get(i));
						comparableList.set(i, temp);
					}
				}
			}
		}
	}
}
