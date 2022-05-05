import java.util.ArrayList;
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
				if(StudentT.prestupnyRok(year)) {
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
	
	
	public void printStudents() {
		for (Student i: students) {
			System.out.println(String.format("%d %s %s %d", i.studentID, i.firstName, i.lastName, i.birthYear));
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
}