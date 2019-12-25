package two_threads_race;

import java.io.FileWriter;
import java.io.IOException;

public class SynchronAB {

    public static boolean isEnd;
    public static int isWin;

    public SynchronAB() {
        this.isEnd = false;
        this.isWin = 0;
    }

    public synchronized boolean isEnd() {
        return isEnd;
    }

    public synchronized void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public synchronized void setIsWin(int isWin) {
        this.isWin = isWin;
    }

    public synchronized int isWin() {
        return this.isWin;
    }

    public synchronized void synchronAB(String name) {

        try {

            FileWriter pw = new FileWriter("newFile.txt", true);

            pw.append(name);
            pw.flush();

        } catch (
                IOException e) {
            System.out.println("Error: " + e);

        }
    }
}






