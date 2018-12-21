package implementations;

import observer.SongObserver;

import java.util.List;
import java.util.Objects;

public abstract class Song implements SongObserver {

    private String title;
    private String artist;
    private String albumName;
    private List<Playlist> playlistsSongBeongsTo;


    public Song(String title, String artist, String albumName) {

        this.title = title;
        this.artist = artist;
        this.albumName = albumName;

    }


    // getters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbumName() {
        return albumName;
    }


    // abstract methods
    public abstract int getRating();  // between 1 and 10, 10 being the highest rating

    public abstract int getsongLength();


    public abstract  String getfavSongSymbol();


    public void addPlaylistSongBelongsTo(Playlist p) {
        if (!playlistsSongBeongsTo.contains(p)) {
            playlistsSongBeongsTo.add(p);
            p.addSongToPlaylist(this);
        }
    }

    @Override
    public void update(Song song) {
        System.out.println("The following song has been added: "+ song.getTitle()+ " by " + song.getArtist());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) &&
                Objects.equals(artist, song.artist) &&
                Objects.equals(albumName, song.albumName) &&
                Objects.equals(playlistsSongBeongsTo, song.playlistsSongBeongsTo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, artist, albumName, playlistsSongBeongsTo);
    }





}
