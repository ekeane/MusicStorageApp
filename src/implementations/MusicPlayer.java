package implementations;

import exceptions.NonNumberInputException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicPlayer {

    public ArrayList<Song> songList;
    private ArrayList<Playlist> playlistArrayList = new ArrayList<>();
    public Map<String, List<Song>> songHashMap = new HashMap<>();
    private Map<String, List<Playlist>> playList = new HashMap<>();


    public MusicPlayer() {
        this.songList = new ArrayList<>();

    }

    // getters
    public ArrayList<Song> getSongList() {
        return this.songList;
    }

    public ArrayList<Playlist> getPlaylists() {
        return this.playlistArrayList;
    }


    // MODIFIES: this
    // EFFECTS: returns a list of songs associated with the song name
    public List<Song> getKeyFromMap(String songName) {
        return songHashMap.get(songName);
    }

    // MODIFIES: this
    // EFFECTS: returns the playlist based on its name
    public List<Playlist> getPlaylist(String playlistName) {
        return playList.get(playlistName);
    }


    // REQUIRES: a song with a Title, Artist, and the album which the song belongs too
    // MODIFIES: this
    // EFFECTS: adds the song to the list of songs, and a key of the songs title
    public void addSong(Song s) {
        songHashMap.put(s.getTitle(), songList);
        this.songList.add(s);
    }


    // MODIFIES: this
    // EFFECTS: adds playlist entry
    public void addPlaylist(Playlist p) {
         playList.put(p.getName(), playlistArrayList);
        this.playlistArrayList.add(p);
    }


    // MODIFIES: this
    // EFFECTS: prints the name of the songs from the given playlist
    public ArrayList<String> printPlaylistSongs(String playlistName) {
        ArrayList<String> playListSongs = new ArrayList<>();

        for (Playlist p : getPlaylist(playlistName)) {
            for (Song s : p.getSongs()) {
                playListSongs.add(s.getTitle());
            }
        }

        return playListSongs;
    }

    public ArrayList<String> iterateOverPlaylistSongs(String playlistname) {
        ArrayList<String> playListSongs = printPlaylistSongs(playlistname);
        ArrayList<String> allPlaylistSongs = new ArrayList<>();
        for (String song : playListSongs) {
            allPlaylistSongs.add(song);
            System.out.println(song);
        }

        return allPlaylistSongs;
    }


    // EFFECTS: prints the title, artist, and album the song belongs too in the current song list
    public void printSongList() {
        if (songList.size() > 0) {
            for (Song s : songList) {
                if (s instanceof RegularSong) {
                    System.out.println(s.getTitle() + " by " + s.getArtist());
                    System.out.println("-------------------------------");
                } else {
                    System.out.println(s.getfavSongSymbol() + " " + s.getTitle() + " by " + s.getArtist());
                    System.out.println("Rating: " + s.getRating());
                    System.out.println("Song length: " + s.getsongLength());
                    System.out.println("-------------------------------");
                }
            }

        } else {
            System.out.println("No songs in list, add a song to view your song list!");
        }
    }


    // EFFECTS: prints the title, artist, and album the song belongs too in the current song list
    public List<String> printSongListReturn() {
        ArrayList<String> displaySongs = new ArrayList<>();
        if (songList.size() > 0) {
            for (Song s : songList) {
                if (s instanceof RegularSong) {
                    displaySongs.add(s.getTitle() + " by " + s.getArtist());
                    displaySongs.add("-------------------------------");
                } else {
                    System.out.println(s.getfavSongSymbol() + " " + s.getTitle() + " by " + s.getArtist());
                    System.out.println("Rating: " + s.getRating());
                    System.out.println("Song length: " + s.getsongLength());
                    System.out.println("-------------------------------");
                }
            }



        } else {
            System.out.println("No songs in list, add a song to view your song list!");
        }

        return displaySongs;
    }


    // REQUIRES: a valid song
    // MODIFIES: this
    // EFFECTS: removes the song if successful and returns true, otherwise false
    public boolean removeSong(String song) {   // Reference: Data Abstraction Solutions/Friend Net Master
        for (Song s : songList) {
            if (s.getTitle().equals(song)) {
                System.out.println(s.getTitle() + " has been removed!");
                songList.remove(s);
                return true;
            }

        }
        System.out.println("Song not found!");
        return false;
    }




    // MODIFIES: this
    // EFFECTS: returns the string input as an int
    public int parseInput(String input) throws NonNumberInputException {
        int i = -1;
        try {
            i = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new NonNumberInputException();
        }
        return i;
    }






}
