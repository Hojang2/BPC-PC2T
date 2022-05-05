import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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
		try {
		      File myObj = new File(path);
		      ArrayList<String> data = new ArrayList<String>();
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String line = myReader.nextLine();
		        data.add(line);
		      }
		      myReader.close();
		      String[] tmp;
		      for (String line: data) {
					 tmp = line.split(" ");
					 System.out.println();
					 
					 if (tmp[4].equals("T")) {
						 
					 students.add(new StudentT(tmp[1], tmp[2], Integer.parseInt(tmp[3])));
					 } else if (tmp[4].equals("H")) {
						 students.add(new StudentH(tmp[1], tmp[2], Integer.parseInt(tmp[3]), Integer.parseInt(tmp[5]), Integer.parseInt(tmp[6])));
					 } else if (tmp[4].equals("K")) {
						 students.add(new StudentK(tmp[1], tmp[2], Integer.parseInt(tmp[3]), Integer.parseInt(tmp[5]), Integer.parseInt(tmp[6])));
					 }
					 System.out.println(students.get(Student.ID-1));
					 for (int i = 7; i < data.size()-1; i++) {
						 students.get(Student.ID-1).setGrade(Integer.parseInt(tmp[i]));
						 System.out.println(students.get(Student.ID-1));
						 
					 }
				
					
				}
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	public void exportDatabase(String path) {
		try {
		      FileWriter myWriter = new FileWriter(path, false);
		      String messege;
		      for (Student s: students) {
		    	  messege = "";
		    	  if (s instanceof StudentT) {
		    		  	messege = String.format("%d %s %s %d %s %d %d ", s.studentID, s.firstName, s.lastName, s.birthYear, "T", 0, 0);
					} else if (s instanceof StudentK) {
						messege = String.format("%d %s %s %d %s %d %d ", s.studentID, s.firstName, s.lastName, s.birthYear, "K", ((StudentK)s).birthMonth, ((StudentK)s).birthDay);
					} else if (s instanceof StudentH) {
						messege = String.format("%d %s %s %d %s %d %d ", s.studentID, s.firstName, s.lastName, s.birthYear, "H", ((StudentH)s).birthMonth, ((StudentH)s).birthDay);
					}
		    	  for (int grade: s.getGrades()) {
		    		  messege += (grade + " ");
		    	  }
		    	  messege += "\n";
		    	  myWriter.write(messege);
		    	  System.out.println(messege);
		      }
		     
		      
		      myWriter.close();
		      System.out.println("Uspesne byli zapsani vsichni studenti.");
		    } catch (IOException e) {
		      System.out.println("Nastala chyba s ukladanim souboru.");
		      e.printStackTrace();
		    }
	}
}