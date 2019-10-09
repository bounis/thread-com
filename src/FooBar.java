import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;
    StringBuilder check = new StringBuilder("foo");
    //Object monitor = new Object();
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.

            lock.lock();
            while (check.equals("bar")) {
                condition.await();
            }
            try {
                printFoo.run();
            } finally {
                check = new StringBuilder("bar");
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            lock.lock();
            while (check.equals("foo")) {
                condition.await();
            }

            try {
                printBar.run();
            } finally {
                check = new StringBuilder("foo");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable foo = () -> System.out.println("foo");
        Runnable bar = () -> System.out.println("bar");
        FooBar fooBar = new FooBar(6);
        Runnable r1 = () -> {
            try {
                fooBar.foo(foo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                fooBar.bar(bar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}