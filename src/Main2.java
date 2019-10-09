public class Main2 {
    public static void main(String[] args) {
        Runnable runnable3 = () -> {
            System.out.println("start thread 3");
            System.out.println("finish thread 3");
        };
        Thread thread3 = new Thread(runnable3);
        Runnable runnable2 = () -> {
            System.out.println("star thread2");
            try {
                thread3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish thread2");
        };
        Thread thread2 = new Thread(runnable2);
        Runnable runnable1 = () -> {
            System.out.println("start thead 1");
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish thread 1");
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
