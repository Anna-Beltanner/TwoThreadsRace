package two_threads_race;

public class ABThreads extends Thread {

    SynchronAB syncronAB;

    ABThreads(SynchronAB syncronAB) {
        this.syncronAB = syncronAB;
    }

    public void run() {
        Thread ABThread = Thread.currentThread();

        for (int i = 1; i < 101; i++) {
            syncronAB.synchronAB(ABThread.getName() + " " + i + "\n");
        }

        if (!syncronAB.isEnd()) {
            if (ABThread.getName() == "Поток A") {
                syncronAB.synchronAB("Поток A выиграл\n");
                syncronAB.setIsWin(1);

            } else {
                syncronAB.synchronAB("Поток B выиграл\n");
                syncronAB.setIsWin(2);
            }
        }
        syncronAB.setIsEnd(true);

    }

}



