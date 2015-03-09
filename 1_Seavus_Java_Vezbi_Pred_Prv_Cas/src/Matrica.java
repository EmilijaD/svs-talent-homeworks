import java.util.Scanner;


public class Matrica {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		 int[][] matrica = new int [3][3];
		 int zbir =0;
		 
		 for (int i =0; i< matrica.length; i++){
			 for(int j = 0; j<matrica.length; j++){
				 System.out.print(" a["+ i+"]["+j+"] =");
				 matrica[i][j]=scanner.nextInt();
			 }}
		 
		 for (int i =0; i< matrica.length; i++){
			 for(int j = 0; j<matrica.length; j++)
			 {
				 if (i==j)
				 {
					 zbir+=matrica[i][j];
				 }
			 }
		 }
   System.out.println("Zbirot na elementite na dijagonalata e: "+ zbir);
	}

		
		
		

	}


