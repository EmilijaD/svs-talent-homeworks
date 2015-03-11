package logicAndLoops_06;

public class YearlyCalendar {
	
	String [] konecen = new String[13];
	
	int godina =2015;
	static int countDays(int month, int year) {
        int count = -1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    count = 29;
                } else {
                    count = 28;
                }
                if ((year % 100 == 0) & (year % 400 != 0)) {
                    count = 28;
                }
        }
        return count;
    }
	  public  void pecati()
	  { 
		  for (int i = 1; i <= konecen.length; i++) {
			  int daysInMonth = countDays(i, this.godina);
			  for (int j = 1; j <= daysInMonth; j++) {
				  
				             
				  konecen[i]="Mesec "+ i+ " den "+ j +" "+ this.godina+" god.";
				System.out.println(konecen[i]);
				 
			}
			  System.out.println("\n");
			
		}
		  
		
		  
	  }
	

	public static void main(String[] args) {
		YearlyCalendar kal = new YearlyCalendar();
		kal.pecati();

	}

}
