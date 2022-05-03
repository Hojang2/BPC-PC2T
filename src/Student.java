
public class Student {
	protected String firstName;
	protected String lastName;
	protected int birthYear;
	static protected  int ID = 0;
	protected int studentID;
	protected int[] grades;
	
	public Student(String fn, String ln, int br) {
		this.firstName = fn;
		this.lastName = ln;
		this.birthYear = br;
		this.studentID = ID;
		ID += 1;
		
	}

}
