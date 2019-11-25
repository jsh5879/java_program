public class Student {

	private final String name ;
	private int year ;
	private final School theSchool ;
	
	public Student(School theSchool, String studentName, int schoolYear) {
		this.name = studentName;
		this.year = schoolYear;
		this.theSchool = theSchool;
	}

	public String getName() { return name; }
	
	public int getYear() { return year; }

	@Override
	public String toString() {
		return "[Name=: " + name + ", School:" + theSchool + ", " + year +"ÇÐ³â]";
	}

	
}
