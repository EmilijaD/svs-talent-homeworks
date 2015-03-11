package workingWithObjects_04;

import java.util.StringTokenizer;

public class DateParser {

	public static void main(String[] args) {
		StringTokenizer st1;

		String quote2 = "12/28/1992";
		st1 = new StringTokenizer(quote2, "/");
		System.out.println("\nToken 1: " + st1.nextToken());
		System.out.println("Token 2: " + st1.nextToken());
		System.out.println("Token 3: " + st1.nextToken());

	}

}
