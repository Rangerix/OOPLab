import java.io.*;
public class Main_Hospital {

	public static void main(String[] args) throws Exception {
		
		
		Patient_main pm = new Patient_main();
		int choice;
		boolean flag=true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		
		do
		{
	

			System.out.print("\n\n1. Register a dotor\n");
			System.out.print("2. Admission of Patient\n");
			System.out.print("3. Update Details of an patient\n");
			System.out.print("4. Display the Current Status of the Patient\n");
			System.out.print("5. Release a Patient\n");
			System.out.print("6. Show all patient under a particular doctor\n");
			System.out.print("7. Exit\n");
			System.out.print("\t\tPlease enter your choice:  ");
	
			
			choice = Integer.parseInt(br.readLine());
			
			switch(choice)	
			{
			
				case 1:
						pm.Taking_Doctor_Entry();
						break;
						
				case 2:
						pm.taking_register();;
						break;
					
				case 3:
						pm.update_Details();;
						break;
					
				case 4:
						pm.display_details();
						break;
					
				case 5: 
						pm.Release_A_Patient();;
						break;
						
				case 6:
						pm.show_all_patient_under_one_Doctor();
						break;
	
				
				case 7:
						System.out.println("\n\t\t************Thank You************\n");
						System.exit(0);
						break;
				
				default:
						System.out.println("\nsorry !! Wrong entry.");
						break;
			}

	}while(true);
     }

}
