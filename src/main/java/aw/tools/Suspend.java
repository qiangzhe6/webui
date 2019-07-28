package aw.tools;

public class Suspend {
    public static void suspend(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
