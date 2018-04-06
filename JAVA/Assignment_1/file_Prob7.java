import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;


class comparename implements Comparator<File>
{
	public int compare(File a,File b){
		return a.getName().compareTo(b.getName());
	}
}
class comparedates implements Comparator<File>
{
	public int compare(File a,File b){
		return (int)(b.lastModified()-a.lastModified());
	}
}
class comparesize implements Comparator<File>
{
	public int compare(File a,File b){
		return (int)(a.length()-b.length());
	}
}

class sortingFiles{
	ArrayList<File> files=new ArrayList<File>();
	void makeListFiles(String foldername){
		File folder=new File(foldername);
		for(File fileItr : folder.listFiles()){
			/*if(fileItr.isDirectory()){
				makeListFiles(fileItr);
			}
			else{*/
				//System.out.println(fileItr.getName());
				files.add(fileItr);
			//} 
		}
	}
	void sortbyname(){
		Collections.sort(files,new comparename());
	}
	void sortbysize(){
		Collections.sort(files,new comparesize());
	}
	void sortbydate(){
		Collections.sort(files,new comparedates());
	}
	void display(){
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println();
		for(File f:files){
			System.out.println(f.getName()+"\t\t"+sdf.format(f.lastModified())+"\t\t"+f.length()+"Bytes");
		}
	}

}

class file_Prob7{
	public static void main(String[] args) {
		if(args.length==1){
			if(!args[0].equals("-s") && !args[0].equals("-d")){
				System.out.println("Invalid options... use -s or -d");
				return;
			}
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter folder name : ");
		String name="";
		try{
			name=sc.nextLine();
		} catch (Exception e){
			System.out.println("Exception occurred : "+e);
		}
		sortingFiles f=new sortingFiles();
		f.makeListFiles(name);
		if(args.length==0){
			f.sortbyname();
		}
		else{
			if(args[0].equals("-s"))
				f.sortbysize();
			else
				f.sortbydate();
		}
		f.display();
	}
}