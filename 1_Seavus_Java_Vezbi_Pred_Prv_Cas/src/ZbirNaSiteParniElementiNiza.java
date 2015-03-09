
public class ZbirNaSiteParniElementiNiza {

	public static void main(String[] args) {
		
		int zbirParni=0;
		int[] niza = {1,2,3,4,5,6,7,8,9,10};
		
		for (int i = 0; i < niza.length; i++) {
			
			if(niza[i] % 2 == 0)
			{
				zbirParni+=niza[i];
				
			}
			
		}
		System.out.println("Zbirot na parnite elementi e: "+zbirParni);
		

	}

}
