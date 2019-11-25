class Person {
	private String name ;
	private int age ;
	private String address ;
	public Person(String name, int age, String address) {
		this.name = name ; this.age = age ; this.address = address ;
	}
	public String getName() { return name ; }
	public void rename(String name) { this.name = name ; }
	public int getAge() { return age ; }
	public void increaseAge() { age ++ ; }
	public String getAddress() { return address ; }
	public void moveTo(String address) { this.address = address ; }
	@Override
	public String toString() {
		return String.format("%s, %d, %s", name, age, address) ;
	}
	// override hashCode() and equals()
}