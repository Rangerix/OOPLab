import java.util.*;
class Item
{
    private static int id=0;
    private int code;
    private String name;
    private double rate;
    private int qty;

    public Item(String nm, double r,int q)
    {
        name=nm;
        rate=r;
        qty=q;
        code=10000+id;
        id++;
    }
    public void setRate(double r){
        rate=r;
    }
    public void setQty(int q)    {
        qty=q;
    }
    public int getQty()    {
        return qty;
    }
    public double getRate()    {
        return rate;
    }
    public int getCode(){
        return code;
    }
    public void display(){
        System.out.println("\nName: "+name+"\nPrice: "+rate+"\nQuantity: "+qty+"\nCode :"+code);
    }
}


class ItemList
{
    ArrayList<Item> itemList;

    public ItemList(){
        itemList=new ArrayList<>();
    }

    public void addItem()
    {
        Scanner sc=new Scanner(System.in);
        String name;
        System.out.print("Enter name of item : ");
        name=sc.nextLine();
        double rate;
        int qty;

        do
        {
            System.out.print("Enter price: ");
            rate=sc.nextDouble();
            if(rate<=0)
                System.out.println("Invalid price");
        } while(rate<=0);

        do
        {
            System.out.print("Enter qty: ");
            qty=sc.nextInt();
            if(qty<=0)
                System.out.println("Invalid quantity");
        } while(qty<=0);

        Item i=new Item(name,rate,qty);
        System.out.println();
        i.display();
        itemList.add(i);
    }

    public int check(int id)
    {
        int pos=-1;
        for(Item i:itemList)
        {
            if(i.getCode()==id)
                return ++pos;
            pos++;
        }
        return -1;
    }

    public void changeRate()
    {
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        int code,pos;
        double rate;
        do
        {
            System.out.print("Enter item code : ");
            code=sc.nextInt();
            pos=check(code);
            if(pos==-1)
                System.out.println("Invalid code");
        }
        while(pos==-1);

        do
        {
            System.out.print("Enter price : ");
            rate=sc.nextDouble();
            if(rate<=0)
                System.out.println("Invalid price");
        }
        while(rate<=0);

        Item i=itemList.get(pos);
        i.setRate(rate);
        itemList.set(pos,i);
    }

    public void changeQty()
    {
        Scanner sc=new Scanner(System.in);
        int code,pos,qty;
        do
        {
            System.out.print("Enter item code : ");
            code=sc.nextInt();
            pos=check(code);
            if(pos==-1)
                System.out.println("Invalid code");
        }
        while(pos==-1);

        do
        {
            System.out.print("Enter new quantity : ");
            qty=sc.nextInt();
            if(qty<=0)
                System.out.println("Invalid price");
        }
        while(qty<=0);

        Item i=itemList.get(pos);
        i.setQty(qty);
        itemList.set(pos,i);
    }

    public void issue()
    {
        Scanner sc=new Scanner(System.in);
        int code,pos,qty;
        do
        {
            System.out.print("Enter item code: ");
            code=sc.nextInt();
            pos=check(code);
            if(pos==-1)
                System.out.println("Invalid code");
        }
        while(pos==-1);

        do
        {
            System.out.print("Enter quantity : ");
            qty=sc.nextInt();
            if(qty<=0)
                System.out.println("Invalid quantity");
        }
        while(qty<=0);

        Item i=itemList.get(pos);
        if(i.getQty()<qty){
            System.out.println("Insufficient quantity");
            i.display();
        }
        else
        {
            System.out.println("\nPrice: "+i.getRate()+"\nQuantity: "+qty+"\nTotal cost: "+(qty*i.getRate()));
            i.setQty(i.getQty()-qty);
            itemList.set(pos,i);
        }
    }

    public void viewItem()
    {
        Scanner sc=new Scanner(System.in);
        int code,pos;
        do
        {
            System.out.print("Enter item code : ");
            code=sc.nextInt();
            pos=check(code);
            if(pos==-1)
                System.out.println("Invalid code");
        }
        while(pos==-1);
        Item i=itemList.get(pos);
        i.display();
    }

    public void moreCount()
    {
        double rate;
        Scanner sc=new Scanner(System.in);
        do
        {
            System.out.print("Enter amount : ");
            rate=sc.nextDouble();
            if(rate<=0)
                System.out.println("Invalid amout");
        }
        while(rate<=0);
        int count=0;
        for(Item i:itemList)
        {
            if(i.getRate()>rate)
                count++;
        }
        System.out.println("No of items above "+rate+" is "+count);
    }
}



class item_Problem2
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner (System.in);
        int ch1,ch2,ch3;
        ItemList i=new ItemList();
        do
        {
            System.out.println("1. SEO\n2. Shopkeeper\n3. Exit");
            System.out.print("Enter choice : ");
            ch1=sc.nextInt();
            switch(ch1)
            {
                case 1:
                //Functions for SEO
                do
                {
                    System.out.println();
                    System.out.println("1. Add new item\n2. Modify price\n3. Modify quantity");
                    System.out.println("4. Issue \n5. View item");
                    System.out.println("6. Find elements with higher cost\n7. Main menu");
                    System.out.print("Enter choice : ");
                    ch2=sc.nextInt();

                    switch(ch2)
                    {
                        case 1:
                        i.addItem();
                        break;

                        case 2:
                        i.changeRate();
                        break;

                        case 3:
                        i.changeQty();
                        break;

                        case 4:
                        i.issue();
                        break;

                        case 5:
                        i.viewItem();
                        break;

                        case 6:
                        i.moreCount();
                        break;

                        default:
                        System.out.println("Invalid choice");
                        break;

                    }
                }
                while(ch2!=7);
                break;

                case 2:
                //For sk
                do
                {
                    System.out.println();
                    System.out.println("1. Update quantity");
                    System.out.println("2. Issue \n3. View item");
                    System.out.println("4. Find elements with higher cost\n5. Main menu");
                    System.out.print("Enter choice : ");
                    ch2=sc.nextInt();

                    switch(ch2)
                    {
                        case 1:
                        i.changeQty();
                        break;

                        case 2:
                        i.issue();
                        break;

                        case 3:
                        i.viewItem();
                        break;

                        case 4:
                        i.moreCount();
                        break;

                        default:
                        System.out.println("Invalid choice");
                        break;

                    }
                }
                while(ch2!=5);
                break;

                case 3:
                System.out.println("Opted for Exit");
                break;

                default:
                System.out.println("invalid choice");
            }

        }
        while(ch1!=3);
    }
}