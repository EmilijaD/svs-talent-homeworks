
public class ZipCode {

	long zipCode;
	public boolean check (long zip)
	{
		if (String.valueOf(zip).length()==5 || String.valueOf(zip).length()==9)
			{return true;}
		else{
		return false;
		}
	}
	
	public ZipCode(long zipCode) throws ZipCodeException{
		
		if  (check(zipCode))
		{
		this.zipCode=zipCode;
		}else{
			
			throw new ZipCodeException("");
		}
	}
     

	public static void main(String[] args) throws ZipCodeException {
	ZipCode kod = new ZipCode(0);

}}
