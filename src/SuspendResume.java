/**
 * Created by igor on 31.05.16.
 */
public class SuspendResume {
    public static void main(String[] args) {
        NewThread newThread1 = new NewThread("One");
        NewThread newThread2 = new NewThread("Two");

        try {
            Thread.sleep(1000);
            newThread1.mySuspend();
            System.out.println("suspend one");
            Thread.sleep(1000);
            newThread1.myResume();
            System.out.println("resume one");
            newThread2.mySuspend();
            System.out.println("suspend two");
            Thread.sleep(1000);
            newThread2.myResume();
            System.out.println("resume two");
        }catch (InterruptedException e){
            System.out.println("MainThreadStop");
        }

        try {
            System.out.println("SuspenceThread.");
            newThread1.thread.join();
            newThread2.thread.join();
        }catch (InterruptedException e){
            System.out.println("MainThreadStop");
        }
        System.out.println("MainThreadClosed");
    }
}
