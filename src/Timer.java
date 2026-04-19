public class Timer {

    private long endTime;
    private boolean running;
    private Thread timerThread;

    public void start(int minutes) {

        endTime = System.currentTimeMillis() + (minutes * 60 * 1000L);
        running = true;

        timerThread = new Thread(() -> {

            while (running && !isTimeUp()) {

                long remaining = getRemainingSeconds();
                long min = remaining / 60;
                long sec = remaining % 60;
                System.out.println();
                System.out.print("\r⏳ Time left: " + min + "m " + sec + "s   ");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }

            if (isTimeUp()) {
                System.out.println("\n\nTIME IS UP!");
            }
        });

        timerThread.setDaemon(true);
        timerThread.start();
    }

    public boolean isTimeUp() {
        return System.currentTimeMillis() >= endTime;
    }

    public long getRemainingSeconds() {
        long remaining = endTime - System.currentTimeMillis();
        return Math.max(0, remaining / 1000);
    }

    public void stop() {
        running = false;
    }
}