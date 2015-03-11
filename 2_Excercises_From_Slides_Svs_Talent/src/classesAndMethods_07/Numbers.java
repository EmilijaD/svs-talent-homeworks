package classesAndMethods_07;

public class Numbers {

	public static int numConvertor(String num) {
		switch (num) {
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
			System.out.println("Error! Only numbers from 0 to 10");
			break;
		}
		return 0;
	}

	public static void main(String[] args) {

		String[] numbers = { "one", "five", "zero" };
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numConvertor(numbers[i]));
		}

	}

}
