import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Database {
	Scanner sc=new Scanner(System.in);
	ArrayList<Student> students;
	int option;
	
	public Database() {
		students = new ArrayList<Student>();
		
	}
	public void addStudent() {
		System.out.print("Zadej jmeno:");
		String firstName = sc.next();
		System.out.print("Zadej prijmeni:");
		String lastName = sc.next();
		System.out.print("Zadej rok narozeni:");
		int birthYear = Main.onlyInt(sc);
		boolean run = true;
		while(run) {
			System.out.println("Typ studenta:");
			System.out.println("1 .. Technickeho oboru");
			System.out.println("2 .. Humanitniho oboru");
			System.out.println("3 .. Kombinovaneho studia");
			System.out.print("Volba:");
			option = Main.onlyInt(sc);
			switch(option) {
				case 1:
					students.add(new StudentT(firstName, lastName, birthYear));
					run = false;
					break;
				default:
					if (option == 2 || option == 3) {
						
						System.out.print("Zadej mesic narozeni:");
						int birthMonth = checkMonth(sc);
						
						System.out.print("Zadej cislovkou den narozeni:");
						int birthDay = checkDay(sc, birthMonth, birthYear);		
						
						if (option == 2) {
							students.add(new StudentH(firstName, lastName, birthYear, birthMonth, birthDay));
						} else if (option == 3) {
							students.add(new StudentK(firstName, lastName, birthYear, birthMonth, birthDay));
						}
						
						run = false;
						break;
					}
			}
			System.out.println(String.format("Student typu:%d s ID:%d byl pridan" , option, (Student.ID - 1)));
		}
	}
	
	public static int checkMonth(Scanner sc) {
			int number = 0;
			try
			{
				number = sc.nextInt();
				if (number < 1 || number > 12) {
					System.out.print("Spatna hodnota mesice, zadej mesic znova:");
					number = checkMonth(sc);
				}
					
			}
			catch(Exception e)
			{
				System.out.println("Nastala vyjimka typu "+e.toString());
				System.out.println("zadejte prosim cele cislo ");
				sc.nextLine();
				number = checkMonth(sc);
			}
			return number;
	}
	public static int checkDay(Scanner sc, int month, int year) {
		int maxDays = 0;
		int number = 0;
		try{
			number = sc.nextInt();
			switch(month) {
			case 1:
				maxDays = 31;
				break;
			case 2:
				if(StudentT.leapYear(year)) {
					System.out.println("Prestupny");
					maxDays = 29;
				} else {
					maxDays = 28;
				}
				break;
			case 3:
				maxDays = 31;
				break;
			case 4:
				maxDays = 30;
				break;
			case 5:
				maxDays = 31;
				break;
			case 6:
				maxDays = 30;
				break;
			case 7:
				maxDays = 31;
				break;
			case 8:
				maxDays = 31;
				break;
			case 9:
				maxDays = 30;
				break;
			case 10:
				maxDays = 31;
				break;
			case 11:
				maxDays = 30;
				break;
			case 12:
				maxDays = 31;
				break;
			}
			if (number < 1 || number > maxDays) {
				System.out.println("Spatna hodnota Dne, tento mesic nema tolik dni");
				System.out.print("Zadej den znova:");
				number = checkDay(sc, month, year);
			}		
		} catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			number = checkMonth(sc);
		}
		return number;
		
		
	}
	public static int checkGrade(Scanner sc) {
			int number = 0;
			try
			{
				number = sc.nextInt();
				if (number < 1 || number > 5) {
					System.out.print("Spatna hodnota znamky, zadej znamku znova:");
					number = checkGrade(sc);
				}
					
			}
			catch(Exception e)
			{
				System.out.println("Nastala vyjimka typu "+e.toString());
				System.out.println("zadejte prosim cele cislo ");
				sc.nextLine();
				number = checkGrade(sc);
			}
			return number;
	}
	
	
	public static void printStudents(ArrayList<Student> students) {
		for (Student i: students) {
			System.out.println(i);
		}
	}
	
	public Student getStudent(int id) {
		for (Student s: students) {
			if(s.studentID == id) {
				return s;
			}
		}
		return null;
	}
	public void addGrade() {
		System.out.print("Zadej ID studenta:");
		int id = Main.onlyInt(sc);
		Student s = getStudent(id);
		if (s != null) {
			System.out.print("Zadej znamku:");
			int grade = checkGrade(sc);
			s.setGrade(grade);
			s.printGrades();
			
		} else {
			System.out.println("Student podle ID nenalezen");
		}	
	}
	public void deleteStudent() {
		System.out.print("Zadej ID studenta:");
		int id = Main.onlyInt(sc);
		Student s = getStudent(id);
		if (s != null) {
			students.remove(s);
			
			System.out.println(String.format("Student s ID:%d byl smazan" , id));
		}
		else {
			System.out.println("Student podle ID nenalezen");
		}
		
	}
	public void printStudent() {
		System.out.print("Zadej ID studenta:");
		int id = Main.onlyInt(sc);
		Student s = getStudent(id);
		if (s != null) {
			System.out.println(s);
		}
		else {
			System.out.println("Student podle ID nenalezen");
		}
	}
	public void activateAbility() {
		System.out.print("Zadej ID studenta:");
		int id = Main.onlyInt(sc);
		Student s = getStudent(id);
		if (s != null) {
			if (s instanceof StudentT)
			{
				System.out.println("Prestupny rok: " + ((StudentT)s).leapYear());
			} else if (s instanceof StudentK) {
				System.out.println("Prestupny rok: " + ((StudentK)s).leapYear());
				System.out.println("Znameni: " + ((StudentK)s).getZodiacSign());
			}
			else if (s instanceof StudentH) {
				System.out.println("Znameni: " + ((StudentH)s).getZodiacSign());
			
			}
		}
		else {
			System.out.println("Student podle ID nenalezen");
		}
	}
	public void sortStudents() {
		ArrayList<Student> studentsT = new ArrayList<Student>();
		ArrayList<Student> studentsH = new ArrayList<Student>();
		ArrayList<Student> studentsK = new ArrayList<Student>();
		
		for (Student s: students) {
			if (s instanceof StudentT) {
				studentsT.add((StudentT) s);
			} else if (s instanceof StudentK) {
				studentsK.add((StudentK) s);
			} else if (s instanceof StudentH) {
				studentsH.add((StudentH) s);
			}
		}
		Collections.sort(studentsT);
		Collections.sort(studentsH);
		Collections.sort(studentsK);
		
		System.out.println("Studenti technickeho oboru:");
		Database.printStudents(studentsT);
		System.out.println("Studenti humanitniho oboru:");
		Database.printStudents(studentsH);
		System.out.println("Studenti kombinovaneho studia:");
		Database.printStudents(studentsK);
	}
	public float getStudyAverage(ArrayList<Student> students) {
		float sum = 0f;
		for (Student s: students) {
			sum += s.getAverage();
		}
		return sum / students.size();
	}
	public void printStudyAverage() {
		ArrayList<Student> studentsT = new ArrayList<Student>();
		ArrayList<Student> studentsH = new ArrayList<Student>();
		ArrayList<Student> studentsK = new ArrayList<Student>();
		
		for (Student s: students) {
			if (s instanceof StudentT) {
				studentsT.add((StudentT) s);
			} else if (s instanceof StudentK) {
				studentsK.add((StudentK) s);
			} else if (s instanceof StudentH) {
				studentsH.add((StudentH) s);
			}
		}
		System.out.println("Prumer studentu technickeho oboru:    " + getStudyAverage(studentsT));
		System.out.println("Prumer studentu humanitniho oboru:    " + getStudyAverage(studentsH));
		System.out.println("Prumer studentu kombinovaneho studia: " + getStudyAverage(studentsK));
	}
	public void numberOfStudents() {
		ArrayList<Student> studentsT = new ArrayList<Student>();
		ArrayList<Student> studentsH = new ArrayList<Student>();
		ArrayList<Student> studentsK = new ArrayList<Student>();
		
		for (Student s: students) {
			if (s instanceof StudentT) {
				studentsT.add((StudentT) s);
			} else if (s instanceof StudentK) {
				studentsK.add((StudentK) s);
			} else if (s instanceof StudentH) {
				studentsH.add((StudentH) s);
			}
		}
		System.out.println("Pocet studentu technickeho oboru:    " + studentsT.size());
		System.out.println("Pocet studentu humanitniho oboru:    " + studentsH.size());
		System.out.println("Pocet studentu kombinovaneho studia: " + studentsK.size());
	}
	public void importDatabase(String path) {
		
	}
	public void exportDatabase(String path) {
		
	}
}