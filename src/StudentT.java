
public class StudentT extends Student{

	
	public StudentT(String fn, String ln, int br) {
		super(fn, ln, br);
	}
	
	public boolean leapYear() {
		if (this.birthYear % 100 == 0 && this.birthYear % 400 == 0) {
			return true;
		} else if (this.birthYear % 100 != 0 && this.birthYear % 4 == 0) {
			return true;
		}
		return false;
	}
	
	
	public static boolean leapYear(int year) {
		if (year % 100 == 0 && year % 400 == 0) {
			return true;
		} else if (year % 100 != 0 && year % 4 == 0) {
			return true;
		}
		return false;
	}

}
