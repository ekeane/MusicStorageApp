package GUI;

import exceptions.FileDoesntExistException;
import implementations.*;
import javafx.scene.control.ComboBox;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppInterface {
    private JButton AddSongButton;
    private JPanel SourcePanel;
    private JTextField SongNameField;
    private JTextField ArtistField;
    private JLabel ArtistName;
    private JTextField AlbumField;
    private JButton ViewAllSongs;
    private JTextField RemoveSongField;
    private JButton RemoveSongButton;
    private JTabbedPane SaveLoadSongFile;
    private JPanel SaveLoadMusicStats;
    private JPanel CreatePlaylist;
    private JPanel SearchPlaylist;
    private JTextField SaveSongField;
    private JButton enterButton;
    private JTextField textField1;
    private JLabel FieldPlaylistLabel;
    private JTextField textField2;
    private JButton enterButton1;
    private JTextField PlaylistSearchField;
    private JButton addButton;
    private JTextField LoadSongField;
    private JButton LoadSongButton;
    private JTextField SaveFileNameStat;
    private JButton SaveFileNameStatButton;
    private JTextField LoadFilenameStat;
    private JButton SongKeywordButton;
    private JTextField SongKeywordField;
    private JComboBox comboBox1;
    private JButton PlaylistSearchButton;
    private  MusicPlayer mp1 = new MusicPlayer();
    private MusicPlayerSaveLoad mpsl = new MusicPlayerSaveLoad(mp1);
    private Playlist p1;
    private MusicStatistics musicstats;
    public List<Song> songs;
    private ArrayList<Song> songsForPlaylist = new ArrayList<>();

    public AppInterface() {
        AddSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mp1.addSong(new RegularSong(SongNameField.getText(), ArtistField.getText(), AlbumField.getText()));
                comboBox1.addItem(SongNameField.getText() + " by " + ArtistField.getText());
                JOptionPane.showMessageDialog(null, "Song added.");
            }
        });
        SongNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        ArtistField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        AlbumField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        ViewAllSongs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> songs = new ArrayList<>();
                for (Song s : mp1.getSongList()) {
                    songs.add("\n" + s.getTitle() + " by " + s.getArtist());
                }

                String songsALL = songs.toString();
                JOptionPane.showMessageDialog(null, songsALL.replace("[", "").replace("]", "").replace(",", "").trim());
            }
        });

        RemoveSongField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
        });
        RemoveSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mp1.removeSong(RemoveSongField.getText());
                JOptionPane.showMessageDialog(null,  "Song removed.");
            }
        });
        SaveSongField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mpsl.save(SaveSongField.getText());
                    JOptionPane.showMessageDialog(null,  "Song file saved to downloads.");
                } catch (IOException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,  "Invalid file name!");
                }
            }
        });


        //--------------------------------------------------------------------------- for creating playlist -------------------------//

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                songsForPlaylist.add(new RegularSong(comboBox1.getSelectedItem().toString(), "", ""));

                JOptionPane.showMessageDialog(null,  "Song added.");

            }
        });
        enterButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1 = new Playlist(textField1.getText(), textField2.getText(), songsForPlaylist);

            mp1.addPlaylist(p1);
            JOptionPane.showMessageDialog(null,  "Playlist added.");
            songsForPlaylist = new ArrayList<>();
            }
        });


        //--------------------------------- for creating playlist -------------------------//

        LoadSongField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
        });
        LoadSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mpsl.load(LoadSongField.getText());
                    JOptionPane.showMessageDialog(null,  "File loaded");
                } catch (IOException e1) {
                    System.out.println("File Error!");
                } catch (FileDoesntExistException e1) {
                    JOptionPane.showMessageDialog(null,  "File not found!");
                }
            }
        });
        SaveFileNameStat.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        SaveFileNameStatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicstats = new SongStats(SaveFileNameStat.getText());
                try {
                    musicstats.scrapData(SaveFileNameStat.getText());
                    JOptionPane.showMessageDialog(null,  "Scraping site...");
                } catch (IOException e1) {
                    System.out.println("File Error!");
                }
            }
        });
        LoadFilenameStat.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        SongKeywordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        SongKeywordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    musicstats.writeStatsToFile(LoadFilenameStat.getText(), SongKeywordField.getText());
                    JOptionPane.showMessageDialog(null,  "Song stats in downloads.");
                } catch (IOException e1) {
                    System.out.println("File error!");
                } catch (FileDoesntExistException e1) {
                    System.out.println("File doesn't exist!");
                }
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        PlaylistSearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        PlaylistSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Playlist> playlistName = mp1.getPlaylist(PlaylistSearchField.getText());


                for (Playlist p : playlistName) {
                    if (p.getName().equals(PlaylistSearchField.getText())) {
                        songs = p.getSongs();
                    }
                }

                ArrayList<String> songsArray = new ArrayList<>();
                for (Song s : songs) {
                    songsArray.add(s.getTitle() + " " + s.getArtist());
                }

                String songsString = songsArray.toString();


                JOptionPane.showMessageDialog(null, songsString.replace("[", "").replace("]", "").replace(",", "\n").trim());

            }
        });


    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("Music Collector");

        jf.setContentPane(new AppInterface().SourcePanel);
        jf.getRootPane().setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, new java.awt.Color(123, 171, 182))); // Reference: https://stackoverflow.com/questions/20165698/java-how-to-draw-a-border-around-an-undecorated-jframe
        jf.getContentPane().setBackground(new java.awt.Color(123, 171, 182));  // Reference: https://stackoverflow.com/questions/1081486/setting-background-color-for-the-jframe
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setPreferredSize(new Dimension(900, 600));
        jf.pack();
        jf.setVisible(true);
    }
}
