package languageElementsExcercise_03;

public class InvestmentCalculator {

	public static void main(String[] args) {

		double invesment = 14000.0;
		double procentFirstYear = 0.4;
		double procentThirdYear = 0.12;

		double resultFirstYear = invesment + (invesment * procentFirstYear);
		System.out
				.println("The invesment in the first year will have this value = "
						+ resultFirstYear);

		double resultSecondYear = resultFirstYear - 1500.0;
		System.out
				.println("The invesment in the second year will have this value = "
						+ resultSecondYear);

		double resultThirthYear = resultSecondYear
				+ (resultSecondYear * procentThirdYear);
		System.out
				.println("The invesment in the second year will have this value = "
						+ resultThirthYear);
	}

}
