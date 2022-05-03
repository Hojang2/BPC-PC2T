import java.util.Scanner;

public class Main {

	public static int onlyInt(Scanner sc) 
	{
		int number = 0;
		try
		{
			number = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			number = onlyInt(sc);
		}
		return number;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int option;
		boolean run=true;
		Database db = new Database();
		while(run)
		{
			System.out.println("Menu:");
			System.out.println("1 ..  Pridani noveho studenta");
			System.out.println("2 ..  Zadani znamky studentovi");
			System.out.println("3 ..  Propusteni studenta");
			System.out.println("4 ..  Vypis informace o studentovi");
			System.out.println("5 ..  Spusteni dovednosti studenta");
			System.out.println("6 ..  Serazeny seznam studentu podle prijmeni a oboru");
			System.out.println("7 ..  Vypis prumeru studentu");
			System.out.println("8 ..  Vypis celkoveho poctu studentu podle skupin");
			System.out.println("9 ..  Ulozeni databaze do souboru");
			System.out.println("10 .. Nacteni databaze ze souboru");
			System.out.println("11 .. Ulozeni databaze do SQL");
			System.out.println("12 .. Nacteni databaze ze SQL");
			System.out.println("13 .. ukonceni aplikace");
			option=onlyInt(sc);
			switch(option)
			{
				case 1:	
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					run = false;
					break;
			}
			
		}

	}

}
