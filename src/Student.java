import java.util.ArrayList;

public abstract class Student implements Comparable<Student> {
	protected String firstName;
	protected String lastName;
	protected int birthYear;
	static protected  int ID = 0;
	protected int studentID;
	private ArrayList<Integer> grades;
	
	public Student(String fn, String ln, int br) {
		this.firstName = fn;
		this.lastName = ln;
		this.birthYear = br;
		this.studentID = ID;
		ID += 1;
		grades = new ArrayList<Integer>();
		
	}
	public void setGrade(int grade) {
		grades.add(grade);
	}
	public void printGrades() {
		System.out.print("Znamky studenta " + studentID + ": ");
		for (int grade: grades) {
			System.out.print(grade + " ");
		}
		System.out.println();
	}
	public float getAverage() {
		int sum = 0;
		for (int grade : this.grades) {
			sum += grade;
		}
		return (float) sum / grades.size();
	}
	public String toString() {
		return String.format("%d %s %s %d %.3f", this.studentID, this.firstName, this.lastName, this.birthYear, getAverage());
	}
	public int compareTo(Student s) {
		return this.lastName.compareTo(s.lastName);
			
	}

}
