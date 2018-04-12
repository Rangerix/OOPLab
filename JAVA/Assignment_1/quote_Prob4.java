import java.util.*;
import java.util.prefs.Preferences;
import java.util.ArrayList;
import java.util.Collections;
import java.text.SimpleDateFormat;        
        
class QuoteOfTheDay 
{
    
    
    static ArrayList<String> morning,noon,eve,night;
    static HashMap<Integer,ArrayList<String>> specialdays;
    
    void fillmorning()
    {
        morning = new ArrayList<String>();   
        morning.add("morning 1");
        morning.add("morning 2");
        morning.add("morning 3");
        morning.add("morning 4");
        morning.add("morning 5");
                
    }
    
    void fillnoon()
    {
        noon = new ArrayList<String>();
        noon.add("noon 1");
        noon.add("noon 2");
        noon.add("noon 3");
        noon.add("noon 4");
        noon.add("noon 5");
    }
    
    void fillevening()
    {
        eve = new ArrayList<String>();
        eve.add("eve 1");
        eve.add("eve 2");
        eve.add("eve 3");
        eve.add("eve 4");
        eve.add("eve 5");
        
    }
    
    void fillnight()
    {
        night = new ArrayList<String>();
        
                  
    }
    
    void fillspecialdays()
    {
        specialdays = new HashMap<Integer,ArrayList<String>>();
        inputdata(15,6);
        inputdata(5,6);
        inputdata(14,6);
        
        
    }
    
    public void inputdata(int a,int b)
    {
        if(a==15)
        {
            ArrayList<String> ind_day=new ArrayList<String>();
            ind_day.add("The greatest gifts you can give your children are the roots of responsibility and the wings of independence--Denis Waitley");
            ind_day.add("I am no bird; and no net ensnares me; I am a free human being with an independent will--Charlotte Bronte");
            ind_day.add("Diversity: the art of thinking independently together--Malcolm Forbes");
            ind_day.add("Nothing is more precious than independence and liberty--Ho Chi Minh");
            ind_day.add("The best teamwork comes from men who are working independently toward one goal in unison--James Cash Penney");
            ind_day.add("True individual freedom cannot exist without economic security and independence. People who are hungry and out of a job are the stuff of which dictatorships are made--Franklin D. Roosevelt");
            specialdays.put(a,ind_day);
         }
        else if(a==5){
            ArrayList<String> teacher_day=new ArrayList<String>();
            teacher_day.add("A good teacher can inspire hope, ignite the imagination, and instill a love of learning--Brad Henry");
            teacher_day.add("Let us remember: One book, one pen, one child, and one teacher can change the world--Malala Yousafzai");
            teacher_day.add("Mama was my greatest teacher, a teacher of compassion, love and fearlessness. If love is sweet as a flower, then my mother is that sweet flower of love--Stevie Wonder");
            teacher_day.add("Of all the hard jobs around, one of the hardest is being a good teacher--Maggie Gallagher");
            teacher_day.add("It is the supreme art of the teacher to awaken joy in creative expression and knowledge--Albert Einstein");
            teacher_day.add("The mediocre teacher tells. The good teacher explains. The superior teacher demonstrates. The great teacher inspires--William Arthur Ward");
            specialdays.put(a,teacher_day);
            
        }
        else if (a==14)
        {
            ArrayList<String> children_day=new ArrayList<String>();
            children_day.add("Let us sacrifice our today so that our children can have a better tomorrow--A. P. J. Abdul Kalam");
            children_day.add("My children are the reason I laugh, smile and want to get up every morning--Gena Lee Nolin");
            children_day.add("It is easier to build strong children than to repair broken men.-- Frederick Douglass");
            children_day.add("Racism is still with us. But it is up to us to prepare our children for what they have to meet, and, hopefully, we shall overcome--Rosa Parks");
            children_day.add("Parents are the ultimate role models for children. Every word, movement and action has an effect. No other person or outside force has a greater influence on a child than the parent--Bob Keeshan");
            children_day.add("Live so that when your children think of fairness, caring, and integrity, they think of you--H. Jackson Brown, Jr.");
            specialdays.put(a, children_day);
        }
    }
    
