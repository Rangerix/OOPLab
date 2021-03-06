import java.util.Scanner;
class stack{
        int top=-1;
        char items[] = new char[10000];
 
        void push(char x){
            if (top == 999) 
                System.out.println("Stack full");
            else
                items[++top] = x;
        }
 
        char pop() {
            if (top == -1){
                System.out.println("Underflow error");
                return '\0';
            } 
            else
            {
                char element = items[top];
                top--;
                return element;
            }
        }
 
        boolean isEmpty(){
            return (top == -1) ? true : false;
        }
}
class matchingTest {

    boolean isMatchingPair(char character1, char character2)
    {
       if (character1 == '(' && character2 == ')')
         return true;
       else if (character1 == '{' && character2 == '}')
         return true;
       else if (character1 == '[' && character2 == ']')
         return true;
       else
         return false;
    }

    boolean areParenthesisBalanced(String brackets){
       
       char[] exp=brackets.toCharArray();
       stack st=new stack();
       for(int i=0;i<exp.length;i++)
       {
          if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
            st.push(exp[i]);
      
          if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']'){
             if (st.isEmpty())
                   return false;
             
             else if ( !isMatchingPair(st.pop(), exp[i]) )
                   return false;
          }   
       }
       if (st.isEmpty())
         return true; //*balanced
       else
         {   //*not balanced
             return false;
         } 
    } 
}
 class BracketMatching{
	public static void main(String[] args) {
    while(true){  
  		System.out.println("Enter bracket String : ");
  		Scanner sc=new Scanner(System.in);
  		String brackets=sc.next();
  		char[] expr=new char[brackets.length()];
  		brackets.getChars(0,brackets.length(),expr,0);

  		matchingTest t=new matchingTest();						//calling a non-static method
  		if(t.areParenthesisBalanced(brackets))
  			System.out.println("matched ");
  		else
  			System.out.println("NOT matched");
      System.out.print("Quit ? (1/0) : ");
      int qqq=sc.nextInt();
      if(qqq==1) break;
    }
	}
}
