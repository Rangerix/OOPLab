
import java.util.*;
import java.text.*;

class Readings
{
    private int ubp;
    private int lbp;
    private double temp;
    private String dateTime; 
    
    public Readings(int ubp, int lbp, double temp)
    {
        this.ubp=ubp;
        this.lbp=lbp;
        this.temp=temp;
        Date today = new Date();
        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss"); 
        dateTime=formatter.format(today);
    }
    
    @Override
    public String toString()
    {
        String s=dateTime+"\nBP: "+Integer.toString(ubp)+"/"+Integer.toString(lbp)+"\nTEMPERATURE: "+Double.toString(temp);
        return s;
    }
}


class Doctor
{
    private static int lastId=0;
    private String name;
    private int id;
    
    public Doctor(String name)
    {
        this.name=name;
        id=20000+lastId++;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void display()
    {
        System.out.println("\nId: "+id+"\nName: "+name+"\n");
    }   
}


class Hospital
{
    ArrayList<Patient> pt;
    ArrayList<Doctor> doc;

    public Hospital()
    {
        pt=new ArrayList<>();
        doc=new ArrayList<>();
    }

    public int checkDoctor(int id)
    {
        int pos=-1;
        for(Doctor i:doc)
        {
            if(i.getId()==id)
                return ++pos;
            pos++;
        }
        return -1;
    }

    public int checkPatient(int id)
    {
        int pos=-1;
        for(Patient i:pt)
        {
            if(i.getId()==id)
                return ++pos;
            pos++;
        }
        return -1;
    }

    public void addDoctor()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of doctor : ");
        String name=sc.nextLine();

        Doctor dr=new Doctor(name);
        dr.display();
        doc.add(dr);

    }

    public void addPatient()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of patient : ");
        String name=sc.nextLine();
        int pos,id;

        do
        {
            System.out.print("Enter doctor id to assign to : ");
            id=sc.nextInt();
            pos=checkDoctor(id);
            if(pos==-1)
                System.out.println("Invalid doctor id");
        }
        while(pos==-1);
        String docname=doc.get(pos).getName();
        Patient p=new Patient(name,id,docname);
        pt.add(p);

    }

    public void takeReadings()
    {
        int pos,id,ubp,lbp;
        double temp;
        Scanner sc=new Scanner(System.in);
        do
        {
            System.out.print("Enter patient id : ");
            id=sc.nextInt();
            pos=checkPatient(id);
            if(pos==-1)
                System.out.println("Invalid patient id");
        }
        while(pos==-1);
        if(!pt.get(pos).isChecked())
        {
            System.out.println("Patient is no longer in hospital");
            return;
        }

        do
        {
            System.out.print("Enter upper and lower blood pressure : ");
            ubp=sc.nextInt();
            lbp=sc.nextInt();

            if(ubp<=lbp)
                System.out.println("Invalid pressure");

        }
        while(ubp<=lbp);

        do
        {
            System.out.print("Enter body temperatur in fahrenheit : ");
            temp=sc.nextInt();

            if(temp<90 || temp>110)
                System.out.println("Invalid temperature");

        }
        while(temp<90 || temp>110);

        Readings r=new Readings(ubp,lbp,temp);
        Patient p=pt.get(pos);
        p.setRecord(r);
        pt.set(pos,p);
    }

    public void patientCheckout()
    {
        Scanner sc=new Scanner(System.in);
        int pos,id;

        do
        {
            System.out.print("Enter patient id : ");
            id=sc.nextInt();
            pos=checkPatient(id);
            if(pos==-1)
                System.out.println("Invalid patient id");
        }
        while(pos==-1 );
        if(id==-1)
            return;
        
        if(!pt.get(pos).isChecked())
            System.out.println("Patient already checked out");
        else
        {
            Patient p=pt.get(pos);
            p.checkOut();
            pt.set(pos,p);
            System.out.println("Patient successfully checked out");
        }
            
    }
    
    public void displayReadings()
    {
        Scanner sc=new Scanner(System.in);
        int pos,id;

        do
        {
            System.out.print("Enter patient id : ");
            id=sc.nextInt();
            pos=checkPatient(id);
            if(pos==-1)
                System.out.println("Invalid patient id");
        }
        while(pos==-1);
        
        Patient p=pt.get(pos);
        p.showReadings();
    }
}



class Patient
{
    private static int lastId=0;
    private String name;
    private int id;
    private ArrayList<Readings> record;
    private int docid;
    private String docname;
    private int status;

    public Patient(String name,int did, String dname)
    {
        this.name=name;
        id=10000+lastId++;
        docid=did;
        docname=dname;
        record=new ArrayList<>();
        status=1;
        System.out.println("\nPatient id generated : "+id);
    }

    public void setRecord(Readings r)
    {
        record.add(r);
    }

    public boolean isChecked()
    {
        return status==1;
    }

    public void checkOut()
    {
        status=0;
    }
    public int getId()
    {
        return id;
    }

    public int getDocId()
    {
        return docid;
    }

    public void display()
    {
        System.out.println("Id: "+id+"\nName: "+name);
        if(docid==0)
            System.out.println("Assigned to: None");
        else
            System.out.println("Assigned to: "+docname);
    }

    public void showReadings()
    {
        System.out.println();
        System.out.println("Taken by: "+docname);
        System.out.println();
        for(Readings r:record)
        {
            System.out.println(r);
            System.out.println();
        }
    }
}


public class hospital_Prob6
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int ch,cntd=0,cntp=0;
        Hospital h=new Hospital();
        do
        {
            System.out.println("1. Add a new doctor\n2. Add a new patient\n3. Take readings\n4. Checkout patient");
            System.out.println("5. Display all readings of a patient\n6. Exit");
            System.out.print("Enter choice : ");
            ch=sc.nextInt();

            switch(ch)
            {
                case 1:
                h.addDoctor();
                cntd++;
                break;

                case 2:
                if(cntd==0)
                {
                    System.out.println("Add some doctor first before adding patient");
                    break;
                }
                h.addPatient();
                cntp++;
                break;

                case 3:
                if(cntp==0 || cntd==0)
                {
                    System.out.println("Add some patient or doctor first before taking any recording");
                    break;
                }
                h.takeReadings();
                break;
                
                case 4:
                if(cntp==0)
                {
                    System.out.println("Add some patient first");
                    break;
                }
                h.patientCheckout();
                break;
                
                case 5:
                if(cntp==0)
                {
                    System.out.println("Add some patient first");
                    break;
                }
                h.displayReadings();
                break;
                
                case 6:
                System.out.println("Opted for exit");
                break;
                
                default:
                System.out.println("invalid choice");

            }
        }
        while(ch!=6);
    }   
}