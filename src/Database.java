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
			option = Main.onlyInt(sc);
			switch(option) {
				case 1:
					students.add(new StudentT(firstName, lastName, birthYear));
					run = false;
					break;
				default:
					if (option == 2 || option == 3) {
						System.out.print("Zadej cislovkou den narozeni:");
						int birthDay = Main.onlyInt(sc);
					
						System.out.print("Zadej mesic narozeni:");
						int birthMonth = Main.onlyInt(sc);
						if (option == 2) {
							students.add(new StudentH(firstName, lastName, birthYear, birthMonth, birthDay));
						} else if (option == 3) {
							students.add(new StudentK(firstName, lastName, birthYear, birthMonth, birthDay));
						}
						
						run = false;
						break;
					}
			}
		}
	}
	public void printStudents() {
		for (Student i: students) {
			System.out.println(i.ID);
		}
	}
}