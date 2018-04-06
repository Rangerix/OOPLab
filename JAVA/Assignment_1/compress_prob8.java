import java.io.*;
import java.util.zip.*;
import java.util.*;
import java.nio.file.*;

class zipfile{
    void compressSingleFile(String filename){
        try{
            File file=new File(filename);
            String zipFileName=filename+".zip";

            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);

            zos.putNextEntry(new ZipEntry(file.getName()));

            byte[] bytes = Files.readAllBytes(Paths.get(filename));
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
            zos.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("IOexception");
        }
    }
}

class ZipDirectory{
    void getAllFiles(File dir, List<File> fileList) 
    {
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                fileList.add(file);
                if (file.isDirectory()) {
                    getAllFiles(file, fileList);
                }
                /* else {
                }*/
            }
        } catch (Exception e) {
            System.out.println("exceptionnnnnn "+e);
        }
    }    
    void writeZipFile(File directoryToZip, List<File> fileList) 
    {
        try {
            FileOutputStream fos = new FileOutputStream(directoryToZip.getName() + ".zip");
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (File file : fileList) {
                if (!file.isDirectory()) { // we only zip files, not directories
                    addToZip(directoryToZip, file, zos);
                }
            }

            zos.close();
            fos.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found");
        }
        catch (IOException e) 
        {
            System.out.println("IOException ");
        }
    }
    void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException,IOException 
    {
        FileInputStream fis = new FileInputStream(file);

        String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,file.getCanonicalPath().length());
        System.out.println("Writing '" + zipFilePath + "' to zip file");
        ZipEntry zipEntry = new ZipEntry(zipFilePath);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }

        zos.closeEntry();
        fis.close();
    }
}

class compress_prob8{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i;
        System.out.print("1. file\n2. folder\nEnter choice : ");
        i=sc.nextInt();
        if(i==1){
            try{
                System.out.print("Enter filename : ");
                Scanner scl=new Scanner(System.in);
                String name=scl.nextLine();
                File f=new File(name);
                System.out.println("path : "+f.getAbsolutePath());
                zipfile zf=new zipfile();
                zf.compressSingleFile(name);
            }
            catch(Exception e){
                System.out.println("Error occurred at main :"+e);
            }
        }
        else if(i==2){
                List<File> fileList = new ArrayList<File>();
                System.out.print("Enter folder name : ");
                Scanner scl=new Scanner(System.in);
                String name=scl.nextLine();
                File directoryToZip=new File(name);
                ZipDirectory zp=new ZipDirectory();
                zp.getAllFiles(directoryToZip, fileList);
                zp.writeZipFile(directoryToZip, fileList);
        }
        
    }
}