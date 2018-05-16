import  java.io.*;
import java.util.*;
class file{
	public static void main(String[] args) {
		File f=new File("numbers.dat");
		try{
			FileOutputStream fos=new FileOutputStream(f);
			DataOutputStream dos=new DataOutputStream(fos);
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			try{
				for(int i=0;i<n;i++){
					int j=sc.nextInt();
					dos.writeInt(j);
				}
			}catch(IOException e){

			}
			dos.close();
		}
		catch(Exception e){

		}
		try{	
			FileInputStream fis=new FileInputStream(f);
			DataInputStream dis=new DataInputStream(fis);
	 		System.out.println("OUTPUT : ");
			try{
				while(true){
					int i=dis.readInt();
					System.out.println(i);
				}
			}catch (EOFException e){
				System.out.println("Reading done !");
			}
			dis.close();
		}
		catch(Exception e){
			
		}
	}
}