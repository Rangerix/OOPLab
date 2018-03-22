import java.util.*;
import java.text.SimpleDateFormat;


class Student implements Comparable<Student>
{
    protected static int count;
    protected static String[] courseList={"Undergraduate","Postgraduate"};
    protected String roll;
    protected String name;
    protected String course;
    protected Date adm_date;
    protected double marks[];
    protected double total;
    
    Student()
    {
        count+=1;
        name="";
        course="";
        adm_date=new Date();
        marks=new double[]{-1.0,0.0,0.0,0.0,0.0,0.0};
        total=0.0;
    }

    Student(String r){
        roll=r;
    }

    static void setCount(){
        count=0;
    }

    static int getCount(){
        return count;
    }

    String getRoll(){
        return roll;
    }

    double getTotal(){
        return total;
    }

    String getName(){
        return name;
    }

    String getCourse(){
        return course;
    }

    Date getDate(){
        return adm_date;
    }

    void readData(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name: ");
        name=sc.nextLine();
        System.out.println("Enter course of study:\n1.Undergraduate\n2.Postgraduate");
        course=courseList[sc.nextInt()-1];
    }

    void recMarks()
    {
        System.out.println("Enter marks of 5 subjects");
        Scanner sc=new Scanner(System.in);
        int i;
        marks[0]=1.0;
        for(i=1;i<=5;i++){
            System.out.print("Subject "+i+" : ");
            marks[i]=sc.nextDouble();
            total+=marks[i];
        }
    }

    void display()
    {
        System.out.println("\n");
        System.out.println("Name : "+name);
        System.out.println("Roll : "+roll);
        System.out.println("Course of study : "+course);
        System.out.print("Admission date : ");
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(f.format(adm_date));
        if(marks[0]>0.0){
            System.out.println("Total marks :"+total);
            System.out.println("Average marks : "+(total/5));
        }
        System.out.println("\n");
    }

    public int compareTo(Student s2){
        return (int)(this.total-s2.total);
    } 
}




class StudentDept extends Student
{
    static String[] deptList={"CSE","ETC","CVL","MECH"};
    static int[] deptCount={0,0,0,0};
    String dept;
    
    StudentDept(){
        super();
        dept="";
    }

    String getDept(){
        return dept;
    }

    static int getCount(int dep){
        return deptCount[dep];
    }

    void readData(){
        super.readData();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter course of study:\n1.CSE 2.ETC 3.CVL 4.MECH");
        int d=sc.nextInt();
        dept=deptList[--d];
        deptCount[d]++;
        Calendar c=Calendar.getInstance();
        c.setTime(adm_date);
        roll=dept+(c.get(Calendar.YEAR)%100);
        if(deptCount[d]<10)
            roll=roll+"00"+deptCount[d];
        else if(deptCount[d]<100)
            roll=roll+"0"+deptCount[d];
        else
            roll=roll+deptCount[d];
    }

    void display(){
        System.out.println("\n");
        System.out.println("Name : "+name);
        System.out.println("Roll : "+roll);
        System.out.println("Course of study : "+course);
        System.out.println("Department : "+dept);
        System.out.print("Admission date : ");
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(f.format(adm_date));
        if(marks[0]>0.0){
                    System.out.println("Total marks :"+total);
                    System.out.println("Average marks : "+(total/5));
        }
        System.out.println("\n");
    }
}



class StudentList
{
    ArrayList<StudentDept> arr;
    
    StudentList(){
        Student.setCount();
        arr=new ArrayList<>();
    }

    void readData()
    {
        StudentDept s=new StudentDept();
        s.readData();
        s.display();
        arr.add(s);
    }

    StudentDept search(String r)
    {
        for(StudentDept s:arr){
            if (s.getRoll().equals(r))
                return s;
        }
        return null;
    }

    void readMarks(){
        System.out.print("Enter roll : ");
        Scanner sc=new Scanner(System.in);
        String r=sc.nextLine();
        StudentDept s=search(r);
        if(s==null)
            System.out.println("Student not found");
        else
            s.recMarks();
    }

    void preSheet(){
        System.out.print("Enter roll : ");
        Scanner sc=new Scanner(System.in);
        String r=sc.nextLine();
        StudentDept s=search(r);
        if(s==null)
            System.out.println("Student not found");
        else
            s.display();
    }

    ArrayList<StudentDept> enlist(int dep){
        ArrayList<StudentDept> DeptStu=new ArrayList<>();
        for(StudentDept s:arr){
            if(s.getDept().equals(StudentDept.deptList[dep-1]));
                DeptStu.add(s);
        }
        return DeptStu;
    }

    void removeStu(){
        Iterator<StudentDept> iter=arr.iterator();
        if(!iter.hasNext())
            System.out.println("No Student to remove");
        else{
            while(iter.hasNext()){
                if(iter.next().getTotal()<200.0)
                    iter.remove();
            }
        }
    }

    void display(){
        if(arr.size()<1)
            System.out.println("\nNo Student to display\n");
        System.out.println("Roll\tName\tCourse\tDate of adm\tTotal");
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        for(StudentDept s:arr)
            System.out.println(s.getRoll()+"\t"+s.getName()+"\t"+s.getCourse()+"\t"+f.format(s.getDate())+"\t"+s.getTotal());
    }

    void display(ArrayList<StudentDept> a){
        if(a.size()<1)
            System.out.println("\nNo Student to display\n");
        System.out.println("Roll\tName\tDept\tCourse\tDate of adm\tTotal");
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        for(StudentDept s:a)
            System.out.println(s.getRoll()+"\t"+s.getName()+"\t"+s.getDept()+"\t"+s.getCourse()+"\t"+f.format(s.getDate())+"\t"+s.getTotal());
    }
}

public class student_prob1
{
    public static void main(String args[]){
        int ch,ch2;
        StudentList sl=new StudentList();
        do{
            System.out.println("1. Admission ");
            System.out.println("2. Marks entry");
            System.out.println("3. Display marksheet");
            System.out.println("4. Display total students in a Department");
            System.out.println("5. Show total students");
            System.out.println("6. Display students in sorted order");
            System.out.println("7. Remove student");
            System.out.println("8. Exit");
            System.out.print("Enter choice :  ");
            Scanner sc=new Scanner(System.in);
            ch=sc.nextInt();
            switch(ch){
                case 1:
                sl.readData();
                break;
                
                case 2:                 
                sl.readMarks();
                break;
                
                case 3:
                sl.preSheet();
                break;
                
                case 4:
                System.out.println("Enter dept.\n1.CSE 2.ETC 3.CVL 4.MECH");
                System.out.println("Number of students enrolled = "+StudentDept.getCount(sc.nextInt()-1));
                break;
                
                case 5:
                System.out.println("Number of students enrolled = "+Student.getCount());
                break;
                
                case 6:
                System.out.println("Enter dept\n1.CSE\t2.ETC\t3.CVL\t4.MECH\t5.All");
                ch2=sc.nextInt();
                ArrayList<StudentDept> a2=new ArrayList<>();
                if(ch2!=5){
                    a2=sl.enlist(ch2);
                    Collections.sort(a2);
                    sl.display(a2);
                }
                else{
                    Collections.sort(sl.arr);
                    sl.display();
                }
                break;
                
                case 7:
                sl.removeStu();
                break;
                
                case 8:
                System.out.println("Opted for exit");
                break;
                
                default:
                System.out.println("Invalid input ...");
            }
        }while(ch!=8);
    }
}