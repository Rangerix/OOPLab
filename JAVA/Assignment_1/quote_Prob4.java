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
        morning.add("Some people dream of success, while other people get up every morning and make it happen--Wayne Huizenga");
        morning.add("Success is not final, failure is not fatal: it is the courage to continue that counts--Winston Churchill");
        morning.add("There are no secrets to success. It is the result of preparation, hard work, and learning from failure--Colin Powell");
        morning.add("Put your heart, mind, and soul into even your smallest acts. This is the secret of success--Swami Sivananda");
        morning.add("Success isn't always about greatness. It's about consistency. Consistent hard work leads to success. Greatness will come--Dwayne Johnson");
        morning.add("Only I can change my life. No one can do it for me--Carol Burnett");
        morning.add("Always be yourself, express yourself, have faith in yourself, do not go out and look for a successful personality and duplicate it--Brucce Lee");
        morning.add("The price of success is hard work, dedication to the job at hand, and the determination that whether we win or lose, we have applied the best of ourselves to the task at hand--Vince Lombardi");
        morning.add("Coming together is a beginning; keeping together is progress; working together is success--Henry Ford");
        morning.add("Patience, persistence and perspiration make an unbeatable combination for success--Napoleon Hill"); 
        morning.add("Be the change you want to see around you.--Mahatma Gandhi");      
                
                
    }
    
    void fillnoon()
    {
        noon = new ArrayList<String>();
        noon.add("I'm never any good in the morning. It is only after four in the afternoon that I get going--Stephen Hawking");
        noon.add("Think what a better world it would be if we all, the whole world, had cookies and milk about three o'clock every afternoon and then lay down on our blankets for a nap--Barbara Jordan");
        noon.add("There are few hours in life more agreeable than the hour dedicated to the ceremony known as afternoon tea--Henry James");
        noon.add("Late afternoon on the West Coast ends with the sky doing all its brilliant stuff--Joan Didion");
        noon.add("Leave all the afternoon for exercise and recreation, which are as necessary as reading. I will rather say more necessary because health is worth more than learning--Thomas Jefferson");
        noon.add("My mother always kept library books in the house, and one rainy Sunday afternoon - this was before television, and we didn't even have a radio - I picked up a book to look at the pictures and discovered I was reading and enjoying what I read--Beverly Clear");
        noon.add("If you can spend a perfectly useless afternoon in a perfectly useless manner, you have learned how to live--Lin Yutang");
        noon.add("The key to forming good habits is to make them part of your 'rituals.' I have a morning ritual, afternoon ritual, and Sunday ritual. It's one way to bundle good habits into regular times that you set aside to prepare yourself for the life you want. Rituals help you form habits--Lewis Howes");
        noon.add("We all have these places where shy humiliations gambol on sunny afternoons--W. H. Auden");
        noon.add("It took me seventeen years to get three thousand hits in baseball. I did it in one afternoon on the golf course--Hank Aaron");
    }
    
    void fillevening()
    {
        eve = new ArrayList<String>();
        eve.add("Prayer is the key of the morning and the bolt of the evening--Mahatma Gandhi");
        eve.add("Friendship is the shadow of the evening, which increases with the setting sun of life--Jean de La Fontaine");
        eve.add("Think in the morning. Act in the noon. Eat in the evening. Sleep in the night--William Blake");
        eve.add("Evening is a time of real experimentation. You never want to look the same way--Donna Karan");
        eve.add("O, thou art fairer than the evening air clad in the beauty of a thousand stars--Christopher Marlowe");
        eve.add("The evening sings in a voice of amber, the dawn is surely coming--Al Stewart");
        eve.add("Hide our ignorance as we will, an evening of wine soon reveals it--Heraclitus");
        eve.add("There are worse things in life than death. Have you ever spent an evening with an insurance salesman?--Woody Allen");
        eve.add("Probably the happiest period in life most frequently is in middle age, when the eager passions of youth are cooled, and the infirmities of age not yet begun; as we see that the shadows, which are at morning and evening so large, almost entirely disappear at midday--Eleanor Roosevelt");
        eve.add("The way the world is, I think a silly evening in the theatre is a good thing, to take our minds off terror--Tim Curry");
        
    }
    
    void fillnight()
    {
        night = new ArrayList<String>();
        night.add("Loneliness adds beauty to life. It puts a special burn on sunsets and makes night air smell better--Henry Rollins");
        night.add("There was never a night or a problem that could defeat sunrise or hope--Bernard Williams");
        night.add("A day without sunshine is like, you know, night. Steve Martin");
        night.add("I just want to say, good night, sweet prince, may flights of angels sing thee to thy rest--Harry Dean Stanton");
        night.add("Do not go gentle into that good night but rage, rage against the dying of the light--Dylan Thomas");
        night.add("I often think that the night is more alive and more richly colored than the day--Vincent Van Gogh");
        night.add("My idea of a good night has always been having a lovely meal and a proper conversation--Kirsty Gallacher");
        night.add("They who dream by day are cognizant of many things which escape those who dream only by night--Edgar Allan Poe");
        night.add("Police officers put the badge on every morning, not knowing for sure if they'll come home at night to take it off--Tom Cotton");
        night.add("We live between the act of awakening and the act of surrender. Each morning, we awaken to the light and the invitation to a new day in the world of time; each night, we surrender to the dark to be taken to play in the world of dreams where time is no more--John O'Donohue");
        
                  
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