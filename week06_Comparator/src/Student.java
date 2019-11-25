import java.util.Comparator;

public class Student {
	private final int id;
	private String name;
	private double gpa;
	
	public Student(int id, String name, double gpa) {
		double round;
		this.id = id;
		this.name = name;
		round = Math.round(gpa*100);
		this.gpa = round/100.0;
	}

	public int getId() {return id;}
	public String getName() {return name;}
	public double getGpa() {return gpa;}
	
	public static Comparator<Student> IdComparator = new Comparator<Student>() {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.getId() - s2.getId();
		}
	};
	
	public static Comparator<Student> GpaComparator = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			if(s1.getGpa() - s2.getGpa() > 0) {
				return 1;
			}
			else if( s1.getGpa() - s2.getGpa() == 0) {
				return 0;
			}
			else
				return -1;
		}
	};
	
	public static Comparator<Student> NameComparator = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			return s1.getName().compareTo(s2.getName());
		}
	};

	public static Comparator<Student> NameGpaComparator = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			if(s1.getName().equals(s2.getName())) {
				if(s1.getGpa() - s2.getGpa() > 0) {
					return 1;
				}
				else if( s1.getGpa() - s2.getGpa() == 0) {
					return 0;
				}
				else
					return -1;
			}
			else return s1.getName().compareTo(s2.getName());
		}
	};
}