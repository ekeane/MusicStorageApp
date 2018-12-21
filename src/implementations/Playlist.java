package implementations;

import observer.Subject;

import java.util.List;
import java.util.Objects;


public class Playlist extends Subject {

    private String name;
    private String author;
    public List<Song> songs;

    public Playlist(String name, String author, List<Song> songs) {
        this.name = name;
        this.author = author;
        this.songs = songs;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSongToPlaylist(Song s) {
        if (!songs.contains(s)) {
            songs.add(s);
            s.addPlaylistSongBelongsTo(this);
            addObserver(s);

        }

    }

    public void addSongObserver(Song s) {
        songs.add(s);
        notifySongObserver(s);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(name, playlist.name) &&
                Objects.equals(author, playlist.author) &&
                Objects.equals(songs, playlist.songs);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, author, songs);
    }
}
