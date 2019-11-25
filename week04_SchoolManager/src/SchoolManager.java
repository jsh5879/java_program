import java.util.ArrayList;
//import java.util.Iterator;

public class SchoolManager {
	
	private ArrayList<School> schools = new ArrayList<>() ;
	
	public School findSchool(String schoolName) {
		School foundSchool = null;
		for(int i = 0; i < schools.size(); i++){
			if(schoolName.equals(schools.get(i).getSchoolName())) {
				foundSchool = schools.get(i);
			}
		}
		return foundSchool;
	}

	@Override
	public String toString() {
		String str = null;
		str = "Total School Count: " + schools.size() + "\n";
		for(int i = 0; i < schools.size(); i++) {
			str += "School Name: " + schools.get(i).getSchoolName() + " Student Count: "
					+ schools.get(i).getStudentCount() + "\n"
					+ schools.get(i).getString() + "\n";
		}
		return str;
	}

	public School createSchool(String schoolName) {
		School newSchool = new School(schoolName);
		schools.add(newSchool);
		return newSchool;
	}

	public void removeAllSchools() {
		schools.clear();
		/*Iterator <School>iter = schools.iterator();
		while(iter.hasNext()) {
			iter.next();
			iter.remove();
		}*/
	}

	public ArrayList<Student> findStudent(String studentName, int schoolYear) {
		ArrayList<Student> foundStudents = new ArrayList<>();
		Student foundStudent = null;
		for(int i = 0; i < schools.size(); i++) {
			foundStudent = schools.get(i).findStudent(studentName, schoolYear); 
			if( foundStudent != null)
				foundStudents.add(foundStudent);
		}
		return foundStudents;
	}
	
	
	
}