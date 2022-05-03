
public class StudentH extends Student {
	
	protected int birthMonth;
	protected int birthDay;
	public StudentH(String fn, String ln, int br, int bm, int bd) {
		super(fn, ln, br);
		this.birthMonth = bm;
		this.birthDay = bd;
	}
	public String getZodiacSign() {
		if ((this.birthMonth == 3 && this.birthDay >= 21) || (this.birthMonth == 4 && this.birthDay <= 20)){
			return "Aries";
		} else if ((this.birthMonth == 4 && this.birthDay >= 21) || (this.birthMonth == 5 && this.birthDay <= 21)) {
			return "Taurus";
		} else if ((this.birthMonth == 5 && this.birthDay >= 22) || (this.birthMonth == 6 && this.birthDay <= 21)) {
			return "Gemini";
		}else if ((this.birthMonth == 6 && this.birthDay >= 22) || (this.birthMonth == 7 && this.birthDay <= 22)) {
			return "Cancer";
		}else if ((this.birthMonth == 7 && this.birthDay >= 23) || (this.birthMonth == 8 && this.birthDay <= 22)) {
			return "Leo";
		}else if ((this.birthMonth == 8 && this.birthDay >= 23) || (this.birthMonth == 9 && this.birthDay <= 22)) {
			return "Virgo";
		}else if ((this.birthMonth == 9 && this.birthDay >= 23) || (this.birthMonth == 10 && this.birthDay <= 23)) {
			return "Libra";
		}else if ((this.birthMonth == 10 && this.birthDay >= 24) || (this.birthMonth == 11 && this.birthDay <= 22)) {
			return "Scorpius";
		}else if ((this.birthMonth == 11 && this.birthDay >= 23) || (this.birthMonth == 12 && this.birthDay <= 21)) {
			return "Sagittarius";
		}else if ((this.birthMonth == 12 && this.birthDay >= 22) || (this.birthMonth == 1 && this.birthDay <= 20)) {
			return "Capricornus";
		}else if ((this.birthMonth == 4 && this.birthDay >= 21) || (this.birthMonth == 5 && this.birthDay <= 21)) {
			return "Aquarius";
		}else if ((this.birthMonth == 2 && this.birthDay >= 21) || (this.birthMonth == 3 && this.birthDay <= 20)) {
			return "Pisces";
		}
		return "Wrong input";
	}

}
