import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Integer;

public class Compress {
	
	List<String> ListOfFilesInDirectory;
	
	Compress() {
		ListOfFilesInDirectory = new ArrayList<String>();
	}
	
	static void gzipFile(File file, String gzipFILE_NAME) {
		byte []buffer = new byte[1024];
		try {
			FileOutputStream fileOutObj = new FileOutputStream(gzipFILE_NAME);
			GZIPOutputStream gzipObj = new GZIPOutputStream(fileOutObj);
			FileInputStream fileInObj = new FileInputStream(file);
			int len;
			while((len = fileInObj.read(buffer)) > 0) {
				gzipObj.write(buffer, 0, len);
			}
			fileInObj.close();
			gzipObj.finish();
			gzipObj.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	private void CreateListOfFiles(File dir) throws IOException {
		File[] files = dir.listFiles();
		for(File file : files) {
			if(file.isFile()) {
				ListOfFilesInDirectory.add(file.getAbsolutePath());
			} else if(file.isDirectory()) {
				CreateListOfFiles(file);
			}
		}
	}
	
	private void ZipDirectory(File dir, String zipFOLDER_NAME) {
		try {
			CreateListOfFiles(dir);
			FileOutputStream fileOutObj = new FileOutputStream(zipFOLDER_NAME);
			ZipOutputStream zipOutObj = new ZipOutputStream(fileOutObj);
			
			for(String filePath : ListOfFilesInDirectory) {
				FileInputStream fileInObj = new FileInputStream(filePath);
				ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length() + 1, filePath.length()));
				zipOutObj.putNextEntry(ze);
				
				int len;
				byte []buffer = new byte[1024];
				
				while((len = fileInObj.read(buffer)) > 0) {
					zipOutObj.write(buffer, 0, len);
				}
				
				zipOutObj.closeEntry();
				fileInObj.close();
			}
			
			zipOutObj.close();
			fileOutObj.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		boolean flag = true;
		int ch;
		File file, dir;
		String FILE_NAME,FOLDER_NAME, gzipFILE_NAME, zipFOLDER_NAME;
		
		do {
			
			
			
			System.out.print("\n\n1. Compress a file using GZIP compression.\n");
			System.out.print("2. Compress a directory using ZIP compression.\n");
			System.out.print("3. EXIT\n");
			System.out.print("\tEnter an option:  ");
			
			ch = Integer.parseInt(in.nextLine());
			
			switch(ch) {
				
				case 1:
					System.out.print("Enter the file path: ");
					System.out.print("\t");
					FILE_NAME = in.nextLine();
					file = new File(FILE_NAME);
					System.out.println("Enter the gzip file path: ");
					System.out.print("\t");
					gzipFILE_NAME = in.nextLine();
					Compress.gzipFile(file, gzipFILE_NAME);
					break;
					
				case 2:
					System.out.print("Enter the directory path: ");
					System.out.print("\t");
					dirName = in.nextLine();
					dir = new File(dirName);
					System.out.println("Enter the gzip directory path: ");
					System.out.print("\t");
					zipFOLDER_NAME = in.nextLine();
					Compress com = new Compress();
					com.ZipDirectory(dir, zipFOLDER_NAME);
					break;
				
				case 3:
					System.out.println("\t*************THANK YOU************\n");
					flag = false;
					break;
					
				default:
					System.out.println("sorry !! Wrong Entry");
			}
			
		} while(flag);
		
		in.close();
	}

}
