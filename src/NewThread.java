/**
 * Created by igor on 31.05.16.
 */
public class NewThread implements Runnable {
    String name;
    Thread thread;
    boolean suspendFlag;

    NewThread(String threadName){
        name = threadName;
        thread = new Thread(this,name);
        System.out.println("New thread: "+thread);
        suspendFlag = false;
        thread.start(); //run thread
    }

    public void run(){
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": "+i);
                Thread.sleep(200);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println(name + " interrupted.");
        }
        System.out.printf(name + " completed.");
    }
    synchronized void mySuspend(){
        suspendFlag = true;
    }
    synchronized void myResume(){
        suspendFlag = false;
        notify();
    }
}
