package model;

import exceptions.FileDoesntExistException;

import java.io.IOException;

public interface LoadSong {

    void load(String songFile) throws IOException, FileDoesntExistException;


}