    String getcurrDate()
    {
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String t=sdf.format(cal.getTime());
        return t;
    }
    
    String getcurrTime()
    {
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        String t=sdf.format(cal.getTime());
        return t;
    }
    
    }
public class quote_Prob4
{
    public static void main(String[] args) 
    {

        QuoteOfTheDay obj=new QuoteOfTheDay();
        Scanner sc=new Scanner(System.in);
        String quote=sc.next();
        if(quote.equals("QuoteOfTheDay")==false)
        {
            System.out.println("Please Enter proper quote");

        }
        else
        {
            obj.fillmorning();
            obj.fillnoon();
            obj.fillnight();
            obj.fillevening();
            obj.fillspecialdays();

            String date=obj.getcurrDate();
            String time=obj.getcurrTime();
            
                        
            int day=Integer.parseInt(date.substring(0,date.indexOf("/")));
            int month=Integer.parseInt(date.substring(date.indexOf("/")+1,date.lastIndexOf("/")));
            int year=Integer.parseInt(date.substring(date.lastIndexOf("/")+1));
            int hour=Integer.parseInt(time.substring(0,time.indexOf(":")));
            int min=Integer.parseInt(time.substring(time.indexOf(":")+1,time.lastIndexOf(":")));
            int sec=Integer.parseInt(time.substring(time.lastIndexOf(":")+1));
            
            Preferences userprefs= Preferences.userRoot();

           
            if(day==14 && month==11)
            {
                ArrayList<String> sp=QuoteOfTheDay.specialdays.get(14);
                int cspchild=userprefs.getInt("cspchild",0);
                if(cspchild==sp.size()-1)
                    cspchild=0;
                System.out.println(sp.get(cspchild));
                userprefs.putInt("cspchild",cspchild+1);
            }
            else if(day==5 && month==9)
            {
                ArrayList<String> sp=QuoteOfTheDay.specialdays.get(5);
                int cspteacher=userprefs.getInt("cspteacher",0);
                if(cspteacher==sp.size()-1)
                    cspteacher=0;
                System.out.println(sp.get(cspteacher));
                userprefs.putInt("cspteacher",cspteacher+1);
            }
            else if(day==15 && month==8)
            {
                ArrayList<String> sp=QuoteOfTheDay.specialdays.get(15);
                int cspind=userprefs.getInt("cspind",0);
                if(cspind==sp.size()-1)
                    cspind=0;
                System.out.println(sp.get(cspind));
                userprefs.putInt("cspind",cspind+1);
            }
            else
            {
                if((hour>=6 && hour<=11)|| (hour==12 && min==0))
                {
                    int morn=userprefs.getInt("morning", 0);
                    if(morn==QuoteOfTheDay.morning.size()-1)
                        morn=0;
                    System.out.println(QuoteOfTheDay.morning.get(morn));
                    userprefs.putInt("morning",morn+1);

                }
                else if((hour>=12 && hour<=16)|| (hour==17 && min==0))
                {
                    int afternoon=userprefs.getInt("afternoon", 0);
                    if(afternoon==QuoteOfTheDay.noon.size()-1)
                        afternoon=0;
                    System.out.println(QuoteOfTheDay.noon.get(afternoon));
                    userprefs.putInt("afternoon",afternoon+1);

                }
                else if((hour>=17 && hour<=19)|| (hour==20 && min==0))
                {
                    int evening=userprefs.getInt("evening", 0);
                    if(evening==QuoteOfTheDay.eve.size()-1)
                        evening=0;
                    System.out.println(QuoteOfTheDay.eve.get(evening));
                    userprefs.putInt("evening",evening+1);
                }
                else if((hour>=20 && hour<=23)||(hour>=0 && hour<=5)|| (hour==6 && min==0))
                {
                    int nights=userprefs.getInt("night", 0);
                    if(nights==QuoteOfTheDay.night.size()-1)
                        nights=0;
                    System.out.println(QuoteOfTheDay.night.get(nights));
                    userprefs.putInt("night",nights+1);
                }

            }

        }

          
    }
}