package uk.tanton.legislation.fetcher;

import uk.tanton.legislation.fetcher.domain.searchresult.Entry;

import java.util.Queue;

public class EntryProccessor extends Thread {

    private final Queue<Entry> queue;

    public EntryProccessor(final Queue<Entry> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {

        while (true) {
            try {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        queue.wait();
                    }
                    final Entry remove = queue.remove();



                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
