import java.util.Timer;

public class MultiThread2 {
    static final int worker = 10;
    static int k;
    static long mintime ;

    public static void main(String[] args) throws InterruptedException {

        Thread threads[] = new Thread[worker];
        TheirRunnable[] runnables = new TheirRunnable[worker];

        for (k = 0; k < worker; k++) {

            runnables[k] = new TheirRunnable(0, 72540756);
            threads[k] = new Thread(runnables[k]);
            threads[k].start();
        }
        for (k = 0; k < worker; k++) {
            threads[k].join();
        }
        System.out.println("The best time is - " + Math.max(0, mintime));

    }

    protected static class TheirRunnable implements Runnable {
        long n;
        final int from;
        final int to;
        long sum;


        TheirRunnable(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public void run() {
            long t0 = System.currentTimeMillis();

            for (n = from; n <= to; n++) {
                sum = n * (n + 1) / 2;
            }
            long t1 = System.currentTimeMillis();
            mintime = (t1 - t0);
            System.out.println("Time of the work of thread #" + " - " + mintime + " m.sec");
            System.out.println(sum);

        }
    }
}






