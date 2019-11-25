import java.util.Scanner;
import java.util.ArrayList;

enum OperationKind {
	ADD("ADD"), FIND("FIND"), CLEAR("CLEAR"), LIST("LIST"), QUIT("QUIT"), INVALID("INVALID");

	private String operation;

	private OperationKind(final String operation) {
		this.operation = operation;
	}
}

public class SchoolManagerTest {
	private static SchoolManager schoolManager = new SchoolManager();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		while (true) {
			final OperationKind operation = getOperation();

			if (operation == OperationKind.QUIT) {
				System.out.println("Bye");
				break;
			}
			if (operation == OperationKind.INVALID) {
				System.out.println("Invalid Operation!");
				continue;
			}

			switch (operation) {
			case ADD: {
				Student student = createStudent();
				System.out.println(student);
				break;
			}
			case FIND:
				findStudent();
				break;
			case CLEAR:
				schoolManager.removeAllSchools();
				break;
			case LIST:
				System.out.println(schoolManager);
				break;
			default:
				break;
			}
		}
	}

	private static OperationKind getOperation() {
		System.out.print("Enter Operation String! ");
		final String operation = scanner.next();

		OperationKind kind;
		try {
			kind = OperationKind.valueOf(operation.toUpperCase());
		} catch (IllegalArgumentException e) {
			kind = OperationKind.INVALID;
		}
		return kind;
	}

	private static Student createStudent() {
		final String schoolName = scanner.next();
		final String studentName = scanner.next();
		final int schoolYear = scanner.nextInt();

		School theSchool = schoolManager.findSchool(schoolName);

		if (theSchool == null)
			theSchool = schoolManager.createSchool(schoolName);

		final Student student = new Student(theSchool, studentName, schoolYear);
		theSchool.addStudent(student);

		return student;
	}

	private static void findStudent() {
		final String studentName = scanner.next();
		final int schoolYear = scanner.nextInt();
		final ArrayList<Student> foundStudents = schoolManager.findStudent(studentName, schoolYear);

		if (foundStudents.size() > 0) {
			System.out.println(foundStudents.size() + " found");
			for (Student student : foundStudents) {
				System.out.println(student);
			}
		} else
			System.out.println("No Student Found with name " + studentName + " and year " + schoolYear);
	}
}