import java.io.*;


class product

{
    private int qty;
    private float price;
    private String name, pr_code;
  
    
 // constructor
    
    product() 
    
    {
        name=""; 
        pr_code="";
        qty=0;
        price=0.0f;
        
    }
    
 // parametresied  constructor    
    product(String iname, String icode)
    {
        name=iname;
        pr_code=icode;
        qty=0;
        price=0.0f;
        
    }
    
    
    
    
     // get the code   
String getCode()
    {
    return pr_code;
    }
    
    
    
 // get quantity   
public int getqntyity()
    {
    return qty;
    }   
    
    
  //get the price    
public float getprice()
    {
    return price;
    }  
    
    
//get the qntyity  
void input_qty(int qntyity)
    {
    qty=qntyity;
    }
    
        
 // get the name 
String getName()
    {
    return name;
    }
        
    

 // get the input
    
 void input_details() throws IOException
    {
       
        if (pr_code.equals("")) 
        {
            System.out.println ("product not created");
            return;
        }
        BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
       // System.out.print("Enter name of the product:   ");
       // name=br.readLine();
        System.out.print ("Enter qntyity of the product:   ");
        qty=Integer.parseInt(br.readLine());
        System.out.print("Enter price of the product:   ");
        price=Float.parseFloat(br.readLine());
    }

    
    
    
//update the price
   
    boolean updateprice(float newprice)
    {
        boolean status=false;
        if (newprice<=0.0)
        {
            System.out.println("Invalid price");
        }
        else
        {
            status=true;
            price=newprice;
        }
        return status;
    }
    
    
// to show the details

    void showDetails()
    {
        System.out.println ("Name: "+name+ "\nproduct Code: "+pr_code+Integer.toString(1)+ "  to " + pr_code+Integer.toString(qty) + "\nqntyity: "+qty);
        System.out.printf ("price: Rs. %.2f\n",price);
    }
    
    
}

// end of the class 


// ********************************************************************************************


class productList
{
    private product[] stock;
    private int pdt_count;
    private static int MAX_products=50;
    
    
  // constructor  
    productList()
    {
        stock=new product[MAX_products];
        int i;
        for(i=0;i<MAX_products;i++)
        {
        	stock[i] = new product();
        }
        
        pdt_count=0;
    }
    
    
 
 
 
 // recieve a product
    
public boolean receiveproduct(String icode, int qntyity)
    {
        int pos=search(icode); 
        boolean status=false;
        if(pos>=0)
        {
            status=true;
            stock[pos].input_qty(stock[pos].getqntyity()+qntyity); 
            System.out.println ("product Received: ");

        }
        else System.out.println ("product not in stock");
        return status;
    }
 
 
 // insert a product in theproduct list array
    
    
boolean insert_product(product it)
    {
        if (isFull())
        {
            System.out.println("List is full");
            return false;
        }
        stock[pdt_count++]=it;
        return true;
    }
    
  
  
  
 // adding a product 
  
    
public boolean addproduct() throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter the name of the product: ");
        String iname=br.readLine();
        String icode;
        icode = iname;
        
        
        boolean status=false;
        int pos=search(icode); 
        if (pos==-1) 
        {
            //status=true;
            product temp=new product(iname,icode);
            temp.input_details();
            status = insert_product(temp);
        }
        else
        {
            System.out.println("product already exists in stock");
        }
        return status;
    }   
    
    
    
   // buy a product
    
    
public boolean buy_product(String icode, int qntyity)
    {
        int pos=search(icode); 
        boolean status=false;
        float cost=0.0f;
        if(pos>=0 && (stock[pos].getqntyity()-qntyity)>=0) 
        {
            status=true;
            int temp_quan = stock[pos].getqntyity();
            stock[pos].input_qty(stock[pos].getqntyity()-qntyity); 
            
            cost=qntyity*stock[pos].getprice(); 
            System.out.println ("Your bill is as follows: ");
            System.out.println ("product Code: " + icode +Integer.toString(temp_quan - qntyity+1)+ "  to " + icode +Integer.toString(temp_quan) +   "\nproduct Name: "+stock[pos].getName()+ "\nQuantity: "+qntyity);
            System.out.printf("Total Cost: Rs. %.2f\n",cost);
        }
        else System.out.println ("product not in stock");
        return status;
    }   
    
    
    // show details of a product
    
    
public void showDetails(String icode)
    {
        int pos=-1;
        pos=search(icode); 
        if (pos>=0) 
        {
            stock[pos].showDetails();
        }
        else System.out.println("product not in stock");
    }
   
   
   
      
    // update the price
    
public boolean changeprice(String icode, float newprice)
    {
        int pos=search(icode);
        boolean status=false;
        if (pos>=0) 
        {
            status=stock[pos].updateprice(newprice);
        }
        return status;
    }


// show details of all available products       
   
void show_det()
    {
        for (int i=0; i<pdt_count; i++)
        {
            stock[i].showDetails();
            System.out.println("\n");
        }
    }    
    
    
    
  // check if the array is full  
    
private boolean isFull()
    {
    return (pdt_count==MAX_products);
    }
  
  
  
  // search for a product in the list  
    
private int search(String icode)
    {
        int pos=-1; 
        for (int i=0; i<pdt_count; i++)
        {
            if (stock[i].getCode().compareTo(icode)==0) 
            {
                pos=i;
                break;
            }
        }
        return pos;
    }
    
