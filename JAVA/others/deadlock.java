class class1{
	synchronized void foo(class2 obj2){
		String name=Thread.currentThread().getName();
		System.out.println(name+" entered class1");
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
		}
		System.out.println("trying to call class2.last");
		obj2.last();
	}
	synchronized void last(){
		System.out.println("Inside class1.last");
	}
}

class class2{
	synchronized void bar(class1 obj1){
		String name=Thread.currentThread().getName();
		System.out.println(name+" entered class2");
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
		}
		System.out.println("trying to call class1.last");
		obj1.last();
	}
	synchronized void last(){
		System.out.println("Inside class2.last");
	}
}
class Deadlock implements Runnable{
	class1 obj1=new class1();
	class2 obj2=new class2();
	
	Deadlock(){
		Thread.currentThread().setName("Main thread");
		Thread t=new Thread(this,"Deadlock thread");
		t.start();
		obj1.foo(obj2);
	}

	public void run(){
		obj2.bar(obj1);
	}
}

class deadlock{
	public static void main(String[] args){
		new Deadlock();
	}
}