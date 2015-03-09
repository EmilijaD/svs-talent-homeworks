
public class Nizi {

	public static void main(String[] args) {
		double A[] = {6,9,5.6,48};
		double B[] = {2.3,4.8,5.6,1.9};
		boolean total;
		boolean C[]=  new boolean [A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				
				C[i]=A[i]==B[i];
				System.out.println(C[i]);
			} 
			
		}
         total= C[0]&& C[1]&& C[2] || C[3];
         System.out.println("Total = "+ total);
	}

}
