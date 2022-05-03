
public class StudentT extends Student{

	
	public StudentT(String fn, String ln, int br) {
		super(fn, ln, br);
	}
	public boolean prestupnyRok() {
		if (this.birthYear % 100 != 0) {
			return true;
		} else if (this.birthYear % 400 == 0) {
			return true;
		}
		return false;
	}

}
