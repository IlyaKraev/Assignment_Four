
package models;


public class Timer {
    private long startTime = 0;
    private long endTime = 0;
    
    public Timer() {
        this.start();
    }
    
    public void start() {
        startTime = System.currentTimeMillis();
//        System.out.println("start: " + startTime);
    }
    
    public void stop() {
        endTime = System.currentTimeMillis();
//        System.out.println("end: " + endTime);
    }
    
    public long elapsedTime() {
        return(endTime - startTime);
    }
    
}
