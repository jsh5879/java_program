// Student.java
public class Student {

	private String name ;
	private int year ;
	
	public Student(String studentName, int schoolYear) {
		name = studentName;
		year = schoolYear;
	}
	
	public String getName() {return name;}
	public int getYear() {return year;}
	
	public String toString() {
		String msg = "[" + name + ", " + year + "ÇÐ³â]";
		return msg;
	}
	
	@Override
	public boolean equals(Object otherStudent) {
		if(!(otherStudent instanceof Student)) return false;
		Student s = (Student) otherStudent;
		return this.name.equals(s.name) && this.year == s.year;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year;
		return result;
	}
}