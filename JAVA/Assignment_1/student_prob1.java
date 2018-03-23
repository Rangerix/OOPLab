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
    //constructor
    Student()
    {
        count+=1;
        name="";
        course="";
        adm_date=new Date();
        marks=new double[]{-1.0,0.0,0.0,0.0,0.0,0.0};
        //marks={;//-1 denotes that the student has not appeared for exam
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

    String getCourse() {
        return course;
    }

    Date getDate() {
        return adm_date;
    }

    //function to receive student data
    void readData()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name : ");
        name=sc.nextLine();
        System.out.println("Enter course of study:\n1.Undergraduate\n2.Postgraduate");
        course=courseList[sc.nextInt()-1];
    }

    //function to receive marks
    void recMarks()
    {
        System.out.println("Enter score of 5 subjects : ");
        Scanner sc=new Scanner(System.in);
        int i;
        marks[0]=1.0;//denotes the student has appeared for at least one exam
        for(i=1;i<=5;i++){
            System.out.print("Subject "+i+" Score : ");
            marks[i]=sc.nextDouble();
            total+=marks[i];
        }
    }

    void display()
    {
        System.out.println("\n");
        System.out.println("Name : "+name);
        System.out.println("Course of study : "+course);
        System.out.println("Roll : "+roll);
        System.out.print("Admission date : ");
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(f.format(adm_date));
        int i=0;
        for(double m:marks)
            System.out.println("Subject"+(i++)+": "+m);
        if(marks[0]>0.0)
        {
            System.out.println("Total score :"+total);
            System.out.println("Average score : "+(total/5));
        }
        else
        {
            System.out.println("no record found");
        }
        System.out.println("\n");
    }

    //overriding compareTo function for comparing/sorting
    public int compareTo(Student s2){
        return (int)(-this.total+s2.total);
    } 

}





class StudentList
{
    ArrayList<StudentDept> arr;

    StudentList()
    {
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

    void readMarks()
    {
        System.out.print("Enter roll : ");
        Scanner sc=new Scanner(System.in);
        String r=sc.nextLine();
        StudentDept s=search(r);
        if(s==null)
            System.out.println("not found");
        else
            s.recMarks();
    }

    void preSheet()
    {
        System.out.print("Enter roll : ");
        Scanner sc=new Scanner(System.in);
        String r=sc.nextLine();
        StudentDept s=search(r);
        if(s==null)
            System.out.println("not found");
        else
            s.display();
    }

    ArrayList<StudentDept> enlist(int dep)
    {
        ArrayList<StudentDept> DeptStu=new ArrayList<>();
        for(StudentDept s:arr){
            if(s.getDept().equals(StudentDept.deptList[dep-1]));
            DeptStu.add(s);
        }
        return DeptStu;
    }

    void removeStu()
    {
        int d=0,i;
        StudentDept s;
        String r;
        do
        {
            System.out.print("Enter roll : ");
            Scanner sc=new Scanner(System.in);
            r=sc.nextLine();
            s=search(r);
            if(s==null)
                System.out.println("not found");
        }
        while(s==null);
         for(i=0;i<4;i++)
         {
            if(s.dept.equals(StudentDept.deptList[i]))
            {
                d=i;
                break;
            }
         }

         arr.remove(s);
         StudentDept.deptCount[d]--;
         Student.count--;
        // Iterator<StudentDept> iter=arr.iterator();
        // while(iter.hasNext())
        // {
        //     iter.next();
        //     d=-1;
        //     if(((StudentDept)iter).getTotal()<200.0)
        //     {
        //         for(i=0;i<4;i++){
        //             if(((StudentDept)iter).dept.equals(StudentDept.deptList[i])){
        //                 d=i;
        //                 break;
        //             }
        //         }
        //         iter.remove();
        //         StudentDept.deptCount[d]--;
        //         Student.count--;
        //     }
        // }
    }

    void display()
    {
        System.out.println("Roll\t\tName\t\tCourse\t\tDate of adm\t\tTotal");
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        for(StudentDept s:arr)
            System.out.println(s.getRoll()+"\t"+s.getName()+"\t"+s.getCourse()+"\t"+f.format(s.getDate())+"\t"+s.getTotal());
    }

    void display(ArrayList<StudentDept> a)
    {
        System.out.println("Roll\t\tName\t\tDept\t\tCourse\t\tDate of adm\t\tTotal");
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        for(StudentDept s:a)
            System.out.println(s.getRoll()+"\t"+s.getName()+"\t"+s.getDept()+"\t"+s.getCourse()+"\t"+f.format(s.getDate())+"\t"+s.getTotal());
    }
}




class StudentDept extends Student{
    static String[] deptList={"CSE","ETC","MECH","CVL"};
    static int[] deptCount={0,0,0,0};
    static int[] deptRoll={0,0,0,0};
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
        System.out.println("Enter Department:\n1.CSE\t2.ETC\t3.MECH\t4.CVL");
        int d=sc.nextInt();
        dept=deptList[--d];
        deptCount[d]++;
        deptRoll[d]++;
        Calendar c=Calendar.getInstance();
        c.setTime(adm_date);
        roll=dept+(c.get(Calendar.YEAR)%100);
        if(deptCount[d]<10)
            roll=roll+"00"+deptRoll[d];
        else if(deptCount[d]<100)
            roll=roll+"0"+deptRoll[d];
        else
            roll=roll+deptRoll[d];
    }

    void display(){
        System.out.println("\n");
        System.out.println("Name : "+name);
        System.out.println("Course of study : "+course);
        System.out.println("Department : "+dept);
        System.out.println("Roll : "+roll);
        System.out.print("Admission date : ");
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(f.format(adm_date));
        if(marks[0]>0.0){
                    System.out.println("Total score :"+total);
                    System.out.println("Average score : "+(total/5));
        }
        System.out.println("\n");
    }
}





public class student_prob1
{
    public static void main(String args[]){
        int ch,ch2;
        StudentList sl=new StudentList();
        do{
            System.out.println("1. Admission ");
            System.out.println("2. Score Entry");
            System.out.println("3. Display scorecard");
            System.out.println("4. Dept wise student no");
            System.out.println("5. Total student no");
            System.out.println("6. Display students in sorted order");
            System.out.println("7. Remove student");
            System.out.println("8. Quit");
            System.out.print("Enter choice : ");
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
                System.out.println("Enter dept:\n1.CSE\t2.ETC\t3.MECH\t4.IT");//VALIDATE
                System.out.println("Number of students enrolled = "+StudentDept.getCount(sc.nextInt()-1));
                break;
                
                case 5:
                System.out.println("Number of students enrolled = "+Student.getCount());
                break;
                
                case 6:
                System.out.println("Enter dept\n1.CSE\t2.ETC\t3.MECH\t4.CVL\t5.All");//VALIDATE
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
                System.out.println("Opted for quit");
                break;
                
                default:
                System.out.println("Wrong entry...try again");
            }
        }while(ch!=8);
    }
}