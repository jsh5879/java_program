public class ComparatorTest {
	public static void main(String[] args) {
		final School pnu = new School("PNU", 10);
		for ( int i=0; i < pnu.getCapacity(); i ++ ) {
			final Student newStudent = new Student(i, "Name" + (i % 3), Math.random());
			pnu.add(newStudent);
		}
		System.out.println(pnu);
		System.out.println("[Sorted by GPA]");
		pnu.sortByGPA();
		System.out.println(pnu);
		System.out.println("[Sorted by ID]");
		pnu.sortById();
		System.out.println(pnu);
		System.out.println("[Sorted by Name]");
		pnu.sortByName();
		System.out.println(pnu);
		System.out.println("[Sorted by Name and GPA]");
		pnu.sortByNameGPA();
		System.out.println(pnu);
	}
}