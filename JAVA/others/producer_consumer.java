
class store{
	int x;
	synchronized void set(int i){
		x=i;
	}
	synchronized int get(){
		return x;
	}
}

class producer implements Runnable{
	store s;
	producer(store x){
		s=x;
	}
	public void run(){
		int i=1;
		int limit=15;
		while(limit>0){
			limit--;
			s.set(i);
			i++;
			/*try{
				Thread.sleep(1);
			}
			catch(InterruptedException e){

			}*/
		}
	}
}

class consumer implements Runnable{
	store s;
	consumer(store x){
		s=x;
	}
	public void run(){
		int limit = 15;
		while(limit>0){
			limit--;
			System.out.println(s.get());
			/*try{
				Thread.sleep(1);
			}
			catch(InterruptedException e){

			}*/
		}
	}
}

class producer_consumer{
	public static void main(String[] args){
		store st=new store();
		producer p=new producer(st);
		consumer c=new consumer(st);
		Thread t1=new Thread(p);
		Thread t2=new Thread(c);
		synchronized(st) {
		t1.start();
		t2.start();
		}
		try{
			t1.join();
			t2.join();
		}
		catch(InterruptedException e){

		}
	}
}