package gui;

public class Timer implements Runnable {
    TestWindow testWindow;
    boolean running;

    private long started;
    private long finished;

    private int hours, minutes, seconds;

    public Timer(TestWindow testWindow) {
        this.testWindow = testWindow;
    }

    public void start () {
        running = true;
        started = System.currentTimeMillis();
    }

    public void stop () {
        running = false;
        finished = System.currentTimeMillis();
    }

    public String getTimeSpent() {
        if (finished >= started) {
            return String.format("%2d:%2d:%2d", hours, minutes, seconds);
        } else {
            return "couldn't measure time";
        }
    }

    @Override
    public void run() {
        start();
        while (running) {
            finished = System.currentTimeMillis();
            long totalSec = (finished - started) / 1000;

            seconds = (int) (totalSec % 60);
            minutes = (int) ((totalSec / 60) % 60);
            hours = (int) (totalSec / 3600);

            testWindow.updateTimer();
        }
    }
}
