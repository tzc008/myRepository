package thread;

import java.util.HashSet;

public class Test {

	public static void main(String[] args) {
		/*A a = new A();
		B b = new B();
		C c = new C();*/
		for(int i=0; i<10; i++){
			B b = new B();
			A a = new A(b);
			C c = new C(a);
			c.start();
			b.start();
			a.start();
//			System.out.println("--------------:"+(i+1));
			/*new A().start();
			new B().start();
			new C().start();*/
		}
		
		
	    /*final Thread t1 = new Thread(new Runnable() {  
	        
	        @Override  
	        public void run() {  
	            System.out.println("t1");  
	        }  
	    });  
	    final Thread t2 = new Thread(new Runnable() {  
	      
	        @Override  
	        public void run() {  
	            try {  
	                //引用t1线程，等待t1线程执行完  
	                t1.join();  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            }  
	            System.out.println("t2");  
	        }  
	    });  
	    Thread t3 = new Thread(new Runnable() {  
	      
	        @Override  
	        public void run() {  
	            try {  
	                //引用t2线程，等待t2线程执行完  
	                t2.join();  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            }  
	            System.out.println("t3");  
	        }  
	    });  
	    t3.start();  
	    t2.start();  
	    t1.start();  */
	}
}

class A extends Thread{
	private B b;
	public A(B b){
		this.b = b;
	}
	@Override
	public void run() {
		try {
			b.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A");
	}
}

class B extends Thread{
	/*private A a;
	public B(A a){
		this.a = a;
	}*/
	@Override
	public void run() {
		/*try {
			a.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println("B");
	}
}

class C extends Thread{
	private A a;
	public C(A a){
		this.a = a;
	}
	@Override
	public void run() {
		try {
			a.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("C");
	}
}