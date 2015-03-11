
public class ZipCode {

	private long value;
	
	
	
	
	public ZipCode(long value) {
		super();
		if ((value <= 99999 && value > 9999) || ( value <= 99999999 && value >9999999 ))
		{this.value = value;}
		else{
			System.out.println("greska");
		}
	}




	public static void main(String[] args) {
		ZipCode zipKod = new ZipCode(76599);

	}

}

public class Numbers1 {

	public static int numWord(String broj) {
		

			switch (broj) {
			case "zero":
		          return 0;
			case "one":
			     return 1;
			case "two":
			     return 2;
			case "three":
			     return 3;
			case "four":
			     return 4;
			
			case "five":
			     return 5;
			
			case "six":
			     return 6;
				
			case "seven":
			     return 7;
			
			case "eight":
			     return 8;
			
			case "nine":
			     return 9;
		
			case "ten":
			     return 10;
			
			default:
				System.out.println("Nema vneseno broj");
			}
		
			return 0;
			
		}
	

	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Enter a number from 0 to 10");
		//
		// String broj = scanner.nextLine();
		String[] niza = { "one","five","zero" };
		for (int j = 0; j < niza.length; j++) {
			System.out.println(numWord(niza[j]));
		}
		

	}

}
