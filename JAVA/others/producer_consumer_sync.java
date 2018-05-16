class store{
	int x;
	boolean can_be_produced=true;
	synchronized  void set(int i){
		while(can_be_produced==false){
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
		//produced
		System.out.println("produced : "+i);
		x=i;
		can_be_produced=false;
		notify();
	}
	synchronized int get(){
		while (can_be_produced==true) {
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
		can_be_produced=true;
		notify();
		System.out.println("consumed = "+x);
		return x;
	}
}

class producer implements Runnable{
	store s;
	producer(store st){
		s=st;
	}
	public void run(){
		int i=1;
		int limit=15;
		while(limit>=0){
			limit--;
			s.set(i);
			i++;
		}
	}
}

class consumer implements Runnable{
	store s;
	consumer(store st){
		s=st;
	}
	public void run(){
		int limit=15;
		int i;
		while (limit>=0) {
			limit--;
			i=s.get();
			//System.out.println("consumed : "+i);
		}
	}
}

class producer_consumer_sync {
	public static void main(String[] args) {
		store mystore=new store();
		producer p=new producer(mystore);
		consumer c=new consumer(mystore);
		Thread pt=new Thread(p);
		Thread ct=new Thread(c);
		pt.start();
		ct.start();
		try{
			pt.join();
			ct.join();
		}
		catch(InterruptedException e){}
	}
}