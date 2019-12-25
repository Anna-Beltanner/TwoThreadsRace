package two_threads_race;

public class MainClass {

    static SynchronAB synchronAB;
    public static ABThreads AThread;
    public static ABThreads BThread;

    public static void main(String[] args) throws InterruptedException {

        synchronAB = new SynchronAB();

        AThread = new ABThreads(synchronAB);
        AThread.setName("Поток A");

        BThread = new ABThreads(synchronAB);
        BThread.setName("Поток B");

        AThread.start();
        BThread.start();

        AThread.join();
        BThread.join();

        if (synchronAB.isEnd()) {

            if (synchronAB.isWin() == 1)
                synchronAB.synchronAB("Поток В проиграл\n");
            else
                synchronAB.synchronAB("Поток А проиграл\n");

        }

    }

    }
