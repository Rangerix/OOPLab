import java.util.*;
import java.io.*;
import java.security.SecureRandom;
public class Doctor_Class {
	
	String Name;
	String Designation;
	String id;
	ArrayList<String> Patient_List = new ArrayList<String>();
	ArrayList<Object> Doctor_Details = new ArrayList<Object>();
	
	BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
	public ArrayList<Object> Initialization(String pd) throws Exception
	{
		System.out.print("Enter the NAME of the doctor: ");
		Name = inp.readLine();
		System.out.print("Enter the DESIGNATION of the doctor: ");
		Designation = inp.readLine();
		
		id=pd;
		
		System.out.println("The auto genrated id of the doctor is: "+ id);
		Doctor_Details.add(Name);
		Doctor_Details.add(Designation);
		Doctor_Details.add(id);
		
		return Doctor_Details;
	}
	
	public ArrayList<String> Add_To_List(String id)
	{
		Patient_List.add(id);
		return Patient_List;
	}
}
