public class Timer {

    private long endTime;
    private boolean running;
    private Thread thread;

    public void start(int minutes) {
        endTime = System.currentTimeMillis() + (minutes * 60 * 1000L);
        running = true;

        thread = new Thread(() -> {
            System.out.println("");
            while (running && !isTimeUp()) {
                long sec = getRemainingSeconds();
                //System.out.println("");
                System.out.print("\r⏳ Time left: " + sec + "s ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
            if (isTimeUp()) {
                System.out.println("\n TIME IS UP!");
            }
        });

        thread.setDaemon(true);
        thread.start();
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