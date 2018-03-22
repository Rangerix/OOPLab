import java.util.*;
import java.io.*;
import java.security.SecureRandom;
public class Patient_main {

	String id,Doc_id;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Map<String,Doctor_Class> map1 = new HashMap<String,Doctor_Class>(); 
	Map<String,Patient_Class> map = new HashMap<String,Patient_Class>();
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
	String randomString( int len ){
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
		}
	
	public void taking_register() throws Exception
	{
		Patient_Class pd1 = new Patient_Class();
		do
		{
			id = randomString(6);
		}while(Find_key(id));
		System.out.print("\nEnter the DOCTOR ID: ");
		Doc_id = br.readLine();
		map1.get(Doc_id).Patient_List=map1.get(Doc_id).Add_To_List(id);
		pd1.Patient_Details=pd1.Initialization(id,Doc_id);
		pd1.Patient_Conditions=pd1.Initialize_Details();
		map.put(id,pd1);
	}
	
	public void Taking_Doctor_Entry() throws Exception
	{
		Doctor_Class dc1=new Doctor_Class();
		do
		{
			id = randomString(6);
		}while(Find_key1(id));
		dc1.Doctor_Details=dc1.Initialization(id);
		map1.put(id,dc1);
	}
	
	public void show_all_patient_under_one_Doctor() throws Exception
	{
		System.out.print("Enter the DOCTOR ID: ");
		id = br.readLine();
		System.out.print("Name of doctor: "+map1.get(id).Doctor_Details.get(0));
		System.out.print("The patients are as follows\n");
		for(int i=0;i<map1.get(id).Patient_List.size();i++)
		{
			System.out.print("\nName: " + map.get(map1.get(id).Patient_List.get(i)).Patient_Details.get(0));
			System.out.print("\nId: " + map.get(map1.get(id).Patient_List.get(i)).Patient_Details.get(1));
			System.out.println("\n");
		}
	}
	
	public void update_Details() throws Exception
	{
		System.out.print("Enter the PATIENT ID: ");
		id = br.readLine();
		
		map.get(id).Patient_Conditions.clear();
		map.get(id).Patient_Conditions=map.get(id).Initialize_Details();
	}
	
	public boolean Find_key(String key)
	{
		return map.containsKey(key);
	}
	
	public boolean Find_key1(String key)
	{
		return map1.containsKey(key);
	}
	
	public void display_details() throws IOException
	{
		System.out.print("Enter the PATIENT ID: ");
		id = br.readLine();
		
		System.out.println("Name of the Patient is: "+ map.get(id).Patient_Details.get(0));
		System.out.println("Id of the Patient is: "+ map.get(id).Patient_Details.get(1));
		System.out.println("Register_Date of the Patient is: "+ map.get(id).Patient_Details.get(2));
		System.out.println("Age of the Patient is: "+ map.get(id).Patient_Details.get(4));
		System.out.println("Last time Check at : "+ map.get(id).Patient_Conditions.get(0));
		System.out.println("BP of the patient was : "+ map.get(id).Patient_Conditions.get(1));
		System.out.println("Temperature of the patient was : "+ map.get(id).Patient_Conditions.get(2));
		System.out.println("Pulse_Rate of the patient was : "+ map.get(id).Patient_Conditions.get(3));
		System.out.println("Weight of the patient was : "+ map.get(id).Patient_Conditions.get(4));
	}
	
	public void Put_Details_in_A_File() throws IOException
	{
		PrintWriter writer = new PrintWriter("C:/Users/ju/workspace/Hospitality_Management/src/Doctor_List.txt", "UTF-8");
		for(String key: map1.keySet())
		{
			String id = key;
			writer.println("Name of the Doctor: "+ map1.get(id).Doctor_Details.get(0));
			writer.println("Designation of the Doctor: "+ map1.get(id).Doctor_Details.get(1));
			writer.println("ID of the Doctor: "+ map1.get(id).Doctor_Details.get(2));
			writer.println();
			writer.println();
		}
		writer.close();
	}
	
	public void Release_A_Patient() throws IOException
	{
		System.out.print("Enter the PATIENT ID: ");
		id = br.readLine();
		
		System.out.println(map.get(id).Patient_Details.get(0) + " has been released.");
		map.remove(id);
	}
}
