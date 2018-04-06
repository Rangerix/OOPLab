import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Main_QUOTE {

	public static int Time_stamp()
	{
		Date dNow = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dNow);
		int total_seconds = calendar.get(Calendar.HOUR_OF_DAY)*3600+calendar.get(Calendar.MINUTE)*60+calendar.get(Calendar.SECOND);

		return total_seconds;
	}
	
	
	
	public static void PRINT_TIME()
	{
		Date dNow = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dNow);

		System.out.println("\n\t\tTime is: " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + "\n");
		
	}
	
	
	
	public static int randInt(int min, int max) {
		Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public static int time_now()
	{
		Date dNow = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dNow);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public static void main(String[] args) {
		
	
		
		if(time_now()>=6 && time_now()<18)
		{
			Quotes_For_Morning qm = new Quotes_For_Morning();
			qm.Initialize_Quotes_And_Time();
			
			do
			{
				int n = randInt(0,7);
				
				if(qm.Time.get(n)==0)
				{
					System.out.println(qm.Quotes.get(n));
					qm.Time.set(n,Time_stamp());
					PRINT_TIME();
				}
				
				else if (Time_stamp()-qm.Time.get(n)>60)
				{
					System.out.println(qm.Quotes.get(n));
					System.out.println(Time_stamp()-qm.Time.get(n));
					qm.Time.set(n,Time_stamp());
					PRINT_TIME();
				}
				else
					continue;
				
				try {
				    Thread.sleep(5000);                 
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				
			}while(true);
		
		}
		
		else
		{
			Quotes_For_Night qm = new Quotes_For_Night();
			qm.Initialize_Quotes_And_Time();
			
			do
			{
				int n = randInt(0,35);
				
				if(qm.Time.get(n)==0)
				{
					System.out.println(qm.Quotes.get(n));
					qm.Time.set(n,Time_stamp());
					PRINT_TIME();
				}
				
				else if (Time_stamp()-qm.Time.get(n)>60)
				{
					System.out.println(qm.Quotes.get(n));
					qm.Time.set(n,Time_stamp());
					PRINT_TIME();
				}
				else
					continue;
				
				
				
				try {
				    Thread.sleep(5000);                 
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				
				
			}while(true);
		}
	}

}