public void less_than_a_price(float prc){

	int i;
	int count = 0;
	for(i=0;i<pdt_count;i++)
	{
		if(stock[i].getprice() <= prc)
		{
			count = count + 1;
			stock[i].showDetails();
			System.out.println("\n");
		}
		
	}
	
	if(count == 0) System.out.print("\n sorry no products available\n");
	
    }    



    
}

// end of class

//*******************************************************************************************

public class ITEM_MAIN
{
    public static void main(String args[]) throws IOException
    {
      
      
      
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        productList itList=new productList();
        boolean flag=true,  status;
        int ch, qnty;
        float price=0.0f;
        String code="";
        String name ="";


           boolean flag1 = true;
           
           while(flag1)
           {
           	System.out.print("\n\tWhat type of user you are ?\n");
           	int ch1;
            	System.out.println("\n1. CUSTOMER");
            	System.out.println("2. SHOP OWNER");           
            	System.out.println("3. EXIT");
           
            	System.out.print("\tEnter Your choice:  ");
           	ch1=Integer.parseInt(br.readLine());
            
            switch(ch1)
            {
            	case 1:
            	
            	
            	
            	System.out.println("\n\twelcome to our shop\n");
            	
            	boolean flag2 = true;
            	while(flag2)
            	{
            	
            	System.out.println("\n\n1. Buy a product");
            	System.out.println("2. Show details of an product");
            	System.out.println("3. Show details of all available products");
            	System.out.println("4. List of products whose price is less than a given amount");
            	System.out.println("5. EXIT");
            	
            	int ch2;
            	
            	System.out.print("\tEnter Your choice:  ");
           	ch2=Integer.parseInt(br.readLine());
           	
           	switch(ch2)
           	{
           	
           	case 1: 
           	
           	    System.out.print("Enter NAME:  ");
                        code=br.readLine();
                        System.out.print("Enter qntyity: ");
                        qnty=Integer.parseInt(br.readLine());
                        status=itList.buy_product(code,qnty);
                        if (status) System.out.println("Successfully Issued");
                        
                        break;
                        
                        
                 
                 case 2:
                 
                 	System.out.print("Please enter the NAME of the product: ");
                        name=br.readLine();
                        itList.showDetails(name);
                        break;
                        
                 case 3:
                 
                        itList.show_det();
                	break;
                	
                	
                case 4:
                
                	System.out.print("    Please enter the amount: ");
                	float prc;
                	prc=Float.parseFloat(br.readLine());
                	itList.less_than_a_price(prc);
                	break;
                	
           
           	
           	case 5:
           	
           		flag2 = false;
           		break;
           		
           	
           	default: System.out.println("you have entered invalid choice !!!! ");
           	
           	} // end of switch case
           	
           } // end of while loop
           
           System.out.println("\n\tThank you for coming in our shop\n");
           
           break;
           
           // end of case 1
           
           case 2:
           
           System.out.println("\n\tYou are in the owner profile\n");
           
           boolean flag3 =true;
            	while(flag3)
            	{
            	
            	System.out.println("\n\n1. Add product  to list");
            	System.out.println("2. Change price of an product");           
            	System.out.println("3. Update the qntyity");
            	System.out.println("4. Show details of an product");
            	System.out.println("5. Show details of all available products");
            	System.out.println("6. Exit\n");
            	
            	int ch3;
            	
            	System.out.print("\tEnter Your choice:  ");
           	ch3=Integer.parseInt(br.readLine());
           	
           	switch(ch3)
           	{
           	
           	case 1: 
           	
           	        status=itList.addproduct();
                        if (status) System.out.println("*****succesfully added*****");
                        
                        break;
                        
                        
                 
                 case 2:
                 
                 	System.out.print("Please enter the NAME of the product: ");
                        code=br.readLine();
                        System.out.print("Please enter the PRICE of the product: ");
                        price=Float.parseFloat(br.readLine());
                        status=itList.changeprice(code,price);
                        if (status) System.out.println("Succesfully updated");
                        else System.out.println("product Not in stock");
                        
                        break;
                        
                 case 3:
                 
                        System.out.print("Please enter the NAME of the product : ");
                        code=br.readLine();
                        System.out.print("Please enter the quantity of the product: ");
                        qnty=Integer.parseInt(br.readLine());
                        status=itList.receiveproduct(code,qnty);
                        if (status) System.out.println("Succesfully updated");
                        else System.out.println("product Not in stock");
                        break;
                        
                case 4:
                 
                 	System.out.print("Please enter the NAME of the product: ");
                        code=br.readLine();
                        itList.showDetails(code);
                        break;
                        
                 case 5:
                 
                        itList.show_det();
                	break;
           
           	
           	case 6:
           	
           		flag3 = false;
           		break;
           		
           	
           	default: System.out.println("you have entered invalid choice !!!! ");
           	
           	} // end of switch case
           	
           } // end of while loop
           
           System.out.println("\n\tYou have suucesssfully logged out");
           
           // end of case 2
           
           break;
           
           case 3:
           
           	flag1 = false;
           	break;
           
           default: System.out.println("you have entered invalid choice !!!! ");  
           
       } // end of while loop
       
       
       
       
       // end of switch case
       	

        
  
     
     
     }  // end of while loop
     
     System.out.print( " *****************THANK YOU********************\n\n");
     
    } 
    
    // end of main function
    
      
}

// end of class
