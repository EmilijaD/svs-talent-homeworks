
public class RasteckaNizaProverka {

	public static void main(String[] args) {
		
		int[] niza = {1,2,3,4,5};
		
		int br=1;
		for (int i = 0; i < niza.length-1; i++) {
			
			if (niza[i+1] > niza [i])
			{
				br++;
			}
		}
		
		if (br == niza.length)
		{
			System.out.println("Rastecka");
		}else{
			System.out.println("Ne e rastecka");
		}
		
		

	}

}
