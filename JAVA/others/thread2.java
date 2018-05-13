
class PrintNumber{
	int i;
	PrintNumber(){i=10;}
	PrintNumber(int k){
		i=k;
	}
	void show(){
		for(int j=i;j>=0;j--){
			//System.out.println(j);
			System.out.println(Thread.currentThread().getName()+" : "+j);
		}
	}
}

class mythread implements Runnable{
	PrintNumber p;
	mythread(PrintNumber x){
		p=x;
	}
	public void run(){
		p.show();
	} 
}

class thread2{
	public static void main(String[] args) {
		PrintNumber pn=new PrintNumber(15);
		PrintNumber pm=new PrintNumber(20);
		mythread m1=new mythread(pn);
		mythread m2=new mythread(pm);
		Thread t1=new Thread(m1,"thread with 15");
		Thread t2=new Thread(m2,"thread with 20");
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}
		catch(InterruptedException e){

		}
	}
}