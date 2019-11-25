import java.util.ArrayList;

public class School {
	
	private final String name ;
	private ArrayList<Student> students = new ArrayList<>() ;
	public School(final String name) { this.name = name ; }
	
	public String getSchoolName() {return name;}
	public int getStudentCount() {
		return students.size();
	}
	
	public String getString() {
		String str = "";
		for(int i = 0; i < students.size(); i++) {
			str += students.get(i).toString() + "\n";
		}
		return str;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public Student findStudent(String studentName, int year) {
		Student foundStudent = null; 
		for(int i = 0; i < students.size(); i++) {
			if((studentName.equals(students.get(i).getName())) && ( year == students.get(i).getYear()))
				foundStudent = students.get(i);
		}
		return foundStudent;
	}
	
	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}
}