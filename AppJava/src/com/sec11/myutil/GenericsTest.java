package com.sec11.myutil;

public class GenericsTest {

	public static void main(String[] args) {		

//		MyClass<? extends A> m_c = new MyClass<>(new C());		
//		m_c.doTest();
//		
//		m_c = new MyClass<>(new B());
//		m_c.doTest();
//		
//		m_c = new MyClass<A>(new A());
//		m_c.doTest();
		
		//C의 상위 타입 = ? 을 말함. C클래스의 상위타입이면 된다는 뜻 
		MyClass<? super C> m_T = new MyClass<>(new A());		
		m_T.doTest();
		
	   m_T = new MyClass<C>(new C());		
	   m_T.doTest();
       
    }
}

//A를 상속받는 클래스는 다 가능함 
//후손 클래스만 관리하겠다는 뜻 
class MyClass<T extends A>{     
   private T obj;
  
	public MyClass(T obj){
        this.obj = obj;
    }     
	
	public void  doTest(){
		 obj.my_print();
	}
}

class A{
	  public void my_print(){
        System.out.println("I am in super class A");
    }
}
 
class B extends A{
	  public void my_print(){
        System.out.println("I am in sub class B");
    }
}
 
class C extends A{
    public void my_print(){
        System.out.println("I am in sub class C");
    }
}
