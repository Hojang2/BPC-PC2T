
public class StudentK extends StudentH {

	public StudentK(String fn, String ln, int br, int bm, int bd) {
		super(fn, ln, br, bm, bd);
	}
	public boolean leapYear() {
		if (this.birthYear % 100 == 0 && this.birthYear % 400 == 0) {
			return true;
		} else if (this.birthYear % 100 != 0 && this.birthYear % 4 == 0) {
			return true;
		}
		return false;
	}
}
