package ui;

import exceptions.FileDoesntExistException;
import exceptions.NonNumberInputException;
import implementations.*;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        MusicPlayer mp1 = new MusicPlayer();
        SongStats musicStats;
        MusicPlayerSaveLoad mpsl = new MusicPlayerSaveLoad(mp1);
        Scanner sc = new Scanner(System.in);


        System.out.println("Welcome to the Music Player.");

        while (true) { // Reference: LittleLoggingCalculator
            System.out.println("To get started enter:" +
                    "\n(1) for list of songs " +
                    "\n(2) to add a song " +
                    "\n(3) to remove a song " +
                    "\n(4) to load a list of songs " +
                    "\n(5) save a list of songs to a text file " +
                    "\n(6) to create a playlist " +
                    "\n(7) search for playlist" +
                    "\n(8) save file of music stats"+
                    "\n(9) load and search file of music stats");
            String input = sc.nextLine();
            try {

                int choice = mp1.parseInput(input);

                if (choice == 1) {
                    mp1.printSongList();


                } else if (choice == 2) {

                    System.out.println("Would you like to make this song a favourite? Enter (1) for favourite and (2) to add as a regular song: ");
                    String songChoice = sc.nextLine();
                    int parseSongChoice = Integer.parseInt(songChoice);

                    if (parseSongChoice == 1) {
                        System.out.println("Enter the title of the song: ");
                        String name = sc.nextLine();

                        System.out.println("Enter the artist of the song: ");
                        String artist = sc.nextLine();

                        System.out.println("Enter the album the song belongs to: ");
                        String albumName = sc.nextLine();

                        System.out.println("Enter the song rating (between 1 - 10): ");
                        String stringRating = sc.nextLine();
                        int rating = Integer.parseInt(stringRating);


                        System.out.println("Enter the song length: ");
                        String stringSongLength = sc.nextLine();
                        int songLength = Integer.parseInt(stringSongLength);

                        FavSong favsong = new FavSong(name, artist, albumName, rating, songLength);

                        System.out.println("The favourite song you you are about to add is: " + favsong.getfavSongSymbol() + " " + favsong.getTitle() + " by " + favsong.getArtist() + " in the album " + favsong.getAlbumName() + ".");
                        System.out.println("Rating: " + favsong.getRating());
                        System.out.println("Song length: " + favsong.getsongLength() + " min");

                        mp1.addSong(favsong);

                    } else {
                        System.out.println("Enter the title of the song: ");
                        String name = sc.nextLine();

                        System.out.println("Enter the artist of the song: ");
                        String artist = sc.nextLine();

                        System.out.println("Enter the album the song belongs to: ");
                        String albumName = sc.nextLine();

                        RegularSong regularSong = new RegularSong(name, artist, albumName);

                        System.out.println("The song you are about to add is: " + regularSong.getTitle() + " by " + regularSong.getArtist() + " in the album " + regularSong.getAlbumName() + ".");

                        mp1.addSong(regularSong);
                    }


                } else if (choice == 3) {
                    System.out.println("Enter a song to remove: ");
                    String songToRemove = sc.nextLine();
                    mp1.removeSong(songToRemove);

                } else if (choice == 4) {
                    System.out.println("Enter the name of file to load: ");
                    String songToPlay = sc.nextLine();
                    try {
                        mpsl.load(songToPlay);
                    } catch (FileDoesntExistException e) {
                        System.out.println("File name doesn't exist.");
                    } finally {
                        System.out.println("Always make sure to check the file was saved before loading.");
                    }


                } else if (choice == 5) {
                    System.out.println("Enter the name of the song file: ");
                    String nameOfFile = sc.nextLine();
                    mpsl.save(nameOfFile);

                }

                else if (choice == 6) {

                    System.out.println("Enter the name of the playlist: ");
                    String nameofPlaylist = sc.nextLine();
                    System.out.println("Enter name of playlist author: ");
                    String authorOfPlaylist = sc.nextLine();

                    while (true) {
                        System.out.println("Enter songs to add: or press (q) to quit");
                        String songToAdd = sc.nextLine();

                        if (songToAdd.equals("q")) {
                            break;
                        }

                      List<Song> playlistSongs =  mp1.getKeyFromMap(songToAdd);
                       Playlist p1 = new Playlist(nameofPlaylist, authorOfPlaylist, playlistSongs);
                       for (Song s : p1.getSongs()) {
                           p1.addSongToPlaylist(s);
                           s.update(s);
                       }
                        mp1.addPlaylist(p1);

                    }




                }

                else if (choice == 7) {
                    System.out.println("Enter the name of the playlist to search: ");
                    String nameofPlaylist = sc.nextLine();
                    mp1.iterateOverPlaylistSongs(nameofPlaylist);
                }

                else if (choice == 8) {
                    System.out.println("Enter the name of the stats file: ");
                    String nameOfStatsFile = sc.nextLine();
                    musicStats = new SongStats(nameOfStatsFile);

                    musicStats.scrapData(nameOfStatsFile);
                }

                else if (choice == 9) {
                    System.out.println("Enter the name of the stats file: ");
                    String nameOfStatsFile = sc.nextLine();
                    System.out.println("Enter the name of the song: ");
                    String nameOfSong = sc.nextLine();
                    musicStats = new SongStats(nameOfStatsFile);
                    try {
                        musicStats.displayData("");
                        musicStats.parseData(nameOfStatsFile, nameOfSong);
                    } catch (FileDoesntExistException e) {
                        System.out.println("File name doesn't exist.");
                    }
                    break;
                }


            } catch (NonNumberInputException nnie) {
                System.out.println("Only use 1, 2, 3, 4 or 5.");
            }

            finally {
                System.out.println("Thank you.");
            }



        }

    }


}
