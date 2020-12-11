package test;


/**
 * @author wuhao
 * @date 2020/9/7 17:09
 */
class A implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        System.out.println("第一个线程：");
        for (int n =1;n<=10;n++)
        {
            i=i+1;
            System.out.println(i);
        }
    }
}

class B implements Runnable{
    private int i = 0;

    @Override
    public void run() {
        System.out.println("第二个线程：");
        for (int n =1;n<=10;n++)
        {
            i=i+1;
            System.out.println(i);
        }
    }
}

class C implements Runnable{
    private int i = 0;

    @Override
    public void run() {
        System.out.println("第三个线程：");
        for (int n =1;n<=10;n++)
        {
            i=i-1;
            System.out.println(i);
        }
    }
}

class D implements Runnable{
    private int i = 0;

    @Override
    public void run() {
        System.out.println("第四个线程：");
        for (int n =1;n<=10;n++)
        {
            i=i-1;
            System.out.println(i);
        }
    }
}
public class Test  {
    public static void main(String[] args) throws Exception {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        Thread a1 = new Thread(a);
        Thread b1 = new Thread(b);
        Thread c1 = new Thread(c);
        Thread d1 = new Thread(d);
        a1.start();a1.join();
        b1.start();b1.join();
        c1.start();c1.join();
        d1.start();d1.join();
    }
}


