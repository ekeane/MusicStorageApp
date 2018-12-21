package observer;

import implementations.Song;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<SongObserver> songObservers = new ArrayList<>();

    public void addObserver(SongObserver songObserver) {
        if(!songObservers.contains(songObserver)) {
            songObservers.add(songObserver);
        }
    }

    public void notifySongObserver(Song song) {
        for (SongObserver songObserver : songObservers) {
            songObserver.update(song);
        }
    }
}
