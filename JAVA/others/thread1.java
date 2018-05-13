//create a thread using Runnable interface
class mythread implements Runnable{
	int x;
	mythread(){
		x=5;
	}
	mythread(int k){
		x=k;
	}
	public void run(){
		while(x>0){
			System.out.println("Inside mythread x = "+x);
			x--;
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){

			}
		}
	}
}
//create a thread using Thread class
class extendedthread extends Thread{
	int x;
	extendedthread(){
		super();
		x=7;
	}
	extendedthread(int l){
		super();
		x=l;
	}
	public void run(){
		while(x>=0){
			System.out.println("Inside extendedthread x = "+x);
			x--;
			try{
				Thread.sleep(3000);
			}
			catch(InterruptedException e){

			}
		}
	}
}

class thread1{
	public static void main(String[] args) {
		mythread m=new mythread(10);
		Thread t=new Thread(m,"mythread");
		t.start();

		extendedthread m2=new extendedthread(5);
		Thread t2=new Thread(m2,"extendedthread");
		t2.start();
		try{
			t.join();
			t2.join();
		}
		catch(InterruptedException e){
			System.out.println("Exception");
		}
	}
}