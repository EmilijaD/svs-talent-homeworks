# svs-talent-homeworks
All the homework project from Seavus
import java.util.Scanner;

public class Numbers {

	public static void numWord(String[] broj) {
		for (int i = 0; i < broj.length; i++) {

			switch (broj[i]) {
			case "zero":
				System.out.println("0");
				break;
			case "one":
				System.out.println("1");
				break;
			case "two":
				System.out.println("2");
				break;
			case "three":
				System.out.println("3");
				break;
			case "four":
				System.out.println("4");
				break;
			case "five":
				System.out.println("5");
				break;
			case "six":
				System.out.println("6");
				break;
			case "seven":
				System.out.println("7");
				break;
			case "eight":
				System.out.println("8");
				break;
			case "nine":
				System.out.println("9");
				break;
			case "ten":
				System.out.println("10");
				break;
			default:
				System.out.println("Nema vneseno broj");
			}
		}
	}

	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Enter a number from 0 to 10");
		//
		// String broj = scanner.nextLine();
		String[] niza = { "one", "five", "zero" };
		numWord(niza);

	}

}
