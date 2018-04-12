import java.util.*;
interface Topping{
	public static String pepperoni="pepperoni";
	public static String sausage="sausage";
	public static String anchovy="anchovy";

	public void display();
}

class pizza1 implements Topping{
	String topp;
	pizza1(String s){
		if(s.equals("pepperoni"))
			topp="pepperoni";
		else if(s.equals("sausage"))
			topp="sausage";
		else if(s.equals("anchovy"))
			topp="anchovy";
	}
	public void display(){
		System.out.println("Pizza 1 with topping : "+topp);
	}
}

class pizza2 implements Topping{
	String topp;
	pizza2(String s){
		if(s.equals("pepperoni"))
			topp="pepperoni";
		else if(s.equals("sausage"))
			topp="sausage";
		else if(s.equals("anchovy"))
			topp="anchovy";
	}
	public void display(){
		System.out.println("Pizza 2 with topping : "+topp);
	}
}

class pizza3 implements Topping{
	String topp;
	pizza3(String s){
		if(s.equals("pepperoni"))
			topp="pepperoni";
		else if(s.equals("sausage"))
			topp="sausage";
		else if(s.equals("anchovy"))
			topp="anchovy";
	}
	public void display(){
		System.out.println("Pizza 3 with topping : "+topp);
	}
}

class PizzaFactory
{
	Topping getPizza(String pizzaType, String topping)
	{
		if(pizzaType.equals("pizza1"))
			return new pizza1(topping);
		else if(pizzaType.equals("pizza2"))
			return new pizza2(topping);
		else if(pizzaType.equals("pizza3"))
			return new pizza3(topping);
		return null;
	}
}

class pizza{
	public static void main(String[] args) {
		String p,t;
		Scanner sc=new Scanner(System.in);
		System.out.print(" Enter pizza type as pizza1, pizza2 or pizza3 : ");
		p=sc.next();
		if(!p.equals("pizza1")&&!p.equals("pizza2")&&!p.equals("pizza3")){
			System.out.println("Invalid pizzaType ");
			return;
		}
		System.out.print(" Enter topping type : pepperoni, sausage, or anchovy : ");
		t=sc.next();
		if(!t.equals("pepperoni")&&!t.equals("sausage")&&!t.equals("anchovy")){
			System.out.println("Invalid topping ");
			return ;
		}
		PizzaFactory fac=new PizzaFactory();
		Topping top_ref=fac.getPizza(p,t);
		if(top_ref==null)
			System.out.println("Error .... ");
		else
			top_ref.display();
	}
}