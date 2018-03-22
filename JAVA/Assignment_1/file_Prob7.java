import java.io.*;
import java.util.*;
import java.text.*;



class fileComparatorDate implements Comparator<File>
{
	public int compare(File f1, File f2){
		return (int)(f1.lastModified()-f2.lastModified());
	}
}

class fileComparatorSize implements Comparator<File>
{
	public int compare(File f1, File f2){
		return (int)(f1.length()-f2.length());
	}
}



class FileSort
{
	ArrayList<File> files=new ArrayList<>();

	public void fillList(String src)
	{
		File path=new File(src);
		File[] fl=path.listFiles();
		for(File f:fl)
			files.add(f);
	}

	public void nameSort()
	{
		Collections.sort(files);
	}

	public void dateSort()
	{
		Collections.sort(files, new fileComparatorDate());
	}

	public void sizeSort()
	{
		Collections.sort(files , new fileComparatorSize());
	}

	public void display()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		for(File f:files)
			System.out.println(f.getName()+"      "+sdf.format(f.lastModified())+"      "+(f.length()/1024)+" KB");
	}
}



class file_Prob7
{
	public static void main(String[] args) 
	{
		if(args.length==1)
		{
			if(args[0].compareTo("-s")!=0 && args[0].compareTo("-d")!=0)
			{
				System.out.println("Invalid options");
				return;
			}
		}
		FileSort fs=new FileSort();

		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		String src="";
		do
		{
			try
			{
				flag=true;
				System.out.println("Enter name of directory");
				src=sc.nextLine();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				flag=false;
			}

			
		}
		while(!flag);

		if(args.length==1)
		{
			if(args[0].compareTo("-s")==0)
			{
				fs.fillList(src);
				fs.sizeSort();
				fs.display();
				return;
			}
			else
				if(args[0].compareTo("-d")==0)
				{
					fs.fillList(src);
					fs.dateSort();
					fs.display();
					return;
				}
				else
					System.out.println("Invalid options");
		}
		else{
			fs.fillList(src);
			fs.nameSort();
			fs.display();
		}
	}
}


