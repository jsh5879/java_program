import java.util.Arrays;

public class School {
	private String name ;
	private int limit ;
	private Student[] students;
	private int studentCount;
	
	public String toString() {
		String msg = "School Name: " + name + " Student Count: "
				+ studentCount + "\n" ;
		for ( int i = 0 ; i < studentCount ; i ++ ) {
			msg += "\t" + students[i] + "\n" ;
		}
		return msg ;
	}
	
	public School(String _name, int _limit) {
		name = _name;
		limit = _limit;
		students = new Student[limit];		
		studentCount = 0;
	}
	
	public void addStudent(Student student) {
		for(int i = 0; i < studentCount; i++) {
			if(students[i].equals(student)) {
				System.out.println("You can't add a same student!");
				return;
			}
		}
		students[studentCount] = student;
		studentCount++;
	}
	
	public Student findStudent(String studentName, int studentYear ) {
		for(int i = 0; i<studentCount; i++) {
			if((students[i].getName()).equals(studentName) &&(students[i].getYear() == studentYear)) {
				return students[i];
			}
		}
		return null;
	}

	public void removeAllStudent() {
		for(int i= 0; i < studentCount; i++) {
			students[i] = null;
		}
		studentCount = 0;
	}

	@Override
	public boolean equals(Object otherSchool) {
		if(!(otherSchool instanceof School)) return false;
		School s = (School) otherSchool;
		return name.equals(s.name) && limit == s.limit && studentCount == s.studentCount
				&& Arrays.equals(students, s.students);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + limit;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + studentCount;
		result = prime * result + Arrays.hashCode(students);
		return result;
	}

}