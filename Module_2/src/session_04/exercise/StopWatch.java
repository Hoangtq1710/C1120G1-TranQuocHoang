package session_04.exercise;

public class StopWatch {
    private long startTime;
    private long stopTime;

    public StopWatch() {
    }

    public long getStartTime() {
        return startTime;
    }

    public long getStopTime() {
        return stopTime;
    }
    public void start(){
        this.startTime = System.currentTimeMillis();
    }
    public void stop(){
        this.stopTime =  System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return this.stopTime - this.startTime;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        System.out.println("Start Time : "+ stopWatch.getStartTime());
        for (int i = 0; i < 50000; i++) {
            for (int j = 0; j < 50000; j++) {

            }
        }
        stopWatch.stop();
        System.out.println("Stop Time : "+ stopWatch.getStopTime());
        System.out.println("Elapsed Time : "+stopWatch.getElapsedTime());
    }
}