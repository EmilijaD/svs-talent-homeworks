package classOrganizationAndAccessControl_08;

public class ZipCode {

	long zipCode;
	public boolean check (long zip)
	{
		if (String.valueOf(zip).length()==5 || String.valueOf(zip).length()==9)
			return true;
		return false;
	}
	
	public ZipCode(long zipCode) {
		if  (check(zipCode))
		{
		this.zipCode=zipCode;
		}else{
			System.out.println("Error!");
		}
	}
     

	public static void main(String[] args) {
	ZipCode kod = new ZipCode(987688887);
	}

}
