import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;;

public class Patient_Class {
	
	BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));

	String name;
	String patient_id;
	String register_date;
	String doctor_id;
	int age;

	float BP;
	float Temperature;
	int Pulse_Rate;
	String time_of_checking; 
	float weight;
	
	ArrayList<Object> Patient_Conditions = new ArrayList<Object>();
	ArrayList<Object> Patient_Details = new ArrayList<Object>();
	
	
	
	public ArrayList<Object> Initialization(String pd,String Doc_id) throws Exception
	{
		System.out.print("Enter the NAME of the patient: ");
		name = inp.readLine();
		System.out.print("Enter the AGE of the patient: ");
		age = Integer.parseInt(inp.readLine());
		
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
	    register_date = ft.format(dNow);
	    System.out.println("The register time and date is: " + register_date);
		
		doctor_id=Doc_id;
		patient_id=pd;
		
		System.out.println("So the id of the patient is : "+ patient_id);
		Patient_Details.add(name);
		Patient_Details.add(patient_id);
		Patient_Details.add(register_date);
		Patient_Details.add(doctor_id);
		Patient_Details.add(age);
		return Patient_Details;
	}
	
	public ArrayList<Object> Initialize_Details() throws Exception
	{
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
	    time_of_checking = ft.format(dNow);
	    System.out.println("The current time is: " + time_of_checking);
		
		System.out.print("Enter the BODY TEMPARETURE of the patient: ");
		Temperature = Float.parseFloat(inp.readLine());
		System.out.print("Enter the BP of the patient: ");
		BP = Float.parseFloat(inp.readLine());
		System.out.print("Enter the PULSE RATE of the patient: ");
		Pulse_Rate = Integer.parseInt(inp.readLine());
		System.out.print("Enter the WEIGHT of the patient: ");
		weight = Float.parseFloat(inp.readLine());
		
		Patient_Conditions.add(time_of_checking);
		Patient_Conditions.add(BP);
		Patient_Conditions.add(Temperature);
		Patient_Conditions.add(Pulse_Rate);
		Patient_Conditions.add(weight);
		
		return Patient_Conditions;
	}
}
