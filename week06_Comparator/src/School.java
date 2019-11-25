import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class School {
	private final String name;
	private List<Student> students = new ArrayList<>();
	private int capacity;

	public School(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}
	public void sortById() {
		Collections.sort(students, Student.IdComparator);
	}
	public void sortByGPA() {
		Collections.sort(students, Student.GpaComparator);
	}
	public void sortByName() {
		Collections.sort(students, Student.NameComparator);
	}
	public void sortByNameGPA() {
		Collections.sort(students, Student.NameGpaComparator);
	}
	public int getCapacity() {return capacity;}
	
	public void add(Student newStudent) {
		students.add(newStudent);
	}
	
	@Override
	public String toString() {
		String str;
		str = "School Name: " + name + "\n";
		for(int i = 0; i < students.size(); i++) {
			str += students.get(i).getId() + ", " +
					students.get(i).getName() + ", " +
					students.get(i).getGpa() + "\n";
		}
		return str;
	}
	
}
